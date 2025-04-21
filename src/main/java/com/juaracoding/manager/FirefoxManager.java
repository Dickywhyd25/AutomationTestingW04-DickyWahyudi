package com.juaracoding.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxManager {
    public static WebDriver buildDriver (){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        // options.addArguments("--headless");
        return new FirefoxDriver(options);
    }
}
