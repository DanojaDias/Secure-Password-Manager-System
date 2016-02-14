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
public class Welcome {
    JFrame frame=new JFrame("WARNING");
    
   public Welcome(){
       JPanel main_panel=new JPanel();
        JPanel panel=new JPanel();
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        
        
        panel.setBackground(Color.white);
        panel1.setBackground(Color.white);
        panel2.setBackground(Color.white);
        panel3.setBackground(Color.white);
        
        JLabel state=new JLabel("Welcome to Password Manger");
         JLabel state1=new JLabel( "when you are creating your account\n consider following steps");
         JLabel state2=new JLabel("1.capture photos of you.make sure there different  angles of your face");
         JLabel state3=new JLabel("2.give a strong password and keep it in mind ");
         JLabel state4=new JLabel("Click ok to continue");
        state.setFont(new Font("Calibri", Font.PLAIN, 16));
        state1.setFont(new Font("Calibri", Font.PLAIN, 16));
        state2.setFont(new Font("Calibri", Font.PLAIN, 16));
        state3.setFont(new Font("Calibri", Font.PLAIN, 16));
        state4.setFont(new Font("Calibri", Font.PLAIN, 16));
        
       panel.add(new JLabel(new ImageIcon(this.getClass().getResource("image/cover.png"))));
        JButton cancel=new JButton(new ImageIcon(this.getClass().getResource("image/ok.png"))); 
        cancel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        cancel.addActionListener(new Ok(this.frame));  
        
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(state);
        panel1.add(state1);
        panel1.add(state2);
        panel1.add(state3);
        panel1.add(state4);
        panel3.add(cancel);
        
        main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
         main_panel.add(panel);
        main_panel.add(panel1);
        main_panel.add(panel3);
        
         
        
	frame.setSize(400,400);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         frame.add(main_panel);
         frame.setIconImage((new ImageIcon(this.getClass().getResource("image/icon.png"))).getImage());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        //frame.setAlwaysOnTop(true);
        frame.pack();
        frame.setVisible(true);
   }
   public static void main(String []args){
Welcome f=new Welcome();
}
    
}
