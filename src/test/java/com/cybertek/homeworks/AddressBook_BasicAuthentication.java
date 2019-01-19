package com.cybertek.homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddressBook_BasicAuthentication {
    /**
     * 1.Open browser
     * 2.Go to http://a.testaddressbook.com/sign_in
     * 3.Enter username kexesobepu@zsero.com
     * 4.Enter password password
     * 5.Click sign in button
     * 6.Verify username is displayed on page
     * 7.Verifythe title does not include Sign In
     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://a.testaddressbook.com/sign_in");

        driver.findElement(By.id("session_email")).sendKeys("kexesobepu@zsero.com" + Keys.TAB +
                "password" + Keys.ENTER);

        String username = driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[2]/span")).getText();
        if (username.equals("kexesobepu@zsero.com")) {
            System.out.println("Username is displayed : PASS");
        }else {
            System.out.println("Username is not displayed : FAIL");
            System.out.println("Actual username = " + username);
            System.out.println("Expected username = " + "kexesobepu@zsero.com");
        }

        String title = driver.getTitle();
        if (!title.contains("sign in")) {
            System.out.println("Title does not display \"Sign in\" : PASS");
        }else {
            System.out.println("Title contains \"Sign in\" : FAIL");
            System.out.println("Actual title = " + title);
        }

        driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/a[3]")).click();

        try { Thread.sleep(6000); }catch (Exception ex) { }
        driver.close();
    }
}
