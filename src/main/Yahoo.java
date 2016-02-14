
package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Yahoo {
    
    private String name;
    private String pass;
    
    public Yahoo(String name,String pass){
        try{this.name=name;
        this.pass=pass;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

    // Navigate to a web page
        driver.get("https://login.yahoo.com");

    // Perform actions on HTML elements, entering text and submitting the form
        WebElement usernameElement     = driver.findElement(By.name("username"));
        WebElement passwordElement     = driver.findElement(By.name("passwd"));
    
        usernameElement.sendKeys(this.name);
        passwordElement.sendKeys(this.pass); 
        }
        catch(Exception E){}
    }
    
}
