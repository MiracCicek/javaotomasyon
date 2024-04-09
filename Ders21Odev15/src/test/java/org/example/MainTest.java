package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:/Users/Mirac.Cicek/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



        driver.get("https://demoqa.com/elements");


        driver.findElement(By.xpath("//span[text()='Buttons']")).click();

        driver.findElement(By.xpath("//button[text()='Click Me']")).click();


        WebElement messageElement = driver.findElement(By.xpath("//p[@id='dynamicClickMessage']"));
        String message = messageElement.getText();
        System.out.println("1. Test: " + message);


        driver.get("https://demoqa.com/webtables");


        driver.findElement(By.xpath("//button[text()='Add']")).click();

        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Mirac");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Cicek");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("mami.cc@example.com");
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys("38");
        driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("5000");
        driver.findElement(By.xpath("//input[@id='department']")).sendKeys("PLM");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();


        driver.quit();
    }
}