
package main;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;
/**
 *
 * @author jay
 */

public class Gmail {
    
    private String name;
    private String pass;
    
    public Gmail(String name,String pass){
        this.name=name;
        this.pass=pass;
        
    try{    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
     ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
       capabilities.setCapability(ChromeOptions.CAPABILITY, options);
     
        WebDriver driver = new ChromeDriver();

    // Navigate to a web page
        driver.get("https://mail.google.com");

    // Perform actions on HTML elements, entering text and submitting the form
        WebElement usernameElement     = driver.findElement(By.name("Email"));
        usernameElement.sendKeys(this.name);
        
        WebElement next = driver.findElement(By.id("next"));
        
        TimeUnit.SECONDS.sleep(1);
        
        next.sendKeys(Keys.ENTER);
        
        WebDriverWait wait = new WebDriverWait(driver,50);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Passwd")));
       
        
        WebElement passwordElement     = driver.findElement(By.id("Passwd"));
        
        TimeUnit.SECONDS.sleep(1);
        
        passwordElement.sendKeys(this.pass);
    }
    catch(Exception E){
    
    }
        
        
    }
    public static void main(String []args){
    Gmail g=new Gmail("jay","123");
    
    }
}
