package br.com.devcompleto;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.Border;
public class SwingDemo {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Demo");
        JLabel label;
        label = new JLabel("This is demo label!",JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setFont(new Font("Verdana", Font.PLAIN, 15));
        label.setForeground(new Color(120, 90, 40));
        label.setBackground(new Color(65, 61, 62));
        label.setOpaque(true);
        Border border = BorderFactory.createLineBorder(Color.ORANGE);
        label.setBorder(border);
        frame.add(label);
        frame.setSize(600,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

