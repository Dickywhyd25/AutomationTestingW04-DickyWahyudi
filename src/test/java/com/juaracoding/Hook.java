package com.juaracoding;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class Hook {

    @BeforeSuite
    @Parameters({ "browser" })
    public void setup(String browser) {
        System.out.println(browser);
        DriverSingleton.setDriver(browser);
    }

    @AfterSuite
    public void tearDown() {
        DriverSingleton.exit();
    }
}

