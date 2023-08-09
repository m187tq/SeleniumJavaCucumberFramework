package automationteststore.pageObjects;


import automationteststore.pages.Page;
import automationteststore.helper.logger.LoggerHelper;
import automationteststore.pageObjects.HomePages.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ShippingReturnsPage extends Page {
    WebDriver driver;
    Logger log = LoggerHelper.getLogger(HomePage.class);
    public ShippingReturnsPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Shipping & Returns')]")
    private WebElement shippingReturnsHeadingTxt;

    public String getShippingReturnsHeadingTxt() {
        return verificationHelper.getText(shippingReturnsHeadingTxt);
    }
}
