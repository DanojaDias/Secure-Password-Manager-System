/*this is to login to the account
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


public class Login extends javax.swing.JFrame{
    
    private static JTextField _uname=new JTextField();
    private static JPasswordField _pword=new JPasswordField();
    private static JFrame frame;
    
    public Login(){
        frame=new JFrame("Log in");
        JPanel main_panel=new JPanel();
        JPanel panel=new JPanel();
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        JPanel panel5=new JPanel();
        JPanel panel6=new JPanel();
        
        panel.setBackground(Color.white);
        panel1.setBackground(Color.white);
        panel2.setBackground(Color.white);
        panel3.setBackground(Color.white);
       // panel4.setBackground(Color.white);
        panel5.setBackground(Color.white);
        panel6.setBackground(Color.white);
       // panel7.setBackground(Color.white);
             
        JLabel pword=new JLabel(" Password :");
        pword.setFont(new Font("Calibri", Font.PLAIN, 18));
        JLabel uname=new JLabel("User name:");
        uname.setFont(new Font("Calibri", Font.PLAIN, 18));
       
        
        _uname.setPreferredSize(new Dimension(100,30));
        
        _pword.setPreferredSize(new Dimension(100,30));
        
        JButton create=new JButton(new ImageIcon(this.getClass().getResource("image/login.png")));
        create.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        create.addActionListener(new ok_action());
        
        frame.setIconImage((new ImageIcon(this.getClass().getResource("image/icon.png"))).getImage());
        
	frame.setSize(400,400);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        main_panel.setPreferredSize(new Dimension(400,400));
	main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
	
        
        panel2.add(uname);
        panel3.add(pword);
       
        panel2.add(_uname);
        panel3.add(_pword);
        
        panel.add(new JLabel(new ImageIcon(this.getClass().getResource("image/cover.png"))));
        panel6.add(create);
        
        main_panel.add(panel);
        main_panel.add(panel1);
        main_panel.add(panel2);
        main_panel.add(panel3);
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
    Login s=new Login();
    
    }
    
    
        class ok_action implements ActionListener{	        
            @Override
            public void actionPerformed(ActionEvent arg0){
                try {
                    Connect con=new Connect();
                    con.loginReq();
                    
                    String p=new String(_pword.getPassword());
                    Project.setMasterPw(p);
                    
                    EncryptDecrypt d = new EncryptDecrypt();
                    boolean i=true;
                    String pword=con.getPassword();
                    try{
                       pword=d.decrypt(con.getPassword());
                       
                    }
                    catch(Exception e){
                        JFrame error=new JFrame("ERROR");
                        String e_state="Password or username is wrong.\n          try again";
                        Font f=new Font("Calibri", Font.PLAIN, 18);
                        UIManager.put("OptionPane.messageFont", f);
                        UIManager.put("OptionPane.buttonFont", f);
                        JOptionPane.showMessageDialog(error,e_state ); 
                        _pword.setText("");
                        pword="blah";
                        i=false;
                    }
                    
                    
                    
                    String uname=con.getUname();
                    String check="DanojaJayProject#1ABCdfghjkurdhDEF12345!@#$%)(*&^%$#@!_+{}:?><,./;'[]=-09876545321)";
                    
                    if((_uname.getText()).equals("")){
                        JFrame error=new JFrame("ERROR");
                        String e_state="Please Enter required fields";
                        Font f=new Font("Calibri", Font.PLAIN, 18);
                        UIManager.put("OptionPane.messageFont", f);
                        UIManager.put("OptionPane.buttonFont", f);
                        JOptionPane.showMessageDialog(error,e_state );
                        
                    }
                    else if(check.equals(pword) ==true && (_uname.getText()).equals(uname)==true) {
                        main m=new main();
                        frame.dispose();
                    }
                    else if(i==true){
                        JFrame error=new JFrame("ERROR");
                        String e_state="Password or username is wrong.\n          try again";
                        Font f=new Font("Calibri", Font.PLAIN, 18);
                        UIManager.put("OptionPane.messageFont", f);
                        UIManager.put("OptionPane.buttonFont", f);
                        JOptionPane.showMessageDialog(error,e_state );               
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }

            }

        }
    
}

