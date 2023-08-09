package automationteststore.pageObjects;

import automationteststore.helper.logger.LoggerHelper;
import automationteststore.pages.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class CheckoutConfirmationPage extends Page {
    //public WebDriver driver;
    Logger log = LoggerHelper.getLogger(CheckoutConfirmationPage.class);
    public AccountCreatePage accountCreatePage;
    public CheckoutSuccessPage checkoutSuccessPage;

    public CheckoutConfirmationPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/h1[1]/span[1]")
    public WebElement checkoutConfirmationTxt;

    @FindBy(xpath = "//span[contains(text(),'Order Summary')]")
    public WebElement orderSummaryTxt;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
    public WebElement qtyProductWithStockLocations;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]")
    public List<WebElement> ShippingPaymentItemsInYourCartText;

    @FindBy(xpath = "/html/body/div/header/div[2]/div/div[2]/ul/li")
    public WebElement currencyDropdownBtn;

    @FindBy(css = "button#checkout_btn")
    public WebElement confirmOrderButton;

    @FindBy(css = "button.btn.btn-orange.pull-right.lock-on-click")
    public WebElement confirmOrderBtn;

    @FindBy(xpath = "/html/body/div/header/div[2]/div/div[3]/ul/li/a")
    public WebElement itemsCartIcon;

    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/h1/span[1]")
    public WebElement checkoutConfirmionHeadingTxt;

    @FindBy(css = "//*[@id='maincontainer']/div/div[1]/div/div[2]/p")
    public WebElement clickingConfirmOrderReturnPolicyText;

    @FindBy(xpath = "//b[contains(text(),'Return Policy')]")
    public WebElement returnPolicyTxtLink;

    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/div[2]/table[1]/tbody/tr/td[4]/a")
    public WebElement editShipmentIcon;

    @FindBy(xpath = "//h4[contains(text(),'Shipping')]")
    public WebElement shippingTxt;

    @FindBy(css = "//h4[contains(text(),'Payment')]")
    public WebElement paymentTxt;

    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/div[2]/table[2]/tbody/tr/td[4]/a[1]")
    public WebElement editPaymentIcon;

    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/div[2]/table[2]/tbody/tr/td[4]/a[2]")
    public WebElement editCouponIcon;

    @FindBy(linkText = "Items in your cart")
    public WebElement itemsInYourCartTxt;

    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/div[2]/h4[3]/a")
    public WebElement editCartIcon;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/table[3]/tbody[1]/tr[1]/td[2]")
    public WebElement itemsInYourCart;

    @FindBy(css = "#back")
    public WebElement backArrowBtn;

    @FindBy(css = "span.bold.totalamout")
    public List<WebElement> totalPriceAndAmountTxt;

    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/div[2]/div/div[1]/table/tbody/tr[4]/td[1]/span")
    public WebElement totalPriceTxt;

    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/div[2]/div/div[1]/table/tbody/tr[4]/td[2]/span")
    public WebElement mountTxt;


    public WebElement getCheckoutConfirmationTxt() {
        return checkoutConfirmationTxt;
    }

    public WebElement getOrderSummaryTxt() {
        return orderSummaryTxt;
    }

    public WebElement getQtyProductWithStockLocations() {
        return qtyProductWithStockLocations;
    }

    public List<WebElement> getShippingPaymentItemsInYourCartText() {
        return ShippingPaymentItemsInYourCartText;
    }

    public WebElement getCurrencyDropdownBtn() {
        return currencyDropdownBtn;
    }

    public String getConfirmOrderButtonTxt() {
        return verificationHelper.getText(confirmOrderBtn);
    }

    public WebElement getItemsCartIcon() {
        return itemsCartIcon;
    }

    public WebElement getCheckoutConfirmionHeadingTxt() {
        return checkoutConfirmionHeadingTxt;
    }

    public WebElement getClickingConfirmOrderReturnPolicyText() {
        return clickingConfirmOrderReturnPolicyText;
    }

    public WebElement getReturnPolicyTxtLink() {
        return returnPolicyTxtLink;
    }

    public WebElement getEditShipmentIcon() {
        return editShipmentIcon;
    }

    public WebElement getShippingTxt() {
        return shippingTxt;
    }

    public WebElement getPaymentTxt() {
        return paymentTxt;
    }

    public WebElement getEditPaymentIcon() {
        return editPaymentIcon;
    }

    public WebElement getEditCouponIcon() {
        return editCouponIcon;
    }

    public WebElement getItemsInYourCartTxt() {
        return itemsInYourCartTxt;
    }

    public WebElement getEditCartIcon() {
        return editCartIcon;
    }

    public WebElement getItemsInYourCart() {
        return itemsInYourCart;
    }

    public WebElement getBackArrowBtn() {
        return backArrowBtn;
    }

    public List<WebElement> getTotalPriceAndAmountTxt() {
        return totalPriceAndAmountTxt;
    }

    public WebElement getTotalPriceTxt() {
        return totalPriceTxt;
    }

    public WebElement getMountTxt() {
        return mountTxt;
    }

    public CheckoutSuccessPage clickOnConfirmOrderButton() throws IOException {
        waitFor(confirmOrderBtn);
        confirmOrderBtn.click();
        return new CheckoutSuccessPage(driver);
    }


}
