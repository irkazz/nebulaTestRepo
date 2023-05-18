package org.nebula.example;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.Matchers.containsString;

public class BasePageObject {

    private final WebDriver driver;

    private BaseTestingUtil util = null;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public BaseTestingUtil getUtil() {
        if (this.util == null) {
            this.util = new BaseTestingUtil(driver);
        }
        return this.util;
    }

    /**
     * Method to validate link click opens <expectedURL> in the <newTabIndex>
     * @param expectedURL
     * @param expectedTabs
     * @param newTabIndex
     */
    protected void validateNewTabNabNavigation(String expectedURL, int expectedTabs,
                                               int newTabIndex) {
        //Switch to the newly opened tab and check URL
        util.switchToNewTab(expectedTabs, newTabIndex);
        Assert.assertThat(getDriver().getCurrentUrl(), containsString(expectedURL));
    }

    /**
     * Use this method to validate link leads to the specific place on the page
     * web element class indicates the activation of the element
     */
    public void validateItemActive(WebElement element) {
        WebDriverWait wait = getUtil().getExplicitWait(5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
