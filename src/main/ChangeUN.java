/*this is to edit a account
 */
package main;

/**
 *
 * @author jay
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class ChangeUN {
        JTextField _uname=new JTextField();
        
       
         JFrame  frame;
        
        Connect con=new Connect();
        
    public ChangeUN(){
      
        frame=new JFrame("CHANGE USER NAME");
        JPanel main_panel=new JPanel();
        JPanel panel=new JPanel();
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        JPanel panel4=new JPanel();
        JPanel panel5=new JPanel();
        JPanel panel6=new JPanel();
        JPanel panel7=new JPanel();
        
        panel.setBackground(Color.white);
        panel1.setBackground(Color.white);
        panel2.setBackground(Color.white);
        panel3.setBackground(Color.white);
        panel4.setBackground(Color.white);
        panel5.setBackground(Color.white);
        panel6.setBackground(Color.white);
        panel7.setBackground(Color.white);
        
        con=new Connect();
        con.loginReq();
       
        _uname.setText(con.getUname());
        
           JLabel Icon;
        
        String nameaccount="facebook gamil dreamspark feels github hackerrank linkedin sumsung yahoo paypal ";
     

    
        JLabel uname=new JLabel("New User name:");
        uname.setFont(new Font("Calibri", Font.PLAIN, 18));
        
        
 
         
        _uname.setPreferredSize(new Dimension(100,30));
        
        
        JButton edit=new JButton(new ImageIcon(this.getClass().getResource("image/ok.png")));
        edit.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        edit.addActionListener(new editAction());
        JButton cancel=new JButton(new ImageIcon(this.getClass().getResource("image/cancel.png"))); 
        cancel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        
        cancel.addActionListener(new Cancel(this.frame));
           
        
        frame.setIconImage((new ImageIcon(this.getClass().getResource("image/icon.png"))).getImage());
        
	frame.setSize(400,400);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        main_panel.setPreferredSize(new Dimension(400,400));
	main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
	
        
    
        panel4.add(uname);
      
      
       
        panel4.add(_uname);
      
        panel.add(new JLabel(new ImageIcon(this.getClass().getResource("image/cover.png"))));
        panel7.add(edit);
        panel7.add(cancel);
        
        main_panel.add(panel);
        main_panel.add(panel1);
        main_panel.add(panel2);
        main_panel.add(panel3);
        main_panel.add(panel4);
        main_panel.add(panel5);
        main_panel.add(panel6);
        main_panel.add(panel7);
        
        frame.add(main_panel);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        //frame.setAlwaysOnTop(true);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String []args){
    ChangeUN s=new ChangeUN();
    
    }
    class editAction implements ActionListener{	        
        @Override
          public void actionPerformed(ActionEvent arg0){
              
                String uname=_uname.getText();
               
                if(uname.equals("")){
                 JOptionPane.showMessageDialog(null, "Please Enter required fields", "Warning", JOptionPane.ERROR_MESSAGE);
                    
                }
                
                else {
                    
                    
                    int selected=JOptionPane.showConfirmDialog(null, "Do you want to edit this User Name?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if(selected==JOptionPane.YES_OPTION){
                       
                                
                        con.editUserAccountName(uname);
                       
                        frame.dispose();
                    }
                   
                    
                }
                
                
                    
	}

    }
    
}

