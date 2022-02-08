package com.cydeo.tests.practiceTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2_ZeroBankHeaderVerification {

//    TC #2: Zero Bank header verification


    public static void main(String[] args) {


        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //2. Go to http://zero.webappsecurity.com/login.html
        driver.navigate().to("http://zero.webappsecurity.com/login.html");

        //3. Verify header text
        // Expected: “Log in to ZeroBank”

        WebElement header = driver.findElement(By.tagName("h3"));
        String expectedHeaderText = "Log in to ZeroBank";
        String actualHeaderText = header.getText();

        if(actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Header verification PASSED");
        }else{
            System.out.println("Header verification FAILED");
        }

        driver.close();

    }













}
