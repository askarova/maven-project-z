package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class EtsyWithSoftAssert extends TestBase {

    @Test
    public void test1() {
//        SoftAssert softAssert = new SoftAssert();
        // added this initiation to TestBase()

        driver.get("https://etsy.com");
        driver.findElement(By.id("search-query")).sendKeys("gift" + Keys.ENTER);

        softAssert.assertTrue(driver.getTitle().contains("gift"));

        Assert.assertTrue(driver.getTitle().contains("AAA"));

//        softAssert.assertAll();
        // added this call to TestBase()
    }
}
