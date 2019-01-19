package com.cybertek.homeworks;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BasicLocators_03_RadioButtonFunctionality {
    WebDriver driver;
    WebElement roundTripButton, oneWayButton;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);

        driver.get("http://www.newtours.demoaut.com/");
        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("tutorial" + Keys.TAB + "tutorial" + Keys.ENTER);

        roundTripButton = driver.findElement(By.xpath("//input[@value='roundtrip']"));
        oneWayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
    }
    @AfterClass
    public void cleanUp() {
        try { Thread.sleep(3000); } catch (Exception e) { }
        driver.quit();
    }
    /**
     * Mercury Tours radio button functionality
     * 1.Open browser
     * 2.Go to http://www.newtours.demoaut.com/
     * 3.Login using username tutorial and password tutorial
     * 4.Verify Round Trip is selected by default
     * 5.Verify One Way is not selected by default
     * 6.Click one way
     * 7.Verify Round Trip selected not selected
     * 8.VerifyOne Way is selected
     */
    @Test
    public void verifyCases4_5() {
        Assert.assertTrue(roundTripButton.isSelected());
        Assert.assertFalse(oneWayButton.isSelected());
    }

    @Test (dependsOnMethods = "verifyCases4_5")
    public void verifyCases6_7_8() {
        oneWayButton.click();
        Assert.assertFalse(roundTripButton.isSelected());
        Assert.assertTrue(oneWayButton.isSelected());
    }
}
