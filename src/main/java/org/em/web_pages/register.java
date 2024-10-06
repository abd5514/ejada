package org.em.web_pages;

import org.em.core.instance.BetaDriver.WebBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class register extends WebBase {

    @FindBy(id = "user-name")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement pass;
    @FindBy(id = "login-button")
    public WebElement loginBtn;
    @FindBy(xpath = "//button[@data-test='error-button']")
    public WebElement errorBtn;
    @FindBy(xpath = "//select[@data-test='product-sort-container']")
    public WebElement priceDDL;
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    public WebElement jaket;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement backBag;
    @FindBy(xpath = "//a[@data-test='shopping-cart-link']")
    public WebElement cartBtn;
    @FindBy(id = "checkout")
    public WebElement checkoutBtn;
    @FindBy(id = "first-name")
    public WebElement firstNameTxt;
    @FindBy(id = "last-name")
    public WebElement lastNameTxt;
    @FindBy(id = "postal-code")
    public WebElement postalCodeTxt;
    @FindBy(id = "continue")
    public WebElement continueBtn;
    @FindBy(xpath = "//span[contains(text(),'Overview')]")
    public WebElement overview;
    @FindBy(xpath = "//dive[@data-test='subtotal-label')]")
    public WebElement subtotal;


    public register(WebDriver driver) {
        PageFactory.initElements (driver,this);
    }

    public void selectDDL(){
        Select price = new Select(priceDDL);
        price.selectByValue("hilo");
    }

    public String getAmount(){
        return subtotal.getText();
    }
}