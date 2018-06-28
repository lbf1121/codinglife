package mathematics.src;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumber {
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
   public static void main(String[] args){
        System.out.print(findPerfectNumber(10000));
   }
}
