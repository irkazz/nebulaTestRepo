package org.nebula.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Header section of nebula.io home page
 * @author isendyk
 */
public class HeaderPageObject extends BasePageObject {
    private FeaturesPageObject featurePO;

    @FindBy(css = "a[href='#features']")
    private WebElement featuresItem;

    @FindBy(css = "a[href='#benefits']")
    private WebElement benefitsItem;

    @FindBy(css = "a[href='#about']")
    private WebElement aboutItem;

    @FindBy(css = "a[href='https://nebula.io/insights/']")
    private WebElement insightsItem;

    @FindBy(css = "a.btn.btn-outline-primary")
    private WebElement requestDemo;


    @FindBy(css = "a.btn.btn-text.mx-0")
    private WebElement login;


    public HeaderPageObject(WebDriver driver) {
        super(driver);
    }

    public void clickFeaturesItem() {
        featuresItem.click();
    }

    public void clickBenefitsItem() {
        benefitsItem.click();
    }

    public void clickAboutItem() {
        aboutItem.click();
    }

    public void clickInsightsItem() {
        insightsItem.click();
    }

    public void clickRequestDemo() {
        requestDemo.click();
    }

    public void clickLogin() {
        login.click();
    }

}
