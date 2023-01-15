package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends Page {
    public ElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickMenuItem(String menuItem) {
        getMenuItem(menuItem).click();
    }
}
