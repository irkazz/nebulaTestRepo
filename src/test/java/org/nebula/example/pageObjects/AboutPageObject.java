package org.nebula.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * "About" section of nebula.io home page
 * @author isendyk
 */
public class AboutPageObject extends BasePageObject {
    @FindBy(css = "div#about>div>h2.sm-visible")
    private WebElement leadershipTeamHeader;

    public AboutPageObject(WebDriver driver) {
        super(driver);
    }

    public boolean isPageVisible() {
        return getUtil().isPageVisible(leadershipTeamHeader);
    }

}
