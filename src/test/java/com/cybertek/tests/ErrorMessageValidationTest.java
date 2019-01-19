package com.cybertek.tests;

import com.cybertek.pages.HomePage;
import com.cybertek.pages.ListingPage;
import com.cybertek.pages.PrestaShopHomePage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorMessageValidationTest extends TestBase {
//    HomePage homePage = new HomePage(); burdan aldik her methoda koyduk. cunku quit edince bu kaliyordu class levelde

    @Test
    public void wrongEmailTest() {
        HomePage homePage = new HomePage();
        //driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.get(ConfigurationReader.getProperty("url"));
        homePage.username.sendKeys("admin");
        homePage.password.sendKeys("test");
        homePage.loginButton.click();
//        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("admin");
//        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
//        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        String error = "Invalid Login or Password.";
        String actualError = driver.findElement(By.id("ctl00_MainContent_status")).getText();
        Assert.assertEquals(actualError, error);
    }

    @Test
    public void wrongPasswordTest() {
        HomePage homePage = new HomePage();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        homePage.username.sendKeys("Tester");
        homePage.password.sendKeys("wrong password");
        homePage.loginButton.click();
//        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
//        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("wrong password");
//        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        String expectedError = "Invalid Login or Password.";
        String actualError = driver.findElement(By.id("ctl00_MainContent_status")).getText();
        Assert.assertEquals(actualError, expectedError);
    }

    @Test
    public void blankUsername() {
        HomePage homePage = new HomePage();

        homePage.open();
        homePage.login("", "test");

        String expextedError = "Invalid Login or Password.";
        String actualError = homePage.errorMessage.getText();
        Assert.assertEquals(actualError, expextedError);
    }


    // this is just a method which does not do anything
//    @Test
    public void test() {
        HomePage homePage = new HomePage();
        ListingPage nilesLane = new ListingPage();

        ListingPage palmetLane = new ListingPage();

        PrestaShopHomePage prestashopHomePage = new PrestaShopHomePage();

        WebElement tshirt = prestashopHomePage.product("tshirt");

        WebElement dress = prestashopHomePage.product("dress");


    }


}
