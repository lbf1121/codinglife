package algorithm4.com.lbf.java;

/**
 * 功能说明：欧几里得算法，求最大公约数
 * 自然语言描述
 * 计算两个非负整数p和q的最大公约数：若q是0，则最大公约数是p。否则，将p除以q得到余数r，p和q的最大公约数即为q和r的最大公约数。
 * @auther liubf
 * @date 2018/10/3
 * @throws
 */
public class Gcd {

    public static int gcd(int p,int q){
        if(q==0) return p;
        int r = p % q;
        return gcd(q,r);
    }

    public static void main(String[] args){
        int n = gcd(12,15);
        System.out.println(n);
    }
}
