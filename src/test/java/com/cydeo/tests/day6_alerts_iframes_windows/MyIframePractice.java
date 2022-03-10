package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MyIframePractice {



//    TC #4: Iframe practice
//1. Create a new class called: T4_Iframes
//2. Create new test and make set ups

WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/javascript_alerts ");
        //3. Go to:
        driver.get("https://practice.cydeo.com/iframe");
    }

    @Test
    public void iframe() {

        driver.switchTo().frame("mce_0_ifr");

//4. Assert: “Your content goes here.” Text is displayed.

        WebElement txt = driver.findElement(By.tagName("p"));
        Assert.assertTrue(txt.isDisplayed());

        Assert.assertEquals(txt.getText(),"Your content goes here.", "Message not displayed");

//5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”

        driver.switchTo().parentFrame();

       WebElement headerTxt = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(headerTxt.isDisplayed());





    }
}
