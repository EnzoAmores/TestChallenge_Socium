package pageObjects;

import org.openqa.selenium.By;

import utilities.Helpers;

public interface HomePOs {
    By _FOOD_GRID = By.xpath(
            "//h2[text() = 'Grid filter row server data']/parent::div[@class = 'example']/div[@id = 'GridFrow2']");

    default By _FOOD_GRID_BASE_ROW(String foodGridID) {
        return By.xpath(Helpers.getXPathFromLocator(_FOOD_GRID)
                + "//div[contains(@class, 'content')]//tr[@data-k = '" + foodGridID + "']");
    }

    default By _FOOD_GRID_PAGES() {
        return By.xpath(Helpers.getXPathFromLocator(_FOOD_GRID) + "//div[@class = 'awe-pager']//button");
    }
    By _COOKIE_MESSAGE_OK_BUTTON = By.xpath(
            "//div[@id = 'cookieMsg']//button");
}