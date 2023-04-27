## Functional Programming without Lambda - Part 2 Lifting, Functor, Monad
### Lifting
Now, let's review map from another perspective. map :: (T -> R) -> [T] -> [R] accepts 2 parameters, 
a function f :: T -> R and a list list :: [T]. [T] is a generic type paramterized by T, 
it's not the same as T, but definitely shares some properties of T. 
So, an interesting interpretation of map(f) :: [T] -> [R] is that map turns a function of type T -> R into a function of [T] -> [R], 
this is called lifting.

Take the square function x -> x * x as an example, map(x -> x * x) turns the function on Int into a function on [Int]. 
Therefore, it makes sense to name map(x -> x * x) as squareForList. 
You can even simply name it as square, which is the overloaded version of square for [Int].

The concept of lifting is the key to understand the advanced abstractions in functional programming. 
Lifting allows you to reuse a function of type T -> R (or T1 -> T2 -> R ...) in the context of List, 
[Maybe](https://en.wikibooks.org/wiki/Haskell/Understanding_monads/Maybe), 
[Lazy](https://sankarsan.wordpress.com/2009/10/04/laziness-in-c-4-0-lazyt/),
[Promise](https://en.wikipedia.org/wiki/Futures_and_promises), 
etc. 
That saves you the work to implement similar functions from scratch just for the context.

Let me explain why lifting matters by changing the string conversion problem in the previous chapter a bit. 
In the original problem, we got a function convert :: String -> String, 
what if the input string is not directly available, but asynchronously fetched from a web service? 
Do you want to chain the convert to the callback for the asynchronous HTTP response? 
You can use callback, but that makes you lose functional composition.

Just like map lifts a function on T into a function on [T], we just wanted to lift it to Promise<T>. 
Here Promise<T> stands for an asynchronously available value of type T. 
So, we'll introduce a function fmap :: (T -> R) -> Promise<T> -> Promise<R>, 
meaning fmap turns a function of type T -> R into a function of type Promise<T> -> Promise<R>. 
See the following example:

```text
// Java 6
F1<String, String> convert = _(split(" "), reverse, map(toUpperCase), join("_"));
// fmap turns a function of type "T -> R" into a function of type "Promise<T> -> Promise<R>"
F1<Promise<String>, Promise<String>> convertForPromise = fmap(convert);
// await() blocks until the async result available
String result = convertForPromise.apply(promise(URL)).await();
```
More details [here](https://github.com/weidagang/fava/blob/master/tests/fava/PromiseTest.java).
```text
promise(URL) :: Promise<String> stands for a string value which will be available in the future. 
Calling await on the promise object will block until the string is available. 
fmap turns convert :: String -> String into convertForPromise :: Promise<String> -> Promise<String> which can work on a promise. 
By the way, if you like we can omit the convert function by inlining it as:

fmap(_(split(" "), reverse, map(toUpperCase), join("_")))
```
### Functor
As I mentioned in the previous section, Promise, [Maybe](https://en.wikibooks.org/wiki/Haskell/Understanding_monads/Maybe), List, Lazy, and so on are all contexts. 
The idea behind is the functional abstraction named [Functor](https://en.wikibooks.org/wiki/Haskell/The_Functor_class). 
In Java, a functor can be defined as follows:

```text
interface class Functor<T> {
  <R> Functor<R> fmap(F1<T, R> f);
}
```
then, Promise<T> will implement the fmap:
```text
class Promise<T> implements Functor<T> {
  <R> Promise<R> fmap(F1<T, R> f) {
    ...
  }
}
```
But as I have said before, we are not in favor of the OO-style API design. 
A better way to define functor in Java is as follows:
```text
public class Promises {
  public static <T, R> F1<Promise<T>, Promise<R>> fmap(F1<T, R> f) {
    return Promises.<T, R>fmap().apply(f);
  }
}
```
It essentially means if we can define a function fmap to lift a function of type T -> R into a function of type Functor<T> -> Functor<R>, 
then Functor<T> is a functor. 
In addition, there're 2 properties named Functor Laws as the semantics constraints to ensure the type makes sense:
```text
fmap id      = id
fmap (p . q) = (fmap p) . (fmap q)
```
Don't be scared, it's actually very simple. 
Just like we put the FILO constraint on the push and pop of the Stack type to make sure it behaves as what we want.

If you feel too abstract, take a look at the example of List<T> or Promise<T>. 
More often than not, your functor class satisfies the laws automatically. 
However, keep in mind that you may always want to test the functor laws for your functor class, 
just like you want to test FILO for a Stack implementation. 
See unit tests of Promise<T> for the functor laws here.

### Monad
Lifting a function of type T -> R into a function of type Functor<T> -> Functor<R> allows us to reuse the existing functions in a different context, 
but sometimes the basic function we have is not as plain as toUpperCase :: String -> String. 
Let's look at the following problem:
```text
Given 1) a function Promise<String> asyncGet(String url) which accepts an URL and returns a promise of the web page; 2) n hyperlinked web pages, the contents of one page is the URL of the next page, url1 -> page1 (url2) -> page2 (url3) -> page3 (url4) ... page_n (url1), please write a function Promise<String> asyncGetK(String url, int k) which starts from the url, goes forward by k steps, returns the page.
```
If what we have is a sync function String get(String url), that would be a simple loop like:
```text
// Java 6
String getK(String url, int k) {
  String page = url;
  for (int i = 0; i < k; i++) {
    page = get(page);
  }
  return page;
}
```

The point here is that the result of the previous get can be directly passed to the next get, 
because the type matches. 
In other words, we can compose multiple get functions together.

But since we only have asyncGet of type String -> Promise<String>, 
the result type Promise<String> of a previous asyncGet doesn't match the parameter type url :: String of the next asyncGet, 
we are unable to compose them together directly. 
So, we'd really like to lift asyncGet :: String -> Promise<String> into asyncGetPromise :: Promise<String> -> Promise<String> then it's composable.

The idea is great, but what would happen if we apply fmap to asyncGet. 
Since the type of fmap is (T -> R) -> Promise<T> -> Promise<R>, 
then the type of fmap(asyncGet) would be Promise<String> -> Promise<Promise<String>>. 
Ooops, that's too much! 
But if we have a join :: Promise<Promise<T>> -> Promise<T> to flatten a nested promise, 
then we will get _(fmap(asyncGet), join) :: Promise<String> -> Promise<String>. 
Combining fmap and join together, we get a function flatMap :: (T -> Promise<R>) -> Promise<T> -> Promise<R>, 
which is exactly what we want.

Being able to define a function fmap makes a type a Functor, 
likewise being able to define a function flatMap makes a type a Monad. 
Then the code would be like:

```text
// Java 6
String getK(String url, int k) {
  F1<Promise<String>, Promise<String>> asyncGetPromise = flatMap(asyncGet);
  Promise<String> page = unit(url);
  for (int i = 0; i < k; i++) {
    page = asyncGetPromise(page);
  }
  return page.await();
}
```
It really shares the same structure as the sync code. That is isomorphic!

#### 参考文章
* [Lifting](https://wiki.haskell.org/Lifting)
* [Scala example source code file (lift-and-unlift.scala)](https://alvinalexander.com/java/jwarehouse/scala/test/files/run/lift-and-unlift.scala.shtml)
* [Lifting Functions to Work With Java Monads](https://dzone.com/articles/lifting-functions-to-work-with-monads-in-java)

想要理解这篇文章，首先要理解lambda语法，lambda是java8的新特性，类似函数式编程，语法简洁，不过习惯了面向对象的编程，理解期lambda还是需要写时间的。
本文作者讲述的是lifting function的编程方法：
[原文](https://www.cnblogs.com/weidagang2046/p/fp-without-lambda-2.html)