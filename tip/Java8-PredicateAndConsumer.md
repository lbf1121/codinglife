## Predicate and Consumer Interface in java.util.function package in Java 8
In my previous post I wrote about [Function interface](https://sanaulla.info/2013/03/27/function-interface-a-functional-interface-in-the-java-util-function-package-in-java-8/) which is part of java.util.package. 
I also mentioned about Predicate interface which is part of the same package and in this post I will show you how you can make use of the [Predicate](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html) and [Consumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html) interfaces.

Lets look at the Javadoc for Predicate interface:
```text
Determines if the input object matches some criteria.
```
And there are 5 methods declared/defined in that interface (you must be wondering how this is a functional interface, 
if you are then you must read this before proceeding) and those methods are:
```Java
//Returns a predicate which evaluates to true only if this predicate
//and the provided predicate both evaluate to true.
and(Predicate<? super T> p)

//Returns a predicate which negates the result of this predicate.
negate()

//Returns a predicate which evaluates to true if either
//this predicate or the provided predicate evaluates to true
or(Predicate<? super T> p)

//Returns true if the input object matches some criteria
test(T t)

//Returns a predicate that evaluates to true if both or neither
//of the component predicates evaluate to true
xor(Predicate<? super T> p)
```
All of the methods except test(T t) are default methods and test(T t) is abstract. 
One approach of providing the implementation for this abstract method is to use Anonymous inner class and the other approach is to use lambda expression.

The Javadoc for Consumer interface states:
```text
An operation which accepts a single input argument and returns no result. Unlike most other functional interfaces, Consumer is expected to operate via side-effects.
```
There are 2 methods in this interface out of which only one is abstract and that abstract method is: accept(T t), which accepts an input and doesn’t return any result.

To explain more about Predicate and Consumer interface lets consider a Student class with name, grade and fee to be paid. Each student has some discount which is decided based on the Student’s grade.
```Java
class Student{
    String firstName;
    String lastName;
    Double grade;
    Double feeDiscount = 0.0;
    Double baseFee = 20000.0;
    
    public Student(String firstName, String lastName,
    Double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }
    
    public void printFee(){
        Double newFee = baseFee - ((baseFee*feeDiscount)/100);
        System.out.println("The fee after discount: "+newFee);
    }
}
```
And lets create a method which accepts a Student object, a Predicate implementation and a Consumer implementation. If you are not familiar with Function interface, then you should spent few minutes reading this. This method uses the predicate to decide if the student discount on the fee has to be updated and then uses the Consumer implementation to update the discount.
```Java
public class PreidcateConsumerDemo {

    public static Student updateStudentFee(Student student,
        Predicate<Student> predicate,
        Consumer<Student> consumer){
        
        //Use the predicate to decide when to update the discount.
        if ( predicate.test(student)){
            //Use the consumer to update the discount value.
            consumer.accept(student);
        }
        return student;
    }
}
```
Both the test method and the accept method in the Predicate and Consumer respectively accept a parameter of the generic type declared. The difference between these is that the predicate uses the parameter to make some decision and return a boolean whereas Consumer uses the parameter to change some of its value.
Lets look at how the updateStudentFee method is invoked:
```Java
public static void main(String[] args) {

    Student student1 = new Student("Ashok","Kumar", 9.5);
    student1 = updateStudentFee(student1,
    //Lambda expression for Predicate interface
    student -> student.grade > 8.5,
    //Lambda expression for Consumer inerface
    student -> student.feeDiscount = 30.0);
    student1.printFee();
    
    Student student2 = new Student("Rajat","Verma", 8.0);
    student2 = updateStudentFee(student2,
    student -> student.grade >= 8,
    student -> student.feeDiscount = 20.0);
    student2.printFee();

}
```
In this post I explained with a sample how we can make use of Predicate and Consumer interfaces which are part of the java.util.function package to be introduced in Java 8.