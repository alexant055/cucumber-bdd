package com.framework.managers;

import com.framework.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private final WebDriver driver;
    private HomePage homePage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return homePage = (homePage == null) ? new HomePage(driver) : homePage;
    }
}
