package com.cybertek.homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Sports {
    WebDriver driver;
    WebElement baseball;
    WebElement basketball;
    WebElement football;
    WebElement hockey;
    WebElement soccer;
    WebElement waterPolo;
    List<WebElement> allSports;

    /**
     * SPORTS
     * 1.open browser
     * 2.go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton
     * 3.verify that Football is selected by default
     *      and all others are not selected.
     * 4.Select a random sport
     * 5.Verify that all other options are not selected
     */

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton");
    }
    @AfterClass
    public void quitWindows() {
        try { Thread.sleep(3000); } catch (Exception ex) { }
        driver.quit();
    }

    @BeforeMethod
    public void gatherSelectedInfo() {
        baseball = driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Baseball-input"));
        basketball = driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Basketball-input"));
        football = driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Football-input"));
        hockey = driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Hockey-input"));
        soccer = driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Soccer-input"));
        waterPolo = driver.findElement(By.id("gwt-debug-cwRadioButton-sport-WaterPolo-input"));

        allSports = new ArrayList<>();
        allSports.add(baseball);
        allSports.add(basketball);
        allSports.add(football);
        allSports.add(hockey);
        allSports.add(soccer);
        allSports.add(waterPolo);
    }

    @Test (priority = 1)
    public void footballSelected() {
        Assert.assertTrue(football.isSelected());

        allSports.remove(football);
        for (WebElement each : allSports)
            Assert.assertFalse(each.isSelected());
    }

    @Test (priority = 2)
    public void selectRandomAndVerifyOthersNotSelected() {
        int randomIndex = (int) (Math.random() * 6);

        WebElement randomSport = allSports.get(randomIndex);
        randomSport.click();
        Assert.assertTrue(randomSport.isSelected());

        allSports.remove(randomIndex);
        for (WebElement each : allSports)
            Assert.assertFalse(each.isSelected());
    }
}
