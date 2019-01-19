package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwitchOptions {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tinymce");
    }

    @Test
    public void switchByElement() {
        // locate the iframe
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));

        // switch to iframe
        driver.switchTo().frame(iframe);
        driver.findElement(By.tagName("body")).sendKeys("salammekim");
    }

    @Test
    public void switchById() {
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.tagName("body")).sendKeys("salammeekim");
    }
}
