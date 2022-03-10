package com.cydeo.tests.officeHours.practice_02_23_2022;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SmartBearTest {

    WebDriver driver;
    String appUrl= "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
    String userName="Tester";
    String password="test";

    @BeforeMethod
    public void setUp() {

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(appUrl);

        String expectedTitle= "Web Orders Login";
        String actualTitle=driver.getTitle();

        assertEquals(actualTitle,expectedTitle,"Before login title did not match!");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(userName);
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(password + Keys.ENTER);
       // driver.findElement(By.id("ctl00_MainContent_login_button")).click();
    }

    @Test
    public void loginTest(){

        String expectedTitle= "Web Orders";
        String actualTitle=driver.getTitle();

        assertEquals(actualTitle,expectedTitle,"After login title did not match!");

    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }
}




