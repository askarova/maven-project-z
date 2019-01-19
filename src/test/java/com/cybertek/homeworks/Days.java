package com.cybertek.homeworks;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Days {
    WebDriver driver;
    WebElement monday;
    WebElement tuesday;
    WebElement wednesday;
    WebElement thursday;
    WebElement friday;
    List<WebElement> days;

    /**
     * DAYS
     * 1.open browser
     * 2.go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
     * 3.Randomly select days of the week.
     *      As soon as you check any day, print the name of the day
     *      and uncheck immediately.
     *      After you check and uncheck Friday for the third time,
     *      exit the program
     */
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
    }
    @AfterClass
    public void quitWindows() {
        try { Thread.sleep(3000); } catch (Exception ex) { }
        driver.quit();
    }

    @BeforeMethod
    public void setUpList() {
        monday = driver.findElement(By.id("gwt-debug-cwCheckBox-Monday-label"));
        tuesday = driver.findElement(By.id("gwt-debug-cwCheckBox-Tuesday-label"));
        wednesday = driver.findElement(By.id("gwt-debug-cwCheckBox-Wednesday-label"));
        thursday = driver.findElement(By.id("gwt-debug-cwCheckBox-Thursday-label"));
        friday = driver.findElement(By.id("gwt-debug-cwCheckBox-Friday-label"));

        days = new ArrayList<>();
            days.add(monday);
            days.add(tuesday);
            days.add(wednesday);
            days.add(thursday);
            days.add(friday);
    }
    @Test
    public void randomSelection() {

        int count = 0;

        while (count < 3) {
            int randomIndex = (int) (Math.random() * 5);
            days.get(randomIndex).click();
                System.out.println(days.get(randomIndex).getText());
            days.get(randomIndex).click();

            if (randomIndex == 4)
                count++;
        }
    }
}
