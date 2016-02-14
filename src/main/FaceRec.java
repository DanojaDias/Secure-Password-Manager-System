/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author jay
 */
/*
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import org.opencv.core.Mat;

/**
 *
 * @author OldSpice
 */
public class FaceRec extends JPanel {
   
    private BufferedImage image;
    Mat image_roi = new Mat();
    

    public FaceRec() {
        super();
        
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
    
} 

