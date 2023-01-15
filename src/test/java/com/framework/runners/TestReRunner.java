package com.framework.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        monochrome = true,
        features = "@target/rerun.txt",
        glue = {"com.framework.steps", "com.framework.runners"},
        plugin = {"pretty", "html:target/cucumber-reports-rerun.html",
                "json:target/cucumber.json"}
)
public class TestReRunner extends AbstractTestNGCucumberTests {

}