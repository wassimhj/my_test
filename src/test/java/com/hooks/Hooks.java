package com.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.base.BaseUtil;
import com.util.WebDriverFactory;

/**
 * This class is used to define hooks used in the application
 */
public class Hooks extends BaseUtil {

    private BaseUtil base;
    private long startTime;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public Hooks(BaseUtil base) {
        this.base = base;
    }

    /**
     * This tag is executed before every scenario
     * and opens a new browser if singleton browser is not specified for the scenario
     * @param scenario It takes the scenario as a paramater, it is passed automatically during runtime
     */
    @Before
    public void initializeTest(Scenario scenario){

        startTime = System.currentTimeMillis();
        System.out.println("Test started at: " + sdf.format(new Date(startTime)));
        base.openBrowser();

        System.out.println("==> Executing Scenario: " + scenario.getName());
    }

    /**
     * This named tag opens a singleton instance of the browser
     */
    @Before("@SingleBrowser")
    public void openSingleBrowser(){
        base.openSingleBrowser();
       
    }

    /**
     * This tag executes after every scenario, it closes the opened browser
     * It takes screenshots of the scenario has failed
     * @param scenario It takes the scenario as a paramater, it is passed automatically during runtime
     */
    @After
    public void tearDown(Scenario scenario){
        long endTime = System.currentTimeMillis();
        System.out.println("Test ended at: " + sdf.format(new Date(endTime)));
        if(scenario.isFailed()){
            //Take screenshot
            base.takeScreenshot(scenario.getName().replace('/', '-').replace('"', ' '));
            base.embedScreenShot(scenario);
            
        }
        
        else if (!scenario.getSourceTagNames().contains("@SingleBrowser")) {
            base.closeBrowser();
        }
    }

    /**
     * This tag closes the singleton browser and takes screenshots if the scenario fails
     * @param scenario It takes the scenario as a paramater, it is passed automatically during runtime
     */
    @After("@CloseSingleBrowser")
    public void closeSingleBrowser(Scenario scenario){
        if(scenario.isFailed()){
            //Take screenshot
            base.takeScreenshot(scenario.getName().replace('/', '-').replace('"', ' '));
            base.embedScreenShot(scenario);

        }

        base.closeSingleBrowser();
    }

}