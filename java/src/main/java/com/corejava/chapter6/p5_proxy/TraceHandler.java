package com.corejava.chapter6.p5_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * TODO 类描述：
 *
 * @auther liubf
 * @date 2023/4/19
 */
public class TraceHandler implements InvocationHandler {

    private Object target;

    public TraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print("."+ method.getName()+"(");
        if(args!=null){
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if(i< args.length-1){
                    System.out.print(",");
                }
            }
        }
        System.out.println(")");
        return method.invoke(target,args);
    }
}
