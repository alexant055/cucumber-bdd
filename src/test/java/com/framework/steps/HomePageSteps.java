package com.framework.steps;

import com.framework.managers.LoggerManager;
import com.framework.managers.TestContext;
import com.framework.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class HomePageSteps {
    TestContext testContext;
    HomePage homePage;
    Logger logger = LoggerManager.getLogger(HomePageSteps.class);

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Then("verify title as {string}")
    public void verifyTitleAs(String title) {
        logger.info(String.format("Home page title is %s", homePage.getHomePageTitle()));
        Assert.assertEquals(title, homePage.getHomePageTitle());
    }

    @Given("application launched")
    public void applicationLaunched() {
        homePage.launchApplication();
    }

    @When("page loaded")
    public void pageLoaded() {
    }

    @When("{string} card clicked")
    public void cardClicked(String cardName) {
        homePage.clickCard(cardName);
    }
}
