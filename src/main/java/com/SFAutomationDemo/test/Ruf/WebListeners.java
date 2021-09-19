package com.SFAutomationDemo.test.Ruf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

/**
 * Author: Ramesh Mourya.
 */
public class WebListeners extends AbstractWebDriverEventListener {

    public void afterClickOn(WebElement element, WebDriver driver){
        System.out.println("Object clicked");
    }


}
