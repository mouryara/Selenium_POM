package com.SFAutomationDemo.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SFAutomationDemo.test.common.CommonFunction;

/**
 * Created by neeraj.bhatnagar on 12/8/2016.
 */
public class AddressPage extends CommonFunction{


    public AddressPage(WebDriver driver) {
        super( driver );
    }

    private static final By myAddressText = By.xpath(".//*[@class='page-subheading']");
    private static final By womenLink = By.xpath("//*[contains(text(), 'Women') and @class='sf-with-ul']");


    /**
     * This function checks if Address page is present. If given locator is present it means page is present.
     * @return
     */
    public boolean isAddressPagePresent(){
        return checkPageExistence(myAddressText);
    }

    public void waitForAddresPageToLoad()
    {
        waitForElementToBeVisible(womenLink);
        waitForElementToBeVisible( myAddressText );


    }






}
