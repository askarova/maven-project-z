package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest extends TestBase {
    @Test
    public void test1() {
        driver.get("https://amazon.com");

        // the code below is moved to TestBase class
//        Actions actions = new Actions(driver);

        WebElement signIn = driver.findElement(By.xpath("//span[.='Hello. Sign in']"));

        // the action below, will hover over the mouse on top of the element specified
        actions.moveToElement(signIn).perform();

        driver.findElement(By.xpath("//span[.='Your Hearts']")).click();

        Assert.assertTrue(driver.getTitle().contains("Interesting"));
    }

    @Test
    public void test2() {
        driver.get("https://amazon.com");

        WebElement helpLink = driver.findElement(By.xpath("(//a[.='Help'])[2]"));

        actions.moveToElement(helpLink).perform();

        try { Thread.sleep(3000); } catch (Exception e) { }
    }
}
