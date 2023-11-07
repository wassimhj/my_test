package com.pages;

import com.config.Configuration;
import com.util.Commons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class LoginPage{

    WebDriver driver;
    public Configuration cf;

    /**
     * Here are the objects used on the LoginPage and their Xpaths
     */
    public static String NAME_BOX = "//input[@id='nom']";
    public static String SURNAME_BOX = "//input[@id='prenom']";
    public static String CITY_DROPDOWN = "//select[@id='ville']";
    public static String EMAIL_BOX = "//input[@id='email']";
    public static String PHONE_BOX = "//input[@id='telephone']";
    public static String SUBMIT_BUTTON = "//button[@type='submit']";
    public static String MESSAGE = "//div//p";


    By name_box = By.xpath(NAME_BOX);
    By surname_box = By.xpath(SURNAME_BOX);
    By city_dropdown = By.xpath(CITY_DROPDOWN);
    By email_box = By.xpath(EMAIL_BOX);
    By phone_box = By.xpath(PHONE_BOX);
    By message = By.xpath(MESSAGE);
    By submit_button = By.xpath(SUBMIT_BUTTON);

    /**
     * Here we will find the methods used on the login page
     */

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }


    public void EnterFullName() throws IOException {
        Commons.ImplicitWait(10, driver);
        Commons.EnterCredentials(cf.getProperties("name"),NAME_BOX,driver);
        //System.out.println(cf.getProperties("username"));

        Commons.EnterCredentials(cf.getProperties("surname"),SURNAME_BOX,driver);

    }

    public void SelectCity() throws IOException{
        WebElement c_dropdown = driver.findElement(city_dropdown);
        Select select = new Select(c_dropdown);
        select.selectByValue(cf.getProperties("city"));
    }

    public void Enter_Email() throws IOException {
        Commons.ImplicitWait(10,driver);
        Commons.EnterCredentials(cf.getProperties("mail"),EMAIL_BOX,driver);
    }

    public void Enter_Tel() throws IOException {
        Commons.ImplicitWait(10,driver);
        Commons.EnterCredentials(cf.getProperties("phone number"),PHONE_BOX,driver);
    }

    public void Submit() throws IOException {
        Commons.ImplicitWait(10,driver);
        driver.findElement(submit_button).click();
    }

    public String Get_Message(){
        String m_content = driver.findElement(message).getText();
        return m_content;
    }

}
