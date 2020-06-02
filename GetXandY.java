/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

/**
 *
 * @author Admin
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class GetXandY {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame=new JFrame("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLayout(new BorderLayout());
        frame.setSize(300,200);
        
        final JTextField text=new JTextField();
        frame.add(text,BorderLayout.SOUTH);
//        final JTextArea textarea=new JTextArea();
//        frame.add(text,BorderLayout.NORTH);
        
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x=e.getX();
                int y=e.getY();
                text.setText("X:"+x+" Y:"+y);
                }

            @Override
            public void mousePressed(MouseEvent e) {
                  }

            @Override
            public void mouseReleased(MouseEvent e) {
                }

            @Override
            public void mouseEntered(MouseEvent e) {
                }

            @Override
            public void mouseExited(MouseEvent e) {
                }
        });
        frame.setVisible(true);
    }
}
