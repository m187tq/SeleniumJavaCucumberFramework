package automationteststore.pageObjects.HomePages;

import automationteststore.pages.Page;
import automationteststore.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class FooterPage extends Page {
    public WebDriver driver;
    Logger log = LoggerHelper.getLogger(FooterPage.class);
    public FooterPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".footer-info-heading")
    public List<WebElement> footerTxtHearing;

    @FindBy(xpath = "//h3[contains(text(),'Navigate')]")
    public WebElement navigate;

    @FindBy(xpath = "//h3[contains(text(),'Categories')]")
    public WebElement categories;

    @FindBy(xpath = "//h3[contains(text(),'Popular Brands')]")
    public WebElement popularBrands;

    @FindBy(xpath = "//h3[contains(text(),'Info')]")
    public WebElement info;

    @FindBy(xpath = "//h3[contains(text(),'Subscribe to our newsletter')]")
    public WebElement subscribeNewsletter;

    @FindBy(css = "#nl_email")
    public WebElement subscribeEmailBox;

    @FindBy(xpath = "/html/body/footer/div[1]/section/article[5]/form/fieldset/div/div/input[2]")
    public WebElement subscribeBtn;


    public void  clickOnFooterHearingTextName(String textName) {
        List<WebElement> textNames = footerTxtHearing;
        Iterator<WebElement> itr = textNames.iterator();
        while (itr.hasNext()) {
            WebElement c = itr.next();
            String text = c.getText().trim().toString();
            if (text.equals(textName)) {
                log.info("selecting date as: "+textName);
                c.click();
                break;
            }
        }
    }

}
