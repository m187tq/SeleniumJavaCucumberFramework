package automationteststore.pageObjects.CheckoutPages;


import automationteststore.pages.Page;
import automationteststore.helper.logger.LoggerHelper;
import automationteststore.pageObjects.AccountCreatePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class CheckoutPage extends Page {
    public WebDriver driver;
    Logger log = LoggerHelper.getLogger(AccountCreatePage.class);

public CheckoutPage(WebDriver driver) throws IOException {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
}

    @FindBy(xpath="//h2[contains(text(),'Customer')]")
    public WebElement customerHeadingTxt;

    @FindBy(css=".product-column.product-figure")
    public WebElement itemImage;

    @FindBy(xpath="//button[contains(text(),'Sign Out')]")
    public WebElement signOutBtn;

    @FindBy(xpath="//*[@id=\"checkout-app\"]/div/div/div/div/ol/li[3]/div/a/div[3]/button")
    public WebElement billingAddrEditBtn;

    @FindBy(xpath="//body/div[@id='checkout-app']/div[1]/div[1]/div[1]/div[1]/ol[1]/li[2]/div[1]/a[1]/div[3]/button[1]")
    public WebElement shippingAddressEditBtn;

    @FindBy(css=".checkout-step.optimizedCheckout-checkoutStep.checkout-step--customer")
    public WebElement fullCustomerHeadingTxt;

    @FindBy(id="addressToggle")
    public WebElement shippingAddressTxt;

    @FindBy(xpath="//label[contains(text(),'My billing address is the same as my shipping addr')]")
    public WebElement myBillingAddressSameShippingAddressTxt;

    @FindBy(xpath="//h2[contains(text(),'Customer')]")
    public WebElement shippingMethodTxt;

    @FindBy(css="#checkout-shipping-continue")
    public WebElement customerContinueBtn;

    @FindBy(xpath="//h3[contains(text(),'Order Summary')]")
    public WebElement orderSummaryTxt;

    @FindBy(css="#cart-edit-link")
    public WebElement editCartLinkTxt;

    @FindBy(xpath="//*[@id=\"checkout-app\"]/div/div/div/aside/article/section[3]/div/div")
    public WebElement totalPrice;

    public String customerHeadingTxt() {
        return verificationHelper.getText(customerHeadingTxt);
    }

    public WebElement itemImage() {
        return itemImage;
    }

    public void clickOnSignOutBtn() {
        waitAndClickElement(signOutBtn);

    }

    public WebElement signOutBtn() {
        return signOutBtn;

    }

    public void clickOnBillingAddEditBtn() {
        waitAndClickElement(billingAddrEditBtn);

    }

    public WebElement billingAddEditBtn() {
        return billingAddrEditBtn;
    }

    public WebElement shippingAddEditBtn() {
        return shippingAddressEditBtn;
    }

    public String getFullCustomerHeadingTxt() {
        return verificationHelper.getText(fullCustomerHeadingTxt);

    }
    public String shippingAddressTxt() {
        return verificationHelper.getText(shippingAddressTxt);
    }
    public String getMyBillingAddressSameShippingAddressTxt() {
        return verificationHelper.getText(myBillingAddressSameShippingAddressTxt);
    }
    public String shippingMethodTxt() {
        return verificationHelper.getText(shippingMethodTxt);
    }

    public void clickOnCustomerContinueBtn() {
        waitAndClickElement(customerContinueBtn);
    }
    public String getOrderSummaryTxt() {
        return verificationHelper.getText(orderSummaryTxt);

    }
    public void clickOnEditCartLinkTxt() {
        waitAndClickElement(editCartLinkTxt);
    }

    public String getEditCartLinkTxt() {
       return verificationHelper.getText(editCartLinkTxt);
    }

    public String getTotalPrice() {
       return verificationHelper.getText(totalPrice);
    }


}
