package org.nebula.example.pageObjects;

/**
 * Insights page
 * @author isendyk
 */
public class InsightsPageObject {
    //To keep things simple, as I'm not planning to test this page, adding only getter
    private static final String url = "https://nebula.io/insights/";

    public static String getBaseUrl() {
        return url;
    }
}
