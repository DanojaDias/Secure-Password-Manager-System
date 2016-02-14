
package main;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Facebook {
    
    private String name;
    private String pass;
    
    public Facebook(String name,String pass){
       try{ this.name=name;
        this.pass=pass;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
         ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
       capabilities.setCapability(ChromeOptions.CAPABILITY, options);
     
        WebDriver driver = new ChromeDriver();

    // Navigate to a web page
        driver.get("https://www.facebook.com");

    // Perform actions on HTML elements, entering text and submitting the form
        WebElement usernameElement     = driver.findElement(By.name("email"));
        WebElement passwordElement     = driver.findElement(By.name("pass"));
        
        TimeUnit.SECONDS.sleep(1);
    
        usernameElement.sendKeys(this.name);
        passwordElement.sendKeys(this.pass);
        
 
       }
       catch(Exception e){
       
       }      
    }
    

}
