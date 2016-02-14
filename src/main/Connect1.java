/*
 This is to connect to the database
 */
package main;

/*
 * @author Danoja Dias
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Connect1 {
   private Connection con;
   private Statement stmt;
   private ResultSet rs;
   private String uname;
   private String password;
   
    public Connect1(){
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
    
    public void loginReq(){
        try{
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
        String sql="SELECT * FROM USERS";
        rs = stmt.executeQuery( sql ); 
        rs.next();
        uname=rs.getString("username");
        password=rs.getString("password");
        con.close();
        stmt.close();
        rs.close();
        
        }catch(SQLException err){
            JFrame error=new JFrame("ERROR2");
            JOptionPane.showMessageDialog(error, err.getMessage()+"e2");
        }
    }
   public String getUname(){
       return this.uname;
   }
   public String getPassword(){
       return this.password;
   }   
   
   public void signUp(String uName,String pword){
        try{
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql="SELECT * FROM USERS";
            rs = stmt.executeQuery( sql ); 
            String id="0";
            while(rs.next()){
                id=rs.getString("ID");
            }  
            int idint;
            if(!id.equals("0"))   {
            
                idint=Integer.parseInt(id);
                idint++;
            }
            else {
                idint=1;
            }
            rs.moveToInsertRow();
            
            rs.updateInt("ID", idint);
            rs.updateString("USERNAME",uName);
            
            rs.updateString("password",pword );
            rs.insertRow( );
            stmt.close( );
            rs.close( );
            con.close();
             
          
        }catch(SQLException err){
            JFrame error=new JFrame("ERROR3");
            JOptionPane.showMessageDialog(error, err.getMessage());
        }
    }
   
   public void addAccount(String name,String pword,String uName){
        try{
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql="SELECT * FROM ACCOUNT";
            rs = stmt.executeQuery( sql ); 
            String id="0";
            while(rs.next()){
                id=rs.getString("ID");
            }            
            int idint;
            if(!id.equals("0"))   {
            
                idint=Integer.parseInt(id);
                idint++;
            }
            else {
                idint=1;
            }
            rs.moveToInsertRow();            
            rs.updateInt("ID", idint);
            rs.updateString("NAME",name);
            rs.updateString("PASSWORD",pword);
            rs.updateString("UNAME",uName );
            rs.insertRow();
            JOptionPane.showMessageDialog(null,"Successfully added");
            stmt.close();
            rs.close();
            con.close();
             
          
        }catch(SQLException err){
            JFrame error=new JFrame("ERROR4");
            JOptionPane.showMessageDialog(error, err.getMessage());
        }
    }
   public boolean whetherEmpty(){
        try{
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql="SELECT * FROM ACCOUNT";
            rs = stmt.executeQuery( sql ); 
            String id="0";
            while(rs.next()){
                id=rs.getString("ID");
            }                        
            stmt.close();
            rs.close();
            con.close();
            return id.equals("0");//empty true   
        }catch(SQLException err){
            JFrame error=new JFrame("ERROR5");
            JOptionPane.showMessageDialog(error, err.getMessage());
        }
       return false;
    }
      
   
   
   
      public int[] allIds(){
        try{
            
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql="SELECT * FROM ACCOUNT";
            rs = stmt.executeQuery( sql ); 
            int id=0;
            while(rs.next()){
                id++;
            }            
            
            rs.first();
            if(id!=0){                
                int []idAry=new int[id];
                idAry[0]=Integer.parseInt(rs.getString("ID"));
                int i=1;
                while(rs.next()){
                    
                    //System.out.println("hello");
                    idAry[i]=Integer.parseInt(rs.getString("ID"));
                    i++;
                }
                con.close();
                stmt.close();
             rs.close();
                return idAry;
            
            }
            else {
                JOptionPane.showMessageDialog(null, "You have not added any Account", "Warning", JOptionPane.ERROR_MESSAGE);
            }
          
        }catch(SQLException err){
            JFrame error=new JFrame("ERROR6");
            JOptionPane.showMessageDialog(error, err.getMessage());
        }
       return null;
       
    }
      
      
    public String[] accountDetail(int id){
        try{            
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql="SELECT * FROM ACCOUNT WHERE ID="+id;
            rs = stmt.executeQuery( sql ); 
            
            if(rs.next()){                
                String []rowDetail=new String[5];
                rowDetail[0]=(rs.getString("NAME"));
                rowDetail[1]=(rs.getString("UNAME"));
                rowDetail[2]=(rs.getString("PASSWORD"));
                rowDetail[3]=(rs.getString("LASTLOGINDATE"));
                rowDetail[4]=(rs.getString("LASTLOGINTIME"));
                stmt.close();
                rs.close();
                con.close();
                return rowDetail;
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid Id number", "Warning", JOptionPane.ERROR_MESSAGE);
             //   System.exit(0);
            }
      
            
           
            
        }catch(SQLException err){
            JFrame error=new JFrame("ERROR7");
            JOptionPane.showMessageDialog(error, err.getMessage());
            
        }
       return null;
       
    } 
     public void deleteAccount(int id) {                                          
                    
        try{
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql="SELECT * FROM ACCOUNT WHERE ID="+id;
            rs = stmt.executeQuery( sql );
            
            if(rs.next()){
                rs.deleteRow( );
                JOptionPane.showMessageDialog(null, "Successfully deleted", "Success", JOptionPane.INFORMATION_MESSAGE); 
                stmt.close( );
                rs.close( );
                con.close();
            }
            else{
                JOptionPane.showMessageDialog(null, "Id is invalid", "Warning", JOptionPane.ERROR_MESSAGE);
            }
            
            
        }
        catch(SQLException err){
            JFrame error=new JFrame("ERROR8");
            JOptionPane.showMessageDialog(error, err.getMessage()+"e8");
            
        }
    }   
     public void editAccount(String uname,String pword,int id) {                                          
                    
        try{
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql="SELECT * FROM ACCOUNT WHERE ID="+id;
            rs = stmt.executeQuery( sql );
            
            if(rs.next()){
               
                rs.updateString( "uname", uname );
                rs.updateString( "password", pword );
                rs.updateRow( );
                JOptionPane.showMessageDialog(null,"Successfully edited");
               
           
            }
            else{
                JOptionPane.showMessageDialog(null, "Id is invalid", "Warning", JOptionPane.ERROR_MESSAGE);
            }
            
             stmt.close();
            rs.close();
            con.close();   
            
            
        }
        catch(SQLException err){
            JFrame error=new JFrame("ERROR9");
            JOptionPane.showMessageDialog(error, err.getMessage()+"e9");
            
        }
    }       
      
}
