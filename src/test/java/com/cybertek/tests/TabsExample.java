package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TabsExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/windows");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void cleanUp() {
        try { Thread.sleep(3000); } catch (Exception ex) { }
        driver.quit();
    }

    @Test
    public void changeTab() {
//        System.out.println(driver.getWindowHandles().size());
//        System.out.println(driver.getWindowHandle());
        driver.findElement(By.linkText("Click Here")).click();
//        System.out.println(driver.getWindowHandles().size());
//
//        System.out.println("***+++===+++***");
//
//        Set<String> windowHandles = driver.getWindowHandles();
//        for (String handle : windowHandles) {
//            System.out.println(handle);
//
//            driver.switchTo().window(handle);
//            System.out.println(driver.getTitle());
//        }
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (driver.getTitle().equals("New Window"))
                break;
            else
                driver.switchTo().window(handle);
        }

        Assert.assertEquals(driver.getTitle(), "New Window");
    }

    /**
     * Go to https://www.w3schools.com/html/
     * click on Try it Yourself
     * verify the url of the new tab contains "default"
     */

    @Test
    public void changeTab2() {
        driver.get("https://www.w3schools.com/html/");

        driver.findElement(By.partialLinkText("Try it Yourself")).click();

        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles)
            if (driver.getCurrentUrl().contains("html_default"))
                break;
            else
                driver.switchTo().window(handle);

        Assert.assertTrue(driver.getCurrentUrl().contains("html_default"));
    }
}
