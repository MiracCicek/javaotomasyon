package stepdefinitions;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import org.junit.jupiter.api.BeforeAll;

public class DemoQATestSteps {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Given("I am on the elements page")
    public void navigateToElementsPage() {
        open("https://demoqa.com/elements");
    }

    @When("I click the {string} option")
    public void clickOption(String option) {
        $(byText(option)).click();
    }

    @When("I click the {string} button")
    public void clickButton(String buttonText) {
        $(byText(buttonText)).click();
    }

    @Then("I read the message")
    public void readMessage() {
        String message = $("#dynamicClickMessage").text();
        System.out.println("1. Test: " + message);
    }

    @Given("I am on the webtables page")
    public void navigateToWebtablesPage() {
        open("https://demoqa.com/webtables");
    }

    @When("I click the {string} button")
    public void clickAddButton(String buttonText) {
        $(byText(buttonText)).click();
    }

    @When("I fill in the form with valid data")
    public void fillInForm() {
        $("#firstName").setValue("Miraç");
        $("#lastName").setValue("Çiçek");
        $("#userEmail").setValue("mirac.cicek@example.com");
        $("#age").setValue("30");
        $("#salary").setValue("5000");
        $("#department").setValue("Engineering");
    }

    @When("I submit the form")
    public void submitForm() {
        $(byText("Submit")).click();
    }

    @Then("the record should be added successfully")
    public void verifyRecordAdded() {
        // Burada eklenen kaydı doğrulama adımları eklenebilir.
    }
}