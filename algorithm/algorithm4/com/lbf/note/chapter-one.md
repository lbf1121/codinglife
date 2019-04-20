## 第一章 基础
### 1.1 基础编程模型
#### 1.1.1 Java程序的基本结构
创建静态方法库和定义数据类型，会用到下面物种语法：
* 原始数据类型：byte short int long float double boolean char
* 语句：声明 赋值 条件 循环 调用 返回
* 数组：是多个同种数据类型的值的集合
* 静态方法：可以封装并重用代码，使我们可以用独立的模块开发程序
* 字符串：一连串的字符
* 标准输入/输出：是程序与外接的桥梁
* 数据抽象：封装和重用代码，可以定义非原始数据类型，进而支持面向对象编程。
#### 1.1.2 原始数据类型与表达式
* 标识符：由字母、数字、下划线 和 $ 组成的字符串，首字母不是数字
* 字面量：值在源代码中的表示
##### 表达式
运算符有优先级：* / % 的优先级高于 + -；在逻辑运算符中，！拥有最高优先级，之后是&&，接下来是||。同级运算符运算顺序从左到右。
##### 类型转换
数值会被自动提升为高级的数据类型，2+3.5中2会被转换为浮点数2.0，表达式的值也为double值5.5。
转换指的是在表达式中把类型名放在括号里将其后的值转换为括号中的类型。
应尽量少使用类型转换，最好是在表达式中只使用同一类型的字面量和变量。
##### 比较
== != < <= > >= 比较相同类型的两个值并产生一个布尔值
#### 1.1.3 语句
* 声明语句
* 赋值语句
* 条件语句： if(<boolean expression>){<block statement>}
* 循环语句: while(<boolean expression>){<block statement>}
* 调用和返回语句：int key = StdIn.readInt(); return key;
* break语句，立即从循环中推出
* continue语句，立即开始下一轮循环
#### 1.1.4 简便记法
* 声明并初始化： int a = 1；
* 隐式赋值：++i；
* 单语句代码段：如果条件、循环语句的代码段只有一条语句，代码段的花括号可以省略
* for 语句：for（<initialize>;<boolean expression>;<increment>）{<block statement>}
#### 1.1.5 数组
创建数组三步：
* 声明数组的名字和类型
* 创建数组
* 初始化数组元素
使用数组时注意防止ArrayOutOfBoundsException的异常而终止程序
##### 典型数组的处理代码
```text
    找出数组中最大元素
    double max = a[0];
    for(int i = 1; i < a.length; i++){
        if(a[i] > max) max = a[i];
    }
    
    计算数组元素的平均值
    int N = a.length;
    double sum = 0.0;
    
    for(int i = 1; i < N; i++){
        sum += a[i];
    }
    double average = sum / N;
    
    复制数组
    int N = a.length;
    double[] b = new double[N];
    for(int i = 1; i < N; i++){
        b[i] = a[i];
    }
    
    颠倒数组元素的顺序
    int N = a.length;
    for(int i = 1; i < N/2; i++){
        double temp = a[i];
        a[i] = a[N-1-i];
        a[N-1-i] = temp;
    }
    
    矩阵相乘（方阵）：a[][] * b[][] = c[][]
    int N = a.length;
    double[][] c = new double[N][N]; 
    for(int i = 0; i < N;i++){
        for(int j = 0; j < N; j++){
            //计算行i和行j的点乘
            for(int k = 0; k < N ; k++){
                c[i][j] += a[i][k] * b[k][j];
            }
        }
    }
    
```
二维数组：double[][] a = new double[M][N];
#### 1.1.6 静态方法
```text
    签名    static   返回类型 方法名 （参数类型 参数变量） { 代码块 }
    public static double sqrt(double c){
        if (c < 0) return Double.NaN;
        double err = 1e-15;
        double t = c;
        while(Math.abs(t - c/t) > err * t){
            t = (c/t + t) / 2.0;
        }
        return t;
    }
```
##### 典型的静态方法实现
```text
    计算一个整数的绝对值
    public static int abs(int x){
        if( x < 0) return -x;
        else return x;
    }
    
    计算一个浮点数的绝对值
    public static double abs(double x){
        if( x < 0.0) return -x;
        else return x;
    }
        
    判定一个数是否为素数：不理解计算原理
    public static boolean isPrime(int N){
        if( N < 2) return false;
        for(int i = 2; i*i <= N; i++){
            if(N % i ==0) return false;
        }
        return true;
    }
    
    计算平方根（牛顿迭代法）: 不理解计算原理
    public static double sqrt(double c){
        if (c < 0) return Double.NaN;
        double err = 1e-15;
        double t = c;
        while(Math.abs(t - c/t) > err * t){
            t = (c/t + t) / 2.0;
        }
        return t;
    }
    
    计算直角三角形的斜边
    public static double hypotenuse(double a,double b){
        return Math.sqrt(a*a + b*b);
    }
    
    计算调和级数
    public static double H(int N){
        double sum = 0.0;
        for(int i = 1; i <= N;i++){
            sum += 1.0 / i;
        }
        return sum;
    }
```
* [调和级数](https://zh.wikipedia.org/wiki/%E8%B0%83%E5%92%8C%E7%BA%A7%E6%95%B0)
* [牛顿迭代法](https://zh.wikipedia.org/wiki/%E7%89%9B%E9%A1%BF%E6%B3%95)

##### 方法的性质

* 方法的参数按值传递
* 方法名可以被重载
* 方法只能返回一个值，但可以包含多个返回语句
* 方法可以产生副作用

##### 递归
方法可以调用自己

编写递归代码时最重要的三点：
* 递归总有一个最简单的情况-----方法的第一条语句总是一个包含return的条件语句
* 递归调用总是去尝试解决一个规模更小的子问题，这样递归才能收敛到最简单的情况
* 递归调用的父问题和尝试解决的子问题之间不应该有交集

```text
/* 二分查找的递归实现 */

//查找key是否存在于数组a中
public static int rank(int key,int[] a){
    return rank(key,a,0,a.length-1);
}

//lo 数组的起始索引，hi数组的结束索引
public static int rank(int key,int[] a,int lo,int hi){
    //如果key存在于a[]中，它的索引不会小于lo且不会大于hi
    
    if(lo > hi) return -1;
    int mid = lo + (hi - lo) / 2;                          //lo与hi的中间索引
    if     (key < a[mid]) return rank(key,a,lo,mid - 1);   //查找数组前半部分
    else if(key > a[mid]) return rank(key,a,mid + 1,hi);   //查找数组后半部分
    else                  return mid;                      //返回结果key在int数组a中的索引
}
```
##### 模块化编程
好处：
* 程序整体的代码量很大时，每次处理的模块大小仍然适中
* 可以共享和重用代码而不需要重新实现
* 很容易用改进的实现替换老的实现
* 可以为解决编程问题建立合适的抽象模型
* 缩小调试范围

##### 单元测试
##### 外部库
会使用的4个不同类型的库中的静态方法
* 系统标准库 java.lang.* ：这其中包括Math库，实现了常用的数学函数；Integer和Double库，String和StringBuilder库；
* 导入的系统库，例如java.utils.Arrays。在程序中使用import语句导入
* 本书中的其他库：其他程序也可以使用BinarySearch的rank()方法。
* 为本书开发的标准库Std*：
#### 1.7 API
##### Java 的数学函数库的API
public class Math
* static double abs(double a)           :   a的绝对值
* static double max(double a,double b)  :   a和b中的较大者
* static double min(double a,double b)  :   a和b中的较小者
###### 注1：abs()、max()、min()也定义了int、long和float的版本
* static double sin(double theta)       :   正弦函数
* static double cos(double theta)       :   余弦函数
* static double tan(double theta)       :   正切函数
###### 注2：角用弧度表示，可以使用toDegrees() 和 toRadians()转换角度和弧度
###### 注3：它们的反函数分别为asin()、acos()、atan()

* static double exp(double a)           :   指数函数（e<sup>e</sup>）
* static double log(double a)           :   自然对数函数（log<sub>e</sub>a,即ln a）
* static double pow(double a,double b)  :   求a的b次方（a<sup>b</sup>）
* static double random()                :   [0,1)之间的随机数
* static double sqrt(double a)          :   a的平方根
* static double E                       :   常数e
* static double PI                      :   常数π

public class Arrays
* static void sort(int[] a)             :   将数组按升序排序

##### 概率与统计
* [正态分布（高斯分布）](https://zh.wikipedia.org/wiki/%E6%AD%A3%E6%80%81%E5%88%86%E5%B8%83)
* [中位数](https://zh.wikipedia.org/wiki/%E4%B8%AD%E4%BD%8D%E6%95%B8)

#### 1.1.8 字符串
##### 1.1.8.2 类型转换
    String值与数字之间的转换API
    
    public class Integer
    static    int   parseInt(String s)      //将字符串s转换为整数
    static    String    toString(int i)     //将整数i转换为字符串
    
    public class Double
    static    double    parseDouble(String s)   //将字符串s转换为浮点数
    static    String    toString(double x)      //将浮点数x转化为字符串
#### 1.1.9 输入输出
    
    //d：整型的十进制数；f：浮点型；s：字符串
    System.out.printf("%.6f\n", 1.0/7.0);   //.6f ：保留6位小数的float类型  
##### printf()格式化方式
    int     d       512                     "%14d"     "           512"
                                            "%-14d"    "512           "
                                            
    double  f       1595.1680010754388      "%14.2f"   "1595.17       "               
            e                               "%.7f"     "1595.1680011"
                                            "%14.4e"   "    1.5952e+03"
                                            
    String  s       "Hello, World"          "%14s"     "  Hello, World"
                                            "%-14s"    "Hello,World   "
                                            "%14.5s"   "Hello         "  
##### 1.1.9.5 重定向与管道
* 将一个程序的输出重定向为另一个程序的输入叫做管道   
```text
    将一个文件重定向为一个标准输入：
    % java Average < data.txt
    data.txt-->标准输入-->Average
    
    将标准输出重定向到一个文件：
    % java RandomSeq 1000 100.0 200.0 > data.txt
    RandomSeq-->标准输入-->data.txt
    
    将一个程序的输出通过管道作为另一个程序的输入：
    % java RandomSeq 1000 100.0 200.0 | java Average
    RandomSeq-->标准输出-->标准输入-->Average
    
```                                         
#### 1.1.10 二分查找
```java
    import java.util.Arrays;
    import algorithm4.com.lbf.java.*;
    public class BinarySearch{
        public static int rank(int key,int[] a){
            //数组必须是有序的
            int lo = 0;
            int hi = a.length - 1;
            while(lo <= hi){
                //被查找的键要么不存在，要么必然存在与a[lo...hi]之中
                int mid = lo + (hi - lo) / 2;   //计算lo与hi的中间值
                if(key < a[mid])   hi = mid - 1;
                else if(key > a[mid])   lo = mid + 1;    
                else return mid;
                
            }
            return -1;
        }
        public static void main(String[] args){
            int[] whitelist = In.readInts(args[0]);
            Arrays.sort(whitelist);
            while (!StdIn.isEmpty()){
                //读取键值，如果不存在于白名单中则将其打印
                int key = StdIn.readInt();
                if (rank(key,whitelist) < 0)
                    StdOut.println(key);
            }
        }
    }
```                                                                                      
##### 答疑
1.负数除法和余数的结果?

答：表达式a / b的商会向0取整；a % b 的余数的定义是(a / b) * b + a % b 恒等于 a。
例如：-14 / 3 和 14 / -3 的商都是-4，但是-14 % 3 是-2，14 % -3 是2。

2.嵌套if语句中的二义性有问题吗？

答：是的，java中，以下语句
```text
    if <expr1> if<expr2>  <stmntA>  else <stmntB>
    等价于
    if <expr1> { if<expr2>  <stmntA>  else <stmntB> }
```
### 1.2 数据抽象
###### 典型的字符串处理代码
```java
    
    class StringObj{
        //判断字符串是否是一条回文
        public static boolean isPalindrome(String s){
            int N = s.length();
            for(int i = 0; i < N/2; i++) {
               if(s.charAt(i) != s.charAt(N-1-i))
                   return false;  
            }
            return true;
        }
        
        //从一个参数中提取文件名和扩展名
        public static void getFileNameAndPrefix(String s){
            int dot = s.indexOf(".");
            String base = s.substring(0,dot);
            String extension = s.substring(dot+1,s.length());
        }  
        
        //String s = "";
        //s.split("\\s+");  
        //  
        // 正则表达式中\s匹配任何空白字符，包括空格、制表符、换页符、回车符、换行符等，等价于[\f\n\r\t\v]
        /*
            \f  匹配一个换页 
            \n  匹配一个换行符
            \r  匹配一个回车符
            \t  匹配一个制表符
            \v  匹配一个垂直制表符
        */
        
        //检查一个字符串数组中的元素是否已按照字母表顺序排列
        public boolean isSorted(String[] a){
            for(int i = 1; i < a.length; i++) {
                if(a[i-1].compareTo(a[i])>0)
                    return false;
            }
            return true;
        }
    }
    
```
* 原始数据类型更解决计算机的硬件所支持的数据类型，因此它们比使用引用数据类型的程序运行的更快

### 1.3 背包、队列、栈
#### 1.3.1 API
* Bag 背包
* Queue 队列（先进先出-FIFO） 
* Stack 栈（后进先出-LIFO）
#### 1.3.1.1 泛型                                         
* 泛型也叫参数化类型    
```
    Stack<String> stack = new Stack<String>();   
    stack.push("hello");
    ....
    String next = stack.pop();
```      
* 样本差：每个值和平均值之差的平方之和除以N-1之后的平方根
* java中不允许创建泛型数组
```java
public class FixedCapacityStackOfStrings<Item> {
    private Item[] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap){
        //a = new Item[cap];   //此种创建泛型数组的方式不被允许，应该使用强制类型转换代替，代码如下：
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty(){ return N == 0; }

    public int size(){ return N; }

    public void push(Item item){
        if (N == a.length) resize(2*a.length);
        a[N++] = item;
    }

    public Item pop(){
       return a[N--];
    }
    
    public void resize(int max){
        //将大小为N <= max的栈移动到一个新的大小为max的数组中
        Item[] temp = (Item[])new Object[max];
        for(int i = 0; i < N; i++) {
           temp[i] = a[i];
        }
        a = temp;
    }
}
```
* 链表是数组的一种重要的替代方式

### 1.4 算法分析