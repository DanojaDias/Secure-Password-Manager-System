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


public class Edit {
        JTextField _uname=new JTextField();
        JPasswordField _rewrite=new JPasswordField();
        JPasswordField _pword=new JPasswordField();
         JFrame  frame;
        int id;
        Connect con=new Connect();
        
    public Edit(int id){
        this.id=id;
        frame=new JFrame("EDIT ACCOUNT");
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
        String [] rowDetail=con.accountDetail(id);
        _uname.setText(rowDetail[1]);
        
        
        JLabel name=new JLabel(rowDetail[0]);
        JLabel Icon;
        
        String nameaccount="facebook gamil dreamspark feels github hackerrank linkedin sumsung yahoo paypal ";
       if(nameaccount .contains(rowDetail[0]) ==true){ Icon=new JLabel(new ImageIcon(this.getClass().getResource("image/"+rowDetail[0]+".png")));}
       else{Icon=new JLabel(new ImageIcon(this.getClass().getResource("image/"+"other"+".png")));}
     

        name.setFont(new Font("Calibri", Font.PLAIN, 18));
        JLabel uname=new JLabel("User name:");
        uname.setFont(new Font("Calibri", Font.PLAIN, 18));
        JLabel pword=new JLabel("Password  :");
        pword.setFont(new Font("Calibri", Font.PLAIN, 18));
        JLabel rewrite=new JLabel(" Rewrite     :");
        rewrite.setFont(new Font("Calibri", Font.PLAIN, 18));
 
         
        _uname.setPreferredSize(new Dimension(100,30));
         _rewrite.setPreferredSize(new Dimension(100,30));
        _pword.setPreferredSize(new Dimension(100,30));
        
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
	
        
        panel2.add(Icon);panel2.add(name);       
        panel4.add(uname);
        panel5.add(pword);
        panel6.add(rewrite);
       
       
        panel4.add(_uname);
        panel5.add(_pword);
        panel6.add(_rewrite);
        
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
    Edit s=new Edit(1);
    
    }
    class editAction implements ActionListener{	        
        @Override
          public void actionPerformed(ActionEvent arg0){
              
                    
         
                String uname=_uname.getText();
                String pword=new String(_pword.getPassword());
                String rewrite=new String(_rewrite.getPassword());
                
                if(uname.equals("")||pword.equals("")){
                 JOptionPane.showMessageDialog(null, "Please Enter required fields", "Warning", JOptionPane.ERROR_MESSAGE);
                    
                }
                
                else if(pword.equals(rewrite)){
                    
                    
                    int selected=JOptionPane.showConfirmDialog(null, "Do you want to edit this Account?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if(selected==JOptionPane.YES_OPTION){
                        EncryptDecrypt d = new EncryptDecrypt();
                        try {
                            pword=d.encrypt(pword);
                        } catch (Exception ex) {
                            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        con.editAccount(uname,pword,id);
                                        
                                           
                        frame.dispose();
                    }
                    else{
                        _pword.setText("");
                        _rewrite.setText("");
                       
                    }
                    
                }
                else{
                    JFrame error=new JFrame("ERROR");
                    String e_state="Password does not match.\n          try again";
                    Font f=new Font("Calibri", Font.PLAIN, 18);
                    UIManager.put("OptionPane.messageFont", f);
                    UIManager.put("OptionPane.buttonFont", f);
                    JOptionPane.showMessageDialog(error,e_state );  
                    _pword.setText("");
                    _rewrite.setText("");
                        
                        
                }
                
                    
	}

    }
    
}

