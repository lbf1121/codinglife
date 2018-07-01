package mathematics.src;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumber {
   /**计算完全数**/
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
   /**计算奇偶数*/
   static void oddAndEven(int n){
       if(n % 2 != 0)
           System.out.println("奇数-ODD:"+n);
       if(n % 2 == 0)
           System.out.println("偶数-EVEN:"+n);
   }
   /**计算素数（质数）和 合数**/
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
   public static void main(String[] args){

       //System.out.print(findPerfectNumber(10000));
       /*for(int i=0;i<20;i++){
           oddAndEven(i);
       }*/

       findPrimeAndCompositeNumber(20);

   }
}
