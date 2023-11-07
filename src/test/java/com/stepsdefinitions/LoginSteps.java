package com.stepsdefinitions;

import com.base.BaseUtil;
import com.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.config.Configuration;
import dev.failsafe.internal.util.Assert;

import java.io.IOException;

import static org.junit.Assert.assertTrue;


public class LoginSteps extends BaseUtil {

    private BaseUtil base;
    public LoginPage lp;
    public Configuration cf;

    public LoginSteps(BaseUtil base) {
        this.base = base;
    }


    @When("Enter name and surname")
        public void Enter_name_and_surname () throws IOException {
            lp = new LoginPage(base.getDriver());
            lp.EnterFullName();
        }

    @When("Select a city")
        public void select_a_city() throws IOException {
            lp = new LoginPage(base.getDriver());
            lp.SelectCity();
    }
    @When("Enter email")
    public void enter_email() throws IOException {
        lp = new LoginPage(base.getDriver());
        lp.Enter_Email();
    }
    @When("Enter phone number")
    public void enter_phone_number() throws IOException {
        lp = new LoginPage(base.getDriver());
        lp.Enter_Email();
    }

    @When("Submit form")
    public void submit_form() throws IOException {
        lp = new LoginPage(base.getDriver());
        lp.Submit();
    }

    @Then("Form should be submitted")
    public void form_should_be_submitted() throws IOException {
        lp = new LoginPage(base.getDriver());
        assertTrue(lp.Get_Message().contains("Merci pour vos informations !"));
    }
}
