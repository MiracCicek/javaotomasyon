package org.example;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MainTest {

    @BeforeAll
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:/Users/Mirac.Cicek/chromedriver.exe");


        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Test
    public void testButtonClick() {

        open("https://demoqa.com/elements");
         $("#item-4").click();
         $(byText("Click Me")).click();
         String message = $("#dynamicClickMessage").text();

        System.out.println("1. Test: " + message);
    }

    @Test
    public void testAddAndEditRecord() {
        open("https://demoqa.com/webtables");
        $(byText("Add")).click();
        $("#firstName").setValue("Miraç");
        $("#lastName").setValue("Çiçek");
        $("#userEmail").setValue("mirac.cicek@example.com");
        $("#age").setValue("30");
        $("#salary").setValue("5000");
        $("#department").setValue("Engineering");
        $(byText("Submit")).click();
    }
}