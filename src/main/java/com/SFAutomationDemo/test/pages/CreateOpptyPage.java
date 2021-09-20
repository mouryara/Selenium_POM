package com.SFAutomationDemo.test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

import com.SFAutomationDemo.test.common.CommonFunction;

import java.io.IOException;

/**
 * Author: Ramesh Mourya
 * Description: This class will store Locators and methods for Opportunity creation.
 */
public class CreateOpptyPage extends CommonFunction{
    
    public CreateOpptyPage(WebDriver driver) throws IOException {
        super(driver);
        
    }

    static Logger log = Logger.getLogger( CreateOpptyPage.class.getName() );    
    
    /*
     * Locators for opening of the Opportunity option from menu, 
     * verifying the oppty home and New Button for Oppty creation
     * RecordType selection popup
    */
      
       
      private static final By opptyPageLabel=By.xpath("//span[@class='slds-var-p-right_x-small']");
      //public static final By NewOpptyBtn=By.xpath("//div[@title='New']");
      
      public static final By NewOpptyBtn=By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/ul/li/a/div");
      
      //private static final By expandOpptyMenu=By.xpath("//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none slds-is-active']//a[@role='button']//lightning-primitive-icon//*[name()='svg']");
      private static final By expandOpptyMenu=By.xpath ("/html[1]/body[1]/div[4]/div[1]/section[1]/div[1]/div[1]/one-appnav[1]/div[1]/one-app-nav-bar[1]/nav[1]/div[1]/one-app-nav-bar-item-root[2]/one-app-nav-bar-item-dropdown[1]/div[1]/one-app-nav-bar-menu-button[1]/a[1]/lightning-icon[1]/lightning-primitive-icon[1]/*[name()='svg'][1]");
      private static final By NewOppty=By.xpath("//lightning-icon[@class='slds-icon-utility-add slds-icon-text-default slds-m-right--x-small slds-shrink-none slds-icon_container']//lightning-primitive-icon");
      
      //Locator for Record type selection popup
      private static final By recordtypeselection=By.xpath("//*[@id=\"content_1615:0\"]/div/div");
      
      // radio button for recordtype Onboarding
      private static final By obRecType=By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div/div[2]/div/div/div[1]/div/div/div[1]/fieldset/div[1]/div[1]/label/div[1]/span");
      
      private static final By TestRecType=By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div/div[2]/div/div/div[1]/div/div/div[1]/fieldset/div[1]/div[3]/label/div[1]/span");
      
      //Locator for Next, Cancel button and Close icon on RecordType popup
      //private static final By NextBtn=By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div/div[2]/div/div/div[2]/div/button[2]/span");
      private static final By NextBtn=By.xpath("//span[normalize-space()='Next']");
      
      private static final By CancelBtn=By.xpath("//*[@id=\"content_1615:0\"]/div/div/div[2]/div/button[1]/span");
      private static final By Closeicon=By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div/div[1]/button");
      
      //Locator for Opportunity form
      
      public final By FormTitle = By.xpath("//h2[normalize-space()='New Opportunity']");
      private static final By opptyOwner = By.xpath("//div[@class='test-id__field-label-container slds-form-element__label no-utility-icon']");
      private static final By opptyamount = By.xpath("//input[@name='Amount']");
      private static final By CloseDate = By.xpath("//input[@name='CloseDate']");
      private static final By OpptyName = By.xpath("//input[@name='Name']");
      private static final By AcctName = By.xpath("//input[@placeholder='Search Accounts...']");
      private static final By AcctNameSearch=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[4]/slot/force-record-layout-item[1]/div/span/slot/slot/force-record-layout-lookup/lightning-lookup/lightning-lookup-desktop/lightning-grouped-combobox/div[1]/div/lightning-base-combobox/div/div[2]");
      private static final By AcctNameFromResult=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[4]/slot/force-record-layout-item[1]/div/span/slot/slot/force-record-layout-lookup/lightning-lookup/lightning-lookup-desktop/lightning-grouped-combobox/div[1]/div/lightning-base-combobox/div/div[2]/ul/li");
      
