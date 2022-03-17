package com.cydeo.tests.day10_upload_actions_jsexecuter;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T7_JSExecutor_scroll_practice {

//JavaScript method to use : arguments[0].scrollIntoView(true)

//Note: You need to locate the links as web elements and pass them as
//arguments into executeScript() method

    @Test
    public void jsexecutor_scroll(){
//        TC #7: Scroll using JavascriptExecutor
//        1- Open a chrome browser
//        2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //locate the links as web elements
        WebElement cydeoLink = Driver.getDriver().findElement(By.xpath("//a[@href='https://cydeo.com/']"));
        WebElement homeLink = Driver.getDriver().findElement(By.className("nav-link"));

//        3- Scroll down to “Cydeo” link
        js.executeScript("arguments[0].scrollIntoView(true)",cydeoLink);

        BrowserUtils.sleep(2);

//        4- Scroll up to “Home” link
        js.executeScript("arguments[0].scrollIntoView(true)",homeLink);



    }
}
