package com.test;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * TODO 类描述：
 *
 * @auther liubf
 * @date 2023/3/21
 */
public class TestTimer {

    public static void main(String[] args){
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(5000,listener);
        timer.start();
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }
}