      private static final By OpptyStage = By.xpath("//lightning-combobox[@class='slds-form-element slds-form-element_stacked']//input[@role='combobox']");
      //private static final By opptyStgList=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[4]/slot/force-record-layout-item[2]/div/span/slot/slot/sfa-input-stage-name/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div[1]/lightning-base-combobox/div/div[2]");
      //public static final By opptyStgList=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[4]/slot/force-record-layout-item[2]/div/span/slot/slot/sfa-input-stage-name/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[1]/input");
      public static final By opptyStgList=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[4]/slot/force-record-layout-item[2]/div/span/slot/slot/sfa-input-stage-name/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[2]");
      
      //private static final By stgListOptionProspect=By.xpath("//span[@title='Prospecting']");
      private static final By stgListOptionProspecting=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[4]/slot/force-record-layout-item[2]/div/span/slot/slot/sfa-input-stage-name/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[2]/span[2]/span");
      private static final By stgListOptionQualification=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[4]/slot/force-record-layout-item[2]/div/span/slot/slot/sfa-input-stage-name/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[3]/span[2]/span");
      private static final By stgListOptionNeedAnalysis=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[4]/slot/force-record-layout-item[2]/div/span/slot/slot/sfa-input-stage-name/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[4]/span[2]/span");
      private static final By stgListOptionValueProposition=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[4]/slot/force-record-layout-item[2]/div/span/slot/slot/sfa-input-stage-name/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[5]/span[2]/span");
      private static final By stgListOptionIdDecisionMakers=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[4]/slot/force-record-layout-item[2]/div/span/slot/slot/sfa-input-stage-name/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[6]/span[2]/span");
      private static final By stgListOptionPerceptionAnalysis=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[4]/slot/force-record-layout-item[2]/div/span/slot/slot/sfa-input-stage-name/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[7]/span[2]/span");
      private static final By stgListOptionProposalPriceQuote=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[4]/slot/force-record-layout-item[2]/div/span/slot/slot/sfa-input-stage-name/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[8]/span[2]/span");
      private static final By stgListOptionNegotiationReview=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[4]/slot/force-record-layout-item[2]/div/span/slot/slot/sfa-input-stage-name/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[9]/span[2]/span");
      private static final By stgListOptionClosedWon=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[4]/slot/force-record-layout-item[2]/div/span/slot/slot/sfa-input-stage-name/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[10]/span[2]/span");
      private static final By stgListOptionClosedLost=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[4]/slot/force-record-layout-item[2]/div/span/slot/slot/sfa-input-stage-name/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[11]/span[2]/span");
      
      
      private static final By OpptyType = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[5]/slot/force-record-layout-item[1]/div/span/slot/slot/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div[1]/lightning-base-combobox/div/div[1]/input");
      private static final By OpptyTypeList = By.xpath("//force-record-layout-row[5]//slot[1]//force-record-layout-item[1]//div[1]//span[1]//slot[1]//slot[1]//force-record-picklist[1]//force-form-picklist[1]//lightning-picklist[1]//lightning-combobox[1]//div[1]//lightning-base-combobox[1]//div[1]//div[2]");
      private static final By oTypeNewCustomer=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[5]/slot/force-record-layout-item[1]/div/span/slot/slot/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div[1]/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[5]");
      private static final By oTypeExistingCustomerUpgrade=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[5]/slot/force-record-layout-item[1]/div/span/slot/slot/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div[1]/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[2]/span[2]/span");
      private static final By oTypeExistingCustomerReplacement=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[5]/slot/force-record-layout-item[1]/div/span/slot/slot/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[3]/span[2]/span");
      private static final By oTypeExistingCustomerDowngrade=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[5]/slot/force-record-layout-item[1]/div/span/slot/slot/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[4]/span[2]/span");
      
                
      private static final By OpptyLeadSource = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[6]/slot/force-record-layout-item[1]/div/span/slot/slot/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[1]");
      private static final By opptyLeadSrcList = By.xpath("//force-record-layout-row[6]//slot[1]//force-record-layout-item[1]//div[1]//span[1]//slot[1]//slot[1]//force-record-picklist[1]//force-form-picklist[1]//lightning-picklist[1]//lightning-combobox[1]//div[1]//lightning-base-combobox[1]//div[1]//div[2]");
      private static final By opptyLeadSrcValOther= By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[6]/slot/force-record-layout-item[1]/div/span/slot/slot/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[6]/span[2]/span");
      private static final By opptyLeadSrcValWeb=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[6]/slot/force-record-layout-item[1]/div/span/slot/slot/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[2]/span[2]/span");
      private static final By opptyLeadSrcValPhoneInquiry=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[6]/slot/force-record-layout-item[1]/div/span/slot/slot/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[3]/span[2]/span");
      private static final By opptyLeadSrcValPartnerReferral=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[6]/slot/force-record-layout-item[1]/div/span/slot/slot/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[4]/span[2]/span");
      private static final By opptyLeadSrcValPurchasedList=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[6]/slot/force-record-layout-item[1]/div/span/slot/slot/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[5]/span[2]/span");

