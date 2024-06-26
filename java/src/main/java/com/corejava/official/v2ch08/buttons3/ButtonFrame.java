package com.corejava.official.v2ch08.buttons3;

import com.corejava.official.v2ch08.runtimeAnnotations.ActionListenerFor;
import com.corejava.official.v2ch08.runtimeAnnotations.ActionListenerInstaller;

import java.awt.*;
import javax.swing.*;

/**
 * A frame with a button panel.
 * @version 1.00 2004-08-17
 * @author Cay Horstmann
 */
public class ButtonFrame extends JFrame
{
   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 200;

   private JPanel panel;
   private JButton yellowButton;
   private JButton blueButton;
   private JButton redButton;

   public ButtonFrame()
   {
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      panel = new JPanel();
      add(panel);

      yellowButton = new JButton("Yellow");
      blueButton = new JButton("Blue");
      redButton = new JButton("Red");

      panel.add(yellowButton);
      panel.add(blueButton);
      panel.add(redButton);

      ActionListenerInstaller.processAnnotations(this);
   }

   @ActionListenerFor(source = "yellowButton")
   public void yellowBackground()
   {
      panel.setBackground(Color.YELLOW);
   }

   @ActionListenerFor(source = "blueButton")
   public void blueBackground()
   {
      panel.setBackground(Color.BLUE);
   }

   @ActionListenerFor(source = "redButton")
   public void redBackground()
   {
      panel.setBackground(Color.RED);
   }
}
