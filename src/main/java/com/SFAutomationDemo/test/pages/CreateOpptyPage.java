package com.SFAutomationDemo.test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Random;

import com.SFAutomationDemo.test.common.CommonFunction;

import java.io.IOException;

/**
 * Author: Ramesh Mourya
 * Description: This class will store Locators and methods for Opportunity creation.
 */
public class CreateOpptyPage extends CommonFunction{
    
    public CreateOpptyPage(WebDriver driver) {
        super(driver);
        
    }

    static Logger log = Logger.getLogger( CreateOpptyPage.class.getName() );
    
  /*
   * Locators for opening of the Opportunity option from menu, 
   * verifying the oppty home and New Button for Oppty creation
   * RecordType selection popup
  */
    
     
    private static final By opptyPageLabel=By.xpath("//span[@class='slds-var-p-right_x-small']");
    public static final By NewOpptyBtn=By.xpath("//*[@id=\"brandBand_1\"]/div/div/div/div/div[1]/div[1]/div[2]/ul/li/a/div");
    
    //Locator for Record type selection popup
    private static final By recordtypeselection=By.xpath("//*[@id=\"content_1615:0\"]/div/div");
    
    // radio button for recordtype Onboarding
    private static final By obRecType=By.xpath("//*[@id=\"content_3289:0\"]/div/div/div[1]/div/div/div[1]/fieldset/div[1]/div[1]/label/div[1]/span");
    
    private static final By TestRecType=By.xpath("//*[@id=\"content_3289:0\"]/div/div/div[1]/div/div/div[1]/fieldset/div[1]/div[3]/label/div[1]/span");
    
    //Locator for Next, Cancel button and Close icon on RecordType popup
    private static final By NextBtn=By.xpath("//*[@id=\"content_1615:0\"]/div/div/div[2]/div/button[2]/span");
    private static final By CancelBtn=By.xpath("//*[@id=\"content_1615:0\"]/div/div/div[2]/div/button[1]/span");
    private static final By Closeicon=By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div/div[1]/button");
    
    //Locator for Opportunity form
    
    private static final By FormTitle = By.xpath("//*[@id=\"content_1615:0\"]/div/div/div[1]/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/h3/span");
    private static final By opptyOwner = By.xpath("//*[@id=\"sectionContent-188\"]/div/slot/force-record-layout-row[1]/slot/force-record-layout-item[1]/div/div/div[2]/span/slot[1]/slot/force-owner-lookup/div/span/force-lookup/div/span");
    private static final By opptyamount = By.xpath("//*[@id=\"input-195\"]");
    private static final By CloseDate = By.xpath("//*[@id=\"input-202\"]");
    private static final By OpptyName = By.xpath("//*[@id=\"input-208\"]");
    private static final By AcctName = By.xpath("//*[@id=\"input-287\"]");
    private static final By OpptyStage = By.xpath("//*[@id=\"input-221\"]");
    private static final By OpptyType = By.xpath("//input[@id='input-230']");
    private static final By OpptyLeadSource = By.xpath("//input[@id='input-241']");
    private static final By OpptyProbability = By.xpath("//input[@id='input-234']");
    private static final By OpptySavebtn = By.xpath("//*[@id=\"content_1615:0\"]/div/div/div[1]/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/force-form-footer/div/div/div/runtime_platform_actions-actions-ribbon/ul/li[3]/runtime_platform_actions-action-renderer/runtime_platform_actions-executor-lwc-headless/slot[1]/slot/lightning-button/button");
    private static final By OpptyCancelbtn = By.xpath("//*[@id=\"content_1615:0\"]/div/div/div[1]/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/force-form-footer/div/div/div/runtime_platform_actions-actions-ribbon/ul/li[1]/runtime_platform_actions-action-renderer/runtime_platform_actions-executor-lwc-headless/slot[1]/slot/lightning-button/button");
    private static final By OpptySaveandNewbtn = By.xpath("//*[@id=\"content_1615:0\"]/div/div/div[1]/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/force-form-footer/div/div/div/runtime_platform_actions-actions-ribbon/ul/li[2]/runtime_platform_actions-action-renderer/runtime_platform_actions-executor-lwc-headless/slot[1]/slot/lightning-button/button");
    private static final By Opptycloseicon = By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div/div[1]/button/lightning-primitive-icon/svg");
    
    // Locator for Opportunity Name after creation
    private static final By OpptyNameLabel = By.xpath("//*[@id=\"brandBand_2\"]/div/div/div[3]/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___sfa__-opportunity_rec_-l___-opportunity___-v-i-e-w/forcegenerated-flexipage_opportunity_rec_l_opportunity__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[1]/slot/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_opportunity___0125f0000008sk6aai___compact___view___recordlayout2/force-highlights2/div[1]/div[1]/div[1]/div[2]/h1/slot/slot/lightning-formatted-text");
    
    //Data for opportunity creation
    private String oAmount="4220";
    Random rnd=new Random();
    private int cnt=rnd.nextInt(1000);
    public String oOpptyName="TestOppty"+cnt; 
    private String ClDateValue = "11/25/2021";
    private String oAcctName="Test Account";
    private String oStage="Prospect";
    private String oType="New Customer";
    private String oLeadSrc="Web";
    private String oProbability="10";
    
    
    //method for filling the Opportunity data
    public void fillOpptyData()
    {
    	log.info( "Opportunity data entries started" );
    	fillValuesInTextBox(opptyamount,oAmount);
    	fillValuesInTextBox(OpptyName,oOpptyName);
    	fillValuesInTextBox(CloseDate,ClDateValue);
    	fillValuesInTextBox(OpptyStage,oStage);
    	fillValuesInTextBox(OpptyType,oType);
    	fillValuesInTextBox(OpptyLeadSource,oLeadSrc);
    	fillValuesInTextBox(OpptyProbability,oProbability);   	
    	log.info( "Opportunity data entries Completed" );
    }
    
    public boolean isCreateOpptyPopupPresent(){
        log.info( "Checking if Create Opportunity Popup is present." );
        return checkPageExistence(FormTitle);
    }
    
   public void recordtypeToggle()
   {
	   log.info("Toggle of selection of Record type");
	   
	   if(getWebElement(obRecType).isSelected()==true)
	   {
		   selectRadioButton(TestRecType);
		   selectRadioButton(obRecType);
	   }
	   else
	   {
		   selectRadioButton(obRecType);
	   }
	   clickOnLocator(NextBtn);
	}
   
   public boolean verifyNewBtnExists()
   {
	   log.info("Verifying the presence of New Oportunity button");
	   return checkPageExistence(NewOpptyBtn);
   }
       
   public void createOppty()
   {
	   clickOnLocator(OpptySavebtn);
	   
   }

   public String verifyCreatedOppty() 
   {
	   String opptyNm = getWebElement(OpptyNameLabel).getText();
	   //return checkPageExistence(OpptyNameLabel);
	   return opptyNm;
   }


}

