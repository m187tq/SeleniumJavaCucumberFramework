package automationteststore.tests;

import automationteststore.TestComponents.BaseTest;
import automationteststore.helper.assertion.AssertionHelper;
import automationteststore.helper.assertion.VerificationHelper;
import automationteststore.helperutilities.GlobalVars;
import automationteststore.pageObjects.AccountEditPage;
import automationteststore.pageObjects.AccountLoginPage;
import automationteststore.pageObjects.AccountLogoutPage;
import automationteststore.pageObjects.AccountPage;

import automationteststore.pageObjects.HomePages.HomePage;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {
    HomePage homePage;
    AccountLoginPage accountLoginPage;
    AccountPage accountPage;
    AccountLogoutPage accountLogoutPage;
    AccountEditPage accountEditPage;

    @Test
    public void loginTest() throws IOException {
        homePage = new HomePage(driver);
        boolean status_url = homePage.getCurrentPageUrl().equalsIgnoreCase(GlobalVars.getHomePageUrl());
        AssertionHelper.updateTestStatus(status_url);
        boolean status_title = homePage.getCurrentPageTitle().equalsIgnoreCase(GlobalVars.getHomePageTitle());
        AssertionHelper.updateTestStatus(status_title);
        accountLoginPage = homePage.clickLoginOrRegisterLink();
        boolean status_returningCustomer = accountLoginPage.getReturningCustomerTxt().equalsIgnoreCase(GlobalVars.getReturningCustomer());
        AssertionHelper.updateTestStatus(status_returningCustomer);
        boolean status_newCustomer = accountLoginPage.getNewCustomerTxt().equalsIgnoreCase(GlobalVars.getNewCustomer());
        AssertionHelper.updateTestStatus(status_newCustomer);
        accountLoginPage.enterLoginName(GlobalVars.getUserName());
        accountLoginPage.enterPassword(GlobalVars.getPassword());
        accountPage = accountLoginPage.clickOnLoginBtn();
        boolean status_welcomeMsg = accountPage.getWelcomeMessageTxt().contains(GlobalVars.getWelcomeMsg());
        AssertionHelper.updateTestStatus(status_welcomeMsg);
        accountEditPage = accountPage.clickOnEditAccountDetailsLink();
        new VerificationHelper(driver).getTitle();
        AssertionHelper.updateTestStatus(accountEditPage.getCurrentPageUrl().contains(GlobalVars.getAccountEditUrlpath()));
        accountPage = accountEditPage.clickOnContinueEditBtn();
        boolean status_updatedSuccessfully = accountPage.getAccountProfileSuccessfulUpdateMessage().contains(GlobalVars.getUpdatedSuccessfully());
        AssertionHelper.updateTestStatus(status_updatedSuccessfully);
        accountLogoutPage = accountPage.clickOnLogoffBtn();
        boolean status_AccountLogoutHeader = accountLogoutPage.getAccountLogoutTxt().contains(GlobalVars.getAccountLogoutHeaderTxt());
        AssertionHelper.updateTestStatus(status_AccountLogoutHeader);
        homePage = accountLogoutPage.clickOnLogoutContinueButton();
    }
}