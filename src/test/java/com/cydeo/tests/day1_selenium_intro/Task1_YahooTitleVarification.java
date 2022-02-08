package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVarification {

    public static void main(String[] args) {


//        TC #1: Yahoo Title Verification

        //  do set up for browser driver
        WebDriverManager.chromedriver().setup();

//        1.Open Chrome browser
        WebDriver driver = new ChromeDriver();

        // make your page full screen
        driver.manage().window().maximize();

//        2.Go to   https://www.yahoo.com
        driver.get("https://www.yahoo.com");

//        3. Verify title:
        //Expected: Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos
        String expectedTitle = "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";

        //Actual title comes from the browser
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title is as expected. Verification PASSED!");
        }else{
            System.out.println("Time is NOT as expected. Verification FAILED!!!");
        }




















    }



















}
