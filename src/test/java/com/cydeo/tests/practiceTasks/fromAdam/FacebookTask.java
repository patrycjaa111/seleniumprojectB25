package com.cydeo.tests.practiceTasks.fromAdam;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class FacebookTask {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to h0ps://www.facebook.com
        driver.get("https://www.facebook.com");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void TC1_verifying_title() {
        //TC #1: Facebook title verification
        //3. Verify title:
        String expectedTitle = "Facebook – log in or sign up";
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, expectedTitle);
        //Expected: “Facebook – log in or sign up”
    }
    //TC #2: Facebook incorrect login .tle verifica.on
    //1. Open Chrome browser
    //2. Go to h0ps://www.facebook.com


    @Test
    public void TC2_verifying_login_title() throws InterruptedException {
        //3. Enter incorrect username
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("incorrect");
        //4. Enter incorrect password
        driver.findElement(By.xpath("//div[@id='passContainer']/input")).sendKeys("incorrect" + Keys.ENTER);

        //5. Verify title changed to:
        String expectedTitle = "Log in to Facebook";
        Thread.sleep(3000);
        String actualTitle = driver.getTitle();
        //Expected: “Log into Facebook”
        assertEquals(actualTitle, expectedTitle);

    }
    //for mac shortcut Command+N
    //for windows shotcut Alt+insert


    @Test
    public void TC3_verifying_header() {
        //TC #3: Facebook header verification
        //3. Verify header text is as expected:
        String expectedHeader = "Facebook helps you connect and share with the people in your life.";
        String actualHeader = driver.findElement(By.cssSelector("h2._8eso")).getText();
        //Expected: “Facebook helps you connect and share with the people in your life.”
        assertEquals(actualHeader, expectedHeader, "verifying header");
        //assertEquals(actualHeader, expectedHeader);
    }


    @Test
    public void createAPageLinkVerification(){

        //TC #4

        //3. Verify “Create a page” link href value contains text:
        //Expected: “registration_form

        String expectedWord="registration_form";
        String actualAtributeValue=  driver.findElement(By.xpath("//a[contains(@href,'regist')]")).getAttribute("href");

        Assert.assertTrue(actualAtributeValue.contains(expectedWord));



        // 1st Solution by me
/*
        WebElement createAPageLink_Verification = driver.findElement(By.xpath("//a[.='Create a Page']"));

        String expectedInHref = "registration_form";
        String actualHrefAttributeValue = createAPageLink_Verification.getAttribute("href");

        System.out.println("actualHrefAttributeValue = " + actualHrefAttributeValue);


        if (actualHrefAttributeValue.contains(expectedInHref)){
            System.out.println("HREF value verification PASSED!\n"+actualHrefAttributeValue);
        }else{
            System.out.println("HREF value verification FAILED!\n"+actualHrefAttributeValue);
        }
*/

    }

    //  WebElement = driver.getCurrentUrl();





}
