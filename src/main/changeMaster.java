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
public class changeMaster {
        private Statement stmt;
        private ResultSet rs;
        private String date, time;
        private int id;
        public changeMaster(){
            
        }
   
   public String[] allPasswords(){
        try{
            
            stmt = Project.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql="SELECT PASSWORD FROM ACCOUNT";
            rs = stmt.executeQuery( sql ); 
            int id=0;
            while(rs.next()){
                id++;
            }            
            
            rs.first();
            if(id!=0){                
                String []idAry=new String[id];
                idAry[0]=rs.getString("PASSWORD");
                int i=1;
                while(rs.next()){
                    
                    //System.out.println("hello");
                    idAry[i]=rs.getString("NAME");
                    i++;
                }
                //con.close();
                stmt.close();
             rs.close();
                return idAry;
            
            }
        }catch(SQLException err){
            JFrame error=new JFrame("ERROR");
            JOptionPane.showMessageDialog(error, err.getMessage());
        }
       return null;
       
    }
   
   
}
