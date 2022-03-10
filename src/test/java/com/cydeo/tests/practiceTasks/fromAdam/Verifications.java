package com.cydeo.tests.practiceTasks.fromAdam;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Verifications {


//    TC 1- As a user I should be able to see the labels [“Home”,”About us”,”Our
//            Approach”,”Products and Services”,”Contact”,”LOGIN”]
//            1- Open a chrome browser
//            2- Go to “https://vytrack.com/”


    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://vytrack.com/");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void LabelsVerification() {      // As a user I should be able to see the headers : [“Home”,”About us”,”Our Approach”,”Products and Services”,”Contact”,”LOGIN”]

//    3- Verify that [“Home”,”About us”,”Our Approach”,”Products and Services”,”Contact”,”LOGIN”] is displayed

        // first solution

        List<WebElement> listOfHeaderWebElements = driver.findElements(By.xpath("//ul[@is='top-menu']/li/a"));
/*
      for(WebElement headerWebElement : listOfHeaderWebElements){

         Assert.assertTrue(headerWebElement.isDisplayed());


        }
*/

        // second solution

        List<String> expectedHeaderLabels = new ArrayList<>(Arrays.asList("Home", "About us", "Our Approach", "Products and Services", "Contact", "LOGIN"));
/*
       for (WebElement headerWebElement : listOfHeaderWebElements){

           Assert.assertTrue(expectedHeaderLabels.contains(headerWebElement.getText()));

       }
*/

        // third solution
        List<String> actualHeaderLabels = new ArrayList<>();
        for (WebElement headerWebElement : listOfHeaderWebElements) {
            actualHeaderLabels.add(headerWebElement.getText());
        }

        Assert.assertEquals(actualHeaderLabels, expectedHeaderLabels);

    }


    @Test
    public void TC2_verify_labels_under_our_approach() {
//      TC 2- As a user I should be able to see the labels [“Our Mission and Vision”,”Car Fleet Management”,”Newest Technologies”,””] under Our Approach

    //  Verify that [“Our Mission and Vision”,”Car Fleet Management”] is displayed

        driver.findElement(By.xpath("//a[.='Our Mission and Vision']")).isDisplayed();




    }

}























