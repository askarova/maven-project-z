package com.cybertek.homeworks;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.*;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BasicLocators {
    WebDriver driver;

    @BeforeClass
    public void setUpDrivers() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @AfterClass
    public void closeWindows() {
        try { Thread.sleep(5000); } catch (Exception e){}
        driver.quit();
    }

    /**
     * 1.Open browser
     * 2.Go to http://a.testaddressbook.com/sign_in
     * 3.Enter username kexesobepu@zsero.com
     * 4.Enter password password
     * 5.Click sign in button
     * 6.Verify username is displayed on page
     * 7.Verify the title does not include Sign In
     */
    @Test (priority = 1)
    public void addressBook() {
        driver.get("http://a.testaddressbook.com/sign_in");
        driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='session_email']")).sendKeys("kexesobepu@zsero.com" + Keys.TAB + "password" + Keys.ENTER);
    }
    @Test (dependsOnMethods = "addressBook")
    public void verifyUsername() {
        String actual = driver.findElement(By.xpath("//span[@data-test='current-user']")).getText();
        Assert.assertEquals(actual, "kexesobepu@zsero.com");
    }
    @Test (dependsOnMethods = "verifyUsername")
    public void verifyTitle() {
        String actual = driver.getTitle();
        Assert.assertTrue(!actual.contains("Sign In"));
    }

    /**
     * 1.Open browser
     * 2.Go to http://zero.webappsecurity.com/login.html
     * 3.Enter username username
     * 4.Enter password password
     * 5.Click sign in button
     * 6.Verify username is displayed on page
     * 7.Verify the title Zero -Account Summary
     */
    @Test(priority = 2)
    public void zeroBank() {
        driver.get("http://zero.webappsecurity.com/login.html");
        driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username" + Keys.TAB + "password" + Keys.ENTER);
    }
    @Test (dependsOnMethods = "zeroBank")
    public void verifyUsernameZB() {
        String actual = driver.findElement(By.partialLinkText("username")).getText();
        Assert.assertTrue(actual.contains("username"));
    }
    @Test (dependsOnMethods = "verifyUsernameZB")
    public void verifyTitleZB(){
        String actual = driver.getTitle();
        Assert.assertTrue(actual.equalsIgnoreCase("Zero - Account Summary"));
    }

    /**
     * Search Amazon
     * 1.Open browser
     * 2.Go to https://amazon.com
     * 3.Enter any search term
     * 4.Click on search button
     * 5.Verify title contains the searchterm
     */
    @Test(priority = 3)
    public void goToAmazon() {
        driver.get("https://amazon.com");
        driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("slow cooker" + Keys.ENTER);
    }
    @Test (dependsOnMethods = "goToAmazon")
    public void verifyTitleAmazon() {
        String actual = driver.getTitle();
        Assert.assertTrue(actual.contains("slow cooker"));
    }

    /**
     * Retrieve password
     * 1.Open browser
     * 2.Go to https://the-internet.herokuapp.com/forgot_password
     * 3.Enter any email
     * 4.Click on Retrieve password
     * 5.Verify url contains email_sent
     */
    @Test(priority = 4)
    public void retrievePassword() {
        driver.get("https://the-internet.herokuapp.com/forgot_password");
        driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@123.com" + Keys.ENTER);
    }
    @Test (dependsOnMethods = "retrievePassword")
    public void verifyURL() {
        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains("email_sent"));
    }

    /**
     * Click on links
     * 1.Open browser
     * 2.Go to https://the-internet.herokuapp.com/
     * 3.Click link File download
     * 4.Verify title contains on download
     * 5.Navigate to previous page
     * 6.Click link File upload
     * 7.Verify title contains on upload
     */
    @Test(priority = 5)
    public void clickOnLinks() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);
    }
    @Test(dependsOnMethods = "clickOnLinks")
    public void fileDownload() {
        driver.findElement(By.xpath("//a[.='File Download']")).click();
        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains("download"));
    }
    @Test(dependsOnMethods = "fileDownload")
    public void fileUpload() {
        driver.navigate().back();
        driver.findElement(By.xpath("//a[.='File Upload']")).click();
        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains("upload"));
    }

}
