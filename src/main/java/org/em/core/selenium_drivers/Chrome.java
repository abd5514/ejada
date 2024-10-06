package org.em.core.selenium_drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.em.core.enums.Drivers;
import org.em.core.enums.HeadlessStrategyOperator;
import org.em.utils.PropReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Chrome implements SelDriverProvider {

    public static final String TRUE = "true";

    WebDriverManager webDriverManager;
    @Override
    public WebDriver getBrowser(boolean isHeadless) {
        if (PropReader.readConfig ("isSpecificVersion").equalsIgnoreCase (TRUE)) {
            webDriverManager.chromedriver ().driverVersion (PropReader.readConfig ("ChromeVersion")).setup ();
        }
        else {

            webDriverManager.chromedriver ().setup ();
        }


        if (isHeadless) {
            return HeadlessStrategyOperator.CHROME.execute ();

        } else {
            ChromeOptions options = (ChromeOptions) OptionsFactory.getOptions(Drivers.CHROME);
            options.addArguments("--no-sandbox");
            options.addArguments("window-size=1920,1080");
            return new ChromeDriver(options);
        }
    }
}