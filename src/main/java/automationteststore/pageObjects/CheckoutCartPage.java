package automationteststore.pageObjects;

import automationteststore.helper.logger.LoggerHelper;
import automationteststore.helperutilities.GlobalVars;
import automationteststore.pageObjects.HomePages.HomePage;
import automationteststore.pages.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CheckoutCartPage extends Page {
    public WebDriver driver;
    Logger log = LoggerHelper.getLogger(CheckoutCartPage.class);
    public CheckoutCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[@innertext='Your shopping cart is empty!']")
    private WebElement cart_empty;
    @FindBy(xpath="//input[@id='coupon_coupon']")
    private WebElement couponBox;

    @FindBy(css="#apply_coupon_btn")
    private WebElement applyCouponBtn;

    @FindBy(css="#estimate_country")
    private WebElement estimateCountryDropdown;

    @FindBy(css="#estimate_country_zones")
    private WebElement countryZonesDropdown;

    @FindBy(xpath="//input[@id='estimate_postcode']")
    WebElement estimatePostcodeBox;

    @FindBy(xpath="//tbody/tr[2]/td[1]/div[1]/form[1]/div[2]/div[1]/span[1]/button[1]")
    private WebElement estimateCalculatorBtn;

    @FindBy(xpath="//select[@id='shippings']")
    private WebElement FlatRateShipmentsDropdown;

    @FindBy(xpath="//*[@id='cart']/div/div[1]/table/tbody/tr[2]/td[7]/a/i")
    private WebElement removeItemBtn;

    public  void inputItemQuantity(int qty) {
        waitAndSendKeys(quantity, String.valueOf(qty)); ;
    }
    public WebElement quantity() {
        return quantity;
    }

    @FindBy(xpath="/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr/td[5]/div/input")
    private WebElement quantity;

    @FindBy(id="cart_update")
    private WebElement updateBtn;

    @FindBy(xpath="//*[@id='cart']/div/div[3]/div/a[1]")
    private WebElement continieShippingBtn;

    @FindBy(css=".mb20.pull-right > a[title='Checkout']")
    private WebElement checkoutBtn;

    @FindBy(css="a[title='Continue']")
    private WebElement ContinueBtn;


    public void EnterCouponNumberOnCouponBox(String CouponNumber) {
        sendKeysToWebElement(couponBox, CouponNumber);
    }

    public void clickOnApplyCouponBtn() {
        waitForWebElementAndClick(applyCouponBtn);
    }

    public void selectEstimateCountryDropdown(String countryName) {
        selectByVisibleText(countryName, estimateCountryDropdown);
    }

    public void selectCountryZonesDropdown(String countryZonesName) {
        selectByVisibleText(countryZonesName, countryZonesDropdown) ;
    }

    public void enterOnEstimatePostcodeBox(String postCode) {
        sendKeysToWebElement(estimatePostcodeBox, postCode);
    }

    public void clickOnEstimateCalculatorBtn() {
        waitForWebElementAndClick(estimateCalculatorBtn);
    }

    public void selectFlatRateShipmentsDropdown(String flatRateShipment) {
        selectByVisibleText(flatRateShipment, FlatRateShipmentsDropdown);
    }

    public WebElement removeIconBtn() {
        return removeItemBtn;
    }

    public void clickOnRemoveIconBtn() {
        waitForWebElementAndClick(removeItemBtn);
    }

    public void clickOnUpdateBtn() {
        waitForWebElementAndClick(updateBtn);
    }
    public HomePage clickOnContinueShippingBtn() throws IOException {
        waitForWebElementAndClick(continieShippingBtn);
        return new HomePage(driver);
    }

    public AccountLoginPage clickOnCheckoutBtn() throws IOException {;
        waitFor(checkoutBtn);
        checkoutBtn.click();
        //waitForElementNotPresent(checkoutBtn, 5);
        return new AccountLoginPage(driver);
    }
    public WebElement continueBtn() {
        return ContinueBtn;
    }

    public HomePage clickContinueBtn() throws IOException {
        waitForWebElementAndClick(ContinueBtn);
        return new HomePage(driver);
    }
    public void tapOnContinueBtn() {
        waitForWebElementAndClick(ContinueBtn);
    }
}