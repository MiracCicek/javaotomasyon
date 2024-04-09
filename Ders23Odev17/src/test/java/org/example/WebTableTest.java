package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTableTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Mirac.Cicek/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testWebTable() {
        driver.get("https://demoqa.com/webtables");

        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();

        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        firstNameInput.sendKeys("John");

        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        lastNameInput.sendKeys("Doe");

        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys("john.doe@example.com");

        WebElement ageInput = driver.findElement(By.id("age"));
        ageInput.sendKeys("30");

        WebElement salaryInput = driver.findElement(By.id("salary"));
        salaryInput.sendKeys("50000");

        WebElement departmentInput = driver.findElement(By.id("department"));
        departmentInput.sendKeys("IT");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='rt-tbody']/div"));
        WebElement lastRow = rows.get(rows.size() - 1);
        List<WebElement> cells = lastRow.findElements(By.xpath(".//div"));

        WebElement editButton = cells.get(cells.size() - 1).findElement(By.xpath(".//span[@title='Edit']"));
        editButton.click();

        WebElement editedFirstNameInput = driver.findElement(By.id("firstName"));
        editedFirstNameInput.clear();
        editedFirstNameInput.sendKeys("Jane");

        WebElement saveButton = driver.findElement(By.id("submit"));
        saveButton.click();

        WebElement editedRow = rows.get(rows.size() - 1);
        List<WebElement> editedCells = editedRow.findElements(By.xpath(".//div"));

        String editedFirstName = editedCells.get(0).getText();
        assert editedFirstName.equals("Jane");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}