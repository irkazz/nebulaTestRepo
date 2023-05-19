package org.nebula.example.utils;

/**
 * Supported browser types
 * @author isendyk
 */
public enum BrowserType {
    CHROME("/C:/Users/irkaz/chromedriver_win32/chromedriver.exe");
    private final String path;

    BrowserType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
