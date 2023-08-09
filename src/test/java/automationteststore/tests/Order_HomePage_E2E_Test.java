package automationteststore.tests;

import automationteststore.TestComponents.BaseTest;
import automationteststore.helper.assertion.AssertionHelper;
import automationteststore.helperutilities.GlobalVars;
import automationteststore.pageObjects.AccountLoginPage;
import automationteststore.pageObjects.CheckoutCartPage;
import automationteststore.pageObjects.CheckoutConfirmationPage;
import automationteststore.pageObjects.CheckoutSuccessPage;
import automationteststore.pageObjects.HomePages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Order_HomePage_E2E_Test extends BaseTest {
    String[] itemsNeeded= {"SKINSHEEN BRONZER STICK","BENEFIT BELLA BAMBA","ABSOLUE EYE PRECIOUS CELLS"};
    HomePage homePage;
    AccountLoginPage accountLoginPage;
    CheckoutConfirmationPage checkoutConfirmationPage;
    CheckoutCartPage checkoutCartPage;
    CheckoutSuccessPage checkoutSuccessPage;

    @Test
    public void completeOrder() throws IOException {
        homePage = new HomePage(driver);
        boolean status_url = homePage.getCurrentPageUrl().equalsIgnoreCase(GlobalVars.getHomePageUrl());
        AssertionHelper.updateTestStatus(status_url);
        boolean status_title = homePage.getCurrentPageTitle().equalsIgnoreCase(GlobalVars.getHomePageTitle());
        AssertionHelper.updateTestStatus(status_title);

        homePage.addProductsToCart(GlobalVars.PRODUCTNAME_1);
        homePage.addProductsToCart(GlobalVars.PRODUCTNAME_2);
        homePage.addProductsToCart(GlobalVars.PRODUCTNAME_3);

        checkoutCartPage = homePage.clickCartLink();
        checkoutCartPage.inputItemQuantity(4);
        checkoutCartPage.clickOnUpdateBtn();

        checkoutCartPage.inputItemQuantity(2);
        checkoutCartPage.clickOnUpdateBtn();

        checkoutCartPage.clickOnRemoveIconBtn();

        accountLoginPage = checkoutCartPage.clickOnCheckoutBtn();

        boolean status_returningCustomer = accountLoginPage.getReturningCustomerTxt().equalsIgnoreCase(GlobalVars.getReturningCustomer());
        AssertionHelper.updateTestStatus(status_returningCustomer);
        boolean status_newCustomer = accountLoginPage.getNewCustomerTxt().equalsIgnoreCase(GlobalVars.getNewCustomer());
        AssertionHelper.updateTestStatus(status_newCustomer);
        accountLoginPage.enterLoginName(GlobalVars.getUserName());
        accountLoginPage.enterPassword(GlobalVars.getPassword());
        checkoutConfirmationPage = accountLoginPage.clickLoginButton();
        checkoutSuccessPage = checkoutConfirmationPage.clickOnConfirmOrderButton();

        boolean status_orderNunber = checkoutSuccessPage.getOrderNumberTxt().contains("Your order #");
        Assert.assertTrue(status_orderNunber, "Order numder is not contained and displayed");

        checkoutSuccessPage.clickOnContinueCheckoutSuccessBtn();

        AssertionHelper.updateTestStatus(homePage.getCurrentPageUrl().contains("https://automationteststore.com/"));
        AssertionHelper.updateTestStatus(homePage.getCurrentPageTitle().contains("A place to practice your automation skills!"));
    }
}