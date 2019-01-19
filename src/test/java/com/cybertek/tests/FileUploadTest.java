package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
go to https://the-internet.herokuapp.com/upload
upload file
click upload
verify text uploaded
 */
public class FileUploadTest extends TestBase {

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        String path = "C:\\Users\\sgadi\\Downloads\\test.txt";

        // chooseFile. --> Selenium's library tool that uploads a file per String path
        chooseFile.sendKeys(path);
        try { Thread.sleep(3000); } catch (Exception e) { }

        driver.findElement(By.id("file-submit")).click();
        try { Thread.sleep(3000); } catch (Exception e) { }

        Assert.assertTrue(
                driver.findElement(By.xpath("//*[.='File Uploaded!']")).isDisplayed());
    }
}
