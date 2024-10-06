package org.em.utils.handler;

import org.em.core.interfaces.ImplicitHandler;
import org.em.utils.Reading_Helper.implicitTimeReader;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WaitHelper {

    public static void handleImplicit(WebDriver webDriver) {
        ImplicitHandler implicit = WaitHelper::setImplicit;
        implicit.handleImplicitTime(webDriver, implicitTimeReader.readTime());
    }

    private static void setImplicit(WebDriver webDriver, long time) {
        webDriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
}
