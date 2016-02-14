/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import java.io.File;
import java.nio.IntBuffer;
import static org.bytedeco.javacpp.opencv_core.*;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.MatVector;
import static org.bytedeco.javacpp.opencv_face.*;
import org.bytedeco.javacpp.opencv_face.FaceRecognizer;
import static org.bytedeco.javacpp.opencv_imgcodecs.*;


/**
 *
 * @author jay
 */
public class Eigenface {
    
    
    public Eigenface(){
   
        try{
       
        System.out.println("ok1");
        MatVector images=new MatVector(3);
        File  t1=new File("test1.jpg");
        File t2=new File("test2.jpg");
        File t3=new File("test3.jpg");
        File t4=new File("test4.jpg");
       
        System.out.println("ok2");
        
       Mat img1 = imread(t1.getAbsolutePath(), CV_LOAD_IMAGE_GRAYSCALE);
       Mat img2 = imread(t2.getAbsolutePath(), CV_LOAD_IMAGE_GRAYSCALE);
       Mat img3 = imread(t3.getAbsolutePath(), CV_LOAD_IMAGE_GRAYSCALE);
       Mat img4 = imread(t4.getAbsolutePath(), CV_LOAD_IMAGE_GRAYSCALE);
          
       System.out.println("ok3");
         Mat counter = new Mat(3, 1, CV_32SC1);
        IntBuffer ib=counter.getIntBuffer();
        System.out.println("ok4");
         
         images.put(0, img1);ib.put(0, 1);
       images.put(1, img2);ib.put(1, 1);
        images.put(2,img3);ib.put(2, 1);
         System.out.println("ok5"); 
         
        FaceRecognizer faceRecognizer;
        faceRecognizer = createLBPHFaceRecognizer();
        faceRecognizer.train(images,counter);
        
        
        System.out.println("ok6");
      int [] predictedLabel =new int[3];
    
              
      double [] con=new double[3];
     faceRecognizer.predict(img4, predictedLabel, con);
      
     Recognization.confidence=con[0];
     System.out.println("confidance "  );
      System.out.println(con[0] );
     
    
    }
    catch(Exception e){
        System.out.println(e.getMessage());
    }
        
    }
    public static void main(String []args){
    Eigenface e=new Eigenface();
    }
    
}
