/*this is to add a account
 */
package main;
/*
  @author jay instant variables
*/
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class Add1 extends javax.swing.JFrame{
     JTextField _name=new JTextField();
      JTextField _url=new JTextField();
     JTextField _uname=new JTextField();
    JPasswordField _rewrite=new JPasswordField();
    JPasswordField _pword=new JPasswordField();
    JFrame frame=new JFrame("ADD ACCOUNT");
   
    
    public Add1( ){
       
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
        
        JLabel name=new JLabel("Name        :");
        name.setFont(new Font("Calibri", Font.PLAIN, 18));
        JLabel url=new JLabel("Url              :");
        url.setFont(new Font("Calibri", Font.PLAIN, 18));
        JLabel uname=new JLabel("User name:");
        uname.setFont(new Font("Calibri", Font.PLAIN, 18));
         JLabel pword=new JLabel("Password  :");
        pword.setFont(new Font("Calibri", Font.PLAIN, 18));
        JLabel rewrite=new JLabel(" Rewrite     :");
        rewrite.setFont(new Font("Calibri", Font.PLAIN, 18));
 
        _name.setPreferredSize(new Dimension(100,30));
         _url.setPreferredSize(new Dimension(100,30));
         _uname.setPreferredSize(new Dimension(100,30));
         _rewrite.setPreferredSize(new Dimension(100,30));
         _pword.setPreferredSize(new Dimension(100,30));
        
        JButton add=new JButton(new ImageIcon(this.getClass().getResource("image/ok.png")));
        add.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        add.addActionListener(new addAction());
        
        JButton cancel=new JButton(new ImageIcon(this.getClass().getResource("image/cancel.png"))); 
        cancel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        cancel.addActionListener(new Cancel(this.frame));  
        
        frame.setIconImage((new ImageIcon(this.getClass().getResource("image/icon.png"))).getImage());
        
	frame.setSize(400,400);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        main_panel.setPreferredSize(new Dimension(400,400));
	main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
	
        
        panel1.add(name);
         panel2.add(url);
          panel4.add(uname);
        panel5.add(pword);
        panel6.add(rewrite);
       
        panel1.add(_name);
        panel2.add(_url);
        panel4.add(_uname);
        panel5.add(_pword);
        panel6.add(_rewrite);
        
        panel.add(new JLabel(new ImageIcon(this.getClass().getResource("image/cover.png"))));
        panel7.add(add);
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
    Add1 s=new Add1();
    
    }
    
    class addAction implements ActionListener{	        
        @Override
          public void actionPerformed(ActionEvent arg0){
                String name=_name.getText();  
                String url=_url.getText();
                String uname=_uname.getText();
                String pword=new String(_pword.getPassword());
                String rewrite=new String(_rewrite.getPassword());
                
                if(name.equals("")||uname.equals("")||pword.equals("") || url.equals("")){
                 JOptionPane.showMessageDialog(null, "Please Enter required fields", "Warning", JOptionPane.ERROR_MESSAGE);
                    
                }
                
                else if(pword.equals(rewrite)){
                    
                    int selected=JOptionPane.showConfirmDialog(null, "Do you want to add this Account?", "Confirm", JOptionPane.YES_NO_OPTION);
                    
                    if(selected==JOptionPane.YES_OPTION){
                        
                        //----------------------------------find
                        Find f=new Find(url);
                        String tfield="";
                        String pfield="";        
                        try{
                         tfield=f.gettfield();
                         pfield=f.getpfield();
                        }catch(Exception E){
                            
                        }
                        
                        //---------------------------------find
                   
                 if(tfield.equals("")==false && pfield.equals("")==false ){
                                Connect con=new Connect();
                                EncryptDecrypt d = new EncryptDecrypt();
                                try {
                                    pword=d.encrypt(pword);
                                } catch (Exception ex) {
                                    Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
                                 }
                             con.addAccount1(name, pword,uname,url,tfield,pfield);
                        _pword.setText("");
                        _rewrite.setText("");
                        _uname.setText("");                                          
                        frame.dispose();
                        
                //--------------------update
                        
                        main.accounts.removeAll();
                        Connect con1=new Connect();
                        int [] idAry=con1.allIds();
                        String []names=con1.allNames();
                        int noOfAccounts=idAry.length;
                        
                        main.accounts.setLayout(new GridLayout(15, 1));//setlayout
        
                        Account_panel []a=new Account_panel[noOfAccounts];
        
                        for(int j=0;j<noOfAccounts;j++){
                            
                            a[j]=new Account_panel(names[j],idAry[j]);
                        
                            main.accounts.add(a[j]);
                        }
                        main.accounts.revalidate();
                        
                        
             //--------------------
                    }
                    else{
                        _pword.setText("");
                        _rewrite.setText("");
                        _uname.setText("");
                        
                         JFrame error2=new JFrame("ERROR");
                    String e_state="Sorry Password manager does not support to this site";
                   
                    UIManager.put("OptionPane.messageFont", f);
                    UIManager.put("OptionPane.buttonFont", f);
                    JOptionPane.showMessageDialog(error2,e_state );      
                        
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
}

