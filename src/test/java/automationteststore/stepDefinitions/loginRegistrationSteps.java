package automationteststore.stepDefinitions;

import automationteststore.TestComponents.BaseTest;
import automationteststore.helper.assertion.AssertionHelper;
import automationteststore.helper.assertion.VerificationHelper;
import automationteststore.helperutilities.GlobalVars;
import automationteststore.pageObjects.*;
import automationteststore.pageObjects.HomePages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class loginRegistrationSteps extends BaseTest {
    public WebDriver driver;
    public AccountPage accountPage;
    public AccountLoginPage accountLoginPage;
    public AccountCreatePage accountCreatePage;
    public AccountEditPage accountEditPage;
    public AccountLogoutPage accountLogoutPage;
    public AccountSuccessPage accountSuccessPage;
    public HomePage homePage;


    @Given("I am in Ecommerce home Page {string}")
    public void iAmInEcommerceHomePage(String url) throws IOException {
        homePage = launchApplication();
        AssertionHelper.updateTestStatus(homePage.getCurrentPageUrl().equalsIgnoreCase(url));
        AssertionHelper.updateTestStatus(homePage.getCurrentPageTitle().equalsIgnoreCase(GlobalVars.getHomePageTitle()));

    }

    @And("I navigate to login page")
    public void iNavigateToLoginPage() throws IOException {
        AssertionHelper.updateTestStatus(new VerificationHelper(driver).isDisplayed(homePage.loginOrRegisterLink));
        accountLoginPage = homePage.clickLoginOrRegisterLink();
    }

    @And("I can see {string} and {string} sub headings texts")
    public void iCanSeeAndSubHeadingsTexts(String returingCustomer, String newCustomer) {
        boolean status = accountLoginPage.returningCustomerTxt.getText().equalsIgnoreCase(returingCustomer);
        AssertionHelper.updateTestStatus(status);
        boolean statusForNewCustomer = accountLoginPage.newCustomerTxt.getText().equalsIgnoreCase(newCustomer);
        AssertionHelper.updateTestStatus(statusForNewCustomer);
    }

    @And("I login {string} and {string}")
    public void iLoginAnd(String loginName, String password) {
        accountLoginPage.enterLoginName(loginName);
        accountLoginPage.enterPassword(password);
    }

    @And("I tap on Login button")
    public void iTapOnLoginButton() throws IOException {
        accountPage = accountLoginPage.clickOnLoginBtn();
    }

    @Then("should be presented with the following validation message as {string}")
    public void shouldBePresentedWithTheFollowingValidationMessageAs(String loginValidationMessage) {
        boolean status = accountPage.getWelcomeMessageTxt().contains(loginValidationMessage);
        AssertionHelper.updateTestStatus(status);
    }
    @Then("should be presented with the following Error validation message as {string}")
    public void shouldBePresentedWithTheFollowingErrorValidationMessageAs(String loginValidationErrorMessage) {
        boolean status = accountLoginPage.getErrorIncorrectLoginPasswordProvidedConfirmationMessageTxt().contains(loginValidationErrorMessage);
        AssertionHelper.updateTestStatus(status);
    }

    @And("I tap on edit profile button")
    public void iTapOnEditProfileButton() throws IOException {
        accountEditPage = accountPage.clickOnEditAccountDetailsLink();
    }

    @And("inputted the following details")
    public void inputtedTheFollowingDetails(DataTable dataTable) {
        accountEditPage.enterFirstName(dataTable.cell(1, 0));
        accountEditPage.enterLastName(dataTable.cell(1, 1));
        accountEditPage.enterTelephone(dataTable.cell(1, 2));
        accountEditPage.enterFax(dataTable.cell(1, 3));
    }

    @And("clicks on Continue button")
    public void clicksOnContinueButton() throws IOException {
        accountPage = accountEditPage.clickOnContinueEditBtn();
    }

    @And("I should see confirmation message {string}")
    public void getConfirmationMessage(String successMsg) {
        boolean status = accountPage.getAccountProfileSuccessfulUpdateMessage().trim().contains(successMsg);
        AssertionHelper.updateTestStatus(status);
    }

    @Then("I am taken back to home page url {string} and page title as {string}")
    public void iAmTakenBackToHomePageUrlAndPageTitleAs(String url, String title) {
        AssertionHelper.updateTestStatus(homePage.getCurrentPageUrl().equalsIgnoreCase(url));
        AssertionHelper.updateTestStatus(homePage.getCurrentPageTitle().equalsIgnoreCase(title));
    }

    @When("I clicks on logoff button")
    public void iClicksOnLogoffButton() throws IOException {
        accountLogoutPage = accountPage.clickOnLogoffBtn();
    }

    @And("I tap logout Continue Button")
    public void iTapLogoutContinueButton() throws IOException {
        homePage = accountLogoutPage.clickOnLogoutContinueButton();
    }

    //=====================================================

    @And("I click Continue button in account login page")
    public void iClickContinueButtonInAccountLoginPage() throws IOException {
        accountCreatePage = accountLoginPage.clickOnContinueButton();
    }

    @And("I can see page title as {string} and heading text as {string}")
    public void iCanSeePageTitleAsAndHeadingTextAs(String pageTitle, String pageHeading) {
        Assert.assertTrue(accountCreatePage.getCurrentPageTitle().contains(pageTitle));
        Assert.assertTrue(accountCreatePage.getCreateAccountTxt().trim().contains(pageHeading));

    }

    @And("I should see the create account form")
    public void iShouldSeeTheCreateAccountForm() {
        AssertionHelper.updateTestStatus(new VerificationHelper(driver).isDisplayed(accountCreatePage.getForm()));
    }

    @And("I can see input sections as {string}, {string}, {string} and {string}")
    public void iCanSeeInputSectionsAsAnd(String perDetails, String yourAddr, String loginDetails, String newsletter) throws IOException {
        AssertionHelper.updateTestStatus(accountCreatePage.getYourPersonalDetailsTxt().contains(perDetails));
        AssertionHelper.updateTestStatus(accountCreatePage.getYourAddressText().contains(yourAddr));
        AssertionHelper.updateTestStatus(accountCreatePage.getLoginDetailsSectionTxt().contains(loginDetails));
        AssertionHelper.updateTestStatus(accountCreatePage.getNewsletterTxt().contains(newsletter));

    }

    @And("I can see labels as {int} as first label as {string} and last as {string}")
    public void iCanSeeLabelsAsFirstLabelAndLast(int labelCourt, String firstname, String subscribe) {
        Assert.assertEquals(accountCreatePage.labels.size(), labelCourt, "Label count not matching");
        accountCreatePage.assertLabels_size_positions(labelCourt, firstname, subscribe);
    }

    @And("I input firstName as {string}")
    public void iInputFirstNameAs(String firstname) {
        accountCreatePage.enterFirstName(firstname);
    }

    @And("I input lastName as {string}")
    public void iInputLastNameAs(String lastname) {
        accountCreatePage.enterLastName(lastname);

    }

    @And("I input emailAddress")
    public void iInputEmailAddress() {
        accountCreatePage.enterEmailAddress();
    }

    @And("I input telephone as {string}")
    public void iInputTelephoneAs(String tel) {
        accountCreatePage.enterTelephoneNumber(tel);
    }

    @And("I input fax as {string}")
    public void iInputFaxAs(String fax) {
        accountCreatePage.enterFaxNumber(fax);
    }

    @And("I input company as {string}")
    public void iInputCompanyAs(String coyname) {
        accountCreatePage.enterCompanyName(coyname);
    }

    @And("I input Address one as {string}")
    public void iInputAddressOneAs(String addr1) {
        accountCreatePage.enterAddress1(addr1);
    }

    @And("I input Address two as {string}")
    public void iInputAddressTwoAs(String addr2) {
        accountCreatePage.enterAddress2(addr2);
    }

    @And("I input city as {string}")
    public void iInputCityAs(String city) {
        accountCreatePage.enterCity(city);
    }

    @And("I select region or province {string}")
    public void iSelectRegionOrProvince(String regionOrprovince) {
        accountCreatePage.selectRegionState(regionOrprovince);
    }

    @And("I input zipCodeOrPostCode as {string}")
    public void iInputZipCodeOrPostCodeAs(String ZipOrPostalCode) {
        accountCreatePage.enterPostalOrZipCode(ZipOrPostalCode);
    }

    @And("I select {string} country from the dropdown")
    public void iSelectCountryFromTheDropdown(String country) {
        accountCreatePage.selectCountry(country);
    }

    @And("I input loginName")
    public void iInputLoginName() {
        accountCreatePage.enterLoginName();
    }

    @And("I input password as {string}")
    public void iInputPasswordAs(String password) {
        accountCreatePage.enterPassword(password);
    }

    @And("I input confirm password as {string}")
    public void iInputConfirmPasswordAs(String password) {
        accountCreatePage.enterPasswordConfirm(password);
    }

    @And("I can see subscription option {string}")
    public void iCanSeeSubscriptionOption(String arg0) {
    }

    @And("I tick on subscription option Yes")
    public void iTickOnSubscriptionOptionYes() {
        accountCreatePage.tickOnSubscribeAsYes();
    }


    @And("I tick on {string} radio button")
    public void iTickOnRadioButton(String privacyPolicy) {
        AssertionHelper.updateTestStatus(accountCreatePage.getAgreeToPrivacyPolicyText().contains(privacyPolicy));
        accountCreatePage.checkOnIAgreeToPrivacyPolicyRadioButton();
    }

    @And("I can see {string} button")
    public void iCanSeeButton(String continueBtnTxt) {
        AssertionHelper.updateTestStatus(accountCreatePage.getContinueBtnTxt().contains(continueBtnTxt));

    }

    @And("I tap on Continue button")
    public void iTapOnContinueButton() throws IOException {
        accountSuccessPage = accountCreatePage.clickOnContinueButton();
    }

    @Then("I should see {string} in Account success page")
    public void iShouldSeeInAccountSuccessPage(String accSuccessfullyCreatedMsg) {
        Assert.assertTrue(accountSuccessPage.getAccountHasBeenCreatedHeadingTxt().trim().equalsIgnoreCase(accSuccessfullyCreatedMsg));

    }

    @And("I tap on Continue button in Account success page")
    public void iTapOnContinueButtonInAccountSuccessPage() throws IOException {
        accountPage = accountSuccessPage.clickOnContinueAccountSuccessBtn();
    }

    @And("I can see {string} and {string} in account page")
    public void iCanSeeAndInAccountPage(String dashboard, String welMsgTxt) {
        Assert.assertTrue(accountPage.getAccountDashboardTxt().contains(dashboard));
        Assert.assertTrue(accountPage.getWelcomeMessageTxt().contains(welMsgTxt));
    }

    @And("I am on Account page and presented with welcome message {string}")
    public void iAmOnAccountPageAndPresentedWithWelcomeMessage(String welMsgTxt) {
        Assert.assertTrue(accountPage.getWelcomeMessageTxt().contains(welMsgTxt));
    }

    @And("I clicks on logout Continue Button")
    public void iClicksOnLogoutContinueButton() throws IOException {
        homePage = accountLogoutPage.clickOnLogoutContinueButton();
    }

    @When("I tap on Continue button in create account page")
    public void iTapOnContinueButtonInCreateAccountPage() {
        accountCreatePage.tapContinueButton();
    }

    @Then("I should see red warning error message {string}")
    public void iShouldSeeRedWarningErrorMessage(String privacPolicyErrorMsg) {
        AssertionHelper.updateTestStatus(accountCreatePage.getAgreeToPrivacyPolicyRedMessages().contains(privacPolicyErrorMsg));
    }

    @And("I can see {string} must be between {string} and {string} characters")
    public void iCanSeeFirstNameMustBeBetweenAndCharacters(String firstname, String min, String max) {
        AssertionHelper.updateTestStatus(accountCreatePage.getFirstNameRedMessages().contains(firstname));
        AssertionHelper.updateTestStatus(accountCreatePage.getFirstNameRedMessages().contains(min));
        AssertionHelper.updateTestStatus(accountCreatePage.getFirstNameRedMessages().contains(max));

    }

    @And("I should see {string} must be between {string} and {string} characters!")
    public void iCanSeeLastNameMustBeBetweenAndCharacters(String lastname,String min, String max) {
        AssertionHelper.updateTestStatus(accountCreatePage.getLastNameRedMessages().contains(lastname));
        AssertionHelper.updateTestStatus(accountCreatePage.getLastNameRedMessages().contains(min));
        AssertionHelper.updateTestStatus(accountCreatePage.getLastNameRedMessages().contains(max));
    }

    @And("I can see {string} does not appear to be valid!")
    public void iCanSeeEmailDoesNotAppearToBeValid(String email) {
        AssertionHelper.updateTestStatus(accountCreatePage.getEmailRedMessages().contains(email));
    }

    @And("I should see {string} must be between {string} and {string} characters")
    //I can see "Address 1" must be between "3 and "128" characters
    public void iCanSeeAddressOneMustBeBetweenAndCharacters(String addr1, String min, String max) {
        AssertionHelper.updateTestStatus(accountCreatePage.getAddress1RedMessages().contains(addr1));
        AssertionHelper.updateTestStatus(accountCreatePage.getAddress1RedMessages().contains(min));
        AssertionHelper.updateTestStatus(accountCreatePage.getAddress1RedMessages().contains(max));
    }

    @And("I see {string} must be between {string} and {string} characters!")
    public void iCanSeeCityMustBeBetweenAndCharacters(String city, String min, String max) {
        AssertionHelper.updateTestStatus(accountCreatePage.getCityRedMessages().contains(city));
        AssertionHelper.updateTestStatus(accountCreatePage.getCityRedMessages().contains(min));
        AssertionHelper.updateTestStatus(accountCreatePage.getCityRedMessages().contains(max));
    }

    @And("I can see {string} a region state")
    public void iCanSeeARegionState(String regionOrState) {
        AssertionHelper.updateTestStatus(accountCreatePage.getStateProvinceRedMessages().contains(regionOrState));

    }

    @And("Then I see {string} must be between {string} and {string} characters!")
    public void iCanSeeZipOrPostalCodeMustBeBetweenAndCharacters(String zipOrPostalCode, String min, String max) {
        AssertionHelper.updateTestStatus(accountCreatePage.getZipCodeRedMessages().contains(zipOrPostalCode));
        AssertionHelper.updateTestStatus(accountCreatePage.getZipCodeRedMessages().contains(min));
        AssertionHelper.updateTestStatus(accountCreatePage.getZipCodeRedMessages().contains(max));
    }

    @And("I can see {string} must be alphanumeric only and between {string} and {string} characters!")
    public void iCanSeeMustBeAlphanumericOnlyAndBetweenAndCharacters(String loginname, String min, String max) {
        AssertionHelper.updateTestStatus(accountCreatePage.getLoginNameRedMessages().contains(loginname));
        AssertionHelper.updateTestStatus(accountCreatePage.getLoginNameRedMessages().contains(min));
        AssertionHelper.updateTestStatus(accountCreatePage.getLoginNameRedMessages().contains(max));
    }

    @And("seeing {string} must be between {string} and {string} characters")
    public void iCanSeePasswordMustBeBetweenAndCharacters(String password, String min, String max) {
        AssertionHelper.updateTestStatus(accountCreatePage.getPasswordRedMessages().contains(password));
        AssertionHelper.updateTestStatus(accountCreatePage.getPasswordRedMessages().contains(min));
        AssertionHelper.updateTestStatus(accountCreatePage.getPasswordRedMessages().contains(max));
    }

    @And("I should see {int} mandatory red icons")
    public void iShouldSeeMandatoryRedIcons(int errorCount) {
        int size = accountCreatePage.getCountOfAllMandatoryRedIcons();
        Assert.assertEquals(size, errorCount);

    }

    @And("I input unique loginName")
    public void iInputUniqueLoginName() {
        accountCreatePage.inputUniqueLoginName();
    }

    @When("I tick on read and agree to the Privacy Policy")
    public void iTickOnReadAndAgreeToThePrivacyPolicy() {
        accountCreatePage.checkOnIAgreeToPrivacyPolicyRadioButton();

    }

    @And("I can see list of red error warning messages are displayed")
    public void iShouldSeeRedErrorWarningMessagesAreDisplayed() {
        AssertionHelper.updateTestStatus(accountCreatePage.getAlertErrorDanger().isDisplayed());
    }

    @And("I login as a returning customer")
    public void iLoginAsReturningCustomer(DataTable dataTable) {
        accountLoginPage.enterLoginName(dataTable.cell(1, 0));
        accountLoginPage.enterPassword(dataTable.cell(1, 1));

    }
}



