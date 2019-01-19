package com.cybertek.tests;

import org.testng.annotations.Test;

public class DependenciesTest {
    @Test
    public void login() {
        System.out.println("login");
    }

    /*
    DEPENDS ON METHODS
    @Test with this parameter will run ONLY IF the method it depends on will PASS
    should the depending test case fails, this test WILL BE IGNORED
     */
    @Test (dependsOnMethods = "login")
    public void zbuySth() {
        System.out.println("buy buy baby");
    }

    @Test
    public void homePage() {
        System.out.println("home page");
    }
}
