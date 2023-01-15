package com.framework.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
        glue = {"com.framework.steps", "com.framework.runners"},
        plugin = {"pretty", "html:target/cucumber-reports.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
