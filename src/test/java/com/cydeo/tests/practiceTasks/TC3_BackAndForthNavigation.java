package com.cydeo.tests.practiceTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_BackAndForthNavigation {

//    TC #3: Back and forth navigation


    public static void main(String[] args) throws InterruptedException {

        // 1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2- Go to: https://google.com
        driver.get("https://google.com");

        // 3- Click to Gmail from top right.
        WebElement gmailButton = driver.findElement(By.className("gb_d"));
        gmailButton.click();

        Thread.sleep(2000);


        // 4- Verify title contains:
        //Expected: Gmail
        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Gmail Title verification PASSED");
        }else{
            System.out.println("Gmail Title verification FAILED");
        }


        //5- Go back to Google by using the .back();
        driver.navigate().back();

        Thread.sleep(2000);

        //6- Verify title equals:
        // Expected: Google

        expectedTitle = "Google";
        actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Google title verification PASSED");
        }else{
            System.out.println("Google title verification FAILED");
        }

        driver.close();















    }
















}
