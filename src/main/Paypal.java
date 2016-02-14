
package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 *
 * @author jay
 */

public class Paypal {
    
    private String name;
    private String pass;
    
    public Paypal(String name,String pass){
        try{this.name=name;
        this.pass=pass;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

    // Navigate to a web page
        driver.get("https://www.paypal.com/signin/");

    // Perform actions on HTML elements, entering text and submitting the form
        WebElement usernameElement     = driver.findElement(By.name("login_email"));
        WebElement passwordElement     = driver.findElement(By.name("login_password"));
    
        usernameElement.sendKeys(this.name);
        passwordElement.sendKeys(this.pass); 
        }
        catch(Exception E){
        
        }
    }
    public static void main(String []args){
    Paypal g=new Paypal("jay","123");
    
    }
    
}
