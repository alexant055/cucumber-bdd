package com.framework.runners;

import com.framework.managers.LoggerManager;
import com.framework.managers.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;

public class Hooks {
    TestContext testContext;
    Logger logger = LoggerManager.getLogger(Hooks.class);

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void setup(Scenario scenario) {
        logger.info(String.format("Started: %s", scenario.getName()));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (!scenario.isFailed())
            logger.info(String.format("Passed: %s", scenario.getName()));
        else
            logger.error(String.format("Failed: %s", scenario.getName()));
        testContext.getWebDriverController().closeDriver();
    }
}
