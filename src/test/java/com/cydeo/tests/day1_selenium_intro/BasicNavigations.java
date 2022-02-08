package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        // 1 - Set up the browser driver
        WebDriverManager.chromedriver().setup();

        // 2 - Create instance of the Selenium  WebDriver
//           - This is the line opening an empty browser
        WebDriver driver = new ChromeDriver();

        // 3 - Go to "https://www.tesla.com"
        driver.get("https://www.tesla.com");

        //get the title of the current page
        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        // get the current url using selenium
        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL); // tesla url



        // Stop code execution for 3 seconds
              Thread.sleep(3000);

        // use selenium to navigate back
        driver.navigate().back();

        // Stop code execution for 3 seconds
        Thread.sleep(3000);

        // use selenium to navigate forward
        driver.navigate().forward();

        // Stop code execution for 3 seconds
        Thread.sleep(3000);

        // use selenium to navigate refresh
        driver.navigate().refresh();

        // Stop code execution for 3 seconds
        Thread.sleep(3000);

        // use navigate().to();
        driver.navigate().to("https://www.google.com");

        currentTitle = driver.getTitle();  // selenium checks the title again and returns the value
        // it gets google title here, assigns it and...**


        // get the title of the page
     //   System.out.println("driver.getTitle() = " + driver.getTitle());//returns String
        System.out.println("current title= "+currentTitle); // **... prints it here


        // get the current URL using Selenium  --> return string so we assigned it to string variable
        currentURL = driver.getCurrentUrl();

        System.out.println("currentURL = " + currentURL);  // will get google URL

        // this will close the currently opened window
        driver.quit();

        // this will close all opened windows
        driver.close();











    }




}
