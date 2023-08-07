package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import pageObjects.HomePOs;

import utilities.Base;
import utilities.Helpers;

public class HomeStepDef extends Helpers implements HomePOs {
    WebDriver webDriver = Base.getWebDriver();
    List<WebElement> rowEntry;
    String foodGridIDSearched;

    public HomeStepDef() {
    }

    @Given("I opened the url: {}")
    public void openURL(String url) {
        openAndMaximizeBrowser(url);
    }

    @Given("I checked that the Food Grid Table is present")
    public void foodGridTableCheck() {
        Assert.assertTrue("Food Grid Table is missing.", checkIfElementIsExisting(_FOOD_GRID));
    }

    @When("I search for a row entry using the ID: {}")
    public void searchByID(String foodGridID) {
        webDriver.findElement(_COOKIE_MESSAGE_OK_BUTTON).click();

        foodGridIDSearched = foodGridID;

        rowEntry = getRowFromTable(_FOOD_GRID_BASE_ROW(foodGridIDSearched), _FOOD_GRID_PAGES(), _FOOD_GRID_PAGE_SIZE_DROPDOWN(), _FOOD_GRID_PAGE_SIZE_DROPDOWN_CHOICES("100"));
    }

    @Then("I will get the row data for that entry")
    public void displayRowData() {
        if (rowEntry.isEmpty()) {
            System.out.println("No data found for the ID: " + foodGridIDSearched);
        } else {
            System.out.println("Input ID Number: " + foodGridIDSearched);
            System.out.println("Person: " + rowEntry.get(1).getText());
            System.out.println("Food: " + rowEntry.get(2).getText());
            System.out.println("Date: " + rowEntry.get(4).getText());
            System.out.println("Country: " + rowEntry.get(5).getText());
            System.out.println("Meals: " + rowEntry.get(6).getText());
        }
    }
}