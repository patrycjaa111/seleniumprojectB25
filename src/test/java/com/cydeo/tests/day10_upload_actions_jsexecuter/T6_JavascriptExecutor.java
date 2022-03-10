package com.cydeo.tests.day10_upload_actions_jsexecuter;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class T6_JavascriptExecutor {


    @Test
    public void javascript_executor_test1() {

        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        //use below javaScript method and scroll
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


        BrowserUtils.sleep(1);

        // 750 pixels down 10 times

        for (int i = 0; i < 10; i++) {       //  x,y    x= horizontal   y=vertical
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");   // 750 is one scroll

        }

        BrowserUtils.sleep(1);

        // 750 pixels up 10 times

        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,-750)");   // - means it will go up

        }

    }



}

