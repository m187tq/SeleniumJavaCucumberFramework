package automationteststore.stepDefinitions;

import automationteststore.TestComponents.BaseTest;
import automationteststore.pageObjects.*;
import automationteststore.pageObjects.CartSummaryPage;
import automationteststore.pageObjects.CheckoutPages.*;
import automationteststore.pageObjects.HomePages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class contactusSteps extends BaseTest {
    public WebDriver driver;
    private AccountPage accountPage;
    private AccountLoginPage accountLoginPage;
    private AccountCreatePage accountCreatePage;
    private AccountEditPage accountEditPage;
    private AccountLogoutPage accountLogoutPage;
    private AccountSuccessPage accountSuccessPage;
    private HomePage homePage;
    private AddToCartPage addToCartPage;

    private NavigationMenuPage navigationMenuPage;
    private SearchResultPage searchResultPage;
    private ShippingReturnsPage shippingReturnsPage;
    private InvoiceOrderPage invoiceOrderPage;
    private MiddleMenuNaviPage middleMenuNaviPage;
    private FooterPage footerPage;
    private CheckoutBillingPage checkoutBillingPage;

    private CheckoutCartPage checkoutCartPage;
    private CheckoutConfirmationPage checkoutConfirmationPage;
    private CheckoutCustomerPage checkoutCustomerPage;
    private CheckoutPage checkoutPage;
    private CheckoutShippingModeEditPage checkoutShippingModeEditPage;
    private CheckoutSuccessPage checkoutSuccessPage;
    private PaymentModeEditPage paymentModeEditPage;
    private CartSummaryPage cartSummaryPage;

    @Given("I navigate to contactus page")
    public void iNavigateToContactusPage() {
    }

    @And("should see company contact details are displayed {string}")
    public void shouldSeeCompanyContactDetailsAreDisplayed(String arg0) {
    }

    @When("I inputted first name as {string} email Address as {string} and inquiry as {string}")
    public void iInputtedFirstNameAsEmailAddressAsAndInquiryAs(String arg0, String arg1, String arg2) {
    }

    @And("clicks on the submit button")
    public void clicksOnTheSubmitButton() {
    }

    @Then("I should get confirmation warning massage firstname  {string}")
    public void iShouldGetConfirmationWarningMassageFirstname(String arg0) {
    }

    @Then("I should get confirmation warning massage email {string}")
    public void iShouldGetConfirmationWarningMassageEmail(String arg0) {
    }

    @Then("I should get confirmation warning massage inquiry {string}")
    public void iShouldGetConfirmationWarningMassageInquiry(String arg0) {
    }

}



