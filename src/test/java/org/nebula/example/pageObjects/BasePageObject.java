package org.nebula.example.pageObjects;

import org.nebula.example.utils.PageTestingUtil;
import org.openqa.selenium.WebDriver;

/**
 * Base class for page objects
 * @author isendyk
 */
public class BasePageObject {

    private final WebDriver driver;

    private PageTestingUtil util = null;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public PageTestingUtil getUtil() {
        if (this.util == null) {
            this.util = new PageTestingUtil(driver);
        }
        return this.util;
    }
}
