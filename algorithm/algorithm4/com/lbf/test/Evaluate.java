package algorithm4.com.lbf.test;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * 功能说明：Dijkstra 双栈算术表达式求值算法
 * in:(1+1+3),无法正确计算，需要更改为((1+1)+3)
 * @auther liubf
 * @date 2018/12/22
 * @throws
 */
public class Evaluate {
    public static void main(String[] args){
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        while (!StdIn.isEmpty()){
            String s = StdIn.readString();
            if (s.equals("("));
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")){
                String op = ops.pop();
                double v = vals.pop();

                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);

                vals.push(v);
            }
            else if (s.equals("="))
                break;
            else
                vals.push(Double.parseDouble(s));
        }
        StdOut.print(vals.pop());
    }
}
