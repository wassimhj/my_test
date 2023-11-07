package com.stepsdefinitions;

import com.base.BaseUtil;

import com.pages.LoginPage;
import cucumber.api.java.en.Given;


public class CommonSteps extends BaseUtil {

    private BaseUtil base;

    public CommonSteps(BaseUtil baseUtil) {
        this.base = baseUtil;
    }

    @Given("Navigate to the home page")
    public void navigateToTheHomePage() {
        base.Navigate();
    }

}
