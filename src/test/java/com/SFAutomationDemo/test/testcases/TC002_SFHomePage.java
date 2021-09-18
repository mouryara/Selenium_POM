package com.SFAutomationDemo.test.testcases;

import com.SFAutomationDemo.test.common.CommonFunction;
import com.SFAutomationDemo.test.pages.LoginPage;
import com.SFAutomationDemo.test.pages.SalesHomePage;
import com.SFAutomationDemo.test.pages.HomePage;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

import org.apache.log4j.Logger;

import java.io.IOException;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.*;

/**
 * Author: Ramesh Mourya.
 * Test Description: Launching Sales Application from Application Launcher
 */
public class TC002_SFHomePage {

    private static Logger log = Logger.getLogger(TC002_SFHomePage.class.getName());

    WebDriver driver ;
    HomePage home;
    CommonFunction commonFunction;
    LoginPage loginPage;
    SalesHomePage salesHomePage;
    
    
    @BeforeClass
    public void setUp() throws IOException, InterruptedException{
        DOMConfigurator.configure( "src/test/log4j.xml" );
        commonFunction = new CommonFunction(driver);
        log.info( "TC for Launching Sales Application started" );
        loginPage = commonFunction.clickSignInButton();
        
        home = loginPage.successFulLogin();
        
    }

     //This method will click on Sign in button on login page.
    @Test
    public void clicksfHmPgLaunchApp() throws InterruptedException, IOException {
        
        home.waitForSFHomePageToLoad();
        home.checkSFHomePageExistence();
        
        log.info("Starting to Launch Sales App");
        
        home.launchAppMenu();
        Thread.sleep(5000);
        assertTrue(commonFunction.isElementPresent(HomePage.sfhmViewAlloption));
        log.info("App Menu expanded and View All option visible");
        home.launchApp();
        Thread.sleep(5000);
        assertTrue(commonFunction.isElementPresent(HomePage.sfAppLauncher));
        log.info("App Selection displayed");
        
        salesHomePage = home.launchSalesApp();
        
        assertTrue(commonFunction.isElementPresent(HomePage.sfSalesAppTitle));
        log.info("user is being taken to Sales App Home page");   
    }

     @AfterClass
    public void tearDown(){
         commonFunction.closeDriver();
        }
    }


