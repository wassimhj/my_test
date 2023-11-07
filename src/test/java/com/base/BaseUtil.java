package com.base;

import java.io.File;
import java.util.Set;

import javax.imageio.ImageIO;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Constants;
import com.util.SingletonWebDriver;
import com.util.WebDriverFactory;

import cucumber.api.Scenario;


public class BaseUtil {
    
    public WebDriver driver;
    private WebDriverWait wait;
    
    public WebDriver getDriver(){
        return driver;
    }

    public void openBrowser(){
        WebDriverFactory factory = new WebDriverFactory();
        driver = factory.createInstance();
    }

    public void openSingleBrowser(){
        driver = SingletonWebDriver.getWebDriver();
    }

     public void Navigate(){
         System.setProperty("app.url", "https://www.amazon.com/");
        getDriver().navigate().to(System.getProperty("app.url"));
    }


    public void closeBrowser() {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            driver.close();
        }
        driver.quit();
        driver = null;
    }

    public void closeSingleBrowser(){
        SingletonWebDriver.closeWebDriver();
    }

    public void takeScreenshot(String scenarioName){
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

        try {

            ImageIO.write(screenshot.getImage(), "PNG", new File(Constants.SCREENSHOTS_PATH + "\\" + scenarioName + ".png"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("scroll(0,0)");
        }
    }

    public void embedScreenShot(Scenario scenario){
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot,"image/png");
    }


}
