package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class ScrollTest extends TestBase {

    @Test
    public void test() {
        driver.get("https://youtube.com");

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        try { Thread.sleep(2000); } catch (Exception e) { }
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        try { Thread.sleep(2000); } catch (Exception e) { }
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        try { Thread.sleep(2000); } catch (Exception e) { }
        actions.sendKeys(Keys.PAGE_UP).perform();
        try { Thread.sleep(2000); } catch (Exception e) { }
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        try { Thread.sleep(2000); } catch (Exception e) { }
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }
}
