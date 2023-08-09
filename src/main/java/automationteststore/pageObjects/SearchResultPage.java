package automationteststore.pageObjects;

import automationteststore.pages.Page;
import automationteststore.helper.logger.LoggerHelper;
import automationteststore.pageObjects.HomePages.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchResultPage extends Page {
    public WebDriver driver;
    Logger log = LoggerHelper.getLogger(HomePage.class);

    public SearchResultPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"product_details\"]/div/div[1]/div[1]/a/img")
    public WebElement productDetailsImage;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/label[1]")
    public WebElement totalPriceTxt;

    @FindBy(xpath = "//*[@id=\"product\"]/fieldset/div[5]/ul/li/a")
    public WebElement addToCartBtn;

    @FindBy(id = "product_quantity")
    public WebElement quantityBtn;

    @FindBy(css = "div.input-group")
    public WebElement colorDropdownBtn;

    @FindBy(css = "span.bgnone")
    public WebElement productNameTxt;

    @FindBy(css = "ul.productinfo")
    public WebElement productInfoBoxTxt;

    @FindBy(css = "ul.li.active")
    public WebElement productReviewBtn;




    public String getProductDetailsImage() {
        return verificationHelper.getText(productDetailsImage);
    }

    public String getTotalPriceTxt() {
        return verificationHelper.getText(totalPriceTxt);
    }

    public void clickOnAddToCartBtn() {
        waitForWebElementAndClick(addToCartBtn); ;
    }

    public void EnterQuantityItemBtn(int noOfItem) throws Exception {
        sendKeysToWebElement(quantityBtn, String.valueOf(noOfItem));
    }


    public String getProductNameTxt() {
        return verificationHelper.getText(productNameTxt);

    }

    public String getProductInfoBoxTxt() {
        return verificationHelper.getText(productInfoBoxTxt);
    }

    public void clickAndValidateProductReviewBtn() {
        waitForWebElementAndClick(productInfoBoxTxt);
    }


}




