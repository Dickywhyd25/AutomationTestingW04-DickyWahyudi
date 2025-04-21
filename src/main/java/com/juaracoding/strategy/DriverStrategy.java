package com.juaracoding.strategy;

import com.juaracoding.manager.ChromeManager;
import com.juaracoding.manager.FirefoxManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;

public class DriverStrategy {
    public static WebDriver setStrategy(String browser) {
        if (browser.equals(Browser.CHROME)) {
            return ChromeManager.buildDriver();
        } else if (browser.equals(Browser.FIREFOX)) {
            return FirefoxManager.buildDriver();
        } else {
            return ChromeManager.buildDriver();
        }
    }
}

