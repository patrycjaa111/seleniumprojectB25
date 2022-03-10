package com.cydeo.tests.practiceTasks;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebtablePractice {

//    TC #1: Web table practice
// 1. Go to: https://practice.cydeo.com/web-tables

    WebDriver driver;
@BeforeMethod
public void setupMethod(){
    driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}

    @Test
    public void TC1() {

    driver.get("https://practice.cydeo.com/web-tables");

//2. Verify Bob’s name is listed as expected.
//    Expected: “Bob Martin”

        // Locate the cell that has Bob Martin text in it first.
    WebElement bobMartinCell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));

        // System.out.println("bobMartinCell.getText() = " + bobMartinCell.getText());

    String expected = "Bob Martin";
    String actual = bobMartinCell.getText();

        Assert.assertEquals(actual,expected);

//3. Verify Bob Martin’s order date is as expected
//    Expected: 12/31/2021

    WebElement orderDate = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));

    String expectedDate = "12/31/2021";
    String actualDate = orderDate.getText();

    Assert.assertEquals(actualDate,expectedDate);


    }





}
