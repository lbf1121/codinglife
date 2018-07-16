<script src='https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.4/MathJax.js?config=TeX-MML-AM_CHTML' async></script>

小学数学
============
Week One
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
 
 
                
   
    

