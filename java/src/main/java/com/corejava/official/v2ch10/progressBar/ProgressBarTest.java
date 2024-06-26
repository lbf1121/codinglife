package com.corejava.official.v2ch10.progressBar;

import java.awt.*;
import javax.swing.*;

/**
 * This program demonstrates the use of a progress bar to monitor the progress of a thread.
 * @version 1.05 2012-05-10
 * @author Cay Horstmann
 */
public class ProgressBarTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(() ->
         {
            JFrame frame = new ProgressBarFrame();
            frame.setTitle("ProgressBarTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
         });
   }
}
