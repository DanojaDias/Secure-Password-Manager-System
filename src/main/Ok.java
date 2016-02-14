/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author jay
 */
public class Ok implements ActionListener{
    public JFrame frame;
    
    public Ok(JFrame frame){
    this.frame=frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) { 
     frame.dispose();
      FaceLoad f=new FaceLoad();
}
    
}
