package com.juaracoding.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static int testCount = 0;
    public static void delay(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
        public static String getScreenshot(WebDriver driver, String screenshotName, boolean isFailed) throws IOException {
            String dateName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String folderName = "PassedTestScreenshot";
            if (isFailed) {
                folderName = "FailedTestScreenshot";
            }
            String pathDestination = System.getProperty("user.dir") + "/" + folderName + "/"
                    + screenshotName + "_" + dateName + ".png";
            File destination = new File(pathDestination);
            FileUtils.copyFile(source, destination);
            return pathDestination;
        }
    }


