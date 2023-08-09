package automationteststore.pageObjects;

import automationteststore.helperutilities.GlobalVars;
import automationteststore.pages.Page;
import automationteststore.helper.assertion.VerificationHelper;
import automationteststore.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class AccountPage extends Page {
    public WebDriver driver;
    Logger log = LoggerHelper.getLogger(AccountEditPage.class);
    public AccountPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = ".maintext")
    public WebElement userProfileMyAccountTxt;

    @FindBy(css = "h1.heading")
    public WebElement myAccountTxt;

    @FindBy(xpath = "//*[@id='maincontainer']/div/div[2]/div[1]/div/ul/li[1]")
    public WebElement accountDashboardTxt;

    @FindBy(css = "i.fa.fa-unlock")
    public WebElement logoffBtn;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[2]/div[1]")
    public List<WebElement> sideWidgetAccountDashboardLinks;

    @FindBy(css = "body.account-account:nth-child(2) div.container-fixed:nth-child(1) div.container-fluid div.column_right.col-md-3.col-xs-12.mt20 div.sidewidt div.myaccountbox ul.side_account_list li:nth-child(3) a:nth-child(1) > i.fa.fa-edit.fa-fw")
    public WebElement editAccountDetailsLink;

    @FindBy(id = "customer_menu_top")
    public WebElement welcomeBackTxt;

    @FindBy(linkText = "Logoff")
    public WebElement logout;

    @FindBy(css = ".alert.alert-success")
    public static WebElement successYourAccountSuccessfullyUpdatedTxt;


    public String getAccountDashboardTxt() {
        waitFor(accountDashboardTxt);
        return verificationHelper.getText(accountDashboardTxt);
    }

    public AccountLogoutPage clickOnLogoffBtn() throws IOException {
        waitAndClick(logoffBtn);
        return new AccountLogoutPage(driver);
    }

    public String getLogoffBtn() {
        return new VerificationHelper(driver).getText(logoffBtn);
    }

    public void verifyAllSideWidgetElementsInAccountPageLinks() {
        List<WebElement> links = sideWidgetAccountDashboardLinks;
        for (int i = 0; i < links.size(); i = i++) {
            String listOfElements = links.get(i).getText();
            System.out.println("Size Of Side Widget List => " + links.size());
            log.info("Size Of Side Widget List => " + links.size());
            break;
        }

    }

    public void ClickOnLogOffLinkInSideWidgetList() {
        List<WebElement> ListSideWidget = driver.findElements(By.cssSelector(".side_account_list"));
        for (int i = 0; i < ListSideWidget.size(); i = i++) {
            String listName = ListSideWidget.get(i).getText();
            if (listName.contains("Logoff")) {
                driver.findElements(By.linkText("Logoff")).get(i).click();
                break;
            }

        }

    }

    public String getUserAccountText() throws InterruptedException {
        waitFor(myAccountTxt);
        Thread.sleep(2000);
        return verificationHelper.getText(myAccountTxt);
    }

    public String userProfileInfoMessageTxt() {
        waitFor(userProfileMyAccountTxt);
        return verificationHelper.getText(userProfileMyAccountTxt);
    }

    public String getWelcomeMessageTxt() {
        return verificationHelper.getText(welcomeBackTxt);
    }

    public String accountDashboardMessage() {
        return accountDashboardTxt.getText();
    }

    public void clickOnLogoutBtn() {
        waitFor(logout);
        waitAndClick(logout);
    }

    public AccountEditPage clickOnEditAccountDetailsLink() throws IOException {
        //waitFor(editAccountDetailsLink);
        //waitAndClick(editAccountDetailsLink);
        editAccountDetailsLink.click();
        return new AccountEditPage(driver);

    }

    public String getAccountProfileSuccessfulUpdateMessage() {
        waitFor(successYourAccountSuccessfullyUpdatedTxt);
        return verificationHelper.getText(successYourAccountSuccessfullyUpdatedTxt);
    }

}