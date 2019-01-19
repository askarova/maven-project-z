package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DragAndDrop extends TestBase {
    @Test
    public void test1() {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        // pass the variable in the correct order!!!
        // first one is source, second one is target
        actions.dragAndDrop(source, target).perform();
        try { Thread.sleep(2000); } catch (Exception e) { }
    }

    @Test
    public void test2() {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        // write the steps for doing the drag and drop operation
        // without using the dragAndDrop(); method
        // when we use multiple actions, we need to add build() BEFORE we perform()
            // build() used to be used in previous editions
            // hence, if you use previous editions, make sure you add the build()
        actions
                .clickAndHold(source)
                    .moveToElement(target)
                        .release()
                            .perform();

        try { Thread.sleep(2000); } catch (Exception e) { }
    }
}
