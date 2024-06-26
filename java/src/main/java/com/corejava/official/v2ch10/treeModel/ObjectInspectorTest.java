package com.corejava.official.v2ch10.treeModel;

import java.awt.*;
import javax.swing.*;

/**
 * This program demonstrates how to use a custom tree model. It displays the fields of an object.
 * @version 1.05 2016-05-10
 * @author Cay Horstmann
 */
public class ObjectInspectorTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(() ->
         {
            JFrame frame = new ObjectInspectorFrame();
            frame.setTitle("ObjectInspectorTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
         });
   }
}



