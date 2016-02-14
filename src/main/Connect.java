/*
 This is to connect to the database
 */
package main;/*
 * @author Danoja Dias
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Connect {
   
   private Statement stmt;   
   private ResultSet rs;  
   private String uname;
   private String password;
   
    public Connect(){
        
    }
    
    public void loginReq(){
        try{
        stmt = Project.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
        String sql="SELECT USERNAME,PASSWORD FROM USERS";
        rs = stmt.executeQuery( sql ); 
        rs.next();
        uname=rs.getString("username");
        password=rs.getString("PASSWORD");
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
   
    public void editUserAccountName(String uname) {                                          
                    
        try{
            stmt = Project.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql="SELECT USERNAME FROM USERS";
            rs = stmt.executeQuery( sql );
            
            if(rs.next()){
               
                rs.updateString( "USERNAME", uname );
                
                rs.updateRow( );
                JOptionPane.showMessageDialog(null,"Successfully edited");
               
           
            }
            else{
                JOptionPane.showMessageDialog(null, "Id is invalid", "Warning", JOptionPane.ERROR_MESSAGE);
            }
            
           
        }
        catch(SQLException err){
            JFrame error=new JFrame("ERROR9");
            JOptionPane.showMessageDialog(error, err.getMessage()+"e9");
            
        }
    }
      
   public void signUp(String uName,String pword){
        try{
            stmt = Project.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql="SELECT ID,USERNAME,PASSWORD FROM USERS";
            rs = stmt.executeQuery( sql ); 
            String id="0";
            while(rs.next()){
                id=rs.getString("ID");
            }  
            int idint;
            if(!id.equals("0")){            
                idint=Integer.parseInt(id);
                idint++;
            }
            else {
                idint=1;
            }
            rs.moveToInsertRow();            
            rs.updateInt("ID", idint);
            rs.updateString("USERNAME",uName);            
            rs.updateString("PASSWORD",pword);
            rs.insertRow( );
            stmt.close( );
            rs.close( );
        }catch(SQLException err){
            JFrame error=new JFrame("ERROR3");
            JOptionPane.showMessageDialog(error, err.getMessage());
        }
    }
   
   public void addAccount(String name,String pword,String uName){
        try{
            stmt = Project.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
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
        }catch(SQLException err){
            JFrame error=new JFrame("ERROR4");
            JOptionPane.showMessageDialog(error, err.getMessage());
        }
    }
   
   public void addAccount1(String name,String pword,String uName,String url,String tfield,String pfield){
        try{
            stmt = Project.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
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
            rs.updateString("UNAMEFIELD",tfield );        
            rs.updateString("PASSFIELD",pfield );        
            rs.updateString("URL",url );        
            rs.insertRow();           
            JOptionPane.showMessageDialog(null,"Successfully added");
            stmt.close();
            rs.close(); 
        }catch(SQLException err){
            JFrame error=new JFrame("ERROR4");
            JOptionPane.showMessageDialog(error, err.getMessage());
        }
    }
   
   public boolean whetherEmpty(){
        try{
            stmt = Project.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql="SELECT * FROM USERS";
            rs = stmt.executeQuery( sql ); 
            if(rs.next()==false) {
                return true;
            }
            
               
        }catch(SQLException err){
            JFrame error=new JFrame("ERROR5");
            JOptionPane.showMessageDialog(error, err.getMessage()+"-empty");
        }
       return false;
    }
   
       public String[] allNames(){
        try{
            
            stmt = Project.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql="SELECT * FROM ACCOUNT";
            rs = stmt.executeQuery( sql ); 
            int id=0;
            while(rs.next()){
                id++;
            }            
            
            rs.first();
            if(id!=0){                
                String []idAry=new String[id];
                idAry[0]=rs.getString("NAME");
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
      public int[] allIds(){
        try{
            
            stmt = Project.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
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
                    
                  
                    idAry[i]=Integer.parseInt(rs.getString("ID"));
                    i++;
                }
               
                stmt.close();
             rs.close();
             return idAry;
            
            }
            

          
            
            
            
        }catch(SQLException err){
            JFrame error=new JFrame("ERROR6");
            JOptionPane.showMessageDialog(error, err.getMessage());
        }
       return null;
       
    }
    public String[] accountDetail(int id){
        try{            
            stmt = Project.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
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
                return rowDetail;
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid Id number", "Warning", JOptionPane.ERROR_MESSAGE);
             
            }            
        }catch(SQLException err){
            JFrame error=new JFrame("ERROR7");
            JOptionPane.showMessageDialog(error, err.getMessage());
            
        }
       return null;
       
    } 
    
    public String[] accountDetail1(int id){
        try{            
            stmt = Project.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql="SELECT * FROM ACCOUNT WHERE ID="+id;
            rs = stmt.executeQuery( sql ); 
            
            if(rs.next()){                
                String []rowDetail=new String[8];
                rowDetail[0]=(rs.getString("NAME"));
                rowDetail[1]=(rs.getString("UNAME"));
                rowDetail[2]=(rs.getString("PASSWORD"));
                rowDetail[3]=(rs.getString("LASTLOGINDATE"));
                rowDetail[4]=(rs.getString("LASTLOGINTIME"));
                rowDetail[5]=(rs.getString("URL"));
                rowDetail[6]=(rs.getString("UNAMEFIELD"));
                rowDetail[7]=(rs.getString("PASSFIELD"));
               
                stmt.close();
                rs.close();               
                return rowDetail;
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid Id number", "Warning", JOptionPane.ERROR_MESSAGE);
             
            }            
        }catch(SQLException err){
            JFrame error=new JFrame("ERROR7");
            JOptionPane.showMessageDialog(error, err.getMessage());
            
        }
       return null;
       
    } 
    
    
     public void deleteAccount(int id) {                                          
                    
        try{
            
            stmt = Project.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql="SELECT * FROM ACCOUNT WHERE ID="+id;
            rs = stmt.executeQuery( sql );
            
            if(rs.next()){
                rs.deleteRow( );
                JOptionPane.showMessageDialog(null, "Successfully deleted", "Success", JOptionPane.INFORMATION_MESSAGE);               
                stmt.close();
                rs.close();
                        }
           else{
                JOptionPane.showMessageDialog(null, "Id is invalid"+id, "Warning", JOptionPane.ERROR_MESSAGE);
            }
            
            
        }
        catch(SQLException err){
            JFrame error=new JFrame("ERROR8");
            JOptionPane.showMessageDialog(error, err.getMessage()+"e8");
            
        }
    }   
     public void editAccount(String uname,String pword,int id) {                                          
                    
        try{
            stmt = Project.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql="SELECT UNAME,PASSWORD FROM ACCOUNT WHERE ID="+id;
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
        }
        catch(SQLException err){
            JFrame error=new JFrame("ERROR9");
            JOptionPane.showMessageDialog(error, err.getMessage()+"e9");
            
        }
    } 
     
    public void changeMaster(String newPassword) throws Exception {                 
       /* try{
            stmt = Project.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql="SELECT ID,PASSWORD FROM ACCOUNT";
           
            rs = stmt.executeQuery(sql);
               String sql1;         
            EncryptDecrypt d = new EncryptDecrypt();          
            EncryptDecryptMasterPW mpw= new EncryptDecryptMasterPW(newPassword);
            int id=0;
            String pass;
           
            while(rs.next()){
                id++;
                stmt1 = Project.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
                sql1="SELECT PASSWORD FROM ACCOUNT WHERE ID="+id;
                rs1 = stmt1.executeQuery(sql1);
                if(rs1.next()){
                    pass=rs1.getString(1);
                    
                    pass=d.decrypt(pass);            
                   
                    pass=mpw.encrypt(pass);
                    System.out.println(pass);
                     
                    
                rs1.updateString("PASSWORD", "hello" );
                //rs1.previous();
               //if(rs1.next())
                System.out.println(pass);
                rs1.last();
                rs1.updateRow();
                 System.out.println(pass);
               }  
            }
            Project.setMasterPw(newPassword);
            JOptionPane.showMessageDialog(null,"Successfully edited");
        }
        catch(SQLException err){
            JFrame error=new JFrame("ERROR9");
            JOptionPane.showMessageDialog(error, err.getMessage()+"e10");
            
        }*/
        try{
            
            stmt = Project.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql="SELECT * FROM ACCOUNT";
            rs = stmt.executeQuery( sql ); 
            int id=0;
            while(rs.next()){
                id++;
            }            
            
            rs.first();
            String []idAry = null;
            if(id!=0){                
                idAry=new String[id];
                idAry[0]=rs.getString("PASSWORD");
                int i=1;
                while(rs.next()){
                    
                    //System.out.println("hello");
                    idAry[i]=rs.getString("PASSWORD");
                    i++;
                }
                  
            }
            EncryptDecrypt d = new EncryptDecrypt();          
            EncryptDecryptMasterPW mpw= new EncryptDecryptMasterPW(newPassword);
            
            
            if(id!=0){                
                
                int j=0;
                String pass;
                rs.first();
                pass =d.decrypt(idAry[j]);           
                    pass=mpw.encrypt(pass);
                    //System.out.println("hello");          
                    rs.updateString("PASSWORD", pass );               
                    
             
                    rs.updateRow();
                    System.out.println(pass +"        1");
                    j=1;
                while(j<id){
                     rs.next();
                    pass =d.decrypt(idAry[j]);           
                    pass=mpw.encrypt(pass);
                    //System.out.println("hello");          
                    rs.updateString("PASSWORD", pass );               
                    System.out.println(pass+"                     2");
             
                    rs.updateRow();
                   
                    j++;
                }
                //con.close();
                stmt.close();
             rs.close();
             Project.setMasterPw(newPassword);
            JOptionPane.showMessageDialog(null,"Successfully edited");
            }
            
        }catch(SQLException err){
            JFrame error=new JFrame("ERROR");
            JOptionPane.showMessageDialog(error, err.getMessage());
        }
    }      
}
