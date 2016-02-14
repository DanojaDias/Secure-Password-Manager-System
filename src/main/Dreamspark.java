/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author jay
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dreamspark {
    
    private String name;
    private String pass;
    
    public Dreamspark(String name,String pass){
        this.name=name;
        this.pass=pass;
        try{
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

    // Navigate to a web page
        driver.get("https://login.live.com");

    // Perform actions on HTML elements, entering text and submitting the form
        WebElement usernameElement     = driver.findElement(By.name("loginfmt"));
        WebElement passwordElement     = driver.findElement(By.name("passwd"));
    
        usernameElement.sendKeys(this.name);
        passwordElement.sendKeys(this.pass);
        }
        catch(Exception e){
       
       }
    }
    public static void main(String []arg){
    Dreamspark e=new Dreamspark("j","123");
    
    }
    
}
