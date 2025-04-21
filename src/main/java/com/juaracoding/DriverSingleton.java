package com.juaracoding;

import com.juaracoding.strategy.DriverStrategy;
import org.openqa.selenium.WebDriver;

public abstract class DriverSingleton {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver not initialized");
        }

        return driver;
    }

    public static void setDriver(String browser) {
        if (driver == null) {
            driver = DriverStrategy.setStrategy(browser);
        }
    }

    public static void exit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
