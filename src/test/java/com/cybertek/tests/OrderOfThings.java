package com.cybertek.tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class OrderOfThings {

    /*
    in TestNG, tase cases are run by alphabetical order
    HOWEVER, if there is (priority = (int)) block,
        test will run per the priority order
     */

    @Test (priority = 4)
    public void test1() {
        System.out.println("Testing case 1");
    }

    @Test (priority = 6)
    public void test2() {
        System.out.println("Testing case 2");
    }

    // @Ignore will IGNORE the case afterwards (not skip, but IGNORE completely)
    @Ignore
    @Test (priority = -1)
    public void test3() {
        System.out.println("Testing case 3");
    }

    @Test (priority = 4-2)
    public void test4() {
        System.out.println("Testing case 4");
    }

}
