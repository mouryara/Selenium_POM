package com.SFAutomationDemo.test.pages;

import java.io.IOException;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.SFAutomationDemo.test.common.CommonFunction;

/**
 * Author: Ramesh Mourya 
 * Description: This class will store all the locators on Sales App Home page and required methods.
 */

public class SalesHomePage extends CommonFunction{

	   
    public SalesHomePage(WebDriver driver)
    {
        super(driver);
    }
	
    static Logger log = Logger.getLogger(SalesHomePage.class.getName());
    
    public static final By salesHm=By.xpath("//span[@title='Sales']");
    public static final By sHome=By.xpath("//span[normalize-space()='Home']");
    public static final By sQtrlyGraph=By.xpath("//span[@title='Quarterly Performance']");
    public static final By opptyMenuOption=By.xpath("//span[@class='slds-truncate'][normalize-space()='Opportunities']");
    
    //public static final By opptyMenuOption=By.cssSelector("a[title='Opportunities'] span[class='slds-truncate']");
    public static final By opptyPgRecentlyViewed=By.xpath("//*[@id=\"brandBand_1\"]/div/div/div/div/div[1]/div[1]/div[1]/div/div/div/div/div/div[1]/h1/span[2]");
    
    public CreateOpptyPage NavigatetoOpptyPage() throws IOException
    {
    	log.info("Navigating to Opportunity Page");
    	
    	//clickOnLocator(opptyMenuOption);
    	((JavascriptExecutor) driver).executeScript(
    		    "arguments[0].click();",
    		    driver.findElement(opptyMenuOption)
    		);
    	
    	log.info("Oppotunities option clicked from Sales Menu.");
    	return new CreateOpptyPage(driver);
    }
    
    public boolean isSalesHomePagePresent() 
    {
         return checkPageExistence(salesHm);
    }
    
    public boolean isHomeOptionPresent() 
    {
         return checkPageExistence(sHome);
    }
    
    public boolean isQtrlyGraphPresent() 
    {
         return checkPageExistence(sQtrlyGraph);
    }
    
}
