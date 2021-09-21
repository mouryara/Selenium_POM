package com.SFAutomationDemo.test.testcases;

import com.SFAutomationDemo.test.common.CommonFunction;
import com.SFAutomationDemo.test.pages.CreateOpptyPage;
import com.SFAutomationDemo.test.pages.LoginPage;
import com.SFAutomationDemo.test.pages.HomePage;
import com.SFAutomationDemo.test.pages.SalesHomePage;


import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 *Author: Ramesh Mourya 
 * Description: This test case is for opportunity creation.
 */
public class TC004_CreateOppty {

    WebDriver driver;
    HomePage homePage;
    HomePage home = new HomePage(driver);
    LoginPage loginPage;
    SalesHomePage salesHomePage;
    CommonFunction commonFunction;
    SalesHomePage shpg= new SalesHomePage(driver);
    //CreateOpptyPage createOpptyPage =new CreateOpptyPage(driver);
    CreateOpptyPage createOppty;
    
    private static Logger log = Logger.getLogger(TC004_CreateOppty.class.getName());
    
    @BeforeClass
    public void setUp() throws IOException, InterruptedException {

        commonFunction = new CommonFunction(driver);
        loginPage = commonFunction.clickLoginButton();
        home=loginPage.successFulLogin();
        home.launchAppMenu();
        Thread.sleep(5000);
        home.launchApp();
        Thread.sleep(5000);
        shpg=home.launchSalesApp();
        log.info("User moved to Sales Home page and now ready for accessing the Oppty page");

		assertTrue(shpg.isOpportunityMenuOptionVisible());
		log.info("Oppoirtunity Menu option found");
        createOppty=shpg.NavigatetoOpptyPage();
        log.info("User Navigated to Opportunity page");
        DOMConfigurator.configure("src/test/log4j.xml");
    }

    @Test(priority = 1, enabled = true, description = "This test will verify and Click New button for Opportunity creation on Oppty page.")
    public void clickNewOpptyBtn() throws InterruptedException, IOException {
    	assertTrue(createOppty.verifyNewBtnExists());
    	log.info("New Oppty Button present on the page");
    	Thread.sleep(5000);
    	createOppty.NewOpptyBtnClick();
    	Thread.sleep(5000);
    	assertTrue(commonFunction.isElementPresent(createOppty.FormTitle));
    	log.info("New Button clicked and record type selection form opens");
    }

    @Test(priority = 2, enabled = true, description = "This test will select the opportunity record type. ")
    public void SelectRecordType() throws InterruptedException, IOException {
        log.info("Selecting the Oppty record type after toggling it");
        createOppty.recTypeSelect();
        Thread.sleep(5000);
        
    }

    @Test(priority = 3, enabled = true, description = "This test will submit the Opportunity  Popup. ")
    public void CreateOppty() throws InterruptedException, IOException 
    {
      	
    	createOppty.fillOpptyData();
    	Thread.sleep(5000);
    	createOppty.createOppty();
    	Thread.sleep(5000);
    	String name = createOppty.verifyCreatedOppty();
    	assertTrue(name.contains(createOppty.oOpptyName.toString().trim()));
    	
    }
    
    @AfterClass
    public void tearDown() {
        commonFunction.closeDriver();
        System.out.println("Driver closed");
    }
}
