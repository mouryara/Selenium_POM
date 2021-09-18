package com.SFAutomationDemo.test.pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import com.SFAutomationDemo.test.common.CommonFunction;

/**
 * Author: Ramesh Mourya
 * This class will store all locator & methods of SF home page
 */
public class HomePage extends CommonFunction
{
    //WebDriver driver;
    public HomePage(WebDriver driver)
    {
        super(driver);
    }
    //public static final By selectSignIn=By.xpath(".//*[@class='login']");
    static Logger log = Logger.getLogger(HomePage.class.getName());
    

    private static final By sfAPPlauncherIcon=By.xpath("//div[@class='slds-icon-waffle']");
       
       //to check for the expanded menu
       private static final By sfMenuExpand=By.xpath("//div[@role='combobox']"); 
       
       // for ViewAll option
       public static final By sfhmViewAlloption=By.xpath("//button[normalize-space()='View All']");
       
       // for Tools selection popup title for presence of the launcher
       public static final By sfAppLauncher=By.xpath("//h2[normalize-space()='App Launcher']");
       
       // Sales Option icon and Label
       public static final By sfSalesApp=By.xpath("//one-app-launcher-app-tile[8]//div[1]//div[1]//lightning-avatar[1]//img[1]");
       public static final By sfSalesAppTitle=By.xpath("//p[normalize-space()='Sales']");
       
       
       public boolean isSFHomePagePresent() 
       {
            return checkPageExistence(sfAPPlauncherIcon);
       }
       
       public void waitForSFHomePageToLoad() {
           waitForElementToBeVisible(sfAPPlauncherIcon);
           
           log.info("Waiting for SF Home page to load.");
       }

       
       public boolean checkSFHomePageExistence() {
           
           checkPageExistence(sfAPPlauncherIcon);
           log.info("Checking if SF Home page is present after login.");
           return checkPageExistence(sfAPPlauncherIcon);
       }
       
       public void launchAppMenu() throws IOException
       {
    	   clickOnLocator(sfAPPlauncherIcon);
    	   log.info("Salesforce App launcher icon clicked.");
           //return new HomePage(getDriver());      	
       }

       public void  launchApp() throws IOException
       {
    	   clickOnLocator(sfhmViewAlloption);
    	   
    	   log.info("Salesforce App launcher icon clicked.");
           
    	   //return new HomePage(getDriver());      	
       }
       
       public SalesHomePage launchSalesApp() throws IOException
       {
    	   checkPageExistence(sfSalesAppTitle);
    	   checkPageExistence(sfSalesApp);
    	   log.info("Sales Option and icon is present of App Launcher");
    	   
    	   clickOnLocator(sfSalesApp);
    	   
    	   log.info("Sales option clicked.");
           
    	   return new SalesHomePage(driver);      	
       }


       

}
