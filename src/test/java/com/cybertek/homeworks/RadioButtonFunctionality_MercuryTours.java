package com.cybertek.homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioButtonFunctionality_MercuryTours {

    /**
     * 1.Open browser
     * 2.Go to http://www.newtours.demoaut.com/
     * 3.Login using username tutorial and password tutorial
     * 4.Verify Round Trip is selected by default
     * 5.Verify One Way is not selected by default
     * 6.Click one way
     * 7.Verify Round Trip selected not selected
     * 8.Verify One Way is selected
     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.newtours.demoaut.com/");

        driver.findElement(By.name("userName")).sendKeys("tutorial" + Keys.TAB +
                "tutorial" + Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        if (driver.findElement(By.xpath("//*[@name=\"tripType\"]/input[1]")).isSelected())
            System.out.println("PASS : \"Round Trip\" is selected by default");
        else System.out.println("FAIL : \"Round Trup\" is not selected by default");


        try { Thread.sleep(6000); } catch (Exception ex) { }
        driver.close();
    }

}
