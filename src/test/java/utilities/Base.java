package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base {
    protected static ThreadLocal<WebDriver> threadLocalWebDriver = new ThreadLocal<>();

    public static synchronized WebDriver getWebDriver() {
        return threadLocalWebDriver.get();
    }

    public static WebDriver initializeWebDriver() {
        WebDriver webDriver = null;
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        WebDriverManager.firefoxdriver().setup();
        threadLocalWebDriver.set(new FirefoxDriver(firefoxOptions));

        webDriver = getWebDriver();

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return webDriver;
    }
}
