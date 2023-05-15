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

    @Test
    public void LeftComponentDemoTest() {
        npo.validateNewTabNabNavigation(npo.getHeroContentPO().getDemoButton(),
                CalendlyRequestDemoPageObject.getBaseUrl(), 2, 1);    }

    @Test
    public void LeftComponentTryItTest() {
        npo.validateNewTabNabNavigation(npo.getHeroContentPO().getTryItButton(),
                RunAMatchPageObject.getBaseUrl(), 2, 1);
    }

    @Test
    public void topNavigationTest() {
        npo.getHeaderPO().validateMenuItemOpensSamePage(
                npo.getHeaderPO().getFeaturesItem(),
                npo.getFeaturesPO().getDivFeatures(),
                "active");
        npo.getHeaderPO().validateMenuItemOpensSamePage(
                npo.getHeaderPO().getBenefitsItem(),
                npo.getBenefitsPO().getBenefitsHeader(),
                "sm-visible");
        npo.getHeaderPO().validateMenuItemOpensSamePage(
                npo.getHeaderPO().getAboutItem(),
                npo.getAboutPO().getLeadershipTeamHeader(),
                "sm-visible");
        npo.validateNewTabNabNavigation(npo.getHeaderPO().getInsightsItem(),
                InsightsPageObject.getBaseUrl(), 1, 0);
    }

    @Test
    public void headerRequestDemoTest() {
        npo.validateNewTabNabNavigation(npo.getHeaderPO().getRequestDemo(),
                CalendlyRequestDemoPageObject.getBaseUrl(), 2, 1);
    }

    /**
     * Validate that Login link click opens Login page
     */
    @Test
    public void loginTest() {
        npo.validateNewTabNabNavigation(npo.getHeaderPO().getRequestDemo(),
                LoginPageObject.getBaseUrl(), 2, 1);
    }

    @After
    public void cleanUp() {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
            driver.close();
        }
    }


    //TopNavigationTest
    //LoginButtonTest
    //RequestDemoTest
}
