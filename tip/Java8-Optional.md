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
* 如果Optional实例有值则将其返回，否则返回orElse方法传入的参数。
```text
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
* map方法用来对Optional实例的值执行一系列操作。通过一组实现了Function接口的lambda表达式传入操作。如果你不熟悉Function接口，可以参考我的[这篇博客](https://sanaulla.info/2013/03/27/function-interface-a-functional-interface-in-the-java-util-function-package-in-java-8/)
```text
//map方法执行传入的lambda表达式参数对Optional实例的值进行修改。
//为lambda表达式的返回值创建新的Optional实例作为map方法的返回值。
Optional<String[]> upperName = arrOptional.map((value) -> toUpperCase(value));
System.out.println(upperName.orElse(new String[]{"No value found"})[0]);

//将字符串数组内所有元素转为大写
static String[] toUpperCase(String[] arr){
    for(int i=0;i<arr.length;i++){
        arr[i] = arr[i].toUpperCase();
    }
    return arr;
}
```
#### flatMap(Function<? super T,Optional<U>> mapper)
如果有值，为其执行mapping函数返回Optional类型返回值，否则返回空Optional。flatMap与map（Funtion）方法类似，区别在于flatMap中的mapper返回值必须是Optional。调用结束时，flatMap不会对结果用Optional封装。
* flatMap方法与map方法类似，区别在于mapping函数的返回值不同。map方法的mapping函数返回值可以是任何类型T，而flatMap方法的mapping函数必须是Optional。
```text
//flatMap与map（Function）非常类似，区别在于传入方法的lambda表达式的返回类型。
//map方法中的lambda表达式返回值可以是任意类型，在map函数返回之前会包装为Optional。 
//但flatMap方法中的lambda表达式返回值必须是Optionl实例：(value) -> Optional.of(toUpperCase(value))。 
upperName = arrOptional.flatMap((value) -> Optional.of(toUpperCase(value)));
System.out.println(upperName.orElse(new String[]{"No value found"})[0]);
```
#### filter(Predicate<? super T> predicate)：
如果有值并且满足断言条件返回包含该值的Optional，否则返回空Optional。
* filter个方法通过传入限定条件对Optional实例的值进行过滤。读到这里，可能你已经知道如何为filter方法传入一段代码。是的，这里可以传入一个lambda表达式。对于filter函数我们应该传入实现了Predicate接口的lambda表达式。如果你不熟悉Predicate接口，可以参考[这篇文章](https://sanaulla.info/2013/04/01/predicate-and-consumer-interface-in-java-util-function-package-in-java-8/)。
现在我来看看filter的各种用法，下面的示例介绍了满足限定条件和不满足两种情况：
```text
//filter方法检查给定的Option值是否满足某些条件。
//如果满足则返回同一个Option实例，否则返回空Optional。
Optional<String[]> longName = arrOptional.filter((value) -> value.length > 1);
System.out.println(longName.orElse(new String[]{"The name is less than 6 characters"})[0]);

//另一个例子是Optional值不满足filter指定的条件。
Optional<String[]> shortName = arrOptional.filter((value) -> value.length > 6);
System.out.println(shortName.orElse(new String[]{"The array length is less than 6"})[0]);
```
以上，我们介绍了Optional类的各个方法。下面通过一个完整的示例对用法集中展示：
```java
public class OptionalDemo {

  public static void main(String[] args) {
    //创建Optional实例，也可以通过方法返回值得到。
    Optional<String> name = Optional.of("Sanaulla");

    //创建没有值的Optional实例，例如值为'null'
    Optional empty = Optional.ofNullable(null);

    //isPresent方法用来检查Optional实例是否有值。
    if (name.isPresent()) {
      //调用get()返回Optional值。
      System.out.println(name.get());
    }

    try {
      //在Optional实例上调用get()抛出NoSuchElementException。
      System.out.println(empty.get());
    } catch (NoSuchElementException ex) {
      System.out.println(ex.getMessage());
    }

    //ifPresent方法接受lambda表达式参数。
    //如果Optional值不为空，lambda表达式会处理并在其上执行操作。
    name.ifPresent((value) -> {
      System.out.println("The length of the value is: " + value.length());
    });

    //如果有值orElse方法会返回Optional实例，否则返回传入的错误信息。
    System.out.println(empty.orElse("There is no value present!"));
    System.out.println(name.orElse("There is some value!"));

    //orElseGet与orElse类似，区别在于传入的默认值。
    //orElseGet接受lambda表达式生成默认值。
    System.out.println(empty.orElseGet(() -> "Default Value"));
    System.out.println(name.orElseGet(() -> "Default Value"));

    try {
      //orElseThrow与orElse方法类似，区别在于返回值。
      //orElseThrow抛出由传入的lambda表达式/方法生成异常。
      empty.orElseThrow(ValueAbsentException::new);
    } catch (Throwable ex) {
      System.out.println(ex.getMessage());
    }

    //map方法通过传入的lambda表达式修改Optonal实例默认值。 
    //lambda表达式返回值会包装为Optional实例。
    Optional<String> upperName = name.map((value) -> value.toUpperCase());
    System.out.println(upperName.orElse("No value found"));

    //flatMap与map（Funtion）非常相似，区别在于lambda表达式的返回值。
    //map方法的lambda表达式返回值可以是任何类型，但是返回值会包装成Optional实例。
    //但是flatMap方法的lambda返回值总是Optional类型。
    upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
    System.out.println(upperName.orElse("No value found"));

    //filter方法检查Optiona值是否满足给定条件。
    //如果满足返回Optional实例值，否则返回空Optional。
    Optional<String> longName = name.filter((value) -> value.length() > 6);
    System.out.println(longName.orElse("The name is less than 6 characters"));

    //另一个示例，Optional值不满足给定条件。
    Optional<String> anotherName = Optional.of("Sana");
    Optional<String> shortName = anotherName.filter((value) -> value.length() > 6);
    System.out.println(shortName.orElse("The name is less than 6 characters"));
  }
}
```
#### empty()
返回一个空的 Optional实例。
```text
Optional optional = Optional.empty();
//在空的Optional实例上调用get()，抛出NoSuchElementException
System.out.println(optional.get());
```
#### equals(Object obj)
Indicates whether some other object is "equal to" this Optional.
#### hashCode()
Returns the hash code value of the present value, if any, or 0 (zero) if no value is present.
#### toString()
Returns a non-empty string representation of this Optional suitable for debugging.

#### Optional参考文章：
* [Optional's API in Java 8](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html)
* [Java 8 Optional类深度解析](https://wizardforcel.gitbooks.io/java8-tutorials/content/Java%208%20Optional%20%E7%B1%BB%E6%B7%B1%E5%BA%A6%E8%A7%A3%E6%9E%90.html)
* [Guide To Java 8 Optional](https://www.baeldung.com/java-optional)
* [Java 8 Optional In Depth](https://www.mkyong.com/java8/java-8-optional-in-depth/)
* [使用 Java8 Optional 的正确姿势](http://www.importnew.com/22060.html)