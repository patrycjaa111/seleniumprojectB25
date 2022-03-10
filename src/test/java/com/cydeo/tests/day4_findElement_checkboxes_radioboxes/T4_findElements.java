package com.cydeo.tests.day4_findElement_checkboxes_radioboxes;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_findElements {

    public static void main(String[] args) {

        // 1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        // Providing extra wait time before our driver b4 it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // go to "https://practice.cydeo.com/abtest"
        driver.get("https://practice.cydeo.com/abtest");

        // 3- Locate all the links in the page
        // alt+enter
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        // 4- Print out the number of the links on the page --> allLinks.size().soutv + enter
        System.out.println("allLinks.size() = " + allLinks.size());

        // 5- Print out the texts of the links.
        // 6- Print out the HREF
        for(WebElement each : allLinks){
            System.out.println("Text of Link: " + each.getText());
            System.out.println("HREF Values: " + each.getAttribute("href"));
        }








    }
}
