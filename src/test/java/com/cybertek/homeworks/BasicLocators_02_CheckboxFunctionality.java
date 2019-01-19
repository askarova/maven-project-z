package com.cybertek.homeworks;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BasicLocators_02_CheckboxFunctionality {
    WebDriver driver;
    WebElement firstCheckbox;
    WebElement secondCheckbox;

    @BeforeClass
    public void setUpDrivers() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);

        driver.get("http://the-internet.herokuapp.com/checkboxes");

        firstCheckbox = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        secondCheckbox = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
    }
    @AfterClass
    public void cleanUpQuitWindows() {
        try{Thread.sleep(3000);}catch (Exception e) {}
        driver.quit();
    }

    /**
     * Verify checkbox functionality
     * 1.Open browser
     * 2.Go to http://the-internet.herokuapp.com/checkboxes
     * 3.Verify the first checkbox is not selected
     * 4.Verify the second checkbox is selected
     * 5.Click on the first checkbox
     * 6.Verify the first checkbox is selected
     * 7.Verify the second checkbox is selected
     * 8.Click on the second checkbox
     * 9.Verify the first checkbox is selected
     * 10.Verify the second checkbox is not selected
     */
    @Test (priority = 1)
    public void verifyCases3_4() {
        try{Thread.sleep(3000);}catch (Exception e) {}
        Assert.assertFalse(firstCheckbox.isSelected());
        Assert.assertTrue(secondCheckbox.isSelected());
    }

    @Test (dependsOnMethods = "verifyCases3_4")
    public void verifyCases5_6_7() {
        firstCheckbox.click();
        try{Thread.sleep(3000);}catch (Exception e) {}
        Assert.assertTrue(firstCheckbox.isSelected());
        Assert.assertTrue(secondCheckbox.isSelected());
    }

    @Test (dependsOnMethods = "verifyCases5_6_7")
    public void verifyCases8_9_10() {
        secondCheckbox.click();
        try{Thread.sleep(3000);}catch (Exception e) {}
        Assert.assertTrue(firstCheckbox.isSelected());
        Assert.assertFalse(secondCheckbox.isSelected());
    }

}
