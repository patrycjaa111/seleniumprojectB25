package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsPractices {



    @Test
    public void test_4_and_5_test() {

        //TC #4: Scroll practice
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/

        Driver.getDriver().get("https://practice.cydeo.com/");

        // 3. Scroll down to "Powered by Cydeo" ==> Create object of Actions and pass our "driver" instance
        Actions actions = new Actions(Driver.getDriver());

        // Locating cydeo link to be able to pass in the actions method
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

        // 4. Scroll using Actions class "moveTo(element)" method
        actions.moveToElement(cydeoLink).perform();  // moveToElement is a better way of scrolling cuz you know what point you stop scrolling

        // 5. Scroll back up to "Home" link using PageUp button
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform(); // here we do not specify how far up we go


       // Driver.getDriver().quit();   // this will completely terminate the driver instance AKA shut down the power


        Driver.closeDriver();  // using the method from the Driver utility class we created

    }
}
