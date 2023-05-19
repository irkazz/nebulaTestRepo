package org.nebula.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * "Features" section of nebula.io home page
 * @author isendyk
 */
public class FeaturesPageObject extends BasePageObject {
    @FindBy(css = "div#features>div.fixed-nav__positioning.active")
    private WebElement divFeatures;

    public FeaturesPageObject(WebDriver driver) {
        super(driver);
    }

    public boolean isPageVisible() {
        return getUtil().isPageVisible(divFeatures);
    }
}
