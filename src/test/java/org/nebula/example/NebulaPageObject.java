package org.nebula.example;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.Matchers.containsString;

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

    protected void validateNewTabNabNavigation(WebElement link, String expectedURL, int expectedTabs,
                                               int newTabIndex) {
        link.click();
        //Switch to the newly opened tab and check URL
        util.switchToNewTab(expectedTabs, newTabIndex);
        Assert.assertThat(getDriver().getCurrentUrl(), containsString(expectedURL));
    }
}
