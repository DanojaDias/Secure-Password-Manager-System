
package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 *
 * @author jay
 */

public class Github {
    
    private String name;
    private String pass;
    
    public Github(String name,String pass){
        try{this.name=name;
        this.pass=pass;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

    // Navigate to a web page
        driver.get("https://github.com/login");

    // Perform actions on HTML elements, entering text and submitting the form
        WebElement usernameElement     = driver.findElement(By.name("login"));
        WebElement passwordElement     = driver.findElement(By.name("password"));
    
        usernameElement.sendKeys(this.name);
        passwordElement.sendKeys(this.pass); 
        }
        catch(Exception E){}
    }
    public static void main(String []args){
    Github g=new Github("jay","123");
    
    }
    
}
