package com.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/**
 * This class is used to create a singleton instance of the webdriver
 */
public class SingletonWebDriver {

    private static WebDriver driver = null;

    private SingletonWebDriver(){

    }

    /**
     * This function creates a singleton instance of the web driver
     * 
     * @returna singleton instance of the browser
     */
    public static WebDriver getWebDriver() {
        if (driver == null) {
            System.out.println("==> OPENING THE SINGLETON CHROME BROWSER");
            HashMap<String, Object> chromePref = new HashMap<String, Object>();
            LoggingPreferences loggingPrefs = new LoggingPreferences();
            loggingPrefs.enable(LogType.BROWSER, Level.ALL);
            chromePref.put("profile.default_content_settings.popups", 0);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("prefs", chromePref);
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--dns-prefetch-disable");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments(" --disable-extensions");
            // chromeOptions.addArguments("--headless=new");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--window-size=1920x1080");
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
        }
        return driver;
    }

    /**
     * This function sets the driver instance to null
     */
    public static void setWebDriverNull() {
        driver = null;
    }

    /**
     * This function closed the driver instance
     */
    public static void closeWebDriver() {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            driver.close();
        }
        driver.quit();
        driver = null;
    }
}
