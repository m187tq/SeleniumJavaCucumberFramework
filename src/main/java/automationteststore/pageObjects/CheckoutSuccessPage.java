package automationteststore.pageObjects;

import automationteststore.helper.logger.LoggerHelper;
import automationteststore.pageObjects.HomePages.HomePage;
import automationteststore.pageObjects.HomePages.InvoiceOrderPage;
import automationteststore.pages.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CheckoutSuccessPage extends Page {

    public WebDriver driver;
    Logger log = LoggerHelper.getLogger(CheckoutSuccessPage.class);
    public CheckoutSuccessPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String orderSuccessPageUrl = "https://automationteststore.com/index.php?rt=checkout/success";
    
    @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/h1/span[1]")
    public WebElement yourOrderHasBeenProcessedHeadingTxt;

    @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/div/section/p[2]")
    public WebElement OrderNumberText;

    @FindBy(partialLinkText = "Your order #")
    public WebElement OrderNumberTxt;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div/section/p[3]")
    public WebElement viewInvoiceText;

    @FindBy(xpath = "//p[contains(text(),'Thank you for shopping with us!')]")
    public WebElement thankYouForShoppingWithUsText;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div/section/p[3]")
    public WebElement invoicePageLink;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div/section/a")
    public WebElement continueCheckoutSuccessBtn;

    public boolean isYourOrderHasBeenProcessedDisplayed() {
        return verificationHelper.isDisplayed(yourOrderHasBeenProcessedHeadingTxt);
    }

    public String getYourOrderHasBeenProcessedTxt() {
        return verificationHelper.getText(yourOrderHasBeenProcessedHeadingTxt);
    }

    public String getOrderNumberTxt() {
        return verificationHelper.getText(OrderNumberText);
    }

    public String getViewInvoiceTxt() {
        return verificationHelper.getText(viewInvoiceText);
    }

    public String getThankYouForShoppingWithUsTxt() {
        return verificationHelper.getText(thankYouForShoppingWithUsText);
    }

    public InvoiceOrderPage clickOnInvoicePageLink() throws IOException {
        waitForWebElementAndClick(invoicePageLink);
        return new InvoiceOrderPage(driver);
    }

    public HomePage clickOnContinueCheckoutSuccessBtn() throws IOException {
        waitForWebElementAndClick(continueCheckoutSuccessBtn);
        return new HomePage(driver);
    }

}
