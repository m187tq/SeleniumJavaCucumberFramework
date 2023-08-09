package automationteststore.tests;

import automationteststore.TestComponents.BaseTest;
import automationteststore.helper.assertion.AssertionHelper;
import automationteststore.pageObjects.*;
import automationteststore.pageObjects.HomePages.HomePage;
import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class registerTestFaker extends BaseTest {
    HomePage homePage;
    AccountLoginPage accountLoginPage;
    AccountCreatePage accountCreatePage;
    AccountPage accountPage;
    AccountLogoutPage accountLogoutPage;
    AccountSuccessPage accountSuccessPage;

    @Test(dataProvider = "getData", groups = {"createAnAccount"})
    public void registration(HashMap<String,String> input) throws IOException {
        Faker fakerWithLocales = new Faker(Locale.UK);

        homePage = new HomePage(driver);
        boolean status = homePage.getCurrentPageUrl().equalsIgnoreCase(input.get("pageUrl"));
        AssertionHelper.updateTestStatus(status);
        AssertionHelper.updateTestStatus(homePage.getCurrentPageTitle().equalsIgnoreCase(input.get("pageTitle")));
        AssertionHelper.updateTestStatus(homePage.getPageHeaderTxt().trim().contains("FEATURED"));

        accountLoginPage = homePage.clickLoginOrRegisterLink();

        AssertionHelper.updateTestStatus(accountLoginPage.getPageHeaderTxt().trim().contains("ACCOUNT LOGIN"));

        AssertionHelper.updateTestStatus(accountLoginPage.getReturningCustomerTxt().trim().equalsIgnoreCase(input.get("returningCustomer")));
        AssertionHelper.updateTestStatus(accountLoginPage.getNewCustomerTxt().trim().equalsIgnoreCase(input.get("newCustomer")));
        accountCreatePage = accountLoginPage.clickOnContinueButton();

        AssertionHelper.updateTestStatus(accountCreatePage.getPageHeaderTxt().trim().contains("CREATE ACCOUNT"));
        AssertionHelper.updateTestStatus(accountCreatePage.getCreateAccountTxt().contains(input.get("createAcc")));

        AssertionHelper.updateTestStatus(accountCreatePage.getYourPersonalDetailsTxt().contains(input.get("personalDetailsSection")));
        accountCreatePage.enterFirstName(fakerWithLocales.name().firstName());
        accountCreatePage.enterLastName(fakerWithLocales.name().lastName());
        accountCreatePage.inputEmailAddress(fakerWithLocales.internet().emailAddress());
        accountCreatePage.enterTelephoneNumber(fakerWithLocales.phoneNumber().cellPhone());
        accountCreatePage.enterFaxNumber(fakerWithLocales.phoneNumber().cellPhone());

        AssertionHelper.updateTestStatus(accountCreatePage.getYourAddressText().contains(input.get("addressSection")));
        accountCreatePage.enterCompanyName(fakerWithLocales.company().bs());
        accountCreatePage.enterAddress1(fakerWithLocales.address().streetAddress());
        accountCreatePage.enterAddress2(fakerWithLocales.address().secondaryAddress());
        accountCreatePage.enterCity(fakerWithLocales.address().city());
        accountCreatePage.selectRegionState(input.get("region"));
        accountCreatePage.enterPostalOrZipCode(input.get("postalCode"));
        accountCreatePage.selectCountry(input.get("country"));

        AssertionHelper.updateTestStatus(accountCreatePage.getLoginDetailsSectionTxt().contains(input.get("loginDetailSection")));
        accountCreatePage.inputLoginName(fakerWithLocales.name().username());
        accountCreatePage.enterPassword(input.get("password"));
        accountCreatePage.enterPasswordConfirm(input.get("conPassword"));


        AssertionHelper.updateTestStatus(accountCreatePage.getNewsletterTxt().contains(input.get("newsletterSection")));
        accountCreatePage.tickOnSubscribeAsYes();
        accountCreatePage.checkOnIAgreeToPrivacyPolicyRadioButton();
        accountSuccessPage = accountCreatePage.clickOnContinueButton();

        AssertionHelper.updateTestStatus(accountSuccessPage.getPageHeaderTxt().trim().contains("YOUR ACCOUNT HAS BEEN CREATED!"));
        boolean status_accountSuccesfullyCreated = accountSuccessPage.getAccountHasBeenCreatedHeadingTxt().contains(input.get("accountSuccesfullyCreated"));
        AssertionHelper.updateTestStatus(status_accountSuccesfullyCreated);

        accountPage = accountSuccessPage.clickOnContinueAccountSuccessBtn();

        AssertionHelper.updateTestStatus(accountPage.getPageHeaderTxt().trim().contains("MY ACCOUNT"));
        boolean result = accountPage.getWelcomeMessageTxt().contains(input.get("welMsg"));
        AssertionHelper.updateTestStatus(result);

        accountLogoutPage = accountPage.clickOnLogoffBtn();

        AssertionHelper.updateTestStatus(accountLogoutPage.getPageHeaderTxt().trim().contains("ACCOUNT LOGOUT"));
        boolean status_logoutPageHeader = accountLogoutPage.getAccountLogoutTxt().equalsIgnoreCase(input.get("accountLogoutHeader"));
        AssertionHelper.updateTestStatus(status_logoutPageHeader);

        homePage = accountLogoutPage.clickOnLogoutContinueButton();

        AssertionHelper.updateTestStatus(homePage.getCurrentPageUrl().equalsIgnoreCase(input.get("pageUrl")));
        AssertionHelper.updateTestStatus(homePage.getCurrentPageTitle().equalsIgnoreCase(input.get("pageTitle")));
        AssertionHelper.updateTestStatus(homePage.getPageHeaderTxt().trim().contains("FEATURED"));
    }
    @DataProvider
    public Object[][] getData() throws IOException
    {
        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//automationteststore//data//createAnAccount.json");
        return new Object[][]  {{data.get(0)} };
        //return new Object[][]  {{data.get(0)}, {data.get(1)}}; // for array multiple data set in the json file
    }


}
