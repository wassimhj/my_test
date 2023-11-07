package com.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class Commons {
    public static void EnterCredentials(String credential, String c_box_xpath, WebDriver driver){
        driver.findElement(By.xpath(c_box_xpath)).sendKeys(credential);
    }

    public static void ImplicitWait(long time,WebDriver driver){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }


}
