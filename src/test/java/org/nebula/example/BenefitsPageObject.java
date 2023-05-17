package org.nebula.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BenefitsPageObject extends BasePageObject {
    @FindBy(css = "div#benefits>div>h2")
    private WebElement benefitsHeader;

    public BenefitsPageObject(WebDriver driver) {
        super(driver);
    }

    public WebElement getBenefitsHeader() {
        return benefitsHeader;
    }

}
