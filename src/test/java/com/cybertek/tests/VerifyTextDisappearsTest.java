package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTextDisappearsTest extends TestBase {
    @Test
    public void verify1() {
        driver.get("https://www.w3schools.com/howto/howto_js_toggle_hide_show.asp");

        WebElement text = driver.findElement(By.id("myDIV"));
        System.out.println(text.getText());

        Assert.assertTrue(text.isDisplayed());

        WebElement button = driver.findElement(By.cssSelector("button[class='w3-btn w3-hover-black w3-dark-grey']"));
        button.click();

        Assert.assertFalse(text.isDisplayed());
    }

    @Test
    public void verify2() {
        driver.get("https://www.w3schools.com/jquery/tryit.asp?filename=tryjquery_html_remove");

        driver.switchTo().frame("iframeResult");

        WebElement text = driver.findElement(By.xpath("//body/p"));

        WebElement button = driver.findElement(By.xpath("//body/button"));

        button.click();

        Assert.assertTrue(button.isDisplayed());
    }
}
