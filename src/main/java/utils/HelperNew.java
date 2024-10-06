package utils;
import drivers_initializer.drivers.AppiumMobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperNew {
    public  static  void waitVisibality (AppiumMobileDriver driver, MobileElement element){
        WebDriverWait wait =new WebDriverWait(driver.getDriver(),60);
        wait.until(ExpectedConditions.visibilityOf(element));

    }
}
