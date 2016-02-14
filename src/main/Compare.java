/*
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.highgui.Highgui;

/**
 *
 * @author OldSpice
 */
public class Compare extends JPanel implements ActionListener {
   
    private BufferedImage image;
    Mat image_roi = new Mat();
    static int  X,Y,Width,Height;
   static  int i=3;
   static  JButton button = new JButton("capture "+i);
     JButton cancel = new JButton("cancel ");
    int count = 1;

    public Compare() {
        super();
        button.addActionListener((ActionListener) this);
        this.add(button);
        cancel.addActionListener(new Cancel(FaceLoad.frame));
        this.add(button);
    }

    private BufferedImage getimage() {
        return image;
    }

     void setimage(BufferedImage newimage) {
        image = newimage;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.image == null) {
            return;
        }
        g.drawImage(this.image, 0, 0, this.image.getWidth(), this.image.getHeight(), null);
    }

    public Mat getMat(){
    return this.image_roi;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            Rect rect_Crop=null;
                    
            rect_Crop = new Rect(X, Y, Width, Height);
            Mat  image2 = new Mat(image_roi,rect_Crop);
           
            //Imgproc.cvtColor(image2,image2,Imgproc.COLOR_RGB2GRAY,0);
           // Imgproc.resize(image2, image2, new Size(128,128));
              Highgui.imwrite("test"+i+".jpg",image2);
              i=i-1;
            button.setText("Capture "+i);
           
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
} 

