package automationteststore.pageObjects;

import automationteststore.helper.wait.WaitHelper;
import automationteststore.helperutilities.GlobalVars;
import automationteststore.pages.Page;
import automationteststore.helper.logger.LoggerHelper;
import automationteststore.pageObjects.HomePages.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AccountLogoutPage extends Page {
    public WebDriver driver;
    Logger log = LoggerHelper.getLogger(AccountEditPage.class);
    public AccountLogoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[contains(text(),'You have been logged off your account. It is now s')]")
    public WebElement saveToLogoutTxt;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/section[1]/a[1]")
    public WebElement logoutAccountContinueBtn;

    @FindBy(css = ".heading1")
    public WebElement accountLogoutTxt;


    public String getSuccessfulLogOffProcess() throws InterruptedException {
        return verificationHelper.getText(saveToLogoutTxt);
    }

    public String getAccountLogoutTxt() {
        return verificationHelper.getText(accountLogoutTxt);
    }

    public String getCurrentUrl() throws InterruptedException {
        return driver.getCurrentUrl();
    }

    public HomePage clickOnLogoutContinueButton() throws IOException {
        HomePage homePage = new HomePage(driver);
        waitFor(logoutAccountContinueBtn);
        waitAndClick(logoutAccountContinueBtn);
        waitFor(homePage.logoImage);
        return homePage;

    }

    public String getLogoutContinueBtnIsDisplayed() throws InterruptedException {
        waitFor(logoutAccountContinueBtn);
        return verificationHelper.getText(logoutAccountContinueBtn);
    }


}
