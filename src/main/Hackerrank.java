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
public class Hackerrank {
    
    private String name;
    private String pass;
    
    public Hackerrank(String name,String pass){
        this.name=name;
        this.pass=pass;
        try{
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
       capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        
        WebDriver driver = new ChromeDriver();

    // Navigate to a web page
        driver.get("https://www.hackerrank.com/login");

    // Perform actions on HTML elements, entering text and submitting the form
        WebElement usernameElement     = driver.findElement(By.name("login"));
        WebElement passwordElement     = driver.findElement(By.name("password"));
    
        usernameElement.sendKeys(this.name);
        passwordElement.sendKeys(this.pass);
        
        
        
        }
        catch(Exception e){
       
       }
    }
    public static void main(String []args){
    Hackerrank g=new Hackerrank("jay","123");
    
    }
    
}
