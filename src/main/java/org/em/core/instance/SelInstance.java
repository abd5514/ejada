package org.em.core.instance;

import org.em.core.enums.BrowserEnumParser;
import org.em.core.enums.Drivers;
import org.em.core.selenium_drivers.*;
import org.em.utils.PropReader;
import org.em.utils.error_handlers.Logger;
import org.em.utils.handler.XMLReader;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SelInstance {

    public static final String IS_HEADLESS = "is-headless";
    private final static Map<Drivers, SelDriverProvider> map;
    private final static String browser = PropReader.readConfig("browser");
    private static final Drivers driverType = BrowserEnumParser.parse(browser);
    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    public static XMLReader objXMLReader;


    static {
        map = new HashMap<>();
        map.put(Drivers.CHROME, new Chrome());
        map.put(Drivers.FIREFOX, new Firefox());
        map.put(Drivers.EDGE, new Edge());
        map.put(Drivers.IE, new IE());
        map.put(Drivers.CHROMEREMOTE, new ChromeRemote());
        map.put(Drivers.SAFARI,new Safari());
    }

    public SelInstance(XMLReader objXMLReader) {

        SelInstance.objXMLReader =objXMLReader;
    }

    public SelInstance() {


    }

    private static boolean getHeadlessFlag() {
        try {
            return Boolean.parseBoolean(PropReader.readConfig(IS_HEADLESS));

        } catch (RuntimeException e) {
            Logger.info("Error while reading headless value, value will be set to false as default");
        }
        return false;
    }

    public static WebDriver doBrowserSetup () {
        System.out.println ("browser setup started");

        WebDriver driver = map.get (driverType).getBrowser (getHeadlessFlag ());
       driver.manage ().window ().maximize ();
        driver.manage()
                .timeouts().implicitlyWait (6, TimeUnit.SECONDS);
        return driver;

    }


    public static WebDriver getDriver(){

        return threadLocalDriver.get();

    }

}