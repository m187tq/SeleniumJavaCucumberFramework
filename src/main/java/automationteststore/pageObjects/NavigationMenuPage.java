package automationteststore.pageObjects;

import automationteststore.helperutilities.GlobalVars;
import automationteststore.pages.Page;
import automationteststore.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class NavigationMenuPage extends Page {
	public WebDriver driver;
	Logger log = LoggerHelper.getLogger(NavigationMenuPage.class);

	public NavigationMenuPage(WebDriver driver) throws IOException {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div/div[1]/div[1]/section/nav/ul/li")
	private List<WebElement> subcategories;

	@FindBy(xpath = "/html/body/div/div/div/section/nav/ul/li/div/ul/li")
	private WebElement subCategoriesDropdownList;



	public ProductCategoryPage clickOnMenu(WebElement element) throws IOException {
		log.info("clicking on : "+element.getText());
		waitAndClick(element);
		return new ProductCategoryPage(driver);
	}
	public ProductCategoryPage clickOnItem(String data) throws IOException {
		log.info("clicking on :"+data);
		WebElement item = driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]"));
		waitAndClick(item);
		return new ProductCategoryPage(driver);
	}
	public void mouseOver(String data) {
		log.info("doing mouse over on :" + data);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'" + data + "')]"))).build().perform();

	}

	public void mouseOverElement(WebDriver driver, WebElement element) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(element).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				log.info(" MouserOver Action is performed on: " + element.getText());
			} else {
				log.info("MouseOver action is not performed on");
			}
		}
	}


}