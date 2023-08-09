package automationteststore.pageObjects;

import automationteststore.helper.wait.WaitHelper;
import automationteststore.helperutilities.GlobalVars;
import automationteststore.pages.Page;
import automationteststore.helper.assertion.VerificationHelper;
import automationteststore.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class AccountCreatePage extends Page {

    public WebDriver driver;
    AccountSuccessPage accountSuccessPage;
    Logger log = LoggerHelper.getLogger(AccountCreatePage.class);

    public AccountCreatePage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    // URL, LOGO, TEXTS//
    public final String URL = "https://automationteststore.com/index.php?rt=account/create";
    @FindBy(xpath = "//*[@id='maincontainer']/div/div[1]/div/h1/span[1]/text()")
    public WebElement yourAccountHasBeenCreatedTxt;
    @FindBy(xpath = "//a[contains(text(),'Register')]")
    public WebElement registerLinkText;
    @FindBy(css = ".heading1")
    public WebElement createAccountTxt;
    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/p[1]")
    public WebElement ifYouAlreadyHaveAnAccountWithUs;

    @FindBy(css = "#AccountFrm")
    public WebElement form;
    @FindBy(css = "label.control-label.col-sm-4")
    public List<WebElement> labels;

    @FindBy(xpath = "//h4[contains(text(),'Your Personal Details')]")
    public WebElement yourPersonalDetailsTxt;
    @FindBy(xpath = "//input[@id='AccountFrm_firstname']")
    public WebElement firstNameTextBox;

    //**************Your Personal Details**************//
    @FindBy(xpath = "//input[@id='AccountFrm_lastname']")
    public WebElement lastNameTextBox;
    @FindBy(xpath = "//input[@id='AccountFrm_email']")
    public WebElement emailTextBox;
    @FindBy(xpath = "//input[@id='AccountFrm_telephone']")
    public WebElement telephoneTextBox;
    @FindBy(xpath = "//input[@id='AccountFrm_fax']")
    public WebElement faxTextBox;
    @FindBy(xpath = "//h4[contains(text(),'Your Address')]")
    public WebElement yourAddressText;
    @FindBy(css = "#AccountFrm_company")
    public WebElement companyTextBox;

    //**************Your Address*****************//
    @FindBy(css = "#AccountFrm_address_1")
    public WebElement address1TextBox;
    @FindBy(xpath = "//input[@id='AccountFrm_address_2']")
    public WebElement address2TextBox;
    @FindBy(css = "#AccountFrm_city")
    public WebElement cityTextBox;
    @FindBy(xpath = "//select[@id='AccountFrm_zone_id']")
    public WebElement regionStateDropdownBtn;
    @FindBy(xpath = "//input[@id='AccountFrm_postcode']")
    public WebElement zipCodeTextBox;
    @FindBy(xpath = "//select[@id='AccountFrm_country_id']")
    public WebElement countryDropdownBtn;
    @FindBy(xpath = "//h4[contains(text(),'Login Details')]")
    public WebElement loginDetailsSectionText;
    @FindBy(css = "#AccountFrm_loginname")
    public WebElement loginNameTextBox;

    //**************Login Details**************//
    @FindBy(css = "#AccountFrm_password")
    public WebElement passwordTextBox;
    @FindBy(css = "#AccountFrm_confirm")
    public WebElement passwordConfirmTextBox;
    @FindBy(xpath = "//h4[contains(text(),'Newsletter')]")
    public WebElement newsletterText;
    @FindBy(css = "#AccountFrm_newsletter1")
    public WebElement subscribeYesRadioButton;

    //**************Newsletter**********************//
    @FindBy(css = "#AccountFrm_newsletter0")
    public WebElement subscribeNORadioButton;
    @FindBy(css = "#AccountFrm_agree")
    public WebElement agreeToPrivacyPolicyButton;

    public String getAgreeToPrivacyPolicyText() {
        return verificationHelper.getText(agreeToPrivacyPolicyText);
    }

    @FindBy(css = ".col-md-6.mb40.mt20")
    public WebElement agreeToPrivacyPolicyText;
    // Summit button //
    @FindBy(css = "button[title='Continue']")
    public WebElement continueBtn;
    @FindBy(css = "#AccountFrm_firstname")
    public WebElement firstNameErrorTxt;
    @FindBy(css = "#AccountFrm_lastname")
    public WebElement lastNameErrorTxt;

    //**********ERRORS ********************//
    @FindBy(css = "#AccountFrm_email")
    public WebElement emailErrorTxt;

    @FindBy(css = ".alert.alert-error.alert-danger")
    public WebElement alertErrorDangerList;
    @FindBy(css = "#AccountFrm_address_1")
    public WebElement address1ErrorTxt;
    @FindBy(css = "#AccountFrm_city")
    public WebElement cityErrorTxt;
    @FindBy(css = "#AccountFrm_zone_id")
    public WebElement regionStateErrorTxt;
    @FindBy(css = "#AccountFrm_postcode")
    public WebElement zipCodeErrorTxt;
    @FindBy(css = "#AccountFrm_password")
    public WebElement passwordErrorTxt;
    @FindBy(xpath = "//b[contains(text(),'Privacy Policy')]")
    public WebElement privacyPolicyErrorTxt;
    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")
    public WebElement youMustAgreeToThePrivacyPolicyErrorTxt;
    @FindBy(xpath = "//span[contains(text(),'')]")
    public List<WebElement> allHighlightedWarningRedMessageErrorTxt;
    @FindBy(xpath = "//span[contains(text(),'First Name must be between 1 and 32 characters!')]")
    public WebElement firstNameRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Last Name must be between 1 and 32 characters!')]")
    public WebElement lastNameRedMessages;

    //**********RED WARNING MESSAGES**********//
    @FindBy(xpath = "//span[contains(text(),'Email Address does not appear to be valid!')]")
    public WebElement emailRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Address 1 must be between 3 and 128 characters!')]")
    public WebElement address1RedMessages;
    @FindBy(xpath = "//span[contains(text(),'City must be between 3 and 128 characters!')]")
    public WebElement cityRedMessages;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/fieldset[1]/div[6]/span[1]")
    public WebElement zipCodeRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Please select a region / state!')]")
    public WebElement StateProvinceRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Login name must be alphanumeric only and between 5')]")
    public WebElement loginNameRedMessages;
    @FindBy(xpath = "//span[contains(text(),'Password must be between 4 and 20 characters!')]")
    public WebElement passwordRedMessages;
    @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/div[1]")
    public WebElement agreeToPrivacyPolicyRedMessages;

    @FindBy(css = "span.input-group-addon")
    public List<WebElement> mandatoryfields;

    String email = System.currentTimeMillis() + "Gen";

    public WebElement getForm() {
        return form;
    }

    public String getCreateAccountTxt() {
        return new VerificationHelper(driver).getText(createAccountTxt);
    }

    public void assertLabels_size_positions(int labelCourt, String firstname, String subscribe) {
        int size = labels.size();
        System.out.println("Size of labels: " + size);
        log.info("Size of labels: " + size);
        for (int i = 0; i < size; i++) {
            String labelsText = labels.get(i).getText();
            log.info(labelsText);
            System.out.println(labelsText);
            if (labels.get(0).getText().trim().contains(firstname) || labels.get(15).getText().trim().contains(subscribe)) {
                Assert.assertEquals(size, labelCourt);

            }


        }

    }

    public int getLabelResultsCount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until((d) -> this.labels.size() > 14);
        return this.labels.size();
    }

    public String getIfYouAlreadyHaveAnAccountWithUs() {
        return new VerificationHelper(driver).getText(ifYouAlreadyHaveAnAccountWithUs);
    }

    public String getYourPersonalDetailsTxt() {
        return new VerificationHelper(driver).getText(yourPersonalDetailsTxt);
    }

    public void enterFirstName(String firstName) {
        sendKeys(firstNameTextBox, firstName);
    }

    public void enterLastName(String lastName) {
        sendKeys(lastNameTextBox, lastName);
    }

    public void enterEmailAddress() {
        String email = System.currentTimeMillis() + "@gmail.com";
        waitAndSendKeys(emailTextBox, email);
    }

    public void inputEmailAddress(String email) {
        emailTextBox.clear();
        waitAndSendKeys(emailTextBox, email);
    }

    public void enterTelephoneNumber(String telephone) {
        sendKeys(telephoneTextBox, telephone);
    }

    public void enterFaxNumber(String fax) {
        sendKeys(faxTextBox, fax);
    }

    public void enterYourPersonalDetailsSection(String firstName, String lastName, String telephone, String fax) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmailAddress();
        enterTelephoneNumber(telephone);
        enterFaxNumber(fax);

    }

    public String getYourAddressText() {
        return new VerificationHelper(driver).getText(yourAddressText);
    }

    public void enterCompanyName(String companyName) {
        sendKeys(companyTextBox, companyName);
    }

    public void enterAddress1(String address1) {
        sendKeys(address1TextBox, address1);
    }

    public void enterAddress2(String address2) {
        sendKeys(address2TextBox, address2);
    }

    public void enterCity(String cityName) {
        sendKeys(cityTextBox, cityName);
    }

    public void selectRegionState(String regionOrStateName) {
        selectByVisibleText(regionOrStateName, regionStateDropdownBtn);
    }

    public void enterPostalOrZipCode(String ZipOrPostalCode) {
        sendKeys(zipCodeTextBox, ZipOrPostalCode);
    }

    public void selectCountry(String countryName) {
        selectByVisibleText(countryName, countryDropdownBtn);

    }

    public String getLoginDetailsSectionTxt() throws IOException {
        return new VerificationHelper(driver).getText(loginDetailsSectionText);
    }

    public void enterLoginName() {
        loginNameTextBox.clear();
        waitAndSendKeys(loginNameTextBox, email);

    }

    public void inputLoginName(String loginname) {
        loginNameTextBox.clear();
        waitAndSendKeys(loginNameTextBox, loginname);

    }

    public void inputUniqueLoginName() {
        loginNameTextBox.clear();
        String loginname = System.currentTimeMillis() + "Gen";
        loginNameTextBox.sendKeys(loginname);
        log.info("Keys successfully sent to login name field :: " + loginname);

    }

    public void enterPassword(String password) {
        waitAndSendKeys(passwordTextBox, password);
    }

    public void enterPasswordConfirm(String passwordConfirm) {
        waitAndSendKeys(passwordConfirmTextBox, passwordConfirm);
    }

    public String getNewsletterTxt() throws IOException {
        return new VerificationHelper(driver).getText(newsletterText);

    }

    public void tickOnSubscribeAsYes() {
        waitForWebElementAndClick(subscribeYesRadioButton);

    }

    public boolean validateSubscribeYesTicked() {
        return isSelected(subscribeYesRadioButton);

    }

    public void clickOnSubscribeAsNo() {
        waitForWebElementAndClick(subscribeNORadioButton);

    }

    public void checkOnIAgreeToPrivacyPolicyRadioButton() {
        waitForWebElementAndClick(agreeToPrivacyPolicyButton);
    }

    public AccountSuccessPage clickOnContinueButton() throws IOException {
        continueBtn.click();
        accountSuccessPage = new AccountSuccessPage(driver);
        return accountSuccessPage;
    }


//===========================================================================================================//

    public String getFirstNameRedMessages() {
        return verificationHelper.getText(firstNameRedMessages);

    }

    public String getLastNameRedMessages() {
        return verificationHelper.getText(lastNameRedMessages);

    }

    public String getEmailRedMessages() {
        return verificationHelper.getText(emailRedMessages);
    }

    public String getAddress1RedMessages() {
        return verificationHelper.getText(address1RedMessages);

    }

    public String getCityRedMessages() {
        return verificationHelper.getText(cityRedMessages);
    }

    public String getZipCodeRedMessages() {
        return verificationHelper.getText(zipCodeRedMessages);
    }
    public String getStateProvinceRedMessages() {
        return verificationHelper.getText(StateProvinceRedMessages);
    }
    public String getLoginNameRedMessages() {
        return verificationHelper.getText(loginNameRedMessages);
    }

    public String getPasswordRedMessages() {
        return verificationHelper.getText(passwordRedMessages);
    }
    public String getAgreeToPrivacyPolicyRedMessages() {
        return verificationHelper.getText(agreeToPrivacyPolicyRedMessages);

    }
    public String getContinueBtnTxt() {
        return verificationHelper.getText(continueBtn);
    }
    public void tapContinueButton() {
        waitAndClickElement(continueBtn);
        //continueBtn.click();
    }
    public int getCountOfAllMandatoryRedIcons() {
        int size = mandatoryfields.size();
        System.out.println("Size of labels: " + size);
        log.info("Size of labels: " + size);
        return size;
    }
    public WebElement getAlertErrorDanger() {
        return alertErrorDangerList;
    }

}