package automationteststore.pageObjects.HomePages;

import automationteststore.helper.logger.LoggerHelper;
import automationteststore.pages.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;


public class HomePage extends Page {

    public WebDriver driver;
    Logger log = LoggerHelper.getLogger(HomePage.class);

    public HomePage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public final String url = "https://automationteststore.com/";

    @FindBy(css = ".navbar-header.header-logo")
    public WebElement logoImage;

    @FindBy(css = ".welcome_msg h4")
    public WebElement welcome_msg;

    @FindBy(xpath = "///h2[@innertext='Fast shipping']")
    public WebElement fastShipping;
    @FindBy(xpath = "///h2[@innertext='Easy Payments']")
    public WebElement easyPayments;
    @FindBy(xpath = "///h2[@innertext='Shipping Options']")
    public WebElement shippingOptions;
    @FindBy(xpath = "///h2[@innertext='Large Variety']")
    public WebElement largeVariety;
    @FindBy(xpath = "span.maintext")
    public List<WebElement> headingLists;

    @FindBy(css = ".col-md-3.col-sm-6.col-xs-12")
    public List<WebElement> allProductsList;

    By addToCart = By.cssSelector("[title='Add to Cart']");
    public String getFastShipping() {
        return verificationHelper.getText(fastShipping);
    }

    public String getEasyPayments() {
        return verificationHelper.getText(easyPayments);
    }

    public String getShippingOptions() {
        return verificationHelper.getText(shippingOptions);
    }

    public String getlargeVarietyLargeVariety() {
        return verificationHelper.getText(largeVariety);
    }

    public List<WebElement> getHeadingLists() {
        return headingLists;
    }



    public String getUrl() {
        return url;
    }
    public List<WebElement> getProductList() {
        return allProductsList;
    }
    public WebElement getProductByName(String productName) {
        WebElement prod = getProductList()
                .stream()
                .filter(product -> product.findElement(By.cssSelector("a.prdocutname")).getText().equals(productName))
                .findFirst()
                .orElse(null);
        return prod;
    }
    public void addProductsToCart(String productName) {
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCart).click();
    }

}
