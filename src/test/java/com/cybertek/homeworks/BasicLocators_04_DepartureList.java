package com.cybertek.homeworks;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class BasicLocators_04_DepartureList {
    WebDriver driver;
    Select departingFrom;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(51, TimeUnit.SECONDS);

        driver.get("http://www.newtours.demoaut.com/");
        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("tutorial" + Keys.TAB + "tutorial" + Keys.ENTER);

        departingFrom = new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
    }
    @AfterClass
    public void quitWindows() {
        try { Thread.sleep(3000); } catch (Exception ex) { }
        driver.quit();
    }

    /**
     * Mercury Tours departure list
     * 1.Open browser
     * 2.Go to http://www.newtours.demoaut.com/
     * 3.Login using username tutorial and password tutorial
     * 4.Verify default Departing From value is Acapulco
     * 5.Verify list of locations: Acapulco, Frankfurt, London,
     *      New York, Paris, Portland, San Francisco, Seattle,
     *      Sydney, Zurich
     *  6.Test Departing From dropdown functionality by changing
     *      different values
     */
    @Test (priority = 1)
    public void defaultDepartingFrom() {
        String defaultDeparture = departingFrom.getFirstSelectedOption().getText();
        Assert.assertEquals(defaultDeparture, "Acapulco");
    }

    @Test (priority = 2)
    public void departingListDestinations() {
        List<WebElement> options = departingFrom.getOptions();

        String[] givenOptions = new String[options.size()];
        for (int i = 0; i < givenOptions.length; i++)
            givenOptions[i] = options.get(i).getText();

        String[] actualOptions = {"Acapulco", "Frankfurt", "London", "New York", "Paris", "Portland", "San Francisco", "Seattle", "Sydney", "Zurich"};

        for (int i = 0; i < actualOptions.length; i++)
            Assert.assertEquals(givenOptions[i], actualOptions[i]);
    }

    @Test (priority = 3)
    public void changeDepartingCity() {
        departingFrom.selectByValue("Seattle");

        String currentCity = departingFrom.getFirstSelectedOption().getText();

        Assert.assertEquals(currentCity, "Seattle");
    }
}
