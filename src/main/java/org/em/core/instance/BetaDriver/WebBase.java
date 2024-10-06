package org.em.core.instance.BetaDriver;

import org.em.core.instance.SelInstance;
import org.em.utils.PropReader;
import org.em.utils.handler.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static org.em.utils.common.SharedMethods.generateRandomString;


public class WebBase extends SelInstance {


    public static final String xmlPathName = "web";
    public static final String emailGenerator="automation5514+"+generateRandomString() +"@gmail.com";
    public static String Env;


    static {
        Env = PropReader.readConfig("Web");
    }

    public WebBase() {
        super(new WebXMLReader(xmlPathName));
    }

    @BeforeMethod
    public void NavigateToBaseURL() {
        WebDriver driver = doBrowserSetup();
        WaitHelper.handleImplicit(driver);
        threadLocalDriver.set(driver);
        getDriver().get(Env);
    }

    public void mouseOverAction(WebElement locator) {
        String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";
        ((JavascriptExecutor) getDriver()).executeScript(javaScript, locator);
    }

    public void jsScrollUp(WebElement locator) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,-750)", locator);
    }

    public void jsScrollDown(WebElement locator, int Pixel) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView()", locator);
        js.executeScript("window.scrollBy(0," + Pixel + ")", locator);
    }

    public void mouseClickAction(WebElement locator) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView()", locator);
        js.executeScript("arguments[0].click()", locator);
    }

    public static void waitElementToBecomeClickable(WebElement locator) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 30);
            wait.until(ExpectedConditions.elementToBeClickable((locator)));
        } catch (Exception e) {
        }
    }

    public static void waitElementTillAppear(WebElement locator) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.visibilityOf((locator)));
        } catch (Exception e) {
        }
    }

    public static void ifElementAppears(WebElement locator) {
        ElementHelper.elementWaitSeconds (3);
        try {
            locator.click();
        } catch (Exception e) {
            System.out.println(e + " caught");
        }
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        threadLocalDriver.remove();
    }
}

