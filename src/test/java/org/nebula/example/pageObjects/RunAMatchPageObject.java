package org.nebula.example.pageObjects;

/**
 * Run a Match page
 * @author isendyk
 */
public class RunAMatchPageObject {
    //To keep things simple, as I'm not planning to test this page, adding only getter
    private static final String url = "https://nebula.io/run-a-match/";

    public static String getBaseUrl() {
        return url;
    }
}
