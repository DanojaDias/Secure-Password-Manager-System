/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author jay
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Cancel implements ActionListener{
    
    public JFrame frame;
    
    public Cancel(JFrame frame){
    this.frame=frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) { 
     frame.dispose();
}
    
}
