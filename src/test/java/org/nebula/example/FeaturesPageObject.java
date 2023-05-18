package org.nebula.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FeaturesPageObject extends BasePageObject {


    @FindBy(css = "div#features>div.fixed-nav__positioning.active")
    private WebElement divFeatures;

    public FeaturesPageObject(WebDriver driver) {
        super(driver);
    }

    public void validateItemActive() {
        validateItemActive(divFeatures);
    }

}
