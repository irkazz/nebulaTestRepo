package org.nebula.example;

public class CalendlyRequestDemoPageObject {
    //To keep things simple, as I'm not planning to test this page, adding only getter
    private static final String url = "https://calendly.com/gareth-nebula/30min";

    public static String getBaseUrl() {
        return url;
    }
}
