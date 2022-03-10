package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC3_InformationAlert {


//    TC #3: Information alert practice

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
//1. Open browser
//2. Go to website: http://practice.cydeo.com/javascript_alerts

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/javascript_alerts ");
    }



    @Test
    public void JSPrompt() {

//3. Click to “Click for JS Prompt” button
        WebElement JSPrompt = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        JSPrompt.click();

        BrowserUtils.sleep(2);

//4. Send “hello” text to alert

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");

//5. Click to OK button from the alert
        alert.accept();

//6. Verify “You entered:  hello” text is displayed.

        WebElement resultTxt = driver.findElement(By.id("result"));
        Assert.assertTrue(resultTxt.isDisplayed());

        Assert.assertEquals(resultTxt.getText(),"You entered: hello");


    }
}
