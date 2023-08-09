package automationteststore.pageObjects.CheckoutPages;

import automationteststore.pages.Page;
import automationteststore.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class PaymentModeEditPage extends Page {
    public WebDriver driver;
    Logger log = LoggerHelper.getLogger(PaymentModeEditPage.class);
    public PaymentModeEditPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".paymentProviderHeader-name")
    private WebElement testGatewayTxt;

    @FindBy(css = "#ccNumber")
    private WebElement ccNumberBox;





}
