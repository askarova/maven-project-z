package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    public WebDriver driver;
    public SoftAssert softAssert;
    public Actions actions;




    @BeforeMethod
    public void setUpMethod() {
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);
        actions = new Actions(driver);
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDownMethod() {
        Driver.closeDriver();
        softAssert.assertAll();
    }
}
