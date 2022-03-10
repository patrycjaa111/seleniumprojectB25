package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_locators_getText {

    public static void main(String[] args) {


//        TC #1: NextBaseCRM, locators and getText() practice
        //1- Open a chrome browser
    //    WebDriverManager.chromedriver().setup();
    //    WebDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverFactory.getDriver("firefox");       // this line has the method coming from WebDriverFactory utilities package we created

        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Enter incorrect username: “incorrect”         //first must locate the webElement
       WebElement inputUsername = driver.findElement(By.className("login-inp"));
       inputUsername.sendKeys("incorrect");
    //    driver.findElement(By.className("login-inp")).sendKeys("incorrect"); //disadvantage for writing this line like this --> we can not reuse it!


        //4- Enter incorrect password: “incorrect”
        // alt+enter --> to autogenerate local varibale
        WebElement inputPassword = driver.findElement(By.name("USER_PASSWORD"));
        inputPassword.sendKeys("incorrect");  // we are doing negative test scenarios --> so we do not want to actually login
        // you can type anything in the perenthesis above insred of incorrect


        //5- Click to login button.
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();


        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        WebElement errorMessage = driver.findElement(By.className("errortext"));

        String expectedErrorMessage = "Incorrect login or password";
        String actualErrorMessage = errorMessage.getText();

        if(actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("Error message verification PASSED");
        }else{
            System.out.println("Error message verification FAILED");
        }

        //PS: Inspect and decide which locator you should be using to locate web elements.


        driver.close();






















    }









}
