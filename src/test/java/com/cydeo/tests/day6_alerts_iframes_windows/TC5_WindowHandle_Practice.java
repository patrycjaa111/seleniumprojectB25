package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TC5_WindowHandle_Practice {

    //        TC #5: Window Handle practice

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/windows");
    }

    @Test
    public void TC5() {
//storing our main page's window handle as String for later re-usability
       String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);

//        4. Assert: Title is “Windows”
        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

//        5. Click to: “Click Here” link
        WebElement clickHereBtn = driver.findElement(By.xpath("//a[.='Click Here']"));
                                                  //(By.LinkText("Clcik Here")
        clickHereBtn.click();

//        6. Switch to new Window.
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current title while switching windows: " + driver.getTitle());
        }

//        7. Assert: Title is “New Window”
        String expectedTitleAfterClick = "New Window";
        String actual = driver.getTitle();

        Assert.assertEquals(actual,expectedTitleAfterClick);
        System.out.println("Title after click: "+actual);

    }
}
