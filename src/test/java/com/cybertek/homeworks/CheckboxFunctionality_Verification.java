package com.cybertek.homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxFunctionality_Verification {
    /**
     * 1.Open browser
     * 2.Go to http://the-internet.herokuapp.com/checkboxes
     * 3.Verify the first checkbox is not selected
     * 4.Verify the second checkbox is selected
     * 5.Click on the first checkbox
     * 6.Verify the first checkbox is selected
     * 7.Verify the second checkbox is selected
     * 8.Click on the second checkbox
     * 9.Verify the first checkbox is selected
     * 10.Verify the second checkbox is not selected
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://the-internet.herokuapp.com/checkboxes");

        if (!driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).isSelected())
            System.out.println("PASS : the first checkbox is not selected");
        else
            System.out.println("FAIL : the checkbox is selected");

        if (driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isSelected())
            System.out.println("PASS : the second checkbox is selected");
        else
            System.out.println("FAIL : the checkbox is not selected");

        try { Thread.sleep(3000); } catch (Exception ex) { }
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).click();
        if (driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).isSelected())
            System.out.println("PASS : the first checkbox is selected");
        else
            System.out.println("FAIL : the checkbox is not selected");

        if (driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isSelected())
            System.out.println("PASS : the second checkbox is selected");
        else
            System.out.println("FAIL : the checkbox is not selected");

        try { Thread.sleep(3000); } catch (Exception ex) { }
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click();
        if (driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).isSelected())
            System.out.println("PASS : the first checkbox is selected");
        else
            System.out.println("FAIL : the checkbox is not selected");

        if (!driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isSelected())
            System.out.println("PASS : the second checkbox is not selected");
        else
            System.out.println("FAIL : the checkbox is selected");


        try { Thread.sleep(6000); } catch (Exception ex) { }
        driver.close();
    }
}
