## What I learned from doing 1000 code reviews
    While working at LinkedIn a large part of my job involved doing code reviews. 
    在LinkedIn工作的时候，我的大部分工作是做代码复查。
    There were certain suggestions that kept coming up over and over again, so I decided to put together a list that I shared with the team.
    有一些建议不断的出现，所以我决定把我平时分享给我团队的一些建议整理一份清单，分享给大家。
    Here are my 3 (+1 bonus) most common code review suggestions.
    这里有3条常见的代码复查建议。
### Suggestion 1: Throw an exception when things go wrong 
### 建议1：当发生错误时，抛出一个异常
A common pattern I have seen is this:
我见过的一个常用模式是：
```
List<String> getSearchResults(...) {
  try {
    List<String> results = // make REST call to search service
    return results;
  } catch (RemoteInvocationException e) {
    return Collections.emptyList();
  }
}
```
    This pattern actually caused an outage in one of the mobile apps I worked on. 
    这个模式事实上导致了我工作的一个移动应用程序的宕机。
    The search backend we were using started throwing exceptions. 
    在搜索服务后端我们开始抛出异常。
    However, the app’s API server had some code similar to the above.
    然而，该应用的API服务器还有一些类似于上面的代码。 
    Therefore, from the perspective of the app it was getting a 200 successful response and happily showed an empty list for every single search query.
    因此，从应用的角度来说它得到一个200状态的成功响应，并且很高兴为每一个单独的搜索返回一个空列表。
    If instead the API had thrown an exception, then our monitoring systems would have picked this up immediately and it would have been fixed.
    相反，如果API服务器抛出一个异常，然后我们的监测系统直接捡起，它应该已经被修复了。
    There are lots of times when it may be tempting to just return an empty object after you’ve caught an exception.
    很多时候，在你捕获一个异常之后，返回一个空对象是很有诱惑力的。 
    Examples of empty objects in Java are Optional.empty(), null, and empty list. 
    在Java中空对象的例子是：Optional.empty(),null 和 空集合。
    A place where this comes up all the time is in URL parsing. 
    一个经常出现的地方就是URL解析。
    Instead of returning null if the URL can’t be parsed from a String, ask yourself: “Why is the URL malformed? Is this a data issue we should be fixing upstream?”.
    如果URL不能从字符串中解析，而不是返回null，请问你自己："为什么URL是不正确的？是不是我们应该在上游就该修复的数据问题？"
    Empty objects are not the right tool for this job. 
    空对象并不是这个工作的正确工具。（空对象并不适合解决这个问题）
    If something is exceptional you should throw an exception.
    如果一些事情是异常的，你应该抛出一个异常。
