package com.framework.managers;

public class TestContext {
    private final WebDriverController webDriverController;
    private final PageObjectManager pageObjectManager;

    public TestContext() {
        webDriverController = new WebDriverController();
        pageObjectManager = new PageObjectManager(webDriverController.getDriver());
    }

    public WebDriverController getWebDriverController() {
        return webDriverController;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}
