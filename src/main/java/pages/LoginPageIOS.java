package pages;

import drivers_initializer.drivers.AppiumMobileDriver;
import drivers_initializer.drivers.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageIOS {

    public LoginPageIOS(AppiumMobileDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver.getDriver()), this);
    }


    @iOSXCUITFindBy(accessibility = "Allow")
    public MobileElement notificationPopup;

    @iOSXCUITFindBy(accessibility = "MOEHomeViewController.profileImageView")
    public MobileElement profileIcon;

    @iOSXCUITFindBy( className = "XCUIElementTypeTextField")
    public MobileElement userName;

    @iOSXCUITFindBy(className = "XCUIElementTypeSecureTextField")
    public MobileElement password;

    @iOSXCUITFindBy( iOSNsPredicate = "name =='LOGIN'")
    public IOSElement loginButton;

    public void clickOnNotificationPopup(){
        notificationPopup.click();
    }

    public void clickOnProfileIcon(){
        profileIcon.click();
    }

    public void enterUserName(String username){
        userName.sendKeys(username);
    }

    public void enterPassword(String Password){
        password.sendKeys(Password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void checkVisibility(){
        Assert.assertTrue(profileIcon.isDisplayed());
    }



}
