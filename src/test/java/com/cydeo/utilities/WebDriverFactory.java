package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
/*
                  TASK: NEW METHOD CREATION
 Method name : getDriver
 Static method   --> it belong to the class --> no need to crete the object to use the method
 Accepts String arg: browserType
   - This arg will determine what type of browser is opened
   - if "chrome" passed --> it will open chrome browser
   - if "firefox" passed --> it will open firefox browser
 RETURN TYPE: "WebDriver"
 */

    public static WebDriver getDriver(String browserType) {

        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
           // WebDriver driver = new ChromeDriver();
           // driver.manage().window().maximize();

        }else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
           // WebDriver driver = new FirefoxDriver();
           // driver.manage().window().maximize();
        }else{
            System.out.println("Given browser type does not exist/or is not currently supported");
            System.out.println("Driver = null");
            return null;
        }


    }


}













