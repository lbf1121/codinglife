## Function interface- A functional interface in the java.util.function package in Java 8
    I had previously written about functional interfaces and their usage. 
    If you are exploring the APIs to be part of Java 8 and especially those APIs which support lambda expressions you will find few interfaces like- Function, Supplier, Consumer, Predicate and others which are all part of the java.util.function package, being used extensively. 
    These interfaces have one abstract method, which is overridden by the lambda expression defined.
    
    In this post I will pick Function interface to explain about it in brief and it is one of the interfaces present in java.util.function package.
    
    Function interface has two methods:
    * R apply(T t) – Compute the result of applying the function to the input argument
    * default ‹V› Function‹T,V› – Combine with another function returning a function which performs both functions.
    
    In this post I would like to write about the apply method, creating APIs which accept these interfaces and parameters and then invoke their corresponding methods. 
    We will also look at how the caller of the API can pass in a lambda expression in place of an implementation of the interface. 
    Apart from passing a lambda expression, the users of the API can also pass method references, about which I havent blogged yet.
    
    Function interface is uses in cases where you want to encapsulate some code into a method which accepts some value as an input parameter and then returns another value after performing required operations on the input. 
    The input parameter type and the return type of the method can either be same or different.
    
Lets look at an API which accepts an implementation of Function interface:    
```Java
public class FunctionTest {
    public static void main(String[] args){
        int incr = 3;
        int myNumber = 20;
        modifyTheValue(myNumber,val->val + incr);
        modifyTheValue(myNumber,val->val - incr);
        modifyTheValue(myNumber,val->val * incr);
        modifyTheValue(myNumber,val->val / incr);
        modifyTheValue(myNumber,val->val % incr);
        modifyTheValue(myNumber, val-> "somestring".length() + val - 100);
    }

    //API which accepts an implementation of Function interface
    static void modifyTheValue(int valueToBeOperated, Function<Integer,Integer> function){
        int newValue = function.apply(valueToBeOperated);
        /** Do some operations using the new value
         */
        System.out.println(newValue);
    }
}
```