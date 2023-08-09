package automationteststore.pageObjects;

import automationteststore.helperutilities.GlobalVars;
import automationteststore.pages.Page;
import automationteststore.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AccountSuccessPage extends Page {
    public WebDriver driver;
    Logger log = LoggerHelper.getLogger(AccountSuccessPage.class);
    public AccountSuccessPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/h2[1]/span[1]")
    public WebElement myAccountText;
    @FindBy(css = ".btn.btn-default.mr10")
    public WebElement continueAccountSuccessBtn;

    @FindBy(css = ".maintext")
    public WebElement yourAccountHasBeenCreatedHeadingTxt;


    public String getMyAccountTxt() {
        waitFor(myAccountText);
        return verificationHelper.getText(myAccountText);
    }
    public String getAccountHasBeenCreatedHeadingTxt() {
        waitFor(yourAccountHasBeenCreatedHeadingTxt);
        return verificationHelper.getText(yourAccountHasBeenCreatedHeadingTxt);
    }

    public AccountPage clickOnContinueAccountSuccessBtn() throws IOException {
        //waitFor(continueAccountSuccessBtn);
        continueAccountSuccessBtn.click();
        //waitAndClickElement(continueAccountSuccessBtn);
        return new AccountPage(driver);

    }


}
