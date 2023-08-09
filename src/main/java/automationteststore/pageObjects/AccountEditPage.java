package automationteststore.pageObjects;

import automationteststore.helper.wait.WaitHelper;
import automationteststore.helperutilities.GlobalVars;
import automationteststore.pages.Page;
import automationteststore.helper.assertion.VerificationHelper;
import automationteststore.helper.javaScript.JavaScriptHelper;
import automationteststore.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AccountEditPage extends Page {
    public WebDriver driver;
    Logger log = LoggerHelper.getLogger(AccountEditPage.class);
    public AccountEditPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/h1[1]/span[1]")
    public WebElement myaccountInformationHeadingtext;

    @FindBy(name = "firstname")
    public WebElement firstNameBox;
    @FindBy(xpath = "//*[@id='AccountFrm_lastname']")
    public WebElement lastNameBox;

    @FindBy(id = "AccountFrm_email")
    public WebElement emailBox;
    @FindBy(css = "#AccountFrm_telephone")
    public WebElement telephoneBox;
    @FindBy(css = "#AccountFrm_fax")
    public WebElement faxBox;
    @FindBy(xpath = "//*[@id='AccountFrm']/div[2]/div/button")
    public static WebElement continueEditBtn;

    public String userOnAccountEditPage() {
        waitFor(myaccountInformationHeadingtext);
        return new VerificationHelper(driver).getText(myaccountInformationHeadingtext);
    }
    public void enterFirstName(String FirstName) {
        firstNameBox.clear();
        sendKeys(firstNameBox, FirstName);
    }
    public void enterLastName(String Lastname) {
        lastNameBox.clear();
        sendKeys(lastNameBox, Lastname);
    }
    public void enterFreshEmail() {
        emailBox.clear();
        String email = System.currentTimeMillis() + "@gmail.com";
        sendKeys(emailBox, email);

    }

    public void enterTelephone(String Telephone) {
        telephoneBox.clear();
        sendKeys(telephoneBox, Telephone);

    }

    public void enterFax(String Fax) {
        faxBox.clear();
        sendKeys(faxBox, Fax);

    }

    public AccountPage clickOnContinueEditBtn() throws IOException {
        new JavaScriptHelper(driver).scrollToElement(continueEditBtn);
        //waitAndClickElement(continueEditBtn);
        continueEditBtn.click();
        return new AccountPage(driver);
    }
    public void updatingProfileDetails(String firstname, String lastname, String telephone, String fax) {
        log.info("editing Profile Details....");
        enterFirstName(firstname);
        enterLastName(lastname);
        enterFreshEmail();
        enterTelephone(telephone);
        enterFax(fax);
        log.info("editing Profile Details....");

    }

}
