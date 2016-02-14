/*
 * this is the main class runner :-)
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jay
 */

public class Project {
    
    static Connection con;
    private static String masterPw; 

    public Project(){
        conn();
    }
    public static void conn(){
        try{
            String host ="jdbc:derby://localhost:1527/passwordManager";
            String uName="user1";
            String uPass="abc123";                
            con=DriverManager.getConnection(host,uName,uPass);         
        }catch(SQLException err){
            JFrame error=new JFrame("ERROR1");
            JOptionPane.showMessageDialog(error, err.getMessage()+"e1");
        }
    }
    public static void main(String[] args) {
        Project p=new Project();
        Connect con1=new Connect();
	  
        if(con1.whetherEmpty()==true){
             FaceLoad f=new FaceLoad();
        }
        else{
           Recognization f=new Recognization();
        }
    }
    public static String getMasterPw() {
        return masterPw;
    }
    public static void setMasterPw(String masterPw) {
        Project.masterPw = masterPw;
    }  
}
