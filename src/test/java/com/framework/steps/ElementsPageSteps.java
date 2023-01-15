package com.framework.steps;

import com.framework.managers.LoggerManager;
import com.framework.managers.TestContext;
import com.framework.pages.ElementsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class ElementsPageSteps {
    TestContext testContext;
    ElementsPage elementsPage;
    Logger logger = LoggerManager.getLogger(HomePageSteps.class);

    public ElementsPageSteps(TestContext context) {
        testContext = context;
        elementsPage = testContext.getPageObjectManager().getElementsPage();
    }

    @Then("verify header as {string}")
    public void verifyHeaderAs(String header) {
        Assert.assertEquals(header, elementsPage.getHeaderText());
    }

    @When("{string} menu clicked on Elements list")
    public void menuClickedOnElementsList(String menuItem) {
        elementsPage.clickMenuItem(menuItem);
    }
}
