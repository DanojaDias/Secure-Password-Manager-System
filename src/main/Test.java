/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Danoja Dias
 */
public class Test {
   // boolean empty; // this is the variable which stores whether it's empty or not.
   
    
    public static void main(String args[]){
        
        /* below it checks whether empty or not. 
        uncomment this and see. Console will display whether empty or not
        
        Connect con=new Connect();
	System.out.println(con.whetherEmpty());        
        */
        
        
        
        
        /*this is to get the all ids in the database. idAry contains all the ids.
        
        Connect con=new Connect();
        int [] idAry=con.allIds();
        for(int i=0;i<idAry.length;i++){
            System.out.println(idAry[i]);
        }
        */
        
        
        
        
        /* When id is given this displays the all details.
        
        
        
        Connect con=new Connect();
        String [] rowDetail=con.accountDetail(id);
        for(int i=0;i<rowDetail.length;i++){
            System.out.println(rowDetail[i]);
        }
        */
        
    
    /*
     * /*
 * for main view 
 
package main;


 *
 * @author jay

import java.awt.*;
import javax.swing.*;

public class main {
    
    
    
    public static JPanel accounts;
    public static JLabel conn_label=new JLabel("Connection state:");
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
       // setting.setBackground(new Color(70,140,210));
        
        accounts=new JPanel();
        accounts.setOpaque(false);
        accounts.setPreferredSize(new Dimension(600,630));
        
        JLabel add=new JLabel(new ImageIcon(this.getClass().getResource("image/addacc.png")));
        
        
        conn_label.setPreferredSize(new Dimension(780,33));
        conn_label.setFont(new Font("Calibri", Font.PLAIN, 22));
        conn_label.setBorder(BorderFactory.createRaisedBevelBorder());
        
        
        menu_panel.setPreferredSize(new Dimension(800,90));
        menu_panel.add(add);
        menu_panel.add(conn_label);
         
        JLabel set_image=new JLabel(new ImageIcon(this.getClass().getResource("image/set.png")));
        setting.add(set_image);
        
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
        
        work_panel.setLayout(new BoxLayout(work_panel, BoxLayout.X_AXIS));
        work_panel.setPreferredSize(new Dimension(600,600));
        work_panel.add(setting);
        
        JScrollPane scroll = new JScrollPane(accounts);
        work_panel.add(scroll);
        
        main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
        main_panel.add(menu_panel);
        main_panel.add(work_panel);
      
        frame.setIconImage((new ImageIcon(this.getClass().getResource("image/icon.png"))).getImage());
       
        frame.add(main_panel);
        frame.setSize(800,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
     
 
}


     */
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();
    System.out.println(dateFormat.format(date));
    
    DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    Date time = new Date();
    System.out.println(timeFormat.format(time));
    }
}
