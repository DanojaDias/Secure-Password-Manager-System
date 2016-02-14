/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Danoja Dias
 */
public class inputDateTime {
        private Statement stmt;
        private ResultSet rs1;
        private String date, time;
        private int id;
        public inputDateTime(String date,String time,int id){
            this.date=date;
            this.time=time;
            this.id=id;
        }
   
   public void editAccount() {                                          
                    
        try{
            stmt = Project.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql="SELECT * FROM ACCOUNT WHERE ID="+id;
            rs1 = stmt.executeQuery( sql );
            
            if(rs1.next()){               
                rs1.updateString("LASTLOGINDATE",  date);
                rs1.updateString("LASTLOGINTIME",  time);
                rs1.updateRow( );
                
            }
            
            
           
        }
        catch(Exception err){
            JFrame error=new JFrame("ERROR9");
            JOptionPane.showMessageDialog(error, err.getMessage()+"e100");
            
        }
    }
   
   
}
