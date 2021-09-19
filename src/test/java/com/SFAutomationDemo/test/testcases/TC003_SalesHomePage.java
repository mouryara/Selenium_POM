package com.SFAutomationDemo.test.testcases;

import com.SFAutomationDemo.test.common.CommonFunction;
import com.SFAutomationDemo.test.pages.CreateOpptyPage;
import com.SFAutomationDemo.test.pages.HomePage;
import com.SFAutomationDemo.test.pages.LoginPage;
import com.SFAutomationDemo.test.pages.SalesHomePage;

//import jdk.internal.org.jline.utils.Log;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
//import com.SFAutomationDemo.test.common.*;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Author: Ramesh Mourya 
 * Description: Verify sales Home page and navigate to Opportunity page.
 */


public class TC003_SalesHomePage {
    WebDriver driver;
    private static Logger log = Logger.getLogger(TC003_SalesHomePage.class.getName());
    HomePage home = new HomePage(driver);
    HomePage homePage;
    SalesHomePage salesHmPg; 
    CreateOpptyPage createOppty;
    
    
    LoginPage loginPage;
    CommonFunction commonFunction;

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {

        commonFunction = new CommonFunction(driver);
        loginPage = commonFunction.clickSignInButton();
        home=loginPage.successFulLogin();
        home.launchAppMenu();
        Thread.sleep(5000);
        home.launchApp();
        Thread.sleep(5000);
        salesHmPg=home.launchSalesApp();  
        
        
        DOMConfigurator.configure("src/test/log4j.xml");
    }


    @Test(priority = 1)
    public void VerifySalesHomePage() throws InterruptedException, IOException 
    {
    	salesHmPg.isSalesHomePagePresent();
    	assertTrue(commonFunction.isElementPresent(salesHmPg.salesHm));
    	salesHmPg.isHomeOptionPresent();
    	assertTrue(commonFunction.isElementPresent(salesHmPg.sHome));
    	salesHmPg.isQtrlyGraphPresent();    	
    	assertTrue(commonFunction.isElementPresent(salesHmPg.sQtrlyGraph));
    	log.info("Sales Home page is displayed, Home and Quarterly Graph visible");
    	

    }

    @Test(priority = 2)
    public void OpenOpportunitiesPage() throws InterruptedException, IOException 
    {
    	log.info("Clicking on Opportunity option from Menu");
    	assertTrue(commonFunction.isElementPresent(salesHmPg.opptyMenuOption));
    	createOppty=salesHmPg.NavigatetoOpptyPage();
    	Thread.sleep(5000);
    	assertTrue(commonFunction.isElementPresent(salesHmPg.opptyPgRecentlyViewed));
    	log.info("Opportunity Page Opens successfully");
    }

    @Test(priority = 3)
    public void CreateOppty() throws InterruptedException, IOException 
    {
    	
    	assertTrue(salesHmPg.verifyNewBtnExists());
    	log.info("New Oppty Button present on the page");
    	Thread.sleep(5000);
    	salesHmPg.NewOpptyBtnClick();
    	Thread.sleep(5000);
    	assertTrue(commonFunction.isElementPresent(salesHmPg.FormTitle));
    	log.info("New Button clicked and record type selection form opens");
    	
    	log.info("Selecting the Oppty record type after toggling it");
    	//salesHmPg.recordtypeToggle();
    	salesHmPg.recTypeSelect();
        Thread.sleep(5000);
        salesHmPg.fillOpptyData();
    	Thread.sleep(5000);
    	salesHmPg.createOppty();
    	Thread.sleep(5000);
    	String name = salesHmPg.verifyCreatedOppty();
    	if(name==salesHmPg.oOpptyName)
    	{
    		log.info("Opportunity is successfully created and opened on the page: "+name);;
    	}
    	else
    	{
    		log.info("There is a problem with the Opportunity creation: "+name);;
        		
    	}
    	
    }
    
    
    
    @AfterClass
    public void tearDown() {
        commonFunction.closeDriver();
    }

}
