package org.nebula.example.utils;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;

/**
 * Page objects testing util
 * @author isendyk
 */
public class PageTestingUtil {
    private final WebDriver driver;

    public PageTestingUtil(WebDriver driver) {
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

    /**
     * Method to validate link click opens <expectedURL> in the <newTabIndex>
     *
     * @param expectedURL
     * @param expectedTabs
     * @param newTabIndex
     */
    public void validateNewTabNabNavigation(String expectedURL, int expectedTabs,
                                            int newTabIndex) {
        //Switch to the newly opened tab and check URL
        switchToNewTab(expectedTabs, newTabIndex);
        Assert.assertThat(driver.getCurrentUrl(), containsString(expectedURL));
    }

    /**
     * Use this method to validate link leads to the specific place on the page
     * web element class indicates the activation of the element
     */
    public void waitUntilElementVisible(WebElement element) throws Exception {
        WebDriverWait wait = getExplicitWait(5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Use this method to validate link leads to the specific place on the page
     * web element class indicates the activation of the element
     */
    public boolean isPageVisible(WebElement element) {
        try {
            waitUntilElementVisible(element);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
