package com.framework.pages;

import com.framework.managers.FileReadManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public String getHeaderText() {
        return this.driver.findElement(By.cssSelector(".main-header")).getText();
    }

    public WebElement getMenuItem(String title) {
        return this.driver.findElement(By.xpath(String.format("//ul[@class='menu-list']//span[contains(text(), '%s')]", title)));
    }

    public WebElement getCardItem(String title) {
        return this.driver.findElement(By.xpath(String.format("//h5[contains(text(), '%s')]", title)));
    }
}
