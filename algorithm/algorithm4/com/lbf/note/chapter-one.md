## 第一章 基础
### 1-1 基础编程模型
#### 1-1-1 Java程序的基本结构
创建静态方法库和定义数据类型，会用到下面物种语法：
* 原始数据类型：byte short int long float double boolean char
* 语句：声明 赋值 条件 循环 调用 返回
* 数组：是多个同种数据类型的值的集合
* 静态方法：可以封装并重用代码，使我们可以用独立的模块开发程序
* 字符串：一连串的字符
* 标准输入/输出：是程序与外接的桥梁
* 数据抽象：封装和重用代码，可以定义非原始数据类型，进而支持面向对象编程。
#### 1-1-2 原始数据类型与表达式
* 标识符：由字母、数字、下划线 和 $ 组成的字符串，首字母不是数字
* 字面量：值在源代码中的表示
##### 1-1-2-1 表达式
运算符有优先级：* / % 的优先级高于 + -；在逻辑运算符中，！拥有最高优先级，之后是&&，接下来是||。同级运算符运算顺序从左到右。
##### 1-1-2-2 类型转换
数值会被自动提升为高级的数据类型，2+3.5中2会被转换为浮点数2.0，表达式的值也为double值5.5。
转换指的是在表达式中把类型名放在括号里将其后的值转换为括号中的类型。
应尽量少使用类型转换，最好是在表达式中只使用同一类型的字面量和变量。
##### 1-1-2-3 比较
== != < <= > >= 比较相同类型的两个值并产生一个布尔值
#### 1-1-3 语句
* 声明语句
* 赋值语句
* 条件语句： if(<boolean expression>){<block statement>}
* 循环语句: while(<boolean expression>){<block statement>}
* 调用和返回语句：int key = StdIn.readInt(); return key;
* break语句，立即从循环中推出
* continue语句，立即开始下一轮循环
#### 1-1-4 简便记法
* 声明并初始化： int a = 1；
* 隐式赋值：++i；
* 单语句代码段：如果条件、循环语句的代码段只有一条语句，代码段的花括号可以省略
* for 语句：for（<initialize>;<boolean expression>;<increment>）{<block statement>}
#### 1-1-5 数组
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
#### 1-1-6 静态方法
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
