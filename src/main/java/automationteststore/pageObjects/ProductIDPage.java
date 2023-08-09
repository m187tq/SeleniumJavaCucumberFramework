package automationteststore.pageObjects;

import automationteststore.pages.Page;
import automationteststore.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class ProductIDPage extends Page {
    public WebDriver driver;

    Logger log = LoggerHelper.getLogger(ProductIDPage.class);
    public ProductIDPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="[class='col-md-6 text-center'] div:nth-child(2) [src]")
    List<WebElement> productEasyZoom;
    @FindBy(css="[class='productname']")
    List<WebElement> productnames;

    @FindBy(css=".productfilneprice")
    WebElement unitprice;

    @FindBy(css="[class='input-group col-sm-10']")
    WebElement colorDropdown;

    @FindBy(xpath="/html/body/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div/div[2]/form/fieldset/div[1]/div/select/option")
    List<WebElement> colorDropdownList;


    @FindBy(css="input#product_quantity")
    WebElement product_quantity;

    @FindBy(css=".total-price-holder .control-label")
    WebElement total_price_holder_label;

    @FindBy(css=".fa-cart-plus")
    WebElement add2Cart;

    @FindBy(css=".btn.btn-large.productprint")
    WebElement productprint;
    @FindBy(css=".productinfo li:nth-of-type(1)")
    WebElement productModel;
    @FindBy(css="[title='Lancôme']")
    WebElement manufacturerLogo;



    public List<WebElement> getProductEasyZoom() {
        return productEasyZoom;
    }

    public List<WebElement> getProductnames() {
        return productnames;
    }

    public String getUnitpriceTxt() {
        return verificationHelper.getText(unitprice);
    }

    public WebElement colorDropdown() {
        return colorDropdown;
    }

    public void clickOnColorDropdown() {
        waitForWebElementAndClick(colorDropdown);
    }

    public List<WebElement> colorDropdownList() {
        return colorDropdownList;
    }

    public WebElement product_quantity() {
        return product_quantity;
    }
    public void inputProduct_quantity(String  qty) {
        waitAndSendKeys(product_quantity, qty);
    }

    public WebElement add2Cart() {
        return add2Cart;
    }

    public CartSummaryPage clickOnAdd2Cart() {
        waitForWebElementAndClick(add2Cart);
        return new CartSummaryPage(driver);
    }


}
