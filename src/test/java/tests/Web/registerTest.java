package tests.Web;

import org.em.core.instance.BetaDriver.WebBase;
import org.em.utils.ExtentReport.TestListener;
import org.em.utils.handler.ElementHelper;
import org.em.web_pages.register;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TestListener.class)
public class registerTest extends WebBase {


    @Test(description = "To verify invalid username and pass"/*,retryAnalyzer = RetryAnalyzer.class*/)
    public void verifyInvalidUsername() {
        register login=new register(getDriver());
        waitElementToBecomeClickable(login.loginBtn);
        login.username.sendKeys(emailGenerator);
        login.pass.sendKeys(objXMLReader.getXMLData("password"));
        login.loginBtn.click();
        ElementHelper.elementWaitSeconds(2);
        Assert.assertTrue(login.errorBtn.isDisplayed());
    }
    @Test(description = "To verify valid username and pass"/*,retryAnalyzer = RetryAnalyzer.class*/)
    public void verifyUserAbleToLogin() {
        register login=new register(getDriver());
        waitElementToBecomeClickable(login.loginBtn);
        login.username.sendKeys("standard_user");
        login.pass.sendKeys(objXMLReader.getXMLData("password"));
        login.loginBtn.click();
        ElementHelper.elementWaitSeconds(1);
        login.selectDDL();
        ElementHelper.elementWaitSeconds(2);
        login.jaket.click();
        login.backBag.click();
        waitElementToBecomeClickable(login.cartBtn);
        login.cartBtn.click();
        waitElementToBecomeClickable(login.checkoutBtn);
        Assert.assertTrue(login.checkoutBtn.isDisplayed());
        login.checkoutBtn.click();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("checkout"));
        login.firstNameTxt.sendKeys("abda");
        login.lastNameTxt.sendKeys("gdsd");
        login.postalCodeTxt.sendKeys("00962");
        waitElementToBecomeClickable(login.continueBtn);
        login.continueBtn.click();
        waitElementToBecomeClickable(login.overview);
        Assert.assertTrue(login.overview.isDisplayed());

        Assert.assertEquals(login.getAmount(),objXMLReader.getXMLData("subtotal"));
        Assert.assertEquals(getDriver().getCurrentUrl(),objXMLReader.getXMLData("url"));
    }
}
