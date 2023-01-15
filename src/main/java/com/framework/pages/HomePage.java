package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Page {
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getHomePageTitle() {
        return getPageTitle();
    }

    public void clickCard(String cardName) {
        getCardItem(cardName).click();
    }
}
