package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import utilities.Base;

public class Hooks {
    WebDriver webDriver = Base.getWebDriver();

    @Before
    public void scenarioBefore() {
        webDriver = Base.initializeWebDriver();
    }

    @After
    public void scenarioAfter() {
        if (webDriver != null)
            webDriver.quit();
    }
}
