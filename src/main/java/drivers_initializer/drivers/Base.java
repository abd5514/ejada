package drivers_initializer.drivers;

import drivers_initializer.instance.MobileDriverInstance;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.XMLReader;
import java.time.Duration;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;


public class Base {


    public static XMLReader objXMLReader;

    public AppiumMobileDriver appiumMobileDriver = MobileDriverInstance.getAppiumMobileDriver();

    @BeforeMethod
    public void initializeDriver() {
        appiumMobileDriver.setup();
    }

    @AfterMethod
    public void tearDown() {
        appiumMobileDriver.getDriver().quit();
        appiumMobileDriver.removeDriver();
    }

    public Base(XMLReader objXMLReader) {

        this.objXMLReader = objXMLReader;
    }

    public Base() {

    }
    public static void scrollTo(AppiumMobileDriver appiumMobileDriver, String direction, int times) {
        if (direction.equalsIgnoreCase("down")) {
            Dimension dimensions = appiumMobileDriver.getDriver().manage().window().getSize();
            int width = dimensions.getWidth() / 2;
            for (int i = 0; i < times; i++) {
                int startY = (int) (dimensions.getHeight() * 0.5);
                int endY = (int) (dimensions.getHeight() * 0.2);
                new TouchAction(appiumMobileDriver.getDriver())
                        .press(point(width, startY))
                        .waitAction(waitOptions(Duration.ofSeconds(1)))
                        .moveTo(point(width, endY))
                        .release()
                        .perform();
            }
        }
    }
}