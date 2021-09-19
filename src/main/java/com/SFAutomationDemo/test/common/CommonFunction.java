package com.SFAutomationDemo.test.common;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.ApplicationCache;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.ApplicationCache;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SFAutomationDemo.test.pages.CreateOpptyPage;
import com.SFAutomationDemo.test.pages.LoginPage;

import utilities.ExcelUtils;
import utilities.Excel_Reader;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.NoSuchElementException;
import java.util.Properties;
import static org.openqa.selenium.remote.CapabilityType.*;
import static org.openqa.selenium.remote.CapabilityType.*;

/**
 * Author: Ramesh Mourya
 * Description: This class will store all the common and reusable methods
 */
public class CommonFunction {
    //public static WebDriver driver=null;

    static Logger log = Logger.getLogger(CommonFunction.class.getName());
    public static WebDriver driver;
    protected static int waitForElementPresentTimeout = 40;
    //private static String appURL = "http://automationpractice.com/index.php";
    private static final By Login = By.xpath(".//*[@id='Login']");
    //public static final By signOutButton = By.linkText("Sign out");
    static Properties properties;
    public static String mailscreenshotpath;
    Excel_Reader excel;



    public CommonFunction() {
    }

    public CommonFunction(WebDriver driver) {
        this.driver = driver;
    }

    /*
    Load config file.
     */

    public static void LoadConfigFile() throws IOException {

        properties = new Properties();
        File file = new File(System.getProperty("user.dir") + "\\config.properties");
        //System.out.println("file path is "+ " " + file);
        FileReader obj = new FileReader(file);
        properties.load(obj);

    }

    /**
     * This fnunction will load test data file.Test data file is in .xlsx format.
     */

    public static void loadTestDataFile() throws Exception {
        //ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
        ExcelUtils.setExcelFile(System.getProperty("user.dir") + "\\testdata\\testData.xlsx", "testDataSheet");

    }

    /**
     * Get data from config file.
     */

    /*public static String getConfigFileData(String Data) throws IOException {

        LoadConfigFile();
        String data = properties.getProperty(Data);
        // System.out.println(data);
        return data;
    }*/
    public static String getConfigFileData(String Data) throws IOException {
        String data = null;
        try {
            LoadConfigFile();
            data = properties.getProperty(Data);
        } catch (FileNotFoundException e) {
           log.info("File not found.");
        } catch (IOException e) {
            e.printStackTrace();

        }
        // System.out.println(data);
        return data;
    }

    /**
     * This function will invoke application & initialize driver.
     */
    public static WebDriver invokeApplication() throws IOException, InterruptedException {
        String browser = getConfigFileData("browserType"); // Since getConfigFileData is returning String so we use String type variable browser
        driver = selectBrowserToTest(browser); // selectBrowserToTest method is returning driver so we use that driver here.
        driver.get(getConfigFileData("applicationURL")); // driver will invoke application.
        return driver;
    }

    /*
   This simple function will pass values in text boxes. using locator & text. Usage of this locator can be found in
    Login Page & CreateAccount Page.
    */
    public void fillValuesInTextBox(By locator, String textBoxData) {
        waitForElementToBeVisible(locator).clear();
        waitForElementToBeVisible(locator).sendKeys(textBoxData);
    }

    public void fillValuesInTextBox1(By locator, int amt) {
        String amnt=String.valueOf(amt);
    	waitForElementToBeVisible(locator).clear();
        waitForElementToBeVisible(locator).sendKeys(amnt);
    }
    
    /**
     * Function to select browser from config file.
     */

