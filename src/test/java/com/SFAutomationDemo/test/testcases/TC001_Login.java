package com.SFAutomationDemo.test.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.*;

import com.SFAutomationDemo.test.common.CommonFunction;
import com.SFAutomationDemo.test.pages.LoginPage;
import com.SFAutomationDemo.test.pages.HomePage;
//import com.SFAutomationDemo.test.pages.sfHomePage;

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
    HomePage sfHomePage;
    CommonFunction commonFunction;

    //public static final By signOutButton = By.linkText("Sign out");
    //private String userName = "Ramesh Mourya";

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {

        commonFunction = new CommonFunction(driver);
        loginPage = commonFunction.clickSignInButton();
        //sfHomePage = loginPage.successFulLogin();
        DOMConfigurator.configure("src/test/log4j.xml");
    }

    /**
     * Methods which will be used repeatedly should be in BeforeMethod annotation.
     */

    /*@BeforeMethod
    public void naviagtionSetUp(){
        sfHomePage = loginPage.successFulLogin();
    }*/
    @Test(priority = 0)
    public void successFulLogin() {

        try {
            sfHomePage = loginPage.successFulLogin(); //successFulLogin is returning myAccount page so we assign it in sfHomePage so that we can use it in next function.
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*sfHomePage.checksfHomePageExistence();
        assertTrue(sfHomePage.issfHomePagePresent(), "Login is unsuccessful.");
        */

        if (sfHomePage.checkSFHomePageExistence()== true){
            assertTrue(sfHomePage.isSFHomePagePresent(), "Login is successful.");

        } else{
            assertFalse(sfHomePage.isSFHomePagePresent(), "Login is unsuccessful");
        }

    }

    @Test(priority = 2, enabled = false)
    public void failedLogin() throws IOException {

        // sfHomePage.checksfHomePageExistence();
        // sfHomePage.checkMyAccount();
        if (sfHomePage.isSFHomePagePresent() == false) {
            //   if (sfHomePage.checksfHomePageExistence()) {
            //loginPage.waitForLoginPage();
            loginPage.failedLoginCases();
        } else {
            //sfHomePage.clickSignOutButton();
            loginPage.failedLoginCases();
        }
    }

    /*@Test(priority = 1, dependsOnMethods = {"successFulLogin"} )
    public void verifyUserName(){
       // sfHomePage.getuserName();
        //assertEquals(userName, sfHomePage.getuserName());
        assertEquals( sfHomePage.userNameValue, sfHomePage.getuserName(), "User name value do not match.Please check test again." );
        // Can be writtten as with assertion
        //assertEquals(userName, sfHomePage.getuserName(),"" );

    }*/


    @AfterClass
    public void tearDown() {
        commonFunction.closeDriver();
        System.out.println("Driver closed");
    }

}