      private static final By OpptyProbability = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0125f0000008sk6aai___full___create___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[5]/slot/force-record-layout-item[2]/div/span/slot/slot/lightning-input/div/input");
      private static final By OpptySavebtn = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/force-form-footer/div/div/div/runtime_platform_actions-actions-ribbon/ul/li[3]/runtime_platform_actions-action-renderer/runtime_platform_actions-executor-lwc-headless/slot[1]/slot/lightning-button/button");
      private static final By OpptyCancelbtn = By.xpath("//*[@id=\"content_1615:0\"]/div/div/div[1]/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/force-form-footer/div/div/div/runtime_platform_actions-actions-ribbon/ul/li[1]/runtime_platform_actions-action-renderer/runtime_platform_actions-executor-lwc-headless/slot[1]/slot/lightning-button/button");
      private static final By OpptySaveandNewbtn = By.xpath("//*[@id=\"content_1615:0\"]/div/div/div[1]/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/force-form-footer/div/div/div/runtime_platform_actions-actions-ribbon/ul/li[2]/runtime_platform_actions-action-renderer/runtime_platform_actions-executor-lwc-headless/slot[1]/slot/lightning-button/button");
      private static final By Opptycloseicon = By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div/div[1]/button/lightning-primitive-icon/svg");
      
      
      //Data for opportunity creation
      int min=10;
      int max=60;
      Random rnd=new Random();
      private int amt=rnd.nextInt(1000)*(max-min+1)+min;
      private int prob=rnd.nextInt(40);
      private int oAmount=amt;
      
      private int cnt=rnd.nextInt(1000);
      public String oOpptyName="TestOppty"+cnt; 
      private String ClDateValue = getConfigFileData("closingDt");
      private String oAcctName=getConfigFileData("accountNm");
      private String oStage=getConfigFileData("oStage");
      private String oType=getConfigFileData("oType");
      private String oLeadSrc=getConfigFileData("oLeadSrc");
      private int oProbability=prob;
      
   // Locator for Opportunity Name after creation
      private String newOpptyNm="//lightning-formatted-text[normalize-space()="+"'"+oOpptyName+"']";
      private final By OpptyNameLabel = By.xpath(newOpptyNm);
      
      
      //method for filling the Opportunity data
      public void fillOpptyData()
      {
      	log.info( "Opportunity data entries started" );
      	log.info("New amount: "+amt);
      	fillValuesInTextBox1(opptyamount,amt);
      	fillValuesInTextBox(OpptyName,oOpptyName);
      	fillValuesInTextBox(CloseDate,ClDateValue);
      	
      	fillValuesInTextBox(AcctName,oAcctName);
      	//checking if search results are visible     	
      	if(checkPageExistence(AcctNameSearch)==true)
      	{
      		log.info("Account Name search result present");
      	}
      	else
      	{
      		log.info("Account Name search result isn't present");
      	}
      	clickOnLocator(AcctNameFromResult);
      	log.info("Account Name is selected");
      	
      	//selectValueFromDropDownList(AcctName,oAcctName);
      	clickOnLocator(OpptyStage);
      	
      	if(checkPageExistence(opptyStgList)==true)
      	{
      		log.info("Opportunity Stage Picklist expanded");
      	}
      	else
      	{
      		log.info("Opportunity Stage Picklist isn't visible");
      	}
      	
      	//clickOnLocator(stgListOptionProspecting);
      	selectOpptyStage();
      	//getElementListFromComboBox(opptyStgList,oStage);
      	
      	//log.info("Stage is selected");
      	
      	//selectValueFromPickList(opptyStgList,oStage);
      	
      	clickOnLocator(OpptyType);
      	if(checkPageExistence(OpptyTypeList)==true)
      	{
      		log.info("Opportunity Type List Expanded");
      	}
      	else
      	{
      		log.info("Opportunity Type List isn't visible");
      	}
      	
      	selectOpptyType();
      	
      	scrollToElement(OpptyLeadSource);
      	clickOnLocator(OpptyLeadSource);
      	if(checkPageExistence(opptyLeadSrcList)==true)
      	{
      		log.info("Lead Source List Expanded");
      	}
      	else
      	{
      		log.info("Lead Source List isn't visible");
      	}
      	
      	selectOpptyLeadSrc();
      	      	
      	fillValuesInTextBox1(OpptyProbability,oProbability);   	
      	log.info( "Opportunity data entries Completed" );
      }
      
