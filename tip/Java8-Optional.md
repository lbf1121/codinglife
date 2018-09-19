## Java 8 - Optional
### 方法描述
这是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。

#### of(T value)
为非null的值创建一个Optional
```text
//创建Optional实例
Optional<String[]> arrOptional = Optional.of(new String[]{"java man"});
//传入参数为null，抛出NullPointerException.
Optional<String[]> nullOptional = Optional.of(null);
```    
#### ofNullable(T value)
为指定的值创建一个Optional，如果指定的值为null，则返回一个空的Optional
* ofNullable与of方法相似，唯一的区别是接受参数为null时并不抛出NPE而是返回一个Optional空对象。
```text
//创建一个不包含任何值的Optional实例。传入参数为null，返回Optional空对象。
Optional nullOptional = Optional.of(null);
```
#### isPresent()
如果值存在返回true，否则返回false。
```text
//isPresent方法用来检查Optional实例中是否包含值
if (arrOptional.isPresent()) {
  //在Optional实例内调用get()返回已存在的值
  System.out.println(arrOptional.get()[0]);//输出java man
}
```
#### get()
如果Optional有值则将其返回，否则抛出NoSuchElementException。
```text
try {
    //在空的Optional实例上调用get()，抛出NoSuchElementException
    System.out.println(nullOptional.get());
}catch (NoSuchElementException nse){
    //输出：No value present
    System.out.println(nse.getMessage());
}
```
#### ifPresent(Consumer<? super T> consumer)
如果Optional实例有值则为其调用consumer，否则不做处理
* 要理解ifPresent方法，首先需要了解[Consumer类](https://sanaulla.info/2013/04/01/predicate-and-consumer-interface-in-java-util-function-package-in-java-8/)。简答地说，Consumer类包含一个抽象方法。该抽象方法对传入的值进行处理，但没有返回值。Java8支持不用接口直接通过[lambda表达式](https://sanaulla.info/2013/03/11/using-lambda-expression-to-sort-a-list-in-java-8-using-netbeans-lambda-support/)传入参数。
* 如果Optional实例有值，调用ifPresent()可以接受接口段或lambda表达式
```text
//ifPresent方法接受lambda表达式作为参数。
//lambda表达式对Optional的值调用consumer进行处理。
arrOptional.ifPresent((value) -> {
   System.out.println("The length of the value is: " + value.length);
});
```
#### orElse(T other)
如果有值则将其返回，否则返回指定的其它值
```text
如果Optional实例有值则将其返回，否则返回orElse方法传入的参数。示例如下：
//如果值不为null，orElse方法返回Optional实例的值。
//如果为null，返回传入的消息。
//输出：There is no value present!
System.out.println(nullOptional.orElse("There is no value present!"));
//输出：java man
 System.out.println(arrOptional.orElse(new String[]{"There is else value!"})[0]);
```
#### orElseGet(Supplier<? extends T> other)
如果有值则将其返回，否则调用other，并返回其结果。
* orElseGet与orElse方法类似，区别在于得到的默认值。orElse方法将传入的字符串作为默认值，orElseGet方法可以接受Supplier接口的实现用来生成默认值
```text
//orElseGet与orElse方法类似，区别在于orElse传入的是默认值，
//orElseGet可以接受一个lambda表达式生成默认值。
//输出：Default Value
 System.out.println(nullOptional.orElseGet(() -> new String[]{"Default Value"})[0]);
//输出：java man
System.out.println(arrOptional.orElseGet(() -> new String[]{"Default Value"})[0]);
```
#### orElseThrow(Supplier<? extends X> exceptionSupplier)
如果有值则将其返回，否则抛出supplier接口创建的异常。
* 在orElseGet方法中，我们传入一个Supplier接口。然而，在orElseThrow中我们可以传入一个lambda表达式或方法，如果值不存在来抛出异常。
```text
try {
  //orElseThrow与orElse方法类似。与返回默认值不同，
  //orElseThrow会抛出lambda表达式或方法生成的异常 

  nullOptional.orElseThrow(ValueAbsentException::new);
} catch (Throwable ex) {
  //输出: No value present in the Optional instance
  System.out.println(ex.getMessage());
}

class ValueAbsentException extends Throwable {

  public ValueAbsentException() {
    super();
  }

  public ValueAbsentException(String msg) {
    super(msg);
  }

  @Override
  public String getMessage() {
    return "No value present in the Optional instance";
  }
}
```
#### map(Function<? super T,? extends U> mapper)
如果有值，则对其执行调用mapping函数得到返回值。如果返回值不为null，则创建包含mapping返回值的Optional作为map方法返回值，否则返回空Optional。
* map方法用来对Optional实例的值执行一系列操作。通过一组实现了Function接口的lambda表达式传入操作。如果你不熟悉Function接口，可以参考我的这篇博客
```text
//map方法执行传入的lambda表达式参数对Optional实例的值进行修改。
//为lambda表达式的返回值创建新的Optional实例作为map方法的返回值。
Optional<String[]> upperName = arrOptional.map((value) -> value.toUpperCase());
System.out.println(upperName.orElse("No value found"));
```
#### flatMap(Function<? super T,Optional<U>> mapper)
#### filter(Predicate<? super T> predicate)：

#### empty()：返回一个空的 Optional实例。
#### equals(Object obj)：
#### hashCode()
#### toString()

#### Optional参考文章：
* [Optional's API in Java 8](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html)
* [Java 8 Optional类深度解析](https://wizardforcel.gitbooks.io/java8-tutorials/content/Java%208%20Optional%20%E7%B1%BB%E6%B7%B1%E5%BA%A6%E8%A7%A3%E6%9E%90.html)
* [使用 Java8 Optional 的正确姿势](http://www.importnew.com/22060.html)
* [Guide To Java 8 Optional](https://www.baeldung.com/java-optional)
* [Java 8 Optional In Depth](https://www.mkyong.com/java8/java-8-optional-in-depth/)