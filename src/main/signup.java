/*this is to create an account
a change was done.frame is instance now.
 */
package main;

/*
  * @author jay
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class signup {
    
    private JTextField _uname=new JTextField();
    private JPasswordField _rewrite=new JPasswordField();
    private JPasswordField _pword=new JPasswordField();
    private JFrame frame;
    public signup(){
        frame=new JFrame("SIGN UP");
        JPanel main_panel=new JPanel();
        JPanel panel=new JPanel();
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        JPanel panel4=new JPanel();
        JPanel panel5=new JPanel();
        JPanel panel6=new JPanel();
        
        panel.setBackground(Color.white);
        panel1.setBackground(Color.white);
        panel2.setBackground(Color.white);
        panel3.setBackground(Color.white);
        panel4.setBackground(Color.white);
        panel5.setBackground(Color.white);
        panel6.setBackground(Color.white);
             
        JLabel pword=new JLabel(" Password :");
        pword.setFont(new Font("Calibri", Font.PLAIN, 18));
        JLabel rewrite=new JLabel(" Rewrite     :");
        rewrite.setFont(new Font("Calibri", Font.PLAIN, 18));
        JLabel uname=new JLabel("User name:");
        uname.setFont(new Font("Calibri", Font.PLAIN, 18));
       
       
        _uname.setPreferredSize(new Dimension(100,30));        
        _rewrite.setPreferredSize(new Dimension(100,30));       
        _pword.setPreferredSize(new Dimension(100,30));
        
        JButton create=new JButton(new ImageIcon(this.getClass().getResource("image/ok.png")));
        create.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        create.addActionListener(new addAction());
        
	frame.setSize(400,400);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        main_panel.setPreferredSize(new Dimension(400,400));
	main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
	
        
        panel2.add(uname);
        panel3.add(pword);
        panel4.add(rewrite);
       
        panel2.add(_uname);
        panel3.add(_pword);
        panel4.add(_rewrite);
        
        panel.add(new JLabel(new ImageIcon(this.getClass().getResource("image/cover.png"))));
        panel6.add(create);
        
        frame.setIconImage((new ImageIcon(this.getClass().getResource("image/icon.png"))).getImage());
        
        main_panel.add(panel);
        main_panel.add(panel1);
        main_panel.add(panel2);
        main_panel.add(panel3);
        main_panel.add(panel4);
        main_panel.add(panel5);
        main_panel.add(panel6);
        
        frame.add(main_panel);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        //frame.setAlwaysOnTop(true);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String []args){
    signup s=new signup();
    
    }
    
    class addAction implements ActionListener{	        
        @Override
        public void actionPerformed(ActionEvent arg0){
               
                String uname=_uname.getText();
                String pword=new String(_pword.getPassword());
                String rewrite=new String(_rewrite.getPassword());
                
                if(pword.equals(rewrite)){
                   Project.setMasterPw(pword);
                    pword="DanojaJayProject#1ABCdfghjkurdhDEF12345!@#$%)(*&^%$#@!_+{}:?><,./;'[]=-09876545321)";
                        Font f=new Font("Calibri", Font.PLAIN, 18);
                        UIManager.put("OptionPane.messageFont", f);
                        UIManager.put("OptionPane.buttonFont", f);
                    int selected=JOptionPane.showConfirmDialog(null, "Do you want to add this user?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if(selected==JOptionPane.YES_OPTION){
                        Connect con=new Connect();
                        
                        EncryptDecrypt d = new EncryptDecrypt();
                        
                        try {
                            pword=d.encrypt(pword);
                        } catch (Exception ex) {
                         
                            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       
            
                        con.signUp(uname,pword); 
                        JOptionPane.showMessageDialog(null,"Successfully added");                   
                        frame.dispose();
                        
                        main m=new main();
                    }
                    else{
                        _pword.setText("");
                        _rewrite.setText("");
                        _uname.setText("");
                    }
                    
                }
                else{
                    JFrame error=new JFrame("ERROR");
                    String e_state="Password does not match.\n          try again";
                    Font f=new Font("Calibri", Font.PLAIN, 18);
                    UIManager.put("OptionPane.messageFont", f);
                    UIManager.put("OptionPane.buttonFont", f);
                    JOptionPane.showMessageDialog(error,e_state );      
                }
                
                    
	}

    }
} 