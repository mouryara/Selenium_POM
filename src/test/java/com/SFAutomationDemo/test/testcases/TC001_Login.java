package com.SFAutomationDemo.test.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.*;

import com.SFAutomationDemo.test.common.CommonFunction;
import com.SFAutomationDemo.test.pages.LoginPage;
import com.SFAutomationDemo.test.pages.MyAccountPage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Salesforce Automation demo exercise.
 */
public class TC001_Login {

    WebDriver driver;
    // HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    CommonFunction commonFunction;

    //public static final By signOutButton = By.linkText("Sign out");
    //private String userName = "Ramesh Mourya";

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {

        commonFunction = new CommonFunction(driver);
        loginPage = commonFunction.clickSignInButton();
        //myAccountPage = loginPage.successFulLogin();
        DOMConfigurator.configure("src/test/log4j.xml");
    }

    /**
     * Methods which will be used repeatedly should be in BeforeMethod annotation.
     */

    /*@BeforeMethod
    public void naviagtionSetUp(){
        myAccountPage = loginPage.successFulLogin();
    }*/
    @Test(priority = 0)
    public void successFulLogin() {

        try {
            myAccountPage = loginPage.successFulLogin(); //successFulLogin is returning myAccount page so we assign it in myAccountPage so that we can use it in next function.
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*myAccountPage.checkMyAccountPageExistence();
        assertTrue(myAccountPage.isMyAccountPagePresent(), "Login is unsuccessful.");
        */

        if (myAccountPage.checkMyAccountPageExistence1()== true){
            assertTrue(myAccountPage.isMyAccountPagePresent(), "Login is successful.");

        } else{
            assertFalse(myAccountPage.isMyAccountPagePresent(), "Login is unsuccessful");
        }

    }

    @Test(priority = 2, enabled = false)
    public void failedLogin() throws IOException {

        // myAccountPage.checkMyAccountPageExistence();
        // myAccountPage.checkMyAccount();
        if (myAccountPage.isMyAccountPagePresent() == false) {
            //   if (myAccountPage.checkMyAccountPageExistence()) {
            //loginPage.waitForLoginPage();
            loginPage.failedLoginCases();
        } else {
            myAccountPage.clickSignOutButton();
            loginPage.failedLoginCases();
        }
    }

    /*@Test(priority = 1, dependsOnMethods = {"successFulLogin"} )
    public void verifyUserName(){
       // myAccountPage.getuserName();
        //assertEquals(userName, myAccountPage.getuserName());
        assertEquals( myAccountPage.userNameValue, myAccountPage.getuserName(), "User name value do not match.Please check test again." );
        // Can be writtten as with assertion
        //assertEquals(userName, myAccountPage.getuserName(),"" );

    }*/


    @AfterClass
    public void tearDown() {
        commonFunction.closeDriver();
        System.out.println("Driver closed");
    }

}
