package com.cybertek.xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class XPath_01_Upload {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);

        /*
        ABSOLUTE XPATH: syntax as follows
        /html/parent/subparent/child/child/finalLocation

        It uses the hierarchy (parent/child) of elements to locate an object.
         */
        driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]")).click();

        /*
        RELATIVE XPATH:
        //tag[@attribute='value']
        //button[@class='btn btn-primary']

        It doesn't depend on html structure but looks for anywhere in the document
         */
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();

        /*
        EXACT TEXT SEARCH:
        //tag[.='text']
        <h3>Frames<h/3>
        //h3[.='Frames']
         */

        /*
        PARTIAL TEXT SEARCH:
        //tag[contains(text(), 'text')]
        <h3>Frames<h/3>
        //h3[contains(text(), 'Fra')]
         */

        /*
        ANY ELEMENT WITH CERTAIN TEXT, ATTRIBUTE
        //*[.='Frames']

         */

        /*
        N'TH MATCH WITHIN THE PAGE
        1. I write an xpath that matches both
            //a[.='Help']
        2. select the second match, by putting the xpath in paranthesis and
            providing index outside the paranthesis
            (//a[.='Help'])[2]

         */

        /*
        DYNAMIC ATTRIBUTES: Contains, starts, ends
        //tag[contains(@attribute,'value')]
        //tag[starts-with(@attribute,'value')]
        //tag[ends-with(@attribute,'value')]

        <button id="j_idt691"></button>
        //button[contains(@id,'j_idt')]
        //button[starts-with(@id,'j_idt')]
        //button
         */

        /*
        USING 2 OR MORE XPATH // XPATH CHAINING
        1. Write an xpath which matches multiple elements
            //a[.='Help']
        2. Write an xpath that locates the section of the page where my element is
            //div[@id='navFooter']
        3. Mix and match
            //div[@id='navFooter']//a[.'Help']

        This will first find the div section and then will look for the tag within that div
         */

        try { Thread.sleep(6000); } catch (Exception ex) { }
        driver.close();
    }
}
