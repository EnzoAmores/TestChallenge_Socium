package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helpers {
    WebDriver webDriver = Base.getWebDriver();

    public Boolean checkIfElementIsExisting(By locator) {
        var result = false;
        List<WebElement> webElementList;
        webElementList = webDriver.findElements(locator);

        if (!webElementList.isEmpty()) {
            result = true;
        }

        return result;
    }

    public List<WebElement> getRowFromTable(By tableLocator, By pageLocator) {
        List<WebElement> rows = null;
        List<WebElement> pages = null;
        int pageTotalCount = 1;
        int currentPage = 1;

        pages = webDriver.findElements(pageLocator);
        pageTotalCount = Integer.parseInt(pages.get(pages.size() - 1).getText());

        while (rows == null && currentPage < pageTotalCount) {
            webDriver.findElement(By.xpath(getXPathFromLocator(pageLocator) + "[text() = '" + currentPage + "']")).click();

            if (webDriver.findElements(tableLocator).size() > 0) {
                rows = webDriver.findElement(tableLocator).findElements(By.tagName("td"));
            }

            currentPage++;
        }
        
        return rows;
    }

    public static String getXPathFromLocator(By locator) {
        return locator.toString().replace("By.xpath: ", "");
    }

    public void openAndMaximizeBrowser(String url) {
        webDriver.manage().window().maximize();
        webDriver.navigate().to(url);
    }
}