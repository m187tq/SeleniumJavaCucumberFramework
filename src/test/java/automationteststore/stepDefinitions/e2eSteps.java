package automationteststore.stepDefinitions;

import automationteststore.TestComponents.BaseTest;
import automationteststore.helper.assertion.AssertionHelper;
import automationteststore.helperutilities.GlobalVars;
import automationteststore.pageObjects.*;
import automationteststore.pageObjects.CheckoutCartPage;
import automationteststore.pageObjects.CartSummaryPage;
import automationteststore.pageObjects.CheckoutPages.*;
import automationteststore.pageObjects.HomePages.FooterPage;
import automationteststore.pageObjects.HomePages.HomePage;
import automationteststore.pageObjects.HomePages.InvoiceOrderPage;
import automationteststore.pageObjects.HomePages.MiddleMenuNaviPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;


public class e2eSteps extends BaseTest {

    public WebDriver driver;
    public AccountPage accountPage;
    public AccountLoginPage accountLoginPage;
    public AccountCreatePage accountCreatePage;
    public AccountEditPage accountEditPage;
    public AccountLogoutPage accountLogoutPage;
    public AccountSuccessPage accountSuccessPage;
    public HomePage homePage;
    public AddToCartPage addToCartPage;

    public NavigationMenuPage navigationMenuPage;
    public SearchResultPage searchResultPage;
    public ShippingReturnsPage shippingReturnsPage;
    public InvoiceOrderPage invoiceOrderPage;
    public MiddleMenuNaviPage middleMenuNaviPage;
    public FooterPage footerPage;
    public CheckoutBillingPage checkoutBillingPage;
    public CheckoutCartPage checkoutCartPage;
    public CheckoutCustomerPage checkoutCustomerPage;
    public CheckoutConfirmationPage checkoutConfirmationPage;
    public CheckoutPage checkoutPage;
    public CheckoutShippingModeEditPage checkoutShippingModeEditPage;
    public CheckoutSuccessPage checkoutSuccessPage;
    public PaymentModeEditPage paymentModeEditPage;
    public ProductCategoryPage productCategoryPage;
    public ProductIDPage productIDPage;
    public CartSummaryPage cartSummaryPage;


    @Given("I am on ecommerce website")
    public void iAmOnEcommerceWebsite() throws IOException {
        homePage = launchApplication();
        AssertionHelper.updateTestStatus(homePage.getCurrentPageUrl().equalsIgnoreCase(GlobalVars.getHomePageUrl()));
        AssertionHelper.updateTestStatus(homePage.getCurrentPageTitle().equalsIgnoreCase(GlobalVars.getHomePageTitle()));
    }

    @When("I search with a keyword {string}")
    public void iMoveToTheSearchAndInputAKeyword(String item) throws IOException {
        productCategoryPage = homePage.searchByKeyword(item);
        productCategoryPage.clickProductDescription();
        productCategoryPage.clickProductModel();
        productCategoryPage.clickOnSearchBtn();

    }

    @And("I can see {string} search result")
    public void iCanSeeSearchResult(String searchFound) {
        boolean status = productCategoryPage.getSearchResultFoundTxt().trim().contains(searchFound);
        AssertionHelper.updateTestStatus(status);
    }

    @And("I add product {string}, {string} and {string} to cart")
    public void iAddAnItemToCart(String productName0, String productName1, String productName2) {
        productCategoryPage.addProductToCart(productName0);
        productCategoryPage.addProductToCart(productName1);
        productCategoryPage.addProductToCart(productName2);
    }

    @And("I add products to cart {string}, {string} and {string}")
    public void i_add_products_to_cart_and(String productName0, String productName1, String productName2) {
        homePage.addProductsToCart(productName0);
        homePage.addProductsToCart(productName1);
        homePage.addProductsToCart(productName2);

    }
    @And("I navigate to checkout cart page")
    public void iNavigateToCheckoutCartPage() throws IOException {
        checkoutCartPage = productCategoryPage.clickCartLink();
        checkoutCartPage.getPageHeaderTxt();
    }

    @And("I navigate to checkout-cart page")
    public void iNavigateToCheckout_CartPage() throws IOException {
        checkoutCartPage = homePage.clickCartLink();
    }

