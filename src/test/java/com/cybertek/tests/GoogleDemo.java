package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

/*
   open Chrome
   go to Google
   search for "selenium cookbook"
   verify title contains the search term
 */
public class GoogleDemo extends TestBase {
    @Test
    public void titleTest() {
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("selenium cookbook" + Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains("selenium cookbook"));
    }
}
