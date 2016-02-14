/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jay
 */
public class NotUser {
    JFrame frame=new JFrame("WARNING");
   public NotUser(){
       JPanel main_panel=new JPanel();
        JPanel panel=new JPanel();
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        
        
        panel.setBackground(Color.white);
        panel1.setBackground(Color.white);
        panel2.setBackground(Color.white);
        panel3.setBackground(Color.white);
        
        JLabel state=new JLabel("You are not the user.Sorry ");
        state.setFont(new Font("Calibri", Font.PLAIN, 18));
        
       panel.add(new JLabel(new ImageIcon(this.getClass().getResource("image/cover.png"))));
        JButton cancel=new JButton(new ImageIcon(this.getClass().getResource("image/ok.png"))); 
        cancel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        cancel.addActionListener(new Cancel(this.frame));  
        
        panel1.add(state);
        panel3.add(cancel);
        
        main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
         main_panel.add(panel);
        main_panel.add(panel1);
        main_panel.add(panel2);
        main_panel.add(panel3);
        
         frame.setIconImage((new ImageIcon(this.getClass().getResource("image/icon.png"))).getImage());
        
	frame.setSize(400,400);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         frame.add(main_panel);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        //frame.setAlwaysOnTop(true);
        frame.pack();
        frame.setVisible(true);
   }
   public static void main(String []args){
NotUser f=new NotUser();
}
    
}
