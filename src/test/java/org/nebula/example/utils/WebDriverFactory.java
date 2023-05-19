package org.nebula.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
/**
 * WebDriverFactory create web driver based on Browser type
 * @author isendyk
 */
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
