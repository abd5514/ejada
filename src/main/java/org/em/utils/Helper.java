package org.em.utils;

import org.em.utils.error_handlers.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.em.core.instance.SelInstance.getDriver;


public abstract class Helper {
    public static String winHandleBefore ;



    public static boolean waitVisibility(WebDriver driver, WebElement element, int time) {
        boolean isElementPresent = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);

            wait.until(ExpectedConditions.visibilityOf(element));
            isElementPresent = element.isDisplayed();
        } catch (Exception e) {
            Logger.info("The element on waitVisibility method not found " + e);
        }
        return isElementPresent;
    }

    public static void waitElement(int timeoutInSeconds) {
        try {
            Thread.sleep(timeoutInSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isElementDisplay(WebElement element) {
        try {
            if (element.isDisplayed()) {
                return true;
            }
        } catch (Exception exception) {
            return false;
        }
        return false;
    }

    public static void MouseOverAction(WebElement Locator) {

        Actions action = new Actions(getDriver());
        action.moveToElement(Locator).perform();

    }

    public static void mouseOverAction(WebElement locator) {
        String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";
        ((JavascriptExecutor) getDriver()).executeScript(javaScript, locator);
    }

    public static void MouseClickAction(WebElement Locator)
    {
        //JavascriptExecutor ex=(JavascriptExecutor)driver;
        //ex.executeScript("arguments[0].click()", Locator);
        JavascriptExecutor jse = (JavascriptExecutor)getDriver ();
        jse.executeScript("document.getElementByXpath('"+ Locator +"').click();");
    }

    public static void SwitchToNewTap(WebElement element)
    {
        JavascriptExecutor Js1 = (JavascriptExecutor) getDriver ();

        Js1.executeScript("window.scrollBy(0,4000)");
        element.click();

        winHandleBefore=getDriver ().getWindowHandle();
        for(String winHandle : getDriver ().getWindowHandles())
        {
            getDriver ().switchTo().window(winHandle);
        }
        getDriver ().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public static void SwitchToNewTapUsingSelenium(WebElement element){

        element.click();

        for(String winHandle : getDriver ().getWindowHandles())
        {
            getDriver ().switchTo().window(winHandle);
        }
        getDriver ().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }

    public static void clickOnAnySubCategoryFromTopNavigation(WebElement mainCategory,WebElement subCategory)
    {
        mouseOverAction(mainCategory);
        subCategory.click();
    }

}
