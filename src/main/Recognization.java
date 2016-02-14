/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
/**
 *
 * @author jay
 */
public class Recognization {
    int count=0;
    static double confidence=100;
    
    public Recognization(){
    JFrame frame = new JFrame("Face Recognizer");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setIconImage((new ImageIcon(this.getClass().getResource("image/icon.png"))).getImage());
        frame.setLocationRelativeTo(null);
       
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        CascadeClassifier faceDetector = new CascadeClassifier("lbpcascade_frontalface.xml");
       FaceRec rec=new FaceRec();
        MatToBufImg mat2Buf = new MatToBufImg(); 
        frame.add(rec);
        Mat webcam_image=new Mat();    
        
        VideoCapture capture = null;
        
        
        
        try {
            capture = new VideoCapture(0);
        } catch (Exception xx) {
           System.out.println(xx);
        }
        
        if (capture.open(0)) {
            frame.setVisible(true);
            
            while (true) {
                count++;
                if(confidence<150){
                 frame.dispose();
                 JFrame error=new JFrame("ERROR1");
                 JOptionPane.showMessageDialog(error, "You were identified as the user.");
                 Login l=new Login();
                 break;
                }
                if(count>=25){
                frame.dispose();
                NotUser n=new NotUser();
                break;
                }
                capture.read(webcam_image);
                try{
                if (!webcam_image.empty()) {
                    frame.setSize(webcam_image.width(), webcam_image.height());
                    MatOfRect faceDetections = new MatOfRect();
                    faceDetector.detectMultiScale(webcam_image, faceDetections);
                    
                    for (Rect rect : faceDetections.toArray()) {
                        Core.rectangle(webcam_image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
                      
                        Rect rect_Crop=null;
                                        try{ rect_Crop = new Rect(rect.x, rect.y, rect.width, rect.height);
                                        Mat  image2 = new Mat(rec.image_roi,rect_Crop);
                                       // Imgproc.resize(image2, image2, new Size(128,128));
                                         Highgui.imwrite("test4.jpg",image2);
                                       Eigenface e=new Eigenface();}
                                        catch(Exception e){
                                        }
                    
                       rec.image_roi=webcam_image;
                    }
                                
                    mat2Buf.setMatrix(webcam_image, ".jpg");
                   rec.setimage(mat2Buf.getBufferedImage());
                   rec.repaint();
                } 
                }
                catch(Exception e){
                    System.out.println("problems with webcam image capture");
                    break;
                }
            }
        }
        capture.release();    
}
    public static void main(String []args){
Recognization f=new Recognization();
}
}
