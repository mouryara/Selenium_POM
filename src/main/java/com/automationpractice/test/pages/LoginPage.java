package com.automationpractice.test.pages;


import com.automationpractice.test.common.CommanFunction;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by neeraj.bhatnagar on 11/23/2016.
 */
public class LoginPage extends CommanFunction {

    //WebDriver driver;

    public LoginPage(WebDriver driver) throws IOException {
        super(driver);
        //this.driver = driver;
    }

    /*
    All locator will be defined underneath.
     */
    static Logger log = Logger.getLogger(CreateAccountPage.class.getName());
    //private static final By selectCreateAccount = By.xpath(".//*[@id='username']");
    //private static final By provideEmailToCreateAccount = By.xpath(".//*[@id='email_create']");
    private static final By userName = By.xpath(".//*[@id='username']");
    private static final By password = By.xpath(".//*[@id='password']");
    private static final By signInButton = By.xpath(".//*[@id='Login']");


    /*
    All variables will be defined here. These variables are defined in config.properties file & called by getConfigFileData method from CommanFunction page.
     */
    private String validUserName = getConfigFileData("validUserName");
    private String invalidUserName = getConfigFileData("invalidUserName");
    private String validPassword = getConfigFileData("validPassword");
    private String invalidPassword = getConfigFileData("invalidPassword");

 

    /*
    This function will enter correct user name & password & logs into application successfully.
     */
    public MyAccountPage successFulLogin() throws IOException {
        fillValuesInTextBox(userName, validUserName);
        fillValuesInTextBox(password, validPassword);
        clickOnLocator(signInButton);
        log.info("Verify login functionality with valid username & password.");
        return new MyAccountPage(driver);
    }

    /*
    This function is to test failed login scenarios & check error messages.
     */
    
    public void failedLoginInvalidUserValidPassword() {

        fillValuesInTextBox(userName, invalidUserName);
        fillValuesInTextBox(password, validPassword);
        clickOnLocator(signInButton);
        log.info("Verify login functionality with invalid username & valid password");
    }
    

    /*
   This function is to test failed login scenarios & check error messages.
    */
    public void failedLoginInvalidUserInvalidPassword() {
        fillValuesInTextBox(userName, invalidUserName);
        fillValuesInTextBox(password, invalidPassword);
        clickOnLocator(signInButton);
        log.info("Verify login functionality with invalid username & invalid password");

    }



    /*
   This function is to test failed login scenarios & check error messages.
    */
    public void failedLoginValidUserInvalidPassword() {
        fillValuesInTextBox(userName, invalidUserName);
        fillValuesInTextBox(password, validPassword);
        clickOnLocator(signInButton);
        log.info("Verify login functionality with invalid username & valid password");


    }

    /*
    This function (clickCreateAccountButton) will click on Create an account button on loginPage after enetring email. This function returns refernce
     of CreateAccountPage where user can fill registration form & create new user.
     **********************************************
     This code can also be written as.

     WebElement element = driver.findElement(selectCreateAccount);
        element.click();
        return new CreateAccountPage(getDriver());

       ***********************************************************
     */

 


    /**
     * This method contains failed login scenarios.
     */
    public boolean failedLoginCases() {

        boolean isSuccess = true;

        try {
            log.info("Test Cases for failed login scenarios started.");
            failedLoginInvalidUserInvalidPassword();
            //assertTrue(loginPage.wrongPasswordErrorVerification());
            failedLoginInvalidUserValidPassword();
            failedLoginValidUserInvalidPassword();

        } catch (Exception e) {

            isSuccess = false;
        }
        return isSuccess;
    }


}


