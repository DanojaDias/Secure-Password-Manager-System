/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jay
 */
public class Go {
    private final String username;
    private final String password;
    
    public Go(int id) throws Exception{
        Connect con=new Connect();
        String [] rowDetail=con.accountDetail1(id);
        this.username=rowDetail[1];
        String pw=rowDetail[2];  
        EncryptDecrypt d = new EncryptDecrypt();          
        this.password=d.decrypt(pw);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        Date time = new Date();
        inputDateTime datetime=new inputDateTime(dateFormat.format(date),timeFormat.format(time),id);
        datetime.editAccount();
    System.out.println("hello" + password);
        switch (rowDetail[0]) {
            case "facebook":
                {
                    Facebook f=new Facebook(this.username,this.password);
                    break;
                }
            case "gmail":
                {
                    Gmail f=new Gmail(this.username,this.password);
                    break;
                }
            case "feels":
                {
                    Feels f=new Feels(this.username,this.password);
                    break;
                }
            case "yahoo":
                {
                    Yahoo f=new Yahoo(this.username,this.password);
                    break;
                }
            case "dreamspark":
                {
                    Dreamspark f=new Dreamspark(this.username,this.password);
                    break;
                }
            case "hackerrank":
                {
                    Hackerrank f=new Hackerrank(this.username,this.password);
                    break;
                }
            case "linkedin":
                {
                    Linkedin f=new Linkedin(this.username,this.password);
                    break;
                }
            case "paypal":
                {
                    Paypal f=new Paypal(this.username,this.password);
                    break;
                }
            case "samsung":
                {
                    Samsung f=new Samsung(this.username,this.password);
                    break;
                }
            default:
                {
                    Other f=new Other(this.username,this.password,rowDetail[5],rowDetail[6],rowDetail[7]);
                    break;
                }
        }
        
        
    }
}
