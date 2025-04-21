package com.juaracoding.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeManager {
    public static WebDriver buildDriver (){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //options.addArguments("--headless");
        options.setBinary("C:\\chrome-win64\\chrome.exe");
        return new ChromeDriver(options);
    }
}

