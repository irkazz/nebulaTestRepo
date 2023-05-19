package org.nebula.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * HeroContent section of nebula.io home page
 * @author isendyk
 */
public class HeroContentPageObject extends BasePageObject {
    @FindBy(css = "div.hero__cta-wrap.sm-element.sm-element--d3.sm-visible>a:nth-child(1)")
    private WebElement demoButton;
    @FindBy(css = "div.hero__cta-wrap.sm-element.sm-element--d3.sm-visible>a:nth-child(2)")
    private WebElement tryItButton;

    public HeroContentPageObject(WebDriver driver) {
        super(driver);
    }

    // Not using it now, might need later
    public void clickDemoButton() {
        demoButton.click();
    }

    public void clickTryItButton() {
        tryItButton.click();
    }

}
