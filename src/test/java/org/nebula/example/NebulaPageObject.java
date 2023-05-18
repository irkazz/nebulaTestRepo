package org.nebula.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NebulaPageObject extends BasePageObject {
    private final String url = "https://nebula.io/";

    private final HeroContentPageObject heroContentPO;

    private final HeaderPageObject headerPO;


    private final FeaturesPageObject featuresPO;
    private final AboutPageObject aboutPO;
    private final BenefitsPageObject benefitsPO;

    private final BaseTestingUtil util;

    public NebulaPageObject(WebDriver driver) {
        super(driver);
        heroContentPO = new HeroContentPageObject(driver);
        headerPO = new HeaderPageObject(driver);
        featuresPO = new FeaturesPageObject(driver);
        aboutPO = new AboutPageObject(driver);
        benefitsPO = new BenefitsPageObject(driver);
        util = new BaseTestingUtil(driver);
    }

    public void initPage() {
        PageFactory.initElements(getDriver(), heroContentPO);
        PageFactory.initElements(getDriver(), headerPO);
        PageFactory.initElements(getDriver(), featuresPO);
        PageFactory.initElements(getDriver(), benefitsPO);
        PageFactory.initElements(getDriver(), aboutPO);
    }

    public void openPage() {
        getDriver().get(url);
    }

    public HeroContentPageObject getHeroContentPO() {
        return heroContentPO;
    }

    public HeaderPageObject getHeaderPO() {
        return headerPO;
    }

    public FeaturesPageObject getFeaturesPO() {
        return featuresPO;
    }

    public AboutPageObject getAboutPO() {
        return aboutPO;
    }

    public BenefitsPageObject getBenefitsPO() {
        return benefitsPO;
    }

    /****************************************************************
     *************************** test helpers ***********************
     ****************************************************************/

    public void validateLeftDemoButton() {
        heroContentPO.clickDemoButton();
        validateNewTabNabNavigation(CalendlyRequestDemoPageObject.getBaseUrl(), 2, 1);
    }

    public void validateTryItButton() {
        heroContentPO.clickTryItButton();
        validateNewTabNabNavigation(RunAMatchPageObject.getBaseUrl(), 2, 1);
    }

    public void validateTopNavigation() {
        headerPO.clickFeaturesItem();
        featuresPO.validateItemActive();
        headerPO.clickBenefitsItem();
        benefitsPO.validateItemActive();
        headerPO.clickAboutItem();
        aboutPO.validateItemActive();
        headerPO.clickInsightsItem();
        validateNewTabNabNavigation(InsightsPageObject.getBaseUrl(), 1, 0);
    }

    public void validateLogin() {
        headerPO.clickLogin();
        validateNewTabNabNavigation(LoginPageObject.getBaseUrl(), 2, 1);
    }

    public void validateHeaderRequestDemo() {
        headerPO.clickRequestDemo();
        validateNewTabNabNavigation(CalendlyRequestDemoPageObject.getBaseUrl(), 2, 1);
    }

}
