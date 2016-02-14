
package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Twitter {
    
    private String name;
    private String pass;
    
    public Twitter(String name,String pass){
        this.name=name;
        this.pass=pass;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

    // Navigate to a web page
        driver.get("https://twitter.com/login?lang=en");
       
    // Perform actions on HTML elements, entering text and submitting the form
        WebElement usernameElement     = driver.findElement(By.xpath("//input[@type='text']"));
        WebElement passwordElement     = driver.findElement(By.xpath("//input[@type='password']"));
    
        usernameElement.sendKeys(this.name);
        passwordElement.sendKeys(this.pass);   
    }
    
    public static void main(String []arg){
    Twitter t=new Twitter("jay","123");
    }
    
}
