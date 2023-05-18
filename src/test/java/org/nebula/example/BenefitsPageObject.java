package org.nebula.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BenefitsPageObject extends BasePageObject {
    @FindBy(css = "div#benefits>div>h2.sm-visible")
    private WebElement benefitsHeader;

    public BenefitsPageObject(WebDriver driver) {
        super(driver);
    }

    public void validateItemActive() {
        validateItemActive(benefitsHeader);
    }

}
