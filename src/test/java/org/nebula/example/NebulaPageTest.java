package org.nebula.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class NebulaPageTest {
    WebDriverFactory fact = new WebDriverFactory();
    NebulaPageObject npo;

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = fact.createWD(BrowserType.CHROME);
        npo = new NebulaPageObject(driver);
        npo.initPage();
        npo.openPage();
    }

    /**
     * Validate left component "Schedule Demo" link leads to the Calendly page
     */
    @Test
    public void LeftComponentDemoTest() {
        npo.validateLeftDemoButton();
    }

    /**
     * Validate left component "Try it for free" link leads to the right page
     */
    @Test
    public void LeftComponentTryItTest() {
        npo.validateTryItButton();
    }


    /**
     * Validate top navigation panel links go to the right page/ area of the page.
     * Steps:
     * 1. Click on the "Features" link and verify scroll to the "features" area of the page
     * 2. Click on the "Benefits" link and verify scroll to the "benefits" area of the page
     * 3. Click on the "About Us" link and verify scroll to the "about" area of the page
     * 4. Click on the "Insights" link and verify new page opens in the same tab
     */
    @Test
    public void topNavigationTest() {
        npo.validateTopNavigation();
    }

    /**
     * Validate that Request Demo button opens Calendly page
     */
    @Test
    public void headerRequestDemoTest() {
        npo.validateHeaderRequestDemo();
    }

    /**
     * Validate that Login link click opens Login page
     */
    @Test
    public void loginTest() {
        npo.validateLogin();
    }

    /**
     * Close all the tabs
     */
    @After
    public void cleanUp() {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
            driver.close();
        }
    }

}
