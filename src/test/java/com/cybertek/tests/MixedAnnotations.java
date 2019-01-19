package com.cybertek.tests;

import org.testng.annotations.*;

public class MixedAnnotations {
    @BeforeClass
    public void beforeClass() {
        System.out.println("Setting up the drivers here");
    }

    @BeforeMethod
    public void setUpTestMethod() {
        System.out.println("Opening a browser");
        System.out.println("Go to website: ");
    }

    @Test
    public void testOne() {
        System.out.println("Running test scripts");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("logout");
        System.out.println("closing browser");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Report everything");
    }
}