      private void selectOpptyStage()
      {

        	switch(oStage) {
        		
        		case "Prospecting":
        			
        			if(checkPageExistence(stgListOptionProspecting)==true)
        			{
        				clickOnLocator(stgListOptionProspecting);
        			}
        			else
        			{
        				log.info("Element not visible, trying to scroll down");
        				scrollToPickListValue(opptyStgList,oStage);
        				clickOnLocator(stgListOptionProspecting);        				
        			}
        			log.info("Stage is selected as :"+oStage);
        			break;
        			
        		case "Qualification":
        			
        			if(checkPageExistence(stgListOptionQualification)==true)
        			{
        				clickOnLocator(stgListOptionQualification);
        			}
        			else
        			{
        				log.info("Element not visible, trying to scroll down");
        				scrollToPickListValue(opptyStgList,oStage);
        				clickOnLocator(stgListOptionQualification);        				
        			}
        			
        			log.info("Stage is selected as :"+oStage);
        			break;
        			
        		case "Need Analysis":
        			
        			if(checkPageExistence(stgListOptionNeedAnalysis)==true)
        			{
        				clickOnLocator(stgListOptionNeedAnalysis);
        			}
        			else
        			{
        				log.info("Element not visible, trying to scroll down");
        				scrollToPickListValue(opptyStgList,oStage);
        				clickOnLocator(stgListOptionNeedAnalysis);        				
        			}
        			
        			log.info("Stage is selected as :"+oStage);
        			break;
        			
        		case "Value Proposition":
        			
        			if(checkPageExistence(stgListOptionValueProposition)==true)
        			{
        				clickOnLocator(stgListOptionValueProposition);
        			}
        			else
        			{
        				log.info("Element not visible, trying to scroll down");
        				scrollToPickListValue(opptyStgList,oStage);
        				clickOnLocator(stgListOptionValueProposition);        				
        			}
        			log.info("Stage is selected as :"+oStage);
        			break;
        			
        		case "Id. Decision Makers":
        			
        			if(checkPageExistence(stgListOptionIdDecisionMakers)==true)
        			{
        				clickOnLocator(stgListOptionIdDecisionMakers);
        			}
        			else
        			{
        				log.info("Element not visible, trying to scroll down");
        				scrollToPickListValue(opptyStgList,oStage);
        				clickOnLocator(stgListOptionIdDecisionMakers);        				
        			}
        			log.info("Stage is selected as :"+oStage);
        			break;
        			
        		case "Perception Analysis":
        			
        			if(checkPageExistence(stgListOptionPerceptionAnalysis)==true)
        			{
        				clickOnLocator(stgListOptionPerceptionAnalysis);
        			}
        			else
        			{
        				log.info("Element not visible, trying to scroll down");
        				scrollToPickListValue(opptyStgList,oStage);
        				clickOnLocator(stgListOptionPerceptionAnalysis);
        			}
        			
        			log.info("Stage is selected as :"+oStage);
        			break;
        			
        		case "Proposal/Price Quote":
        			
        			if(checkPageExistence(stgListOptionProposalPriceQuote)==true)
        			{
        				clickOnLocator(stgListOptionProposalPriceQuote);
        			}
        			else
        			{
        				log.info("Element not visible, trying to scroll down");
        				scrollToPickListValue(opptyStgList,oStage);
        				clickOnLocator(stgListOptionProposalPriceQuote);        				
        			}
        			
        			log.info("Stage is selected as :"+oStage);
        			break;
        			
        		case "Negotiation/Review":
        			
        			if(checkPageExistence(stgListOptionNegotiationReview)==true)
        			{
        				clickOnLocator(stgListOptionNegotiationReview);
        			}
        			else
        			{
        				log.info("Element not visible, trying to scroll down");
        				scrollToPickListValue(opptyStgList,oStage);
        				clickOnLocator(stgListOptionNegotiationReview);        				
        			}
        			
        			log.info("Stage is selected as :"+oStage);
        			break;
        			
        		case "Closed Won":
        			
        			if(checkPageExistence(stgListOptionClosedWon)==true)
        			{
        				clickOnLocator(stgListOptionClosedWon);
        			}
        			else
        			{
        				log.info("Element not visible, trying to scroll down");
        				scrollToPickListValue(opptyStgList,oStage);
        				clickOnLocator(stgListOptionClosedWon);        				
        			}
        			
        			log.info("Stage is selected as :"+oStage);
        			break;
        			
        		case "Closed Lost":
        			
        			if(checkPageExistence(stgListOptionClosedLost)==true)
        			{
        				clickOnLocator(stgListOptionClosedLost);
        			}
        			else
        			{
        				log.info("Element not visible, trying to scroll down");
        				scrollToPickListValue(opptyStgList,oStage);
        				clickOnLocator(stgListOptionClosedLost);        				
        			}
        			
        			log.info("Stage is selected as :"+oStage);
        			break;
        	}
      }
      
