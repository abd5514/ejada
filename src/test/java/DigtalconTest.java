import drivers_initializer.drivers.Base;
import drivers_initializer.drivers.BaseAndroidDriver;
import drivers_initializer.drivers.BaseIOSDriver;
import error_handlers.RetryAnalyzer;
import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utils.ExtentReport.TestListener;
import utils.XMLReader;


import java.util.concurrent.TimeUnit;

import static utils.HelperNew.waitVisibality;

@Listeners(TestListener.class)
public class DigtalconTest extends Base {
    @Test(description = "Validate user is able  to log in", retryAnalyzer = RetryAnalyzer.class , priority = 1)
    public void Login() throws InterruptedException {
        if (appiumMobileDriver instanceof BaseAndroidDriver) {
            LoginPageYGB loginPageYGB = new LoginPageYGB(appiumMobileDriver);
            waitVisibality(appiumMobileDriver, loginPageYGB.ProfileButton);
            waitVisibality(appiumMobileDriver, loginPageYGB.EmailFelid);
            loginPageYGB.EmailFelid.sendKeys("0159050");
            loginPageYGB.Password.sendKeys("Test@144");
            loginPageYGB.buttonLogin.click();
            Thread.sleep(3000);
            loginPageYGB.sendcode1.sendKeys("0000");
            Thread.sleep(2000);
            loginPageYGB.done.click();

            Thread.sleep(2000);
        } else if (appiumMobileDriver instanceof BaseIOSDriver) {

            LoginPageIOS login=new LoginPageIOS(appiumMobileDriver);
            login.clickOnNotificationPopup();
            login.clickOnNotificationPopup();
            waitVisibality(appiumMobileDriver, login.profileIcon);
            login.clickOnProfileIcon();
            login.enterUserName(XMLReader.getXMLData("Email"));
            login.enterPassword(XMLReader.getXMLData("Password"));
            login.clickLoginButton();
            waitVisibality(appiumMobileDriver, login.profileIcon);

        }
    }

}
