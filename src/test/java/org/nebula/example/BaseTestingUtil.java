package org.nebula.example;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseTestingUtil {
    private final WebDriver driver;

    public BaseTestingUtil(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getBrowserTabs() {
        return new ArrayList<String>(driver.getWindowHandles());
    }

    public WebDriverWait getDefaultExplicitWait() {
        return getExplicitWait(3);
    }

    public WebDriverWait getExplicitWait(long seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    public boolean isElementVisible(WebElement element) {
        return element.isDisplayed();
    }

    /**
     * Switch to the given tab
     *
     * @param expectedTabs - how many tabs expected
     * @param newTabIndex  - tab to switch (index)
     */
    void switchToNewTab(int expectedTabs, int newTabIndex) {
        List<String> browserTabs = getBrowserTabs();
        Assert.assertEquals(expectedTabs, browserTabs.size());
        driver.switchTo().window(browserTabs.get(newTabIndex));
    }

}
