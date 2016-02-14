/*
 * for main view 
 */
package main;

/**
 *
 * @author jay
 */
import java.awt.*;
import javax.swing.*;

public class main {
    
    
    
    public static JPanel accounts;
    private JFrame frame;
    private static int i=0;
    public static boolean conn_state=false;
    
    public main(){
    
        frame=new JFrame("PASSWORD MANAGER");
        
        //menubar
        Menu_bar menubar=new Menu_bar();
        frame.setJMenuBar(menubar);
         
        JPanel main_panel=new JPanel();
        main_panel.setOpaque(false);
        JPanel work_panel=new JPanel();
        JPanel menu_panel=new JPanel();
        
        JPanel setting=new JPanel();
        setting.setPreferredSize(new Dimension(200,630));
        setting.setBackground(Color.white);
        accounts=new JPanel();
        accounts.setOpaque(false);
        accounts.setPreferredSize(new Dimension(600,630));
        
        JLabel add=new JLabel(new ImageIcon(this.getClass().getResource("image/wall4.png")));
         
        menu_panel.setPreferredSize(new Dimension(800,45));
        menu_panel.add(add);
       
         
        JLabel set_image=new JLabel(new ImageIcon(this.getClass().getResource("image/set.png")));
        setting.add(set_image);
        
        //--------------------update
                        
                        main.accounts.removeAll();
                        Connect con1=new Connect();
                        int [] idAry=con1.allIds();
                        String []names=con1.allNames();
                        
                        if(idAry != null){
                        int noOfAccounts=idAry.length;
                        
                        main.accounts.setLayout(new GridLayout(15, 1));//setlayout
        
                        Account_panel []a=new Account_panel[noOfAccounts];
        
                        for(int j=0;j<noOfAccounts;j++){
                            
                            a[j]=new Account_panel(names[j],idAry[j]);
                        
                            main.accounts.add(a[j]);
                        }
                        main.accounts.revalidate();
                        }         
        work_panel.setLayout(new BoxLayout(work_panel, BoxLayout.X_AXIS));
        work_panel.setPreferredSize(new Dimension(600,600));
        work_panel.add(setting);
        
        JScrollPane scroll = new JScrollPane(accounts);
        work_panel.add(scroll);
        
        menu_panel.setBackground(Color.white);
        main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
        main_panel.add(menu_panel);
        main_panel.add(work_panel);
      
        frame.setIconImage((new ImageIcon(this.getClass().getResource("image/icon.png"))).getImage());
       
        frame.add(main_panel);
        frame.setSize(800,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        frame.setMaximumSize(new Dimension(800,800));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
     
 
}

