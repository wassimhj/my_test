package com.util;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

    private WebDriver driver;

    /**
     * This function creates an instance of the required browser
     * 
     * @return The browser instance
     */
    public WebDriver createInstance() {
        System.out.println("==> OPENING CHROME BROWSER");
        HashMap<String, Object> chromePref = new HashMap<String, Object>();
        LoggingPreferences loggingPrefs = new LoggingPreferences();
        loggingPrefs.enable(LogType.BROWSER, Level.ALL);
        chromePref.put("profile.default_content_settings.popups", 0);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", chromePref);
        chromeOptions.addArguments("--no-sandbox");
        // chromeOptions.addArguments("--headless=new");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--window-size=1920x1080");
        chromeOptions.addArguments("--dns-prefetch-disable");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments(" --disable-extensions");
        chromeOptions.addArguments("--remote-allow-origins=*");
        //chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, loggingPrefs);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        if (driver != null) {
            System.out.println("Chrome instance is open");

        } else {
            System.out.println("Chrome instance is not open");
        }

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        return driver;
    }

}
