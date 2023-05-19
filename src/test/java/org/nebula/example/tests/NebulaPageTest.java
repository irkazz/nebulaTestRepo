package org.nebula.example.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.nebula.example.pageObjects.*;
import org.nebula.example.utils.BrowserType;
import org.nebula.example.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;

/**
 * nebula.io home page tests
 * @author isendyk
 */
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
        npo.getHeroContentPO().clickDemoButton();
        npo.getUtil().validateNewTabNabNavigation(CalendlyRequestDemoPageObject.getBaseUrl(), 2, 1);
    }

    /**
     * Validate left component "Try it for free" link leads to the right page
     */
    @Test
    public void LeftComponentTryItTest() {
        npo.getHeroContentPO().clickTryItButton();
        npo.getUtil().validateNewTabNabNavigation(RunAMatchPageObject.getBaseUrl(), 2, 1);
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
        npo.getHeaderPO().clickFeaturesItem();
        Assert.assertTrue("Features section not visible", npo.getFeaturesPO().isPageVisible());
        npo.getHeaderPO().clickBenefitsItem();
        Assert.assertTrue("Benefits section not visible", npo.getBenefitsPO().isPageVisible());
        npo.getHeaderPO().clickAboutItem();
        Assert.assertTrue("Benefits section not visible", npo.getAboutPO().isPageVisible());
        npo.getHeaderPO().clickInsightsItem();
        npo.getUtil().validateNewTabNabNavigation(InsightsPageObject.getBaseUrl(), 1, 0);
    }

    /**
     * Validate that Request Demo button opens Calendly page
     */
    @Test
    public void headerRequestDemoTest() {
        npo.getHeaderPO().clickRequestDemo();
        npo.getUtil().validateNewTabNabNavigation(CalendlyRequestDemoPageObject.getBaseUrl(), 2, 1);
    }

    /**
     * Validate that Login link click opens Login page
     */
    @Test
    public void loginTest() {
        npo.getHeaderPO().clickLogin();
        npo.getUtil().validateNewTabNabNavigation(LoginPageObject.getBaseUrl(), 2, 1);
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
