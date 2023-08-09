package automationteststore.pageObjects.OrderPage;

import automationteststore.pages.Page;
import automationteststore.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class OrderStatusPage  extends Page {
    public WebDriver driver;
    Logger log = LoggerHelper.getLogger(OrderConfirmationPage.class);
    public OrderStatusPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[contains(text(),'Home')]")
    public WebElement homeLinkTxt;

    @FindBy(xpath="//span[contains(text(),'Your Account')]")
    public WebElement yourAccountLinkTxt;

    @FindBy(xpath="//span[contains(text(),'Your Orders')]")
    public WebElement yourOrdersLinkTxt;

    @FindBy(xpath="//a[contains(text(),'Order #')]")
    public WebElement OrderNoTxt;

    @FindBy(xpath="//p[contains(text(),' products totaling $')]")
    public WebElement productsTotalingPriceTxt;

    @FindBy(css=".account-product-detail")
    public WebElement productDetailDateTxt;

    @FindBy(xpath="//h6[contains(text(),'Awaiting Fulfillment')]")
    public WebElement awaitingFulfillmentTxt;

    @FindBy(css=".breadcrumbs")
    public List<WebElement> allMenuLinksText;

    @FindBy(linkText="Orders")
    public WebElement ordersMenuLinkTxt;

    @FindBy(linkText="Returns")
    public WebElement returnsMenuLinkTxt;

    @FindBy(linkText="Messages")
    public WebElement messagesMenuLinkTxt;

    @FindBy(linkText="Addresses")
    public WebElement addressesMenuLinkTxt;

    @FindBy(linkText="Wish Lists")
    public WebElement wishListsMenuLinkTxt;

    @FindBy(linkText="Recently Viewed")
    public WebElement recentlyViewedLinkTxt;

    @FindBy(css=".page-heading")
    public WebElement orderTitleTxt;

    @FindBy(css=".navBar-section")
    public List<WebElement> navBarSection;

    @FindBy(css=".alertBox-column.alertBox-message")
    public WebElement anyOrdersAlertBoxMessage;


}
