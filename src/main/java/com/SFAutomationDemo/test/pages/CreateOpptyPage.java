package com.SFAutomationDemo.test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Random;

import com.SFAutomationDemo.test.common.CommonFunction;

import java.io.IOException;

/**
 * Created by neeraj.bhatnagar on 11/24/2016.
 */
public class CreateOpptyPage extends CommonFunction{
    //WebDriver driver;
    public CreateOpptyPage(WebDriver driver) {
        super(driver);
        //this.driver = driver;
    }

    static Logger log = Logger.getLogger( CreateOpptyPage.class.getName() );
    
  /*
   * Locators for opening of the Opportunity option from menu, 
   * verifying the oppty home and New Button for Oppty creation
   * RecordType selection popup
  */
    
    private static final By OpptyMenuOption=By.xpath("//span[@class='slds-truncate'][normalize-space()='Opportunities']"); 
    private static final By opptyPageLabel=By.xpath("//span[@class='slds-var-p-right_x-small']");
    private static final By NewOpptyBtn=By.xpath("//*[@id=\"brandBand_1\"]/div/div/div/div/div[1]/div[1]/div[2]/ul/li/a/div");
    
    //Locator for Record type selection popup
    private static final By recordtypeselection=By.xpath("//*[@id=\"content_1615:0\"]/div/div");
    
