package com.corejava.official.v2ch11.print;

import java.awt.*;
import javax.swing.*;

/**
 * This program demonstrates how to print 2D graphics
 * @version 1.13 2016-05-10
 * @author Cay Horstmann
 */
public class PrintTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(() ->
         {
            JFrame frame = new PrintTestFrame();
            frame.setTitle("PrintTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
         });
   }
}
