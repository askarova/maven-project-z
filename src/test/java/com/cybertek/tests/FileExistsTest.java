package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileExistsTest {
    @Test
    public void test() {
        // get the current folder, Java syntax
        String currentFolder = System.getProperty("user.dir");
        System.out.println(currentFolder);

        // get the user folder
        String userFolder = System.getProperty("user.home");
        System.out.println(userFolder);

        // path to the file location
        String path = userFolder + "\\Downloads\\test.txt";
        System.out.println(path);

        // Files.exists(Paths.get()  : returns true if file exists in the parameter provided
        Assert.assertTrue(Files.exists(Paths.get(path)));
//        String whatever = Paths.get("C:\\Users\\sgadi\\Downloads\\test.txt").toString();
//        System.out.println(whatever);
    }
}
