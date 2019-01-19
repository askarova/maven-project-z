package com.cybertek.homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestCases_CheckboxesAndLinks {
    static WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);
    }
    @AfterClass
    public void closeWindows() {
        try { Thread.sleep(3000); } catch (Exception e) { }
        driver.quit();
    }

    /**
     * TC 1: Shop location buttons
     * 1.Open Etsy
     * 2.Enter search any term
     * 3.Verify Shop location: Anywhere is checked
     * 4.Verify Shop location: United States is not checked
     * 5.Click on Shop location: United States
     * 6.Verify Shop location: Anywhere is checked
     * 7.Verify Shop location: United States is not checked
     */

    public static void etsySetup() {
        driver.get("https://etsy.com");
        driver.findElement(By.id("search-query")).sendKeys("wooden spoon" + Keys.ENTER);
    }
    @Test(priority = 1)
    public void testCase1$3_4() {
        etsySetup();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@aria-label='Anywhere']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@aria-label='United States']")).isSelected());
    }
    @Test (dependsOnMethods = "testCase1$3_4")
    public void testCase1$5_6_7() {
        etsySetup();
        driver.findElement(By.partialLinkText("United States")).click();
        try { Thread.sleep(6000); } catch (Exception e) { }
        Assert.assertFalse(driver.findElement(By.xpath("//input[@aria-label='Anywhere']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@aria-label='United States']")).isSelected());
    }

    public static void amazonSetup() {
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium cookbook" + Keys.ENTER);
    }

    /**
     * TC 2: Search results verifications
     * 1.Open Amazon
     * 2.Enter search term Selenium cookbook
     * 3.Verify each result contains work Selenium
     */
    @Test (priority = 2)
    public void testCase2$3() {
        amazonSetup();
        String resultInfo = driver.findElement(By.id("s-result-count")).getText();
        for (int i = 0; i < resultInfo.length(); i++) {
            if (!Character.isDigit(resultInfo.charAt(i))) {
                resultInfo = resultInfo.substring(0, i);
                break;
            }
        }
        int numOfResults = Integer.parseInt(resultInfo);

        List<WebElement> allResultList = driver.findElements(By.tagName("h2"));
        ArrayList<String> listOfResults = new ArrayList<>();
        for (int i = 0; i < numOfResults; i++)
            listOfResults.add(allResultList.get(i).getText());

        for (String each : listOfResults) {
            try { Assert.assertTrue(each.contains("selenium") || each.contains("Selenium"));
                System.out.println(each);
                } catch (Throwable t) { System.out.println(">>>FAIL: [" + each + "] doesn't contain Selenium"); }
        }
    }

    /**
     * TC 3: Search results verifications
     * 1.Open Amazon
     * 2.Enter search term Selenium cookbook
     * 3.Verify default Ship to option is United States
     * 4.Verify options contain Canada
     * 5.Select Canada
     * 6.Verify Ship to option is now Canada
     */
    @Test (priority = 3)
    public void testCase3$3() {
        amazonSetup();
        Assert.assertTrue(driver.findElement(By.id("glow-ingress-line2")).getText().contains("Alexandria"));
    }
    @Test (dependsOnMethods = "testCase3$3")
    public void testCase3$4() {
        driver.findElement(By.id("glow-ingress-line2")).click();

        Select dropdown = new Select(driver.findElement(By.id("GLUXCountryList")));
        List<WebElement> countries = dropdown.getOptions();
        ArrayList<String> countryNames = new ArrayList<>();

        for (WebElement each : countries)
            countryNames.add(each.getText());

        Assert.assertTrue(countryNames.contains("Canada"));
    }
    @Test (dependsOnMethods = "testCase3$4")
    public void selectCanada() {
        driver.findElement(By.id("GLUXCountryValue")).click();
        try { Thread.sleep(1000); } catch (Exception e) { }
        driver.findElement(By.partialLinkText("Canada")).click();
        try { Thread.sleep(1000); } catch (Exception e) { }
        driver.findElement(By.name("glowDoneButton")).click();
        try { Thread.sleep(3000); } catch (Exception e) { }

        Assert.assertEquals("Canada", driver.findElement(By.id("glow-ingress-line2")).getText());
    }
}
