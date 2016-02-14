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
import javax.swing.*;


public class Delete {
     JFrame frame=new JFrame("DELETE ACCOUNT");
    int id;
    public static int [] allid;
    public Delete(int id){
        this.id=id;
        JPanel main_panel=new JPanel();
        JPanel panel=new JPanel();
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        JPanel panel7=new JPanel();
        
        panel.setBackground(Color.white);
        panel1.setBackground(Color.white);
        panel2.setBackground(Color.white);
        panel3.setBackground(Color.white);
        //panel4.setBackground(Color.white);
        //panel5.setBackground(Color.white);
        //panel6.setBackground(Color.white);
        panel7.setBackground(Color.white);
        
        JLabel state=new JLabel("Are you sure you want to delete this account? " +id);
        state.setFont(new Font("Calibri", Font.PLAIN, 18));
        
         
        JButton edit=new JButton(new ImageIcon(this.getClass().getResource("image/ok.png")));
        edit.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        edit.addActionListener(new editAction());
        //edit.addActionListener();
        Update u=new Update();
        
        JButton cancel=new JButton(new ImageIcon(this.getClass().getResource("image/cancel.png"))); 
        cancel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        cancel.addActionListener(new Cancel(this.frame));  
            
        
        frame.setIconImage((new ImageIcon(this.getClass().getResource("image/icon.png"))).getImage());
        
	frame.setSize(400,400);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        main_panel.setPreferredSize(new Dimension(400,300));
	main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
	
        
        panel2.add(state);
        
        panel.add(new JLabel(new ImageIcon(this.getClass().getResource("image/cover.png"))));
        panel7.add(edit);
        panel7.add(cancel);
        
        main_panel.add(panel);
        main_panel.add(panel1);
        main_panel.add(panel2);
        main_panel.add(panel3);
         main_panel.add(panel7);
        
        frame.add(main_panel);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        //frame.setAlwaysOnTop(true);
        frame.pack();
        frame.setVisible(true);
    }
    
    
    class editAction implements ActionListener{	        
        @Override
          public void actionPerformed(ActionEvent arg0){             
                        
                        Connect con=new Connect();
                          
                        con.deleteAccount(id);// here the id must be given 
                        
                        frame.dispose();
                        //--------------------update
                        Connect con1=new Connect();
                        
                        main.accounts.removeAll();
                         main.accounts.setLayout(new GridLayout(15, 1));//setlayout
                        int [] idAry=con1.allIds();
                        
                      try { 
                           String []names=con1.allNames();
                           int noOfAccounts=idAry.length;
                           Account_panel []a=new Account_panel[noOfAccounts];
                        
                        for(int j=0;j<noOfAccounts;j++){                            
                            a[j]=new Account_panel(names[j],idAry[j]);
                            main.accounts.add(a[j]);
                        }
                       }catch(NullPointerException e){
                       //do nothing
                       }
                      
                        main.accounts.revalidate();
                        main.accounts.repaint();
                        
                        
             //--------------------
                        
                }                  
	}   
}

