/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author jay
 */
import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.javascript.*;
import java.io.*;
import java.util.List;

public class Find {

   private String url;
   public String tfield="";
   public String pfield="";
 
    public Find(String url) {
        
        this.url=url;
        
                  final WebClient webClient = new WebClient();
                  webClient.setJavaScriptEngine(new JavaScriptEngine(webClient));
                   HtmlPage page1 = null;
                   
                   try {
                     // if you enable javascript you can not see novalidate forms 
                      webClient.getOptions().setJavaScriptEnabled(false);
                       page1 = webClient.getPage(url); 
                       webClient.getOptions().setJavaScriptEnabled(true);
                     } catch (IOException e) {
                       System.out.println("page error");

                   }

                   try{ 

                       List<HtmlForm> formlist1 = (List<HtmlForm>) page1.getByXPath("//form");
                       int f1=formlist1.size();
                       //System.out.println(f1);


                       List<HtmlForm> formlist = (List<HtmlForm>) page1.getForms();
                       int f=formlist.size();
                      // System.out.println(f);
                       for(int i=0;i<f;i++){
                          // System.out.println(formlist.get(i));
                       }
                        HtmlForm login_form=formlist.get(0);

                        int i;
                       for(i=0;i<f;i++){
                           HtmlForm login_form1=formlist.get(i);
                           String de=login_form1.asXml();
                               if(de.contains("Search")==true || de.contains("search")==true)
                               {  
                                login_form=formlist.get(i+1);
                                   break;
                               }
                               //System.out.println(de);
                       }


                       HtmlTextInput user;
                       try{
                            user=login_form.getFirstByXPath("//input[@type='email']");
                            if(user==null){
                               try{
                                   user=login_form.getFirstByXPath("//input[@type='text']");
                                     }
                               catch(Exception e){
                                   System.out.println("text-"+"no"); 
                               }
                            }
                           // System.out.println("text-"+user);
                            String userElement=user.getId();
                            if(userElement==null){
                                //userElement=user.getLocalName();
                            }
                          //  System.out.println("text-name"+userElement);
                            tfield=userElement;
                       }
                       catch(Exception e){
                           System.out.println("email-"+"no"); 
                       }


                       try{
                            HtmlPasswordInput pass=login_form.getFirstByXPath("//input[@type='password']");
                           // System.out.println("pass-"+pass);
                            String passElement=pass.getId();
                            if(passElement==null){
                                //passElement=pass.getLocalName();
                            }
                            //System.out.println("pass-name"+passElement);
                            pfield=passElement;
                       }
                       catch(Exception e){

                       }

                   }
                   catch(Exception e)
                       {System.out.println(e);}

         }
    public static void main(String [] args){
    Find f=new Find("https://www.facebook.com");
    
    }
    public String gettfield(){
    return this.tfield;
    }
    public String getpfield(){
    return this.pfield;
    }
     
}

