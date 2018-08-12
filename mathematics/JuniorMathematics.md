<script src='https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.4/MathJax.js?config=TeX-MML-AM_CHTML' async></script>

小学数学
============
Week One 5年级下
------------
###1.因数、倍数、完全数
  概念：2 * 6 = 12，2、6 是 12 的因数，12 是 2、6 的倍数。 完全数：6 = 1 + 2 + 3

  [java] 查找1000以下的完全数。<br>
  解析：迭代每一个数，并计算出所有小于当前数并能被这个数模运算等于0的数的和，如果和等于这个数，那么这个数就是完全数。<br>
  ```Java
 public class Math{
    static List findPerfectNumber(int num){
            List rs = new ArrayList();
            for(int i=2;i<=num;i++){
                int a = i;
                int sum = 0;
                for(int j=1;j<i;j++){
                    if(a%j==0){
                        sum += j;
                    }
                }
    
                if(a==sum){
                    rs.add(a);
                }
            }
            return rs;
       }
  }
  ```
 Week Two
 -----------
 ###1.奇数和偶数 
   定义：自然数中，是2的倍数的数叫偶数也叫双数），不是2的倍数的数叫奇数也叫单数。
   ```
     计算奇数-ood： if(n % 2 != 0）return n；
     计算偶数-even: if(n % 2 == 0) return n;
   ```
 ###2.质数和合数
   定义<br>
   一个数，如果只有1和它本身两个因数，这样的数叫做质数（或素数）。如2，3，5，7<br>
   一个数，如果出了1和它本身还有别的因数，这样的数叫做合数。如4，6，15，49<br>
   
   ```*1不算质数也不算合数```
   
 2.1计算质数和合数
   ```
    static void findPrimeAndCompositeNumber(int n){
        for(int i=1;i<=n;i++){
            int count = 0;
            for(int j=1;j<=i;j++){
                if(i % j ==0){
                    count++;
                }
            }

            if(count==2){
                System.out.println("质数："+i);
            }else if(count>2){
                System.out.println("合数："+i);
            }
        }
    } 
   ```  
 ## Work Three
 ### 歌德巴赫猜想
    4=2+2,6=3+3，8=5+3，10=7+3，12=7+5，14=11+3....那么，是不是所有大于2的偶数，都可以表示为两个质数的和呢？<br>
    这个问题是德国数学家哥德巴赫最先提出来的，所以被称为哥德巴赫猜想。世界各国的数学家都想攻克这一难题，但至今还未解决。<br>
    这一难题被成为"数学王冠上的明珠"。
 ###分数与除法的关系   
    被除数 除以 除数 = 被除数/除数
 真分数：分子比分母小的分数。真分数小于1。<br>
 假分数：分子比分母大或分子与分母相等的分数。假分数>=1。<br>
 分数的基本性质：分数的分子和分母同时乘以或除以相同的数（0除外），分数的大小不变。<br>
 最大公因数：1、2、4是16和12的公因数。4是最大公因数。<br>
 互质数：公因数只有1的两个数<br>
 最简分数：分子和分母只有公因数1的分数。<br>
 🈷️约分：把一个分数化成和它相等，但分子、分母都比较小的分数。<br>
 
 ## Work Four
 最小公倍数：6、12、18...是3和2公有的倍数，叫做它们的公倍数。其中，6是最小的公倍数，叫做它们的最小公倍数。<br>
 通分：把异分母分数分别化成和原来分数相等的同分母分数。1/4 和 2/5 分别化成 5/20 与 8/20 ，这样更利于比较两个分数的大小。<br>
 
计算两个数的最大公约数（Greatest Common Divisor - GCD） 和 最小公倍数（Least Common Multiple - LCM）
 ```
    //GCD 采用 Euclidean Algorithm（欧几里得算法又称辗转相除法）：用于计算两个正整数a、b的最大公约数。
    //计算公式：gcd(a,b) = gcd(b,a mod b) 
    //mod ： 取模运算（“Modulo Operation”）
    //lcm = (a * b)/gcd(a,b)
    
    
    //solution 1:
    //If you can use Java 8 (and actually want to) you can use lambda expressions to solve this functionally
    private static int gcd(int x, int y) {
        return (y == 0) ? x : gcd(y, x % y);
    }
    
    public static int gcd(int... numbers) {
        return Arrays.stream(numbers).reduce(0, (x, y) -> gcd(x, y));
    }
    
    public static int lcm(int... numbers) {
        return Arrays.stream(numbers).reduce(1, (x, y) -> x * (y / gcd(x, y)));
    }
    
    // solution 2
    private static int lcm(int numberOne, int numberTwo) {
        final int bigger = Math.max(numberOne, numberTwo);
        final int smaller = Math.min(numberOne, numberTwo);
    
        return IntStream.rangeClosed(1,smaller)
                        .filter(factor -> (factor * bigger) % smaller == 0)
                        .map(factor -> Math.abs(factor * bigger))
                        .findFirst()
                        .getAsInt();
    }
    
    private static int gcd(int numberOne, int numberTwo) {
        return (numberTwo == 0) ? numberOne : gcd(numberTwo, numberOne % numberTwo);
    }
    
    //solution 3
    static int gcd(int a,int b){
        int rem = 0;
        while(b != 0){
            rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
    
    static int gcd(int a,int b){
        while(a != b){
            if(a>b){
                a -= b;
            }else{
                b -= a;
            }
        }
    }
 ```
