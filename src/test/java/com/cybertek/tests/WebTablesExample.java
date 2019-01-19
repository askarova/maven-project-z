package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesExample extends TestBase {

    @Test
    public void printWholeTable() {
        login();

        WebElement table = driver.findElement(By.id("ctl00_MainContent_orderGrid"));
        System.out.println(table.getText());
    }

    @Test
    public void printAllHeaders() {
        login();

        List<WebElement> headers = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }
    }

    @Test
    public void printRow() {
        login();

        List<WebElement> allRows = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr"));
        System.out.println("number of rows: " + allRows.size());

//        for (WebElement header : allRows) {
//            System.out.println(header.getText());
//        }

        // print the nth row only
        // List starts from index 0 which in this case is the header
        // therefore, each row will go by the matching index
        // the code below will print the customer information on the row 1
        System.out.println(allRows.get(1).getText());
    }

    @Test
    public void printTableSize() {
        login();

        List<WebElement> allRows = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tbody//tr"));
        System.out.println("Number of rows: " + allRows.size());

        List<WebElement> allHeaders = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tbody//tr[1]/th"));
        System.out.println(allHeaders.size());
    }

    @Test
    public void printRow2() {
        login();

        WebElement row = driver.findElement(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tbody//tr[6]"));
        System.out.println(row.getText());
    }

    /*
    print all the cells of the row whose index is given in the xpath
     */
    @Test
    public void printAllCellsInOneRow() {
        login();

        List<WebElement> cells = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tbody//tr[7]/td[10]"));
        for (WebElement c : cells) {
            System.out.println(c.getText());
        }

        System.out.println(getCell(4, 3).getText());
    }

    public WebElement getCell(int row, int col) {
        String xpath = "//table[@id='ctl00_MainContent_orderGrid']//tbody//tr["+row+"]/td["+col+"]";
        return driver.findElement(By.xpath(xpath));
    }

    /*
    print all the values in single column
     */
    @Test
    public void printColumn() {
        login();

        List<WebElement> allNames = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));

        for (WebElement header : allNames) {
            System.out.println(header.getText());
        }
    }

    /*
    find the select checkbox for a given name
     */
    @Test
    public void selectCheckbox() {
        login();

        WebElement checkbox = driver.findElement(
                By.xpath("//td[.='Susan McLaren']/../td[1]/input"));
        System.out.println(checkbox.isSelected());

        checkbox.click();
        System.out.println(checkbox.isSelected());
    }

    /*
    verify that name 'someone' exists in the names column
    verify that city 'anytown' exists in the cities column
     */
    @Test
    public void test() {
        login();

        int nameIndex = getColumnIndex("Name");
        System.out.println(nameIndex);

        List<WebElement> allNames = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[" + nameIndex + "]"));
        boolean found = false;

        for (int i = 0; i < allNames.size(); i++) {
            if (allNames.get(i).getText().equals("Mark Smith")) {
                // pass
                found = true;
                // break the loop
                break;
            }
        }

        Assert.assertTrue(found);

        found = false;
        int cityIndex = getColumnIndex("City");
        List<WebElement> allCities = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[" + nameIndex + "]"));

        for (int i = 0; i < allCities.size(); i++) {
            if (allCities.get(i).getText().equals("Whitestone, British")) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
    }

    /*
    gets a column name as a parameter
    returns the index of the column name
     */
    public int getColumnIndex(String column) {
        List<WebElement> allHeader = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));

        for (int i = 0; i < allHeader.size(); i++) {
            if (allHeader.get(i).getText().equals(column))
                return i+1;
        }
        return 0;
    }

    public void login() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);
    }
}
