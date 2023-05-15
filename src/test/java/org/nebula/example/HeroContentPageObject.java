package org.nebula.example;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.Matchers.*;

public class HeroContentPageObject {
    private final WebDriver driver;

    private final BaseTestingUtil util;
    @FindBy(css = "div.hero__cta-wrap.sm-element.sm-element--d3.sm-visible>a:nth-child(1)")
    private WebElement demoButton;
    @FindBy(css = "div.hero__cta-wrap.sm-element.sm-element--d3.sm-visible>a:nth-child(2)")
    private WebElement tryItButton;

    public HeroContentPageObject(WebDriver driver) {
        this.driver = driver;
        this.util = new BaseTestingUtil(driver);
    }

    public WebElement getDemoButton() {
        return demoButton;
    }

    public WebElement getTryItButton() {
        return tryItButton;
    }

    /**
     * Validate that left Demo button opens a new tab.
     */
    public void validateLeftDemoButton() {
        demoButton.click();
        //Switch to the newly opened tab and check URL
        util.switchToNewTab(2, 1);
        Assert.assertThat(driver.getCurrentUrl(), containsString(CalendlyRequestDemoPageObject.getBaseUrl()));
    }

    public void validateTryItButton() {
        tryItButton.click();
        //Switch to the newly opened tab and check URL
        util.switchToNewTab(2, 1);
        Assert.assertThat(driver.getCurrentUrl(), is(equalTo(RunAMatchPageObject.getBaseUrl())));
    }
}
