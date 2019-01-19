package com.cybertek.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DifferentAnnotations_02 {
    @Test
    public void testOne() {
        System.out.println("This is test one");
    }

    @Test
    public void testTwo() {
        System.out.println("This is test two");
    }

    /*
    AFTER METHOD
    similar to @BeforeMethod
     */
    @AfterMethod
    public void afterMethodDemo() {
        System.out.println("This is after method");
    }

    /*
    AFTER CLASS
    similar to @BeforeClass
     */
    @AfterClass
    public void afterClassDemo() {
        System.out.println("This is after class");
    }
}
