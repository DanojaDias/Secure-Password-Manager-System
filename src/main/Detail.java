/*this is for details
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


public class Detail {
    
    private int id;
    public  JFrame frame;
    
    public Detail(int id){
        this.id=id;
        
        frame=new JFrame("DETAILS");
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
        
        JLabel uname=new JLabel("User name:");
        uname.setFont(new Font("Calibri", Font.PLAIN, 18));
        JLabel pword=new JLabel("Last log in date:");
        pword.setFont(new Font("Calibri", Font.PLAIN, 18));
        JLabel llogin=new JLabel("Last log in date:");
        llogin.setFont(new Font("Calibri", Font.PLAIN, 18));
        
        //-----------------------------------------------data base
            Connect con=new Connect();
            String [] rowDetail=con.accountDetail(id);
            
            
       JLabel name;
        
        String nameaccount="facebook gamil dreamspark feels github hackerrank linkedin sumsung yahoo paypal ";
       if(nameaccount .contains(rowDetail[0]) ==true){name=new JLabel(new ImageIcon(this.getClass().getResource("image/"+rowDetail[0]+".png")));}
       else{name=new JLabel(new ImageIcon(this.getClass().getResource("image/"+"other"+".png")));}
      
        //-----------------------------------------------------
        JLabel _name=new JLabel(rowDetail[0]);
        _name.setFont(new Font("Calibri", Font.PLAIN, 18));
        JLabel _uname=new JLabel(rowDetail[1]);
        _uname.setFont(new Font("Calibri", Font.PLAIN, 18));
         JLabel _llogin=new JLabel(rowDetail[3]);
        _llogin.setFont(new Font("Calibri", Font.PLAIN, 18));
        JLabel _pword=new JLabel(rowDetail[4]);
        _pword.setFont(new Font("Calibri", Font.PLAIN, 18));
        
        JButton add=new JButton(new ImageIcon(this.getClass().getResource("image/ok.png")));
        add.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        add.addActionListener(new Cancel(this.frame));
          
        
        frame.setIconImage((new ImageIcon(this.getClass().getResource("image/icon.png"))).getImage());
        
	frame.setSize(400,400);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        main_panel.setPreferredSize(new Dimension(400,400));
	main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
	
        
        panel2.add(name);
        panel4.add(uname);
        panel5.add(pword);
        panel6.add(llogin);
       
        panel2.add(_name);
        panel4.add(_uname);
        panel5.add(_pword);
        panel6.add(_llogin);
        
        panel.add(new JLabel(new ImageIcon(this.getClass().getResource("image/cover.png"))));
        panel7.add(add);
         
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
        frame.setLocationRelativeTo(null);
        //frame.setAlwaysOnTop(true);
        frame.pack();
        frame.setVisible(true);
    }
    
    
}

