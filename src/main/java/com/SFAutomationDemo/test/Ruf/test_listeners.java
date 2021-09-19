package com.SFAutomationDemo.test.Ruf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Author: Ramesh Mourya
 */
public class test_listeners {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\GecoDriver\\geckodriver.exe");
        WebDriver webdriver = new FirefoxDriver();
        webdriver.manage().window().maximize();

        EventFiringWebDriver driver = new EventFiringWebDriver(webdriver);
        WebListeners listeners = new WebListeners();
        driver.register(listeners);

    }
}
