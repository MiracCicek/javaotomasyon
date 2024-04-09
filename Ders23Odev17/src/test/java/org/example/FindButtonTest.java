package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FindButtonTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {


        System.setProperty("webdriver.chrome.driver", "C:/Users/Mirac.Cicek/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void testButtonClick() {

        driver.get("https://demoqa.com/elements");


        WebElement buttonsElement = driver.findElement(By.xpath("//span[text()='Buttons']"));
        buttonsElement.click();

        WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        clickMeButton.click();


        WebElement messageElement = driver.findElement(By.id("dynamicClickMessage"));
        String message = messageElement.getText();
        Assert.assertEquals(message, "You have done a dynamic click");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}