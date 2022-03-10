package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T7_Scroll_JSExecutor {


    @Test
    public void task7_scroll_test(){
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");

        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));

        // downcasting our driver type to javascript executor
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //interface

        //3- Scroll down to “Cydeo” link
        js.executeScript("arguments[0].scrollIntoView(true)",cydeoLink);
    //  javascript method(passing index number of the argument. scrolling until the arg at index 0 is visible on the screen)


        //4- Scroll up to “Home” link
        js.executeScript("arguments[1].scrollIntoView(true)",cydeoLink, homeLink);
                                                             //    0         1

        //5- Use below provided JS method only
        //JavaScript method to use : arguments[0].scrollIntoView(true)


    }



}