      private void selectOpptyType()
      {

        	switch(oType) {
        		
        		case "New Customer":
        			
        			if(checkPageExistence(oTypeNewCustomer)==true)
        			{
        				clickOnLocator(oTypeNewCustomer);
        			}
        			else
        			{
        				log.info("Element not visible, trying to scroll down");
        				scrollToPickListValue(OpptyTypeList,oType);
        				clickOnLocator(stgListOptionProspecting);        				
        			}
        			log.info("Type is selected as :"+oType);
        			break;
        			
        		case "Existing Customer - Upgrade":
        			
        			if(checkPageExistence(oTypeExistingCustomerUpgrade)==true)
        			{
        				clickOnLocator(oTypeExistingCustomerUpgrade);
        			}
        			else
        			{
        				log.info("Element not visible, trying to scroll down");
        				scrollToPickListValue(OpptyTypeList,oType);
        				clickOnLocator(stgListOptionQualification);        				
        			}
        			
        			log.info("Type is selected as :"+oType);
        			break;
        			
        		case "Existing Customer - Replacement":
        			
        			if(checkPageExistence(oTypeExistingCustomerReplacement)==true)
        			{
        				clickOnLocator(oTypeExistingCustomerReplacement);
        			}
        			else
        			{
        				log.info("Element not visible, trying to scroll down");
        				scrollToPickListValue(OpptyTypeList,oType);
        				clickOnLocator(oTypeExistingCustomerReplacement);        				
        			}
        			
        			log.info("Type is selected as :"+oType);
        			break;
        			
        		case "Existing Customer - Downgrade":
        			
        			if(checkPageExistence(oTypeExistingCustomerDowngrade)==true)
        			{
        				clickOnLocator(oTypeExistingCustomerDowngrade);
        			}
        			else
        			{
        				log.info("Element not visible, trying to scroll down");
        				scrollToPickListValue(OpptyTypeList,oType);
        				clickOnLocator(oTypeExistingCustomerDowngrade);        				
        			}
        			log.info("Type is selected as :"+oType);
        			break;
        		
        	}        	
		
      }
      
      
      private void selectOpptyLeadSrc()
      {

        	switch(oLeadSrc) {
        		
        		case "Web":
        			
        			if(checkPageExistence(opptyLeadSrcValWeb)==true)
        			{
        				clickOnLocator(opptyLeadSrcValWeb);
        			}
        			else
        			{
        				log.info("Element not visible, trying to scroll down");
        				scrollToPickListValue(opptyLeadSrcList,oLeadSrc);
        				clickOnLocator(opptyLeadSrcValWeb);        				
        			}
        			log.info("Lead Source is selected as :"+oLeadSrc);
        			break;
        			
        		case "Phone Inquiry":
        			
        			if(checkPageExistence(opptyLeadSrcValPhoneInquiry)==true)
        			{
        				clickOnLocator(opptyLeadSrcValPhoneInquiry);
        			}
        			else
        			{
        				log.info("Element not visible, trying to scroll down");
        				scrollToPickListValue(opptyLeadSrcList,oLeadSrc);
        				clickOnLocator(opptyLeadSrcValPhoneInquiry);        				
        			}
        			
        			log.info("Lead Source is selected as: "+oLeadSrc);
        			break;
        			
        		case "Partner Referral":
        			
        			if(checkPageExistence(opptyLeadSrcValPartnerReferral)==true)
        			{
        				clickOnLocator(opptyLeadSrcValPartnerReferral);
        			}
        			else
        			{
        				log.info("Element not visible, trying to scroll down");
        				scrollToPickListValue(opptyLeadSrcList,oLeadSrc);
        				clickOnLocator(opptyLeadSrcValPartnerReferral);        				
        			}
        			
        			log.info("Lead Source is selected as: "+oLeadSrc);
        			break;
        			
        		case "Purchased List":
        			
        			if(checkPageExistence(opptyLeadSrcValPurchasedList)==true)
        			{
        				clickOnLocator(opptyLeadSrcValPurchasedList);
        			}
        			else
        			{
        				log.info("Element not visible, trying to scroll down");
        				scrollToPickListValue(opptyLeadSrcList,oLeadSrc);
        				clickOnLocator(opptyLeadSrcValPurchasedList);        				
        			}
        			log.info("Lead Source is selected as : "+oLeadSrc);
        			break;
        			
        		case "Other":
        			
        			if(checkPageExistence(opptyLeadSrcValOther)==true)
        			{
        				clickOnLocator(opptyLeadSrcValOther);
        			}
        			else
        			{
        				log.info("Element not visible, trying to scroll down");
        				scrollToPickListValue(opptyLeadSrcList,oLeadSrc);
        				clickOnLocator(opptyLeadSrcValOther);        				
        			}
        			log.info("Lead Source is selected as: "+oLeadSrc);
        			break;
        			
        		
        	}
        	
		
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
  	   
     }
     