### Suggestion 2: Use the most specific type possible
### 建议2：使用最具体的类型
    This suggestion is basically the opposite of [stringly typed programming](http://wiki.c2.com/?StringlyTyped).
    这个建议基本上与字符串类型编程是对立的
    Too often I see code like these examples:
    我经常看到这样的代码：
```
void doOperation(String opType, Data data); 
// where opType is "insert", "append", or "delete", this should have clearly been an enum
// opType是"insert"、"append" 或 "delete",这里应该使用枚举enum。
String fetchWebsite(String url);
// where url is "https://google.com", this should have been an URN
// url参数是url地址字符串，这里应该使用URN(URI)，URN是URI的历史名称
String parseId(Input input);
// the return type is String but ids are actually Longs like "6345789"
// 返回类型是String，事实上id是Long型就像"6345789"
```
    Using the most specific type possible allows you to avoid a whole class of bugs and is basically the entire reason for choosing strongly typed language like Java in the first place.
    使用最具体的类型可以让你避免一大堆bugs，并且基本上也是首选择像Java这中强类型语言的原因。
    So now the question is: how do well-intentioned programmers end up writing bad stringly typed code? 
    所以，现在的问题是：为什么好的程序员最终会写出糟糕的字符串型代码呢？
    The answer: because the external world is not strongly typed. 
    答案是：因为外部的世界不是强类型的。
    There are a number of different places where strings come from, such as:
    这里有许多不同对地方，是都字符串类型的数据的来源，例如：
    * query and path parameters in urls 
    * 在url上的查询参数和路径上的参数
    * JSON
    * JSON数据
    * databases that don’t support enums
    * 数据库不知道枚举类型
    * poorly written libraries
    * 写的很差的库

    In all these cases, you should use the following strategy to avoid this problem: 
    所有这些情况，你都应该使用下面的策略来避免这个问题:
    keep string parsing and serialization to the fringes of your program.
    将字符串解析和序列化保存到程序的边缘。
    Here’s an example:
```
// Step 1: Take a query param representing a company name / member id pair and parse it
// 第一步：用字符串类型查询参数来表示一个公司的名称/成员ID对并解析它。
// example: context=Pair(linkedin,456)
Pair<String, Long> companyMember = parseQueryParam("context");
// this should throw an exception if malformed
// 如果错误，应抛出异常

// Step 2: Do all the stuff in your application
// 第二步：在你的应用中做你想做的所有事情
// MOST if not all of your code should live in this area
//如果你的代码不是所有都应该在这个区域，就写大部分代码

// Step 3: Convert the parameter back into a String at the very end if necessary
// 第三步：若果需要，将参数转换回字符串类型。
String redirectLink = serializeQueryParam("context");
```
    This confers a number of advantages. 
    这会来带很多好处。
    Malformed data is found immediately; the application fails early if there are any problems. 
    错误数据会被直接发现；如果有任何问题，应用程序会更早的报错。
    You also don’t have to keep catching parsing exceptions throughout the entire application once the data has been validated once.
    一旦数据被验证过一次，你也不必在整个应用程序中继续捕获、解析异常。
    In addition, strong types make for more descriptive method signatures; 
    另外，强类型可以提供更多的描述性方法签名；
    you don’t need to write as many javadocs on every method.
    你不必为每个方法都写大量的javadocs。
### Suggestion 3: Use Optionals instead of nulls
### 建议3：使用Optionals 代替 nulls
    One of the best features to come out of Java 8 is the Optional class that represents an entity which could reasonably exist or not exist.
    Java 8中最好的特征之一是 Optional类可以描述一个实体对象是否应该合理的存在。
    Trivia question: what is the only exception to have its own acronym? 
    细节问题：只有哪个异常拥有自己的首字母缩略词？
    Answer: a NPE or Null Pointer Exception. 
    答案：NPE（Null Pointer Exception）
    It is by far the most common exception in Java and has been referred to as a [billion dollar mistake](https://www.infoq.com/presentations/Null-References-The-Billion-Dollar-Mistake-Tony-Hoare).
    它是迄今为止，Java中最常出现的异常，可以参考文章：[10亿美元的错误](https://www.infoq.com/presentations/Null-References-The-Billion-Dollar-Mistake-Tony-Hoare).
    Optional allows you to completely remove NPEs from your program. 
    Optional允许你从程序中完全的移除NPES。
    However, it must be used correctly. 
    然而，它必须被正确的使用。
Here’s some advice surrounding the use of Optional:
这里有一些使用Optional的建议：
* You should not simply call .get() anytime you have an Optional in order to use it, instead think carefully about the case where the Optional is not present and come up with a sensible default value.
* If you do not yet have a sensible default value then methods like .map() and .flatMap() allow you to defer this decision until later.
* If an external library returns null to indicate the empty case, then immediately wrap the value using Optional.ofNullable(). Trust me, you will thank yourself later. nulls have a tendency to “bubble up” inside programs so it’s best to stop them at the source.
* Use Optional in the return type of methods. This is great because then you don’t need to read the javadoc to figure out whether it’s possible for the value to not be present.
### Bonus Suggestion: “Unlift” methods whenever possible
You should try to avoid methods that look like this:
你应该尝试避免使用下面的方法：
```
// AVOID: 避免使用
CompletableFuture<T> method(CompletableFuture<S> param);
// PREFER: 更喜欢使用
T method(S param);

// AVOID:
List<T> method(List<S> param);
// PREFER:
T method(S param);

// AVOID: 
T method(A param1, B param2, Optional<C> param3);
// PREFER:
T method(A param1, B param2, C param3);
T method(A param1, B param2);
// This method is clearly doing two things, it should be two methods
// The same is true for boolean parameters
```
    What do all the avoid methods have in common? 
    所有要避免的方法有什么共同之处？
    They are using container objects like Optional, List, or Task as method parameters. 
    他们都使用像Optional、List或Task作为方法参数的容器对象。
    It’s even worse when the return type is the same kind of container (ie. a one param methods takes an Optional and returns an Optional).
    更糟糕的是返回类型也是同一类型的容器
    Why?
    1) Promise<A> method(Promise<B> param)
    is less flexible than simply having
    2) A method(B param).
    1) 比 2) 更缺少灵活性。

    If you have a Promise<B> then you can use 1) or you can use 2) by “lifting” the function with .map. (ie. promise.map(method)).
    如果你有参数Promise<B> 你可以使用 1) 或 2)
    However, if you have just B then you can easily use 2) but you can’t use 1), which makes 2) the much more flexible option.
    
    I like to call this “unlifting” because it is the opposite of the common functional utility method “lift”. 
    Applying these rewrites make methods more flexible and easier to use for callers.

    作者在大量的code review中总结出的一些经验。
    关于异常处理：虽然并没有看到过像作者说的那样的代码，但是自己在工作对于异常的处理方式也是不合理的。习惯将所有一次catch住，通过打印异常日志信息，使用这些信息调试代码。
    关于具体类型：这个在工作中确实很常见，很多软件设计的时候，都是大量的String类型，包括数据库的设计。似乎字符串类型就可以搞定一切，如此设计也确实放弃了强类型语言本身的一大优势。自己在工作中也犯过同样的错误，特别是对枚举类型，没有好好利用。
    关于Optional：Optional是Java 8的新特性，还不熟悉这个类。
    作者的三个建议是自己都没有掌握的技术，接下来我会分别几篇文章，来学习这些技术点：异常、强类型、Optional、Lifting。

#### 关于Lifting Function介绍
* [Lifting](https://wiki.haskell.org/Lifting)
* [Lifting Functions to Work With Java Monads](https://dzone.com/articles/lifting-functions-to-work-with-monads-in-java)

#### Optional参考文章：
* [Optional's API in Java 8](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html)
* [Java 8 新特性概述](https://www.ibm.com/developerworks/cn/java/j-lo-jdk8newfeature/index.html)
* [使用 Java8 Optional 的正确姿势](http://www.importnew.com/22060.html)
* [Java 8 Optional类深度解析](https://wizardforcel.gitbooks.io/java8-tutorials/content/Java%208%20Optional%20%E7%B1%BB%E6%B7%B1%E5%BA%A6%E8%A7%A3%E6%9E%90.html)
* [Guide To Java 8 Optional](https://www.baeldung.com/java-optional)
* [Java 8 Optional In Depth](https://www.mkyong.com/java8/java-8-optional-in-depth/)

#### 关于异常
* [Top 20 Java Exception Handling Best Practices](https://howtodoinjava.com/best-practices/java-exception-handling-best-practices/)
* [9 Best Practices to Handle Exceptions in Java](https://stackify.com/best-practices-exceptions-java/)
* [Why you should ignore exceptions in Java and how to do it correctly](https://medium.freecodecamp.org/why-you-should-ignore-exceptions-in-java-and-how-to-do-it-correctly-8e95e5775e58)

[What I learned from doing 1000 code reviews(原文)](https://hackernoon.com/what-i-learned-from-doing-1000-code-reviews-fe28d4d11c71)