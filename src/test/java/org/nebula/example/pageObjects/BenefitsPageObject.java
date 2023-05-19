package org.nebula.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * "Benefits" section of nebula.io home page
 * @author isendyk
 */
public class BenefitsPageObject extends BasePageObject {
    @FindBy(css = "div#benefits>div>h2.sm-visible")
    private WebElement benefitsHeader;

    public BenefitsPageObject(WebDriver driver) {
        super(driver);
    }

    public boolean isPageVisible() {
        return getUtil().isPageVisible(benefitsHeader);
    }

}