    // radio button for recordtype Onboarding
    private static final By ObRecType=By.xpath("//*[@id=\"content_3289:0\"]/div/div/div[1]/div/div/div[1]/fieldset/div[1]/div[1]/label/div[1]/span");
    
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
    private String oOpptyName="TestOppty"+cnt; 
    private String ClDateValue = "11/25/2021";
    private String oAcctName="Test Account";
    private String oStage="Prospect";
    private String oType="New Customer";
    private String oLeadSrc="Web";
    private String oProbability="10";
    
    
    //method for filling the Opportunity data
    public void FillOpptyData()
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
	   selectRadioButton(TestRecType);
	   selectRadioButton(ObRecType);
	}
    
    
    
    
    private static final By checkAuthenticate = By.cssSelector(".navigation_page");
    private static final By titleMr = By.xpath(".//*[@id='id_gender1']");
    private static final By titleMrs = By.xpath(".//*[@id='id_gender2']");
    private static final By firstName = By.xpath(".//*[@id='customer_firstname']");
    private static final By lastName = By.xpath(".//*[@id='customer_lastname']");
    private static final By emailofUser = By.xpath(".//*[@id='email']");
    private static final By password = By.xpath(".//*[@id='passwd']");
    private static final By days_DOB = By.id("days");
    private static final By months_DOB = By.id("months");
    private static final By years_DOB = By.id("years");
    private static final By signUpNewsleterCheckBox = By.xpath(".//*[@id='newsletter']");
    private static final By specialOffersCheckBox = By.xpath(".//*[@id='optin']");
    private static final By signupText = By.xpath(".//*[@for='newsletter']");
    private static final By offerText = By.xpath(".//*[@for='optin']");
    private static final By address_First_Name = By.xpath(".//*[@id='firstname']");
    private static final By address_Last_Name = By.xpath(".//*[@id='lastname']");
    private static final By address_Comapany = By.xpath(".//*[@id='company']");
    private static final By address_Line_1 = By.xpath(".//*[@id='address1']");
    private static final By address_Line_2 = By.xpath(".//*[@id='address2']");
    private static final By address_city = By.xpath(".//*[@id='city']");
    private static final By address_State = By.id("id_state");
    private static final By address_Zip_Code = By.xpath(".//*[@id='postcode']");
    // Pick Country from dropdowm.
    private static final By address_Additional_Info = By.xpath(".//*[@id='other']");
    private static final By address_Home_Phone = By.xpath(".//*[@id='phone']");
    private static final By address_Mobile_Phone = By.xpath(".//*[@id='phone_mobile']");
    private static final By address_alias = By.xpath(".//*[@id='alias']");
    private static final By Register_Button = By.xpath(".//*[@id='submitAccount']");


    private String firstNameValue= "Neeraj";
    private String lastNameValue = "Bhatnagar";
    private String emailToCreateAccount = "neerajunlimited@gmail.com";
    private String passwordValue = "12345";
    //String userFirstName = "Neeraj";
    //String userLastName = "Bhatnagar";
    private String addressFirstNameValue= "Neeraj";
    private String addressLastNameValue = "Bhatnaagar";
    private String addressCompanyName = "MyComapany";
    private String addressLine1 = "Indirapuram";
    private String addressLine2 = "Ghaziabad";
    private String addressCity = "Ghaziabad";
    private String addressZipCode = "02453";
    private String addressAdditionalInfo = "From Filled completely";
    private String addressHomePhone = "9876675456";
    private String addressMobile = "9867564534";
    private String addressAlias = "This is home address";
    private String daysDOBValue = "5";
    private String monthsDOBValue = "4";
    private String yearsDOBValue = "1981";


   /*
    This function will fill registration form.A String type variable is being used in sendKeys method.
    This variable is defined in class. we can use fillAccountInformation or fillAccountForm to complete account form.
   */

   /* public void fillAccountInformation(){

           waitForElementToBeVisible(firstName).sendKeys(userFirstName);
        waitForElementToBeVisible(lastName).sendKeys(userLastName);
    }*/
    public void fillAccountForm() {
        log.info( "Registration page data entries started" );
        fillValuesInTextBox(firstName, firstNameValue);
        fillValuesInTextBox(lastName, lastNameValue);
        fillValuesInTextBox(password,passwordValue);
        fillValuesInTextBox(address_First_Name, addressFirstNameValue);
        fillValuesInTextBox(address_Last_Name,addressLastNameValue);
        fillValuesInTextBox(address_Comapany,addressCompanyName);
        fillValuesInTextBox(address_Line_1,addressLine1);
        fillValuesInTextBox(address_Line_2,addressLine2);
        fillValuesInTextBox(address_city,addressCity);
        fillValuesInTextBox(address_Zip_Code,addressZipCode);
        fillValuesInTextBox(address_Additional_Info,addressAdditionalInfo);
        fillValuesInTextBox(address_Home_Phone,addressHomePhone);
        fillValuesInTextBox(address_Mobile_Phone,addressMobile);
        fillValuesInTextBox(address_alias,addressAlias);
        log.info( "Registration page data entries ended." );
   }

    /*
    This function will select radio button Mr.
     */
    public void selectTitleMr() {
        log.info( "Selecting Mr Radio Button" );
        selectRadioButton(titleMr);

    }

    /*
   This function will select radio button Mrs.
    */
    public void selectTitleMrs() {
        log.info( "Selecting Mrs. Button" );
        selectRadioButton(titleMrs);
    }

    /*
    This function will check if preFilled email is matching with email entered in LoginPage.
     */
    public void checkPreFilledEmail() {
        log.info( "Checking if Prefilled EMail entry is matching." );
        checkPreFilledTextBoxEntries(emailofUser,emailToCreateAccount);
    }

    /*
    This function will select newsletter checkbox.
     */
    public void selectNewsLetter() {
        log.info( "NewsLetter Checkbox selected" );
        selectRadioButton(signUpNewsleterCheckBox);
    }

    /*
   This function will select offers checkbox.
    */
    public void selectOffers() {
        log.info( "Offers Checkbox selected" );
        selectRadioButton(specialOffersCheckBox);
    }

    /*
    This function will select Day in DOB field
    */
    public void selectDayDOB() {
        log.info( "Day Selected in DOB" );
        selectValueFromDropDownList(days_DOB,daysDOBValue);
    }

    /*
    This function will select Month in DOB field
    */
    public void selectMonthsDOB() {
        log.info( "Month Selected in DOB" );
        selectValueFromDropDownList(months_DOB,monthsDOBValue);
    }

    /*
    This function will select Year in DOB field
    */
    public void selectYearsDOB() {
        log.info( "Year Selected in DOB" );
        selectValueFromDropDownList(years_DOB,yearsDOBValue);
    }

    /*
    This function will click on Register button after filling new user
    form.
     */
    public MyAccountPage selectRegisterButton() throws IOException{
        log.info( "Register new user button selected." );
        clickOnLocator(Register_Button);
        return new MyAccountPage(getDriver());
    }

    /**
     * This function is waiting for firstName & lastName to be visible. This funtion will wait till the time these elements are not visible so it can be use where ever
     * we have to wait for some items to load.
     */
    public void waitForCreateAccountPageToLoad(){
        //assertEquals( waitForElementToBeVisible(firstName).getText(),"Expected" ," Text doesn't match");
        waitForElementToBeVisible(lastName);

    }

    /**
     * This function checks if createAccount page is present. If given locator is present it means page is present.
     * @return
     */
    public boolean isCreateAccountPagePresent(){
        log.info( "Checking if Create Account page is present." );
        return checkPageExistence(checkAuthenticate);
    }



}

