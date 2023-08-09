package automationteststore.pageObjects.HomePages;

import automationteststore.pages.Page;
import automationteststore.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoiceOrderPage extends Page {
    WebDriver driver;
    Logger log = LoggerHelper.getLogger(HomePage.class);

    public InvoiceOrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/h1[1]/span[1]")
    private WebElement orderDetailsHeadingTxt;

    @FindBy(xpath = "a.btn.btn-default.mr10.mb20")
    private WebElement continueBtn;

    @FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div[1]/div/div/div[4]/div/a[2]")
    private WebElement printBtn;

}
