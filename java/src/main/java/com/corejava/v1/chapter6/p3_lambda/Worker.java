package com.corejava.v1.chapter6.p3_lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * TODO 类描述：
 *
 * @author liubf
 * @date 2024/3/20
 */
public class Worker implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event){
        System.out.println("The time is "+new Date());
    }
}