    @And("I increased quantity by {int}")
    public void iInputInQuantityFieldAndIncreasedBy(int number) {
        checkoutCartPage.inputItemQuantity(number);
        checkoutCartPage.clickOnUpdateBtn();
    }
    @And("I reduced quantity by {int}")
    public void iReducedQuantityBy(int number) {
        checkoutCartPage.inputItemQuantity(number);
        checkoutCartPage.clickOnUpdateBtn();
    }

    @And("I removed some items")
    public void iRemovedSomeItems() {
        checkoutCartPage.clickOnRemoveIconBtn();
    }

    @And("I add an item {string} and increase quantity by {int}")
    public void iAddAnItemAndIncreaseQuantityBy(String arg0, int arg1) {
    }

    @And("I should see the product item , unit price, quantity and grand total price")
    public void iShouldSeeTheProductItemUnitPriceQuantityAndGrandTotalPrice() {
    }

    @And("I can see {string} and  {string}")
    public void iCanSeeAnd(String returningCustomerTxt, String newCustomerTxt) {
        boolean status_returningCustomer = accountLoginPage.getReturningCustomerTxt().equalsIgnoreCase(returningCustomerTxt);
        AssertionHelper.updateTestStatus(status_returningCustomer);
        boolean status_newCustomer = accountLoginPage.getNewCustomerTxt().equalsIgnoreCase(newCustomerTxt);
        AssertionHelper.updateTestStatus(status_newCustomer);

    }

    @And("I login in login page as a returning customer")
    public void iLoginInLoginPageAsAReturningCustomer(DataTable dataTable) throws IOException {
        accountLoginPage.enterLoginName(dataTable.cell(1, 0));
        accountLoginPage.enterPassword(dataTable.cell(1, 1));
        checkoutConfirmationPage = accountLoginPage.clickLoginButton();
    }

    @And("I click on confirm order button")
    public void iClickOnConfirmOrderButton() throws InterruptedException, IOException {
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getConfirmOrderButtonTxt().contains("Confirm"));
        checkoutSuccessPage = checkoutConfirmationPage.clickOnConfirmOrderButton();
    }

    @And("I am presented with an order number {string}")
    public void iAmPresentedWithAnOderNumber(String orderNumberMsg) {
        boolean status = checkoutSuccessPage.getOrderNumberTxt().contains(orderNumberMsg);
        AssertionHelper.updateTestStatus(status);

    }

    @And("I click on continue Button")
    public void iClicksOnContinueAndLogoutButton() throws IOException {
        checkoutSuccessPage.clickOnContinueCheckoutSuccessBtn();
    }

    @And("I am back to home page")
    public void iAmBackToHomePage() {
        AssertionHelper.updateTestStatus(homePage.getCurrentPageUrl().equalsIgnoreCase(GlobalVars.getHomePageUrl()));
        AssertionHelper.updateTestStatus(homePage.getCurrentPageTitle().equalsIgnoreCase(GlobalVars.getHomePageTitle()));
    }

    @And("I tap on checkout button")
    public void iTapOnCheckoutButton() throws IOException {
        accountLoginPage = checkoutCartPage.clickOnCheckoutBtn();
    }

    @And("I login with {string} and {string} as a returning customer")
    public void iLoginWithValidCredentialsAsAReturningCustomer(String loginname, String password) throws IOException {
        accountLoginPage.enterLoginName(loginname);
        accountLoginPage.enterPassword(password);
        checkoutConfirmationPage = accountLoginPage.clickLoginButton();
    }

    @And("I should be on checkout confirmation page")
    public void iShouldBeOnCheckoutConfirmationPage() {
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getCurrentPageUrl().contains("?rt=checkout/confirm"));
        AssertionHelper.updateTestStatus(checkoutConfirmationPage.getCurrentPageTitle().contains("Checkout Confirmation"));
    }

    @And("I can see YOUR ORDER HAS BEEN PROCESSED is Displayed")
    public void iCanSeeYourOrderHasBeenProcessedDisplayed() {
        boolean status = checkoutSuccessPage.getYourOrderHasBeenProcessedTxt().contains("YOUR ORDER HAS BEEN PROCESSED");
        Assert.assertTrue(status);
    }
}



