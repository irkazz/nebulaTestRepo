package org.nebula.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPageObject extends BasePageObject {
    private final BaseTestingUtil util;
    private FeaturesPageObject featurePO;
    @FindBy(css = "ul#menu-main-menu>li:nth-child(1)>a")
    private WebElement featuresItem;

    @FindBy(css = "ul#menu-main-menu>li:nth-child(2)>a")
    private WebElement benefitsItem;

    @FindBy(css = "ul#menu-main-menu>li:nth-child(3)>a")
    private WebElement aboutItem;

    @FindBy(css = "ul#menu-main-menu>li:nth-child(4)>a")
    private WebElement insightsItem;

    @FindBy(css = "a.btn.btn-outline-primary")
    private WebElement requestDemo;


    @FindBy(css = "a.btn.btn-text.mx-0")
    private WebElement login;


    public HeaderPageObject(WebDriver driver) {
        super(driver);
        this.util = new BaseTestingUtil(driver);
    }

    public WebElement getFeaturesItem() {
        return featuresItem;
    }

    public WebElement getBenefitsItem() {
        return benefitsItem;
    }

    public WebElement getAboutItem() {
        return aboutItem;
    }

    public WebElement getInsightsItem() {
        return insightsItem;
    }

    public WebElement getRequestDemo() {
        return requestDemo;
    }

    public WebElement getLogin() {
        return login;
    }

    /**
     * Click on the nav link leading to the main page section
     * and validate element class change
     *
     * @param link
     * @param testElement
     */
    public void validateMenuItemOpensSamePage(WebElement link, WebElement testElement, String activeClassName) {
        WebDriverWait wait = util.getExplicitWait(5);
        link.click();
        wait.until(ExpectedConditions.attributeContains(testElement, "class", activeClassName));
    }

}
