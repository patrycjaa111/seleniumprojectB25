package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    Creating a private constructor so we are closing access to the object of this class from outside the class
     */
    private Driver(){

    }

    /*
     We make WebDriver private bc we want to close access form outside of the class
     We make it static bc we will use it in a static method
     */
    private static WebDriver driver;

    /*
    Creating a reusable utility method which will return same driver instance when we call it
     */
    public static WebDriver getDriver(){

        if (driver == null){

            /*
            We read our browser type from configuration.properties
            This way we can control which browser is opened from outside our code from configuration.properties
             */
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on the browserType that will return from configuration.properties file
            switch statement will determine the case, and open the matching browser
             */
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();         // comming from bonigarcia dependency
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }

        }

        return driver;
    }


    /*
    This method will ensure our driver value is always null after using quit() method... so we do not get nosuchsessionexception
     */

    public static void closeDriver(){
        if (driver != null){
            driver.quit();  // this line will terminate the existing session. value will not even be null
            driver = null; // so we set it to null so we can call another test and get the browser and the getDriver method will set it and not show the exception
        }
    }






}
