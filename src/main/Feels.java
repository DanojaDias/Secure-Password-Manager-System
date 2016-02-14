
package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Feels {
    
    private String name;
    private String pass;
    
    public Feels(String name,String pass){
        this.name=name;
        this.pass=pass;
       try{ 
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

    // Navigate to a web page
        driver.get("https://feels.pdn.ac.lk");

    // Perform actions on HTML elements, entering text and submitting the form
        WebElement usernameElement     = driver.findElement(By.name("username"));
        WebElement passwordElement     = driver.findElement(By.name("password"));
    
        usernameElement.sendKeys(this.name);
        passwordElement.sendKeys(this.pass); 
       }
       catch(Exception E){}
    }
}
