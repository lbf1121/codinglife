##How do I print my name 1000 times in Java without looping?
####Different solutions have been proposed:
    
    1.Recursion: Using a function that calls itself with a decrementing parameter counting the times it still has to call itself
    2.Nested functions: Using functions that call subfunctions an arbitrary amount of times so that the product of all of them equals 1000 (for example 10*10*10)
    3.String concatenation: Creating a string of 1000 identical characters and using the replace function on them, for example through
        Conversing a just initialized char array[1000] to String, knowing that it initializes with “\0” for each character
        Using the replace function multiple times on its result, similar to the nested function approach
        Using Collections.nCopies()
        Using Arrays.parallelSetAll()
        Using IntStream.mapToObj().forEach()
    4.Semantics: Understanding the task as needing to print “my name 1000 times in Java without looping”
    5.Scheduling
    6.Using the loop abilities of the console, just running the file 1000 times
    7.Letting a class constructors print and then creating 1000 objects of this class. This uses the java-specifity that an array of such objects gets initialized directly at the declaration of the array.
    8.Using GoTo Statements (not possible in Java)
    9.Just writing the statement 1000 times (using copy&paste)
    
    The usefulness of this question has been questioned multiple times, since without explicit reasons there is no need not to use loops. 
    On the other hand it has been argued that this can be a good excercise for the very specific times when looping is not a good approach.
    ......
[原文](https://www.quora.com/How-do-I-print-my-name-1000-times-in-Java-without-looping)

本文讲述的内容是：如何在不使用looping的情况下，输出1000次名字。
提出了很多有意思的方案：
Recursion
    void display(String name,int p)
    {
        System.out.println(p+"."+name);
        if(p==1000)
        {
            System.exit(0);
        }
        display(name,++p);
    }
    
Scheduling 使用定时器
```Java
import java.util.Timer;
import java.util.TimerTask;
 
public class ShreyashPrinter {
 
    Timer timer;
    int count = 1000;
    
    public ShreyashPrinter(){
        timer = new Timer();
        timer.schedule(
            new TimerTask() {
 
                public void run() {
                    if (count == 0) {
                        timer.cancel();
                        System.exit(0);
                    }
 
                    System.out.println("Shreyash");
                    count--;
                }
            }, 0, 
            1 * 100
        );
    }
 
    public static void main(String args[]) {
        new ShreyashPrinter();
    }
}

```    
非常简短的代码：现实在数字0前面补1000个0，软化将1000个0字符串替换成名称
   
    public class Names {
        public static void main(String [] args) {
            //%0:数字前面补0
            System.out.print(String.format("%01000d",0).replace("0","Shreyash\n"));
        }
    }
    
利用字符串数组初始化值\0

    public class NoDirectLooping {
        public static void main(String args[]) {
            System.out.println(multiplyString("Shreyash\n", 1000));
        }
        
        private static String multiplyString(String input, int count) {
            return new String(new char[count]).replace("\0", input);
        }
    }
    
不一一列举，看似简单，其实很考验对基础知识的掌握程度。 循环不一定使用for、while、do-while       