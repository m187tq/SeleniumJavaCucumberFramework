package automationteststore.pageObjects;

import automationteststore.helper.assertion.VerificationHelper;
import automationteststore.helper.logger.LoggerHelper;
import automationteststore.pages.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AccountLoginPage extends Page {
    public WebDriver driver;
    Logger log = LoggerHelper.getLogger(AccountLoginPage.class);
    public AccountCreatePage accountCreatePage;

    public AccountLoginPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "loginFrm_loginname")
    public WebElement loginNameTxtField;
    @FindBy(css = "#loginFrm_password")
    public WebElement passwordTxtField;
    @FindBy(css = "button[title='Login']")
    public WebElement loginBtn;
    @FindBy(xpath = "//form[@id='loginFrm']//button[@title='Login']")
    public WebElement loginButton;

    public WebElement continueBtn() {
        return continueBtn;
    }

    @FindBy(css = "button[title='Continue']")
    public WebElement continueBtn;

    @FindBy(xpath = "//form[@id='accountFrm']//button[@title='Continue']")
    public WebElement continueButton;

    // successful Login Variables declaration //
    @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/div[1]")
    public WebElement loginWithBlanksCredentialsTxt;

    @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/div[1]/text()")
    public WebElement loginWithBadPasswordTxt;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")
    public WebElement errorIncorrectLoginOrPasswordProvidedTxt;

    // Registration Variables declaration //

    @FindBy(xpath = ".form-group.mb40.mt20")
    public WebElement createAnAccountTxt;

    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    public WebElement returningCustomerTxt;

    @FindBy(xpath = "//a[contains(text(),'Forgot your passwordErrorTxt?')]")
    public WebElement forgotYourPasswordLink;

    // Unsuccessful Login attempts Variables declaration //
    @FindBy(xpath = "//a[contains(text(),'Forgot your Login?')]")
    public WebElement forgotYourLoginLink;

    @FindBy(css = "[class='col-sm-6 newcustomer'] .heading4")
    public WebElement checkoutOptionTxt;

    @FindBy(css = "accountFrm_accountregister")
    public WebElement registerAccountCheckBox;



    @FindBy(xpath = "//h2[contains(text(),'I am a new customer.')]")
    public WebElement newCustomerTxt;


    // Forget Password Variable declaration //
    @FindBy(xpath = "//*[@id='email_create']")
    public WebElement registrationEmailAddress;

    public WebElement getRegisterAccountCheckBox() {
        return registerAccountCheckBox;
    }
    public void enterLoginName(String LoginName) {
        loginNameTxtField.clear();
        sendKeysToWebElement(loginNameTxtField,LoginName);
    }
    public void enterPassword(String Password) {
        passwordTxtField.clear();
        sendKeysToWebElement(passwordTxtField, Password);
    }
    public AccountPage clickOnLoginBtn() throws IOException {
        //waitAndClickElement(loginBtn);
        loginBtn.click();
        return new AccountPage(driver);
    }

    public CheckoutConfirmationPage clickLoginButton() throws IOException {
        loginButton.click();
        return new CheckoutConfirmationPage(driver);
    }

    public String getLoginBtn() {
        return new VerificationHelper(driver).getText(loginBtn);
    }

    public void goToLoginPageEnterLoginNameAndPasswordThenClickOnLoginBtn(String loginName, String password) throws Exception {
        enterLoginName(loginName);
        enterPassword(password);
        clickOnLoginBtn();
    }

    public void clickForgetYourLogin() {
        waitForWebElementAndClick(forgotYourLoginLink);
    }

    public void clickForgetYourPassword() {
       waitForWebElementAndClick(loginWithBadPasswordTxt);
    }

    public String getForgotYourPasswordLinkTxt() {
        return new VerificationHelper(driver).getText(forgotYourPasswordLink);
    }

    public String getForgotYourLogin() {
        return new VerificationHelper(driver).getText(forgotYourLoginLink);
    }

    public String getErrorIncorrectLoginPasswordProvidedConfirmationMessage() {
        waitFor(errorIncorrectLoginOrPasswordProvidedTxt);
        return new VerificationHelper(driver).getText(errorIncorrectLoginOrPasswordProvidedTxt);
    }

    public String getErrorIncorrectLoginPasswordProvidedConfirmationMessageTxt() {
        waitFor(errorIncorrectLoginOrPasswordProvidedTxt);
        return verificationHelper.getText(errorIncorrectLoginOrPasswordProvidedTxt);
    }

    public String getReturningCustomerTxt() {
      return verificationHelper.getText(returningCustomerTxt);
  }
    public String getCheckoutOptionTxt() {
        return verificationHelper.getText(checkoutOptionTxt);
    }

    public boolean isCheckoutOptionSelected() {
        return verificationHelper.isSelected(checkoutOptionTxt);
    }

    public String getNewCustomerTxt() {
        return verificationHelper.getText(newCustomerTxt);
    }

    public AccountCreatePage clickOnContinueButton() throws IOException {
        isCheckoutOptionSelected();
        js.scrollIntoViewAndClick(continueButton);
        accountCreatePage = new AccountCreatePage(driver);
        return accountCreatePage;

    }

    public void clickOnContinueBtn() throws IOException {
        //js.scrollIntoViewAndClick(continueBtn);
        isCheckoutOptionSelected();
        driver.findElement(By.cssSelector("button[title='Continue']")).click();
        //js.scrollIntoViewAndClick(continueButton);
        //continueButton.click();


    }

}
