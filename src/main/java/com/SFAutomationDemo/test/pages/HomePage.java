package com.SFAutomationDemo.test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.SFAutomationDemo.test.common.CommonFunction;

/**
 * Created by neeraj.bhatnagar on 11/22/2016.
 * This class will store all locator & methods of home page
 */
public class HomePage extends CommonFunction
{
    //WebDriver driver;
    public HomePage(WebDriver driver)
    {
        super(driver);
    }
    //public static final By selectSignIn=By.xpath(".//*[@class='login']");
    static Logger log = Logger.getLogger(CreateOpptyPage.class.getName());

}
