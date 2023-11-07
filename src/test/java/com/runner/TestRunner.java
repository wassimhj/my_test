package com.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/Features" }, glue = { "com.stepsdefinitions", "com.hooks" }, plugin = {
        "pretty", "html:src/test/reports", "json:target/cucumber.json"
         }, tags = { "@Stable" })
public class TestRunner {
}