     public void recTypeSelect()
     {
    	 log.info("Toggle of selection of Record type");
    	 clickOnLocator(NextBtn);
     }
     
     
     public boolean verifyNewBtnExists()
     {
  	   log.info("Verifying the presence of New Oportunity button");
  	   return checkPageExistence(NewOpptyBtn);
     }
     
     public void NewOpptyBtnClick()
     {
     	log.info("Clicking New Opportunity Button");
     	//clicking on New Oppty button);
     	//clickOnLocator(NewOpptyBtn);
     	waitForElementToBeVisible(expandOpptyMenu);
     	clickOnLocator(expandOpptyMenu);
     	waitForElementToBeVisible(NewOppty);
     	clickOnLocator(NewOppty);
     	
//    	((JavascriptExecutor) driver).executeScript(
//    		    "arguments[0].click();",
//    		    driver.findElement(expandOpptyMenu)
//    		);
//    	
//    	
//    	((JavascriptExecutor) driver).executeScript(
//    		    "arguments[0].click();",
//    		    driver.findElement(NewOppty)
//    		);
//    	
//    	
     }
         
     public void createOppty()
     {
  	   clickOnLocator(OpptySavebtn);
  	   
     }

     public String verifyCreatedOppty() 
     {
  	   String opptyNm = getWebElement(OpptyNameLabel).getText().toString();
  	   //return checkPageExistence(OpptyNameLabel);
  	   return opptyNm;
     }
     
		/*
		 * public boolean compareOpptyNm() { String ActopptyNm =
		 * getWebElement(OpptyNameLabel).getText().toString().trim();
		 * if(ActopptyNm==oOpptyName.toString().trim()) {
		 * log.info("Opportunity Details page Opens after Oppty creation"); return true;
		 * } else {
		 * log.info("Propblem with Opportunity Details page opening, Name found as "
		 * +ActopptyNm+" and "+oOpptyName); return false; }
		 * 
		 * }
		 */     

}

