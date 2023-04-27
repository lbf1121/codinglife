package com.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * TODO 类描述：
 *
 * @auther liubf
 * @date 2023/3/21
 */
public class TimePrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone,the time is "+new Date());
        Toolkit.getDefaultToolkit().beep();
    }

}
