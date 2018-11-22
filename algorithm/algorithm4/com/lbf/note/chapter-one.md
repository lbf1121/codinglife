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
格式化输出
    
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
                                                                                      
                                            
            