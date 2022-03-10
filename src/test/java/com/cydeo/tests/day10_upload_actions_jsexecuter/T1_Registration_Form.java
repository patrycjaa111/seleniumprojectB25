package com.cydeo.tests.day10_upload_actions_jsexecuter;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class T1_Registration_Form {


    @Test
    public void registration_form_test() {

        //1. Open browser
        //2. Go to website:https://practice.cydeo.com/registration_form
      //  Driver.getDriver() ==> driver.get(url)
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        // ** Create a JavaFaker object --> so we can generate a random names
        Faker faker = new Faker();

        //3. Enter first name
        WebElement inputFirstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        String fakerFirstName = faker.name().firstName();
        inputFirstName.sendKeys(fakerFirstName);

        //4. Enter last name
        WebElement inputLastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        inputLastName.sendKeys(faker.name().lastName());

        //5. Enter username
        WebElement inputUsername = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        String user = faker.bothify("helpdesk###");

        inputUsername.sendKeys(user);

        //6. Enter email address
        WebElement inputEmail = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        inputEmail.sendKeys(user+"@email.com");

        //7. Enter password
        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        //inputPassword.sendKeys(faker.bothify("????##??#"));
        inputPassword.sendKeys(faker.internet().password());

        //8. Enter phone number
        WebElement inputPhoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        inputPhoneNumber.sendKeys(faker.numerify("###-###-####"));

        //9. Select a gender from radio buttons
        WebElement inputGender = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        inputGender.click();

        //10.Enter date of birth
        WebElement inputBirthday = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        inputBirthday.sendKeys("03/08/2000");
                // faker.number().numberBetween(1,12);

        //11.Select Department/Office
        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByIndex(faker.number().numberBetween(1,9));  // every time it will generate an integer between 1 to 9, and it will return different select dropdown

        //12.Select Job Title
        Select jobTitleDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
       // jobTitleDropdown.selectByIndex(faker.number().numberBetween());


        //13.Select programming language from checkboxes


        //14.Click to sign up button


        //15.Verify success message “You’ve successfully completed registration.” is
        //displayed.





    }

}
