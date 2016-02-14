/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author jay
 */
public class Other {
    
    private String name;
    private String pass;
    
    public Other(String name,String pass,String url,String tfield,String pfield){
        this.name=name;
        this.pass=pass;
        
        try{
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
       capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        
        WebDriver driver = new ChromeDriver();

    // Navigate to a web page
        driver.get(url);

    // Perform actions on HTML elements, entering text and submitting the form
        WebElement usernameElement     = driver.findElement(By.id(tfield));
        WebElement passwordElement     = driver.findElement(By.id(pfield));
    
        usernameElement.sendKeys(this.name);
        passwordElement.sendKeys(this.pass);
        }
        catch(Exception e){
       
       }
    }
    public static void main(String []args){
    Other g=new Other("jay","123","https://login.bigcommerce.com/login","user_email","user_password");
    
    }
    
}
