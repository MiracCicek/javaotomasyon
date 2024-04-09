import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainTest {
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

        driver.findElement(By.cssSelector("li#item-4")).click();

        driver.findElement(By.cssSelector("button#doubleClickBtn")).click();


        WebElement messageElement = driver.findElement(By.cssSelector("p#doubleClickMessage"));
        String message = messageElement.getText();
        Assert.assertEquals(message, "Button double-clicked");
    }

    @Test
    public void testAddAndEditRecord() {

        driver.get("https://demoqa.com/webtables");

        driver.findElement(By.cssSelector("button#addNewRecordButton")).click();

        driver.findElement(By.cssSelector("div[class='modal-content'] input#firstName")).sendKeys("John");
        driver.findElement(By.cssSelector("div[class='modal-content'] input#lastName")).sendKeys("Doe");
        driver.findElement(By.cssSelector("div[class='modal-content'] input#userEmail")).sendKeys("john.doe@example.com");
        driver.findElement(By.cssSelector("div[class='modal-content'] input#age")).sendKeys("30");
        driver.findElement(By.cssSelector("div[class='modal-content'] input#salary")).sendKeys("5000");
        driver.findElement(By.cssSelector("div[class='modal-content'] input#department")).sendKeys("IT");
        driver.findElement(By.cssSelector("div[class='modal-content'] button#submit")).click();
    }

    @AfterClass
    public void tearDown() {
        // WebDriver'ı kapatma
        driver.quit();
    }
}