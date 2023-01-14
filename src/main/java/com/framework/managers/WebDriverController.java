package com.framework.managers;

import com.framework.enums.DriverType;
import com.framework.enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

public class WebDriverController {
    private static DriverType driverType;
    private static EnvironmentType environmentType;
    private WebDriver driver;

    public WebDriverController() {
        driverType = FileReadManager.getInstance().getConfigReader().getBrowser();
        environmentType = FileReadManager.getInstance().getConfigReader().getEnvironment();
    }

    public WebDriver getDriver() {
        if (driver == null) driver = createDriver();
        return driver;
    }

    public void closeDriver() {
        // Close the driver
        driver.close();
        driver.quit();
    }

    private WebDriver createDriver() {
        switch (environmentType) {
            case LOCAL:
                driver = createLocalDriver();
                break;
            case REMOTE:
                driver = createRemoteDriver();
                break;
        }

        return driver;
    }

    private WebDriver createLocalDriver() {
        switch (driverType) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case INTERNETEXPLORER:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case CHROME:
                // Set up the wWebDriverManager for chrome driver
                WebDriverManager.chromedriver().setup();
                // Create the driver object
                driver = new ChromeDriver();
                break;
        }

        // reset driver configurations
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        return driver;
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }
}
