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
    

