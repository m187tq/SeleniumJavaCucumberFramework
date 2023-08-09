package automationteststore.pageObjects;

import automationteststore.pages.Page;
import automationteststore.helper.assertion.VerificationHelper;
import automationteststore.helper.logger.LoggerHelper;
import automationteststore.helper.wait.WaitHelper;
import automationteststore.helperutilities.GlobalVars;
import automationteststore.pageObjects.HomePages.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;


public class CartSummaryPage extends Page {

	public WebDriver driver;
	WaitHelper waitHelper;
	Logger log = LoggerHelper.getLogger(CartSummaryPage.class);

	public CartSummaryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);

	}

	@FindBy(css=".maintext")
	WebElement yourShoppingCart;

	@FindBy(css="i.fa.fa-trash-o.fa-fw")
	List<WebElement> quantity_delete;

	@FindBy(xpath="//*[contains(text(),'Your shopping cart is empty')]")
	WebElement emptyShoppingCartMsg;


	@FindBy(css="a[title='Continue']")
	WebElement continueBtn;


	public HomePage clickOnContinueBtn() throws IOException {
		waitForWebElementAndClick(continueBtn);
		return new HomePage(driver);
	}

	public boolean verifyProduct(String prod){
		log.info("selecting product.."+prod);
		WebElement product = driver.findElement(By.xpath("//*[contains(text(),'"+prod+"')]"));
		return new VerificationHelper(driver).isDisplayed(product);
	}

	public void delectProductFromShoppingCart() throws InterruptedException {
		// Delete all items from cart
		log.info("Deleting all products from cart..");
		List<WebElement> deletes = quantity_delete;
		Iterator<WebElement> itr = deletes.iterator();
		while (itr.hasNext()) {
			itr.next().click();
			Thread.sleep(2000);
		}
	}

	public boolean verifyEmptyShoppingCartMesssage(){
		return new VerificationHelper(driver).isDisplayed(emptyShoppingCartMsg);
	}

}
