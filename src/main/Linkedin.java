
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

public class Linkedin {
    
    private String name;
    private String pass;
    
    public Linkedin(String name,String pass){
        try{this.name=name;
        this.pass=pass;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
         ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
       capabilities.setCapability(ChromeOptions.CAPABILITY, options);
     
        WebDriver driver = new ChromeDriver();

    // Navigate to a web page
        driver.get("https://www.linkedin.com/uas/login?goback=%2Ebzo_*1_*1_*1_*1_*1_*1_*1_*1_login&trk=hb_signin");

    // Perform actions on HTML elements, entering text and submitting the form
        WebElement usernameElement     = driver.findElement(By.name("session_key"));
        WebElement passwordElement     = driver.findElement(By.name("session_password"));
    
        usernameElement.sendKeys(this.name);
        passwordElement.sendKeys(this.pass); 
        }
        catch(Exception E){
        
        }
    }
    public static void main(String []args){
    Linkedin g=new Linkedin("jay","123");
    
    }
    
}
