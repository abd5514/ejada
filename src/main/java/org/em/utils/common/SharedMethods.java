package org.em.utils.common;

import org.apache.commons.lang3.RandomStringUtils;
import org.em.core.instance.SelInstance;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.TimeZone;

public class SharedMethods extends SelInstance {
    WebDriver driver;
    public String winHandleBefore ;

    public SharedMethods(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static String generateRandomString(){
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

    public  int getCurrentDay() {

        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);

        return todayInt;
    }


    public void waitUntilElementVisible(WebElement webElement)
    {
        WebDriverWait wait = new WebDriverWait(getDriver (),30);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public void waitUntilElementClickable(WebElement webElement)
    {
        WebDriverWait wait = new WebDriverWait(getDriver (),30);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void mouseOverAction(WebElement Locator)
    {
        String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";
        ((JavascriptExecutor)getDriver ()).executeScript(javaScript, Locator);
    }

    public static void jsScrollUp(WebElement Locator)
    {
        JavascriptExecutor js = (JavascriptExecutor) getDriver ();
        js.executeScript("window.scrollBy(0,-250)", Locator);
    }

    public void jsScrollDown(WebElement Locator)
    {
        JavascriptExecutor js = (JavascriptExecutor) getDriver ();
        js.executeScript("window.scrollBy(0,350)", Locator);
    }

    public static void mouseClickAction(WebElement Locator)
    {
        JavascriptExecutor js = (JavascriptExecutor) getDriver ();
        js.executeScript("arguments[0].scrollIntoView()", Locator);
        //js.executeScript("document.getElementByXpath('"+ Locator +"').click();");
        js.executeScript("arguments[0].click()", Locator);
    }


    public void waitElement(WebElement Locator)
    {
        WebDriverWait wait = new WebDriverWait(getDriver (),10);
        wait.until(ExpectedConditions.elementToBeClickable((Locator)));
    }

    public void changeAttire(WebElement locator){
        JavascriptExecutor js = (JavascriptExecutor) getDriver ();
        js.executeScript("arguments[0].removeAttribute('disabled','disabled')",locator);
    }

    public static void pageBottom(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

    }



}
