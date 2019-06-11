package algorithm4.com.lbf.test;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 功能说明：
 *
 * @auther liubf
 * @date 2018/12/21
 * @throws
 */
public class Flips {

    static void testObject(){
        int T = 100000;
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        for (int i = 0; i < T; i++) {
            if (StdRandom.bernoulli(0.5))
                heads.increment();
            else
                tails.increment();
        }
        StdOut.println(heads);
        StdOut.println(tails);

        int d = heads.tally() - tails.tally();
        StdOut.println("delta: "+Math.abs(d));
    }

    static void testBaseValue(){
        //基本数据类型，变量赋值，是值拷贝
        int a = 2;
        int b = a;
        b = 4;
        System.out.println(a);
        System.out.println(b);

        //引用类型，变量赋值，是地址拷贝
        Counter c1 = new Counter("ones");
        c1.increment();
        Counter c2 = c1;
        c2.increment();
        StdOut.println(c1);

    }

    public static void main(String[] args){
        testBaseValue();
    }
}
