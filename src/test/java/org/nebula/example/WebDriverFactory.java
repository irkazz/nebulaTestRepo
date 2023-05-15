package org.nebula.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    WebDriver driver;

    public WebDriver createWD(BrowserType browser) {
        if (browser == BrowserType.CHROME) {
            System.setProperty("webdriver.chrome.driver", browser.getPath());
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            return new ChromeDriver(options);
        }
        throw new IllegalArgumentException();
    }
}