## Work Five 7年级上
### 第一章
* 正数、负数
* 0既不是正数，也不是负数
```
    原子钟：是目前世界上最精确的钟，在2000万年的时间内，它的误差在+-1。它以原子共振频率标准来计算及保持时间的准确。
    原子钟是世界上已知最准确的时间测量和频率标准，也是国际时间和频率转换的基准，用来控制电视广播和全球定位系统卫星的讯号。
    原子钟并不使用放射性计时，而是使用电子转变能级时释放的精确微波讯号。早期的原子钟为附上工具的激微波。
    今天最好的原子钟是以原子喷泉中冷原子的吸收光谱法作为基础的。
```
     
* 正整数、0、负整数统称整数（Integer），正分数和负分数统称分数（fraction）。   
* 整数和分数统称有理数（rational number）
* 数轴（number axis）
* 数轴上任取一个点表示数0，这个点叫做原点（origin）
* 相反数：设a是一个正数，数轴上与原点的距离是a的点有两个，它们分别在原点左右，表示-a和a，我们说这两个点关于原点对称，这两个数只有符号不同，它们互为相反数。
* 绝对值：一般数轴上表示数a的点与原点的距离叫做数a的绝对值（absolute value），记作|a|
* 一个正数的绝对值是它本身；一个负数的绝对值是它的相反数；0的绝对值是0
* 正数大于0，0大于负数，正数大于负数；两个负数，绝对值大的反而小
#### 有理数加法法则
* 同号两数相加，取相同的符号，并把绝对值相加。
* 绝对值不同相等的异号两数相加，取绝对值较大的加数的符号。并用较大的绝对值减去较小的绝对值。互为相反数的两个数相加得0。
* 一个数同0相加，仍得这个数.
#### 有理数减法法则
* 减去一个数，等于加上这个数的相反数。
* 中国人最先使用负数
#### 有理数乘法法则
* 两数相乘，同号得正，异号得负，并把绝对值相乘.
* 任何数同0相乘，都得0。
* 乘积是1的两个数互为倒数。
* 乘方交换律：ab = ba。两个数相乘，交换因数的位置，积相等。
* 乘方混合律：三个数相乘，先把前两个数相乘，或者先把后两个数相乘，积相等。
* 分配律：a（b+c）= ab + ac。一个数同两个数的和相乘，等于把这个数分别同这两个数相乘，再把积相加。
* 一个数同两个数的和相乘，等于把这个数分别同这两个数相乘，再把积相加。
#### 有理数除法法则
* 除以一个不等于0的数，等于乘这个数的倒数。
* 两数相除，同号得正，异号得负，并把绝对值相除，0除以任何一个不等于0的数，都得0。

#### 有理数加减乘除混合运算：先乘除再加减
* 乘方：求n个相同因数的积的运算。乘方的结果叫幂（power），
* 在a<sup>n</sup>中，a叫做底数（base number），n叫做指数（exponent），
* 当a<sup>n</sup>看作a的n次方的结果时，也可读作a的n次幂。

* 负数的奇次幂是负数，负数的偶次幂是正数。正数的任何次幂都是正数，0的任何次幂都是0
#### 混合运算
* 先乘方，在乘除，最后加减
* 同级运算，从左到右进行
* 如有括号，先做括号内的运算，按小括号、中括号、大括号一次进行
#### 科学技术法
* 把一个大于10的数表示成a x 10<sup>n</sup>的形式（其中a是整数数位只有一位的数，n是正整数），使用的是科学技术法。
* 1米 = 10<sup>9</sup> 纳米

### Week Six
#### 近似数和有效数字
* 近似数(approximate number)：接近实际数，但与实际数还有差别.
* 有效数字(significant digit)：从一个数的左边第一个非0数字起，到末位数字止，所有数字都是这个数的有效数字。
  例如：0.104有效数字3个，1500有效数字4个。

### 第二章 一元一次方程
* 方程（equation）：列方程时，要先设字母表示未知数，然后根据问题中的相等关系，写出含有未知数的等式。
* 一元一次方程（linear equation with one unknown）：方程中只含有一个未知数 x，未知数x的指数都是1（次）
```text
等式的性质1：等式两边加（或减）同一个数（或式子），结果仍相等。
等式的性质2：等式两边乘同一个数，或除以同一个不为0的数，结果仍相等。
```
* 移项：把等式一边的某项变号后移动到另一边，叫移项。
### 图形认识初步
* 长方体、正方体、球、圆柱等都是立体图形（solid figure）。
* 平面图形（plane figure）
* 几何体简称体（solid），包围着体的是面（surface）；线（line）；点（point）
#### 直线、射线、线段
* 经过两点有一条直线，并且只有一条直线。
* 由两点确定一条直线。
* 中点（center）
* 两点的所有连线中，线段最短。两点间线段的长度，叫做两点的距离（distance）。
* 角（angle）、度（degree）
* 角的平分线（angular bisector）：从一个角的顶点出发，把这个角分成相等的两个角的射线，叫做～
* 如果两个角的和等于90度，就说这两个角互为余角（complementary angle）
* 如果两个角的和等于180度，就说这两个角互为补角
* 等角的补角相等；等角的余角相等。

### Week Seven

### Week Eight


  
                
   
    