    public static WebDriver selectBrowserToTest(String browserType) throws IOException {
        WebDriver driver = null;
        switch (browserType) {
            case "firefox":
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette",true);
                capabilities.setPlatform(Platform.WINDOWS);
                capabilities.setCapability(ACCEPT_SSL_CERTS, true);
                capabilities.setCapability(SUPPORTS_FINDING_BY_CSS,true);
                capabilities.setCapability(SUPPORTS_APPLICATION_CACHE,false);
                //capabilities.setCapability(s);
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\GecoDriver\\geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case "chrome":
                DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("test-type");
                chromeCapabilities.setCapability("chrome.binary","");
                chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
                chromeCapabilities.setPlatform(Platform.WINDOWS);
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\ChromeDriver\\chromedriver.exe");
                driver = new ChromeDriver(chromeCapabilities);
                driver.manage().window().maximize();
                break;

                /*case "IE":
                    System.setProperty("webdriver.ie.driver", System.getProperty("user.dir"));
                    driver = new InternetExplorerDriver();
                    */
            default:
        }
        return driver;
    }

    /*
    This function wait for the element to be visible.
     */

    protected WebElement waitForElementToBeVisible(final By locator) {
        WebElement element = null;
        try {
            element = getWebElement(locator);
        } catch (Exception ex) {
            //CustomReporter.debug("waitForElementToBePresent locator (" + locator.toString() + ")");
            try {
                WebDriverWait webDriverWait = new WebDriverWait(getDriver(), waitForElementPresentTimeout);
                element = webDriverWait.ignoring(NoSuchElementException.class)
                        .until(ExpectedConditions.presenceOfElementLocated(locator));
            } catch (Exception e) {

                element = getWebElement(locator);
            }
        }
        return element;
    }

    /**
     * This function will check if an element is present on page.
     */
    public boolean isElementPresent(By locator){
        boolean isPresent = true;
        try {
            //waitForElementToBeVisible(locator);
            driver.findElement(locator);
            log.info("Element with locator " + locator + " is found.");
        }catch(org.openqa.selenium.NoSuchElementException e) {
            log.info("Element with locator " + locator + " is not found.");
            isPresent = false;
        }
        return isPresent;
    }


    /**
     * This is to get the web element
     *
     * @param locator
     * @return
     */
    protected WebElement getWebElement(By locator) {
        WebElement element;
        //CustomReporter.debug("waitForElementToBeVisible locator (" + locator.toString() + ")");
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), waitForElementPresentTimeout);
        element = webDriverWait.ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    /*
   This simple function will click on a locator
   */
    public void clickOnLocator(By locator) {
        waitForElementToBeVisible(locator).click();
    }

    /**
     * This function will click on child element on a menu which appears on mouse hover
     * MouseHover handling.
     */

    public void mouseHover(By locator) {
        Actions action = new Actions(getDriver());
        WebElement element = waitForElementToBeVisible(locator);
        action.moveToElement(element).build().perform();
    }


    /**
     * This simple function will select a radio button.
     */
    public void selectRadioButton(By locator) {
        //public boolean checkRadioButtonSelected();
        boolean radioButtonState = waitForElementToBeVisible(locator).isSelected();
        if (radioButtonState = false) {
            waitForElementToBeVisible(locator).click();
        } else {
            log.info("Radio button / Checkbox is already selected.");
        }
    }

    /*
    This function will check value of pre-filled text.
    */

    public void checkPreFilledTextBoxEntries(By locator, String preFilledEmail) {
        String textValue = waitForElementToBeVisible(locator).getAttribute("value");
        if (textValue.equals(preFilledEmail)) {
            log.info("PreFilled Email is matching");
        } else {
            //Find out how we can use reusable function fillValuesInTextBox to fill email if it ss not matching.
            log.info("values are not Matching");
        }
    }

    /*
    This function will select value from dropdown list.
     */
    public void selectValueFromDropDownList(By locator, String dropDownValue) {
        WebElement element = waitForElementToBeVisible(locator);
        Select select = new Select(element);
        select.selectByValue(dropDownValue);
    }
    
    // for selecting a value from the pick list using selectByVisbleText 
    public void selectValueFromPickList(By locator, String dropDownValue)
    {
    	WebElement element = waitForElementToBeVisible(locator);
        Select select = new Select(element);
    	select.selectByVisibleText(dropDownValue);
    }
    
    // for scrolling to the element on the page when element is not visible
    public void scrollToElement(By locator)
    {
    	
    	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    /*
    This function will return reference of driver to other pages.
     */
    public WebDriver getDriver() {
        return this.driver;
    }

    /**
     * This method is used to invoke application & click SignIn button on home page.
     *
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public LoginPage clickSignInButton() throws IOException, InterruptedException {

        //WebDriver driver;
        driver = invokeApplication();
        WebElement element = driver.findElement(Login);
        element.click();
        //System.out.println("Sign In button clicked on Home Page.");
        return new LoginPage(driver);

    }

    public void closeDriver() {
        driver.quit();
    }

    /**
     * This method will check if page exists. If given locator is present it means page is present.
     *
     * @param locator
     * @return
     */
    public boolean checkPageExistence(By locator) {

        boolean isPagePresent = false;
        try {
            isPagePresent = waitForElementToBeVisible(locator).isDisplayed();

        } catch (NoSuchElementException e) {
            isPagePresent = false;
        }

        return isPagePresent;
    }

    /**
     * This function will check if logo is present or not. This function should be used to logo on each page.
     * Precondition to this is that logo should be present in header.
     */

    public boolean checkLogo(By locator) {

        boolean isLogoPresent = false;
        try {
            waitForElementToBeVisible(locator);
        } catch (NoSuchElementException e) {
            isLogoPresent = false;
        }
        return isLogoPresent;

    }

    /**
     * This function will use Action class to mouse hover an element.
     */
    public String getTextOfLinkOnMouseHover(By locator) {
        String text = null;
        try {
            Actions actions = new Actions(getDriver());
            WebElement headerHoverLink = waitForElementToBeVisible(locator);
            actions.moveToElement(headerHoverLink).perform();
            text = waitForElementToBeVisible(locator).getText();
        } catch (ElementNotVisibleException e) {
            log.info("Element which user wants to hover over is not present on page");

        }
        return text;
    }


    /**
     * This function will use Action class to mouse hover an element & click on it.
     */
    public void clickOnLinkAfterMouseHover(By locator) {

        try {
            Actions actions = new Actions(getDriver());
            WebElement headerHoverLink = waitForElementToBeVisible(locator);
            actions.moveToElement(headerHoverLink).perform();
            waitForElementToBeVisible(locator).click();
        } catch (ElementNotVisibleException e) {
            log.info("Element which user wants to hover over is not present on page");
        }
    }

    /**
     * This function will use Action class to mouse hover an element.
     */
    public void mouseHoverOnElement(By locator) {

        try {
            Actions actions = new Actions(getDriver());
            WebElement headerHoverLink = waitForElementToBeVisible(locator);
            actions.moveToElement(headerHoverLink).perform();
        } catch (ElementNotVisibleException e) {
            log.info("Element which user wants to hover over is not present on page");
        }
    }


    /**
     * This function will getText of a locator.
     */
    public String textOfLocator(By locator) {
        String text = null;
        try {
            text = waitForElementToBeVisible(locator).getText();
            log.info("Tool tip is :" + " " + text);
        } catch (ElementNotVisibleException e) {
            log.info("Element not present on page");
        }
        return text;
    }

    /**
     * This function will capture screenshot & & will store it in project directory under Screenshots folder.
     *
     * @param methodName
     * @throws IOException
     */
    public static void captureScreenshot(String methodName) throws IOException {

        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int sec = cal.get(Calendar.SECOND);
        int min = cal.get(Calendar.MINUTE);
        int date = cal.get(Calendar.DATE);
        int day = cal.get(Calendar.HOUR_OF_DAY);

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            mailscreenshotpath = System.getProperty("user.dir") + "\\Screenshots\\" + methodName + "_" + year + "_" + date + "_" + (month + 1) + "_" + day + "_" + min + "_" + sec + ".jpeg";
            FileUtils.copyFile(scrFile, new File(mailscreenshotpath));
        } catch (IOException e) {
            e.getMessage();
        }
    }


    /**
     * This function will check text on alert massage
     */

    public String  alertText(){
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        return text;
    }

    /**
     * This function will accept java script alerts.
     */
    public void acceptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    /**
     * This function will reject alert.
     */
    public void rejectAlert(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }


}

