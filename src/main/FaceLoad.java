package main;
 /*
 * @author jay
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.VideoCapture;
import org.opencv.objdetect.CascadeClassifier;

public class FaceLoad{

   public  static JFrame frame;
    
public FaceLoad() {
        
        frame = new JFrame("Face Recognizer");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400,400));
        frame.setIconImage((new ImageIcon(this.getClass().getResource("image/icon.png"))).getImage());
        frame.setLocationRelativeTo(null);
       
        JLabel state=new JLabel("Welcome to Password Manger");
         JLabel state1=new JLabel( "when you are creating your account\n consider following steps");
         JLabel state2=new JLabel("1.capture photos of you.make sure there different  angles of your face");
         JLabel state3=new JLabel("2.give a strong password and keep it in mind ");
        
        state.setFont(new Font("Calibri", Font.PLAIN, 16));
        state1.setFont(new Font("Calibri", Font.PLAIN, 16));
        state2.setFont(new Font("Calibri", Font.PLAIN, 16));
        state3.setFont(new Font("Calibri", Font.PLAIN, 16));
        
        JPanel p=new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.add(state);p.add(state1);p.add(state2);p.add(state3);
        p.setBackground(Color.white);
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        CascadeClassifier faceDetector = new CascadeClassifier("lbpcascade_frontalface.xml");
        Compare toc=new Compare();
        
        p.add(toc);
        frame.add(p);
    Mat webcam_image=new Mat();    
        
        MatToBufImg mat2Buf = new MatToBufImg();
        VideoCapture capture = null;
        
        try {
            capture = new VideoCapture(0);
        } catch (Exception xx) {
           System.out.println(xx);
        }
        
        if (capture.open(0)) {
            frame.setVisible(true);
            while (true) {
                
                capture.read(webcam_image);
                if (!webcam_image.empty()) {
                    frame.setSize(webcam_image.width(), webcam_image.height());
                    MatOfRect faceDetections = new MatOfRect();
                    faceDetector.detectMultiScale(webcam_image, faceDetections);
                    for (Rect rect : faceDetections.toArray()) {
                        Core.rectangle(webcam_image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));// mat2Buf, mat2Buf);
                        Compare.X=rect.x;
                        Compare.Y=rect.y;
                        Compare.Width=rect.width;
                        Compare.Height=rect.height;
                        toc.image_roi=webcam_image;
                        if( Compare.i==0) {
                            frame.dispose();
                            signup s=new signup();
                             capture.release(); 
                             break;
                        }
                    }
                                
                    mat2Buf.setMatrix(webcam_image, ".jpg");
                    toc.setimage(mat2Buf.getBufferedImage());
                    toc.repaint();
                } else {
                    System.out.println("problems with webcam image capture");
                    break;
                }
            }
        }
        capture.release();
    }
public static void main(String []args){
FaceLoad f=new FaceLoad();
}
public void closeframe(){
this.frame.dispose();
}

}