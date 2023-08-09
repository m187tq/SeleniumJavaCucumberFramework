package automationteststore.pageObjects.SearchPages;

import automationteststore.employerTestData.EmployerTestData;
import automationteststore.helper.logger.LoggerHelper;
import automationteststore.pageObjects.AccountEditPage;
import automationteststore.pages.Page;
import io.cucumber.datatable.DataTable;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;



public class SearchResultPage extends Page {
    public WebDriver driver;
    Logger log = LoggerHelper.getLogger(AccountEditPage.class);

    public SearchResultPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }









}
