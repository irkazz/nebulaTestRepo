package org.nebula.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutPageObject extends BasePageObject {
    @FindBy(css = "div#about>div>h2")
    private WebElement leadershipTeamHeader;

    public AboutPageObject(WebDriver driver) {
        super(driver);
    }

    public WebElement getLeadershipTeamHeader() {
        return leadershipTeamHeader;
    }

}
