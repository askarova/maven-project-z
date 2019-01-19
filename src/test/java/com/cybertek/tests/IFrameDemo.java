package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IFrameDemo {

    @Test
    public void test() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tinymce");
        driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);

        // locate and store the iframe
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));

        // swithch to iframe
        driver.switchTo().frame(iframe).findElement(By.xpath("//body[@id=\"tinymce\"]")).sendKeys("Salammekim");

        // if we want to operate on the elements of the previous (parent) html,
        // we need to switch bank so that Selenium will call the elements of that html
        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent(); /* TAKES US TO THE TOP TOP LEVEL */

        driver.findElement(By.xpath("//div[@id='page-footer']/div/div/a")).click();

        // if you have multiple frames from multiple parents, you will have to navigate to parent of the frame
        // that you want to go to first
    }


/**
 selenium can handle only one html at a time
 each page must contain one html document only
 however, if we want to insert another html,
 we can use IFRAME
 html
    iframe
        html

 In order to deal with such an issue, we need to SWITCH to into the iFrame
 and then have Selenium look into elements inside that HTML
 */


}