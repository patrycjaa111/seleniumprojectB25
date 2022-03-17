package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {

    // 1. Initialize the driver instance and object of the class
    public LibraryLoginPage(){
/*
initElements method will create connection in between the current driver session (instance)
and the object of the current class
 */
        PageFactory.initElements(Driver.getDriver(), this);
        //                     (creating new session id, and pass it to this object...this => represent the object of the class
        // object is caring the driver instance and have to control over the obj
        //    libraryLoginPage = new LibraryLoginPage()
    }

    // 2. Use @FindBy annotation to locate web elements
    @FindBy(xpath = "//input[@id='inputEmail']")
    public WebElement inputUsername;

    @FindBy(id = "inputPassword")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[@id='inputEmail-error']")
    public WebElement fieldRequiredErrorMessage;

    @FindBy(xpath = "//div[.='Please enter a valid email address.']/div")
    public WebElement enterValidEmailErrorMessage;

    @FindBy(xpath = "//div[.='Sorry, Wrong Email or Password']")
    public WebElement wrongEmailOrPasswordErrorMessage;






}
