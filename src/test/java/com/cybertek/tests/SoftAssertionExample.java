package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class SoftAssertionExample {
    @Test
    public void test1() {
        System.out.println("starting test 1");

        Assert.assertTrue(false);

        System.out.println("done test 1");
    }

    @Test
    public void test2() {
        SoftAssert softAssert = new SoftAssert();

        System.out.println("starting test 2");

        softAssert.assertTrue(false);

        System.out.println("done test 2");

        softAssert.assertAll();
    }

    @Test
    public void test3() {
        SoftAssert softAssert = new SoftAssert();

        System.out.println("starting test 3");

        softAssert.assertTrue(false);

        Assert.assertTrue(false);

        System.out.println("done test 3");

        softAssert.assertEquals(1, 3, "1 isn't 3");
        softAssert.assertAll();
    }
}
