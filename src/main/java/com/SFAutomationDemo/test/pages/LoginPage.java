package com.SFAutomationDemo.test.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.SFAutomationDemo.test.common.CommonFunction;

import java.io.IOException;

/**
 * Author: Ramesh Mourya
 * This class will store all locator & methods of Sales force Login page
 */
public class LoginPage extends CommonFunction {

    //WebDriver driver;

    public LoginPage(WebDriver driver) throws IOException {
        super(driver);
        //this.driver = driver;
    }

    /*
    All locator will be defined underneath.
     */
    static Logger log = Logger.getLogger(CreateOpptyPage.class.getName());
    private static final By userName = By.xpath(".//*[@id='username']");
    private static final By password = By.xpath(".//*[@id='password']");
    private static final By LoginBtn = By.xpath(".//*[@id='Login']");


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
//    public MyAccountPage successFulLogin() throws IOException {
//        fillValuesInTextBox(userName, validUserName);
//        fillValuesInTextBox(password, validPassword);
//        clickOnLocator(signInButton);
//        log.info("Verify login functionality with valid username & password.");
//        return new MyAccountPage(driver);
//    }

    public HomePage successFulLogin() throws IOException {
        fillValuesInTextBox(userName, validUserName);
        fillValuesInTextBox(password, validPassword);
        clickOnLocator(LoginBtn);
        log.info("Verify login functionality with valid username & password.");
        return new HomePage(driver);
    }
    
    /*
    This function is to test failed login scenarios & check error messages.
     */
    
    public void failedLoginInvalidUserValidPassword() {

        fillValuesInTextBox(userName, invalidUserName);
        fillValuesInTextBox(password, validPassword);
        clickOnLocator(LoginBtn);
        log.info("Verify login functionality with invalid username & valid password");
    }
    

    /*
   This function is to test failed login scenarios & check error messages.
    */
    public void failedLoginInvalidUserInvalidPassword() {
        fillValuesInTextBox(userName, invalidUserName);
        fillValuesInTextBox(password, invalidPassword);
        clickOnLocator(LoginBtn);
        log.info("Verify login functionality with invalid username & invalid password");

    }



    /*
   This function is to test failed login scenarios & check error messages.
    */
    public void failedLoginValidUserInvalidPassword() {
        fillValuesInTextBox(userName, invalidUserName);
        fillValuesInTextBox(password, validPassword);
        clickOnLocator(LoginBtn);
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


