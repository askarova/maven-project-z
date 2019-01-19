package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class GoogleTestWithAnnotations {
    WebDriver driver;

    @BeforeClass
    public void initiateDrivers() {
        System.out.println("Setting up drivers here");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void openBrowser() {
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);
    }

    @Test
    public void testOne() {
        Assert.assertTrue(driver.getTitle().contains("Google"));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
