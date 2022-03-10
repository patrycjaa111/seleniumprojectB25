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

public class TC2_ConfirmationAlert {



//    TC #2: Confirmation alert practice
//1. Open browser
//2. Go to website: http://practice.cydeo.com/javascript_alerts

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/javascript_alerts");

    }

    @Test
    public void JSConfirm() {

//3. Click to “Click for JS Confirm” button
        WebElement JSConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        JSConfirm.click();
        BrowserUtils.sleep(5);

        Alert alert = driver.switchTo().alert();

//4. Click to OK button from the alert
        alert.accept();

//5. Verify “You clicked: Ok” text is displayed.

        WebElement okMsg = driver.findElement(By.xpath("//p[@id='result']"));

       Assert.assertTrue(okMsg.isDisplayed());

       String expected = "You clicked: Ok";
       String actual = okMsg.getText();

       Assert.assertEquals(actual,expected);




    }

}
