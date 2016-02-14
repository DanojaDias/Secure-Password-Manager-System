/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author jay
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AP extends JPanel{
    
    private final String name;
    private final int id;
    
    public AP(String name,int id){
        super();
        this.name=name;
        this.id=id;
        
        
        this.setMaximumSize(new Dimension(600,40));
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JPanel icon_panel=new JPanel();
        JPanel name_panel=new JPanel();
        JPanel edit_panel=new JPanel();
        JPanel delete_panel=new JPanel();
        JPanel go_panel=new JPanel();
        JPanel detail_panel=new JPanel();
        
        icon_panel.setPreferredSize(new Dimension(100,80));
        edit_panel.setPreferredSize(new Dimension(100,80));
        delete_panel.setPreferredSize(new Dimension(100,80));
        name_panel.setPreferredSize(new Dimension(100,80));
        go_panel.setPreferredSize(new Dimension(100,80));
        detail_panel.setPreferredSize(new Dimension(100,80));
                
        icon_panel.setBackground(Color.white);
        edit_panel.setBackground(Color.white);
        delete_panel.setBackground(Color.white);
        name_panel.setBackground(Color.white);
        go_panel.setBackground(Color.white);
        detail_panel.setBackground(Color.white);
        
        Font f = new Font("Calibri", Font.PLAIN, 12);
        UIManager.put("Label.font", f);
        
        JLabel edit=new JLabel("edit");
        JLabel delete=new JLabel("delete");
        JLabel go=new JLabel("Go");
        JLabel acc_name=new JLabel(this.name);
        JLabel detail=new JLabel("details");
        
        edit.addMouseListener(new MouseAdapter()  
            {  
               @Override
                public void mouseClicked(MouseEvent e)  
                { 
                   Edit D=new Edit(getId()); 
                }  
            });    
        delete.addMouseListener(new MouseAdapter()  
            {  
                @Override
                public void mouseClicked(MouseEvent e)  
                { 
                    Delete D=new Delete(getId());
                }  
            });
        go.addMouseListener(new MouseAdapter()  
            {  
                @Override
                public void mouseClicked(MouseEvent e)  
                { 
                   try{ Go g=new Go(getId());}
                   catch(Exception E){System.out.println(E);}
                }  
            });
        acc_name.addMouseListener(new MouseAdapter()  
            {  
                @Override
                public void mouseClicked(MouseEvent e)  
                { 
                    //edit this part
                }  
            });
        detail.addMouseListener(new MouseAdapter()  
            {  
                @Override
                public void mouseClicked(MouseEvent e)  
                { 
                    Detail d=new Detail(getId());
                }  
            });
        
        
        edit_panel.add(edit);
        delete_panel.add(delete);
        go_panel.add(go);
        name_panel.add(acc_name);
        detail_panel.add(detail);
        icon_panel.add(new JLabel(new ImageIcon(this.getClass().getResource("image/"+this.name+".png"))));
        
        this.add(icon_panel);
        this.add(name_panel);
        this.add(edit_panel);
        this.add(detail_panel);
        this.add(delete_panel);
        this.add(go_panel);
       
    }
    public int getId(){//returns id
    return this.id;
    }
    
    
}
