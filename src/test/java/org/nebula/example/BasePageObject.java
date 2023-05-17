package org.nebula.example;

import org.openqa.selenium.WebDriver;

public class BasePageObject {

    private final WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
