package com.cybertek.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DifferentAnnotations {
    @Test
    public void testOne() {
        System.out.println("This is test one");
    }

    /*
    BEFORE METHOD
    IntelliJ will always check to see if there are any @Test methods
    if there is a @Test method, IntelliJ will start looking for @BeforeMethod
    if there is a @BeforeMethod, it will run as many times as there are @Test methods
    -> once for each @Test method
    BeforeMethod will not run if there are not any @Tests
     */
    @BeforeMethod
    public void beforeMethodDemo() {
        System.out.println("This is before method");
    }

    @Test
    public void testTwo() {
        System.out.println("This is test two");
    }

    /*
    BEFORE CLASS
    unlike @BeforeMethod, it will run regardless
    and it will run ONLY ONCE before anything else
     */
    @BeforeClass
    public void beforeClassDemo() {
        System.out.println("This is before class");
    }
}
