package com.framework.managers;

import com.framework.pages.ElementsPage;
import com.framework.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private final WebDriver driver;
    private HomePage homePage;
    private ElementsPage elementsPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return homePage = (homePage == null) ? new HomePage(driver) : homePage;
    }

    public ElementsPage getElementsPage() {
        return elementsPage = (elementsPage == null) ? new ElementsPage(driver) : elementsPage;
    }
}
