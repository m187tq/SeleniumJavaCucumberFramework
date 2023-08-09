package automationteststore.tests;

import automationteststore.TestComponents.BaseTest;
import automationteststore.helper.assertion.AssertionHelper;
import automationteststore.pageObjects.*;
import automationteststore.pageObjects.HomePages.HomePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class RegisterTest extends BaseTest {
    HomePage homePage;
    AccountLoginPage accountLoginPage;
    AccountCreatePage accountCreatePage;
    AccountPage accountPage;
    AccountLogoutPage accountLogoutPage;
    AccountSuccessPage accountSuccessPage;

    @Test(dataProvider = "getData", groups = {"createAnAccount"})
    public void registration(HashMap<String,String> input) throws IOException {
        homePage = new HomePage(driver);
        boolean status = homePage.getCurrentPageUrl().equalsIgnoreCase(input.get("pageUrl"));
        AssertionHelper.updateTestStatus(status);
        AssertionHelper.updateTestStatus(homePage.getCurrentPageTitle().equalsIgnoreCase(input.get("pageTitle")));
        accountLoginPage = homePage.clickLoginOrRegisterLink();

        AssertionHelper.updateTestStatus(accountLoginPage.getReturningCustomerTxt().trim().equalsIgnoreCase(input.get("returningCustomer")));
        AssertionHelper.updateTestStatus(accountLoginPage.getNewCustomerTxt().trim().equalsIgnoreCase(input.get("newCustomer")));
        accountCreatePage = accountLoginPage.clickOnContinueButton();
        AssertionHelper.updateTestStatus(accountCreatePage.getCreateAccountTxt().contains(input.get("createAcc")));

        AssertionHelper.updateTestStatus(accountCreatePage.getYourPersonalDetailsTxt().contains(input.get("personalDetailsSection")));
        accountCreatePage.enterFirstName(input.get("fName"));
        accountCreatePage.enterLastName(input.get("lName"));
        accountCreatePage.enterEmailAddress();
        accountCreatePage.enterTelephoneNumber(input.get("tel"));
        accountCreatePage.enterFaxNumber(input.get("fax"));

        AssertionHelper.updateTestStatus(accountCreatePage.getYourAddressText().contains(input.get("addressSection")));

        accountCreatePage.enterCompanyName(input.get("coyName"));
        accountCreatePage.enterAddress1(input.get("addr1"));
        accountCreatePage.enterAddress2(input.get("addr2"));
        accountCreatePage.enterCity(input.get("city"));
        accountCreatePage.selectRegionState(input.get("region"));
        accountCreatePage.enterPostalOrZipCode(input.get("postalCode"));
        accountCreatePage.selectCountry(input.get("country"));

        AssertionHelper.updateTestStatus(accountCreatePage.getLoginDetailsSectionTxt().contains(input.get("loginDetailSection")));
        accountCreatePage.enterLoginName();
        accountCreatePage.enterPassword(input.get("password"));
        accountCreatePage.enterPasswordConfirm(input.get("conPassword"));

        AssertionHelper.updateTestStatus(accountCreatePage.getNewsletterTxt().contains(input.get("newsletterSection")));

        accountCreatePage.tickOnSubscribeAsYes();
        accountCreatePage.checkOnIAgreeToPrivacyPolicyRadioButton();
        accountSuccessPage = accountCreatePage.clickOnContinueButton();
        boolean result1 = accountSuccessPage.getAccountHasBeenCreatedHeadingTxt().contains(input.get("accountSuccesfullyCreated"));
        AssertionHelper.updateTestStatus(result1);

        accountPage = accountSuccessPage.clickOnContinueAccountSuccessBtn();

        boolean result = accountPage.getWelcomeMessageTxt().contains(input.get("welMsg"));
        AssertionHelper.updateTestStatus(result);

        accountLogoutPage = accountPage.clickOnLogoffBtn();
        boolean result_logoutPageHeader = accountLogoutPage.getAccountLogoutTxt().equalsIgnoreCase(input.get("accountLogoutHeader"));
        AssertionHelper.updateTestStatus(result_logoutPageHeader);
        homePage = accountLogoutPage.clickOnLogoutContinueButton();

        AssertionHelper.updateTestStatus(homePage.getCurrentPageUrl().equalsIgnoreCase(input.get("pageUrl")));
        AssertionHelper.updateTestStatus(homePage.getCurrentPageTitle().equalsIgnoreCase(input.get("pageTitle")));
    }
    @DataProvider
    public Object[][] getData() throws IOException
    {
        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//automationteststore//data//createAnAccount.json");
        return new Object[][]  {{data.get(0)} };
        // return new Object[][]  {{data.get(0)}, {data.get(0)}}; for array multiple data set in the json file
    }


}
