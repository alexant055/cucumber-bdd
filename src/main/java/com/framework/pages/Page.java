package com.framework.pages;

import com.framework.managers.FileReadManager;
import org.openqa.selenium.WebDriver;

public abstract class Page {
    private final WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public void launchApplication() {
        driver.get(FileReadManager.getInstance().getConfigReader().getApplicationUrl());
    }

    public String getPageTitle() {
        return this.driver.getTitle();
    }
}
