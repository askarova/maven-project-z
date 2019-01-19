package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.*;

public class AssertionsDemo {
    // tests will run by alphabetical order
    @Test
    public void test1() {
        String a = "A";
        String b = "A";

        Assert.assertEquals(a, b);
        // comparing a to b by using .equals() method
    }

    @Test
    public void test2() {
        String a = "AAA";
        String b = "A";

        Assert.assertEquals(a, b);
    }

    @Test
    public void test3() {
        boolean b = 1==111;
        Assert.assertTrue(b);
    }

    @Test
    public void test4() {
        String a = "A";
        String b = "AAA";

        Assert.assertTrue(b.contains(a));
        System.out.println("FAILED");
        // any code written after Assertion will not execute should the Assert fails
    }

    @Test
    public void test5() {
        String a= "ABC";
        String b = "ABAA";

        Assert.assertTrue(a.contains(b), a + " should contain " + b);
        // the overloaded assertTrue(condition, String message)
        // prints out the second half on the console if the assertion fails
    }
}
