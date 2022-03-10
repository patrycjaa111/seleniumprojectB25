package com.cydeo.tests.day4_findElement_checkboxes_radioboxes;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Practice_StaleElementReferenceException {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        // 1. Open Chrome browser
    driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testName() {
//        2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");

//        3. Click to “Add Element” button
        WebElement elementBtn = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        elementBtn.click();

//        4. Verify “Delete” button is displayed after clicking.
        WebElement deleteBtn = driver.findElement(By.xpath("//button[.='Delete']"));
        deleteBtn.isDisplayed();

//        5. Click to “Delete” button.
        deleteBtn.click();

//        6. Verify “Delete” button is NOT displayed after clicking.
      //  deleteBtn.isDisplayed();  --> throws StaleElementReferenceException cuz the btn is no longer on the page

    }















/*
TC #1: StaleElementReferenceException handling
1. Open Chrome browser
2. Go to https://practice.cydeo.com/add_remove_elements/
3. Click to “Add Element” button
4. Verify “Delete” button is displayed after clicking.
5. Click to “Delete” button.
6. Verify “Delete” button is NOT displayed after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */

}
