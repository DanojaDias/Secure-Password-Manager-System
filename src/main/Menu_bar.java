/*
 * menu bar
 * 
 */
package main;

/**
 *
 * @author jay
 */
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Menu_bar extends JMenuBar{
    
    public Menu_bar(){
        super();
        
        Font f = new Font("Calibri", Font.PLAIN, 18);
        Font f1 = new Font("Calibri", Font.PLAIN, 14);
        UIManager.put("Menu.font", f);
        UIManager.put("MenuItem.font", f);
        
        JMenu AtoE = new JMenu(" A-E ");
        JMenu FtoJ = new JMenu(" F-J ");
        JMenu KtoO = new JMenu(" K-O ");
        JMenu PtoT = new JMenu(" P-T ");
        JMenu UtoZ = new JMenu(" U-Z ");
        JMenu other=new JMenu("Other account");
        JMenu setting = new JMenu(" Setting ");
  
        JMenuItem facebook=new JMenuItem("facebook",new ImageIcon(this.getClass().getResource("image/facebook.png")));
        JMenuItem feels=new JMenuItem("feels",new ImageIcon(this.getClass().getResource("image/feels.png")));
        JMenuItem gmail=new JMenuItem("gmail",new ImageIcon(this.getClass().getResource("image/gmail.png")));
        JMenuItem yahoo=new JMenuItem("yahoo",new ImageIcon(this.getClass().getResource("image/yahoo.png")));
        JMenuItem dreamspark=new JMenuItem("dreamspark",new ImageIcon(this.getClass().getResource("image/dreamspark.png")));
        JMenuItem hackerrank=new JMenuItem("hackerrank",new ImageIcon(this.getClass().getResource("image/hackerrank.png")));
        JMenuItem github=new JMenuItem("github",new ImageIcon(this.getClass().getResource("image/github.png")));
        JMenuItem linkedin=new JMenuItem("linkedin",new ImageIcon(this.getClass().getResource("image/linkedin.png")));
        JMenuItem paypal=new JMenuItem("paypal",new ImageIcon(this.getClass().getResource("image/paypal.png")));
        JMenuItem samsung=new JMenuItem("samsung",new ImageIcon(this.getClass().getResource("image/samsung.png")));
        JMenuItem _other=new JMenuItem("Create another account",new ImageIcon(this.getClass().getResource("image/other.png")));
        //---------------------------
        AtoE.add(dreamspark);
        
        FtoJ.add(github);
        FtoJ.add(gmail);
        FtoJ.add(facebook);
        FtoJ.add(feels);
        FtoJ.add(hackerrank);
        
        KtoO.add(linkedin);
        
        PtoT.add(paypal);
        PtoT.add(samsung);
		
        UtoZ.add(yahoo);
        other.add(_other);
        //--------------------------------
        JMenuItem ch_pass=new JMenuItem("Change password");
        JMenuItem ch_uname=new JMenuItem("Change username");
        
        setting.add(ch_pass);
        setting.add(ch_uname);
        
        dreamspark.addActionListener(new goToAdd("dreamspark"));
        
        github.addActionListener(new goToAdd("github"));
        facebook.addActionListener(new goToAdd("facebook"));
        feels.addActionListener(new goToAdd("feels"));
        gmail.addActionListener(new goToAdd("gmail"));
        hackerrank.addActionListener(new goToAdd("hackerrank"));
        
        linkedin.addActionListener(new goToAdd("linkedin"));
        
        paypal.addActionListener(new goToAdd("paypal"));
        samsung.addActionListener(new goToAdd("samsung"));
        
        yahoo.addActionListener(new goToAdd("yahoo"));
        
       _other.addActionListener(new goToAdd1());
       
        ch_pass.addActionListener(new goToChangeMP());
        ch_uname.addActionListener(new goToChangeUN());
        //------------------------------------------------
        this.add(AtoE);
        this.add(FtoJ);
        this.add(KtoO);
        this.add(PtoT);
        this.add(UtoZ);
        this.add(other);
        this.add(setting);
    }
   class goToAdd implements ActionListener{
       public String name;
       public goToAdd(String name){
       this.name=name;
       }
        @Override
          public void actionPerformed(ActionEvent arg0){
            Add a=new Add(this.name);
        
        }
   } 
   class goToAdd1 implements ActionListener{
      
        @Override
          public void actionPerformed(ActionEvent arg0){
            Add1 a=new Add1();
        
        }
   } 
   
   class goToChangeMP implements ActionListener{
       @Override
          public void actionPerformed(ActionEvent arg0){
            ChangeMP a=new ChangeMP();
        
        }
   
   
   }
   class goToChangeUN implements ActionListener{
       @Override
          public void actionPerformed(ActionEvent arg0){
            ChangeUN a=new ChangeUN();
        
        }
   
   
   }
}
