package automationteststore.pageObjects;

import automationteststore.pages.Page;
import automationteststore.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ContactUsPage extends Page {
    public WebDriver driver;
    Logger log = LoggerHelper.getLogger(ContactUsPage.class);

    public ContactUsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#field_13 > .help-block > .element_error")
    WebElement inquiryBoxError;

    @FindBy(css = "#ContactUsFrm_first_name")
    WebElement firstNameBox;

    @FindBy(css = "#ContactUsFrm_email")
    WebElement emailBox;

    @FindBy(css = "#ContactUsFrm_enquiry")
    WebElement inquiryBox;
    @FindBy(css = ".col-md-1 > .btn")
    WebElement resetBtn;
    @FindBy(css = ".col-md-6 > .btn")
    WebElement submitBtn;
    @FindBy(css = "#field_11 > .help-block > .element_error")
    WebElement firstNameError;

    @FindBy(css = "#field_12 > .help-block > .element_error")
    WebElement emailBoxError;
    @FindBy(css = "div:nth-of-type(3)  .element_error.has-error")
    WebElement inquiryBoxErrorTxt;
    @FindBy(css = ".element_error.has-error")
    WebElement invalidEmailFormat;
    @FindBy(css = ".maintext")
    WebElement contactUsTxt;
    @FindBy(xpath = ".col-md-6.pull-right")
    WebElement phoneNumber;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement address;

    @FindBy(css = ".heading3")
    WebElement contactUsFormTxt;

    @FindBy(css = ".required")
    WebElement requiredRedColorSign;

    public WebElement firstNameBox() {
        return this.firstNameBox;
    }
    public WebElement emailBox() {
        return this.emailBox;
    }
    public WebElement inquiryBox() {
        return this.inquiryBox;
    }

    public WebElement resetBtn() {
        return this.resetBtn;
    }

    public WebElement submitBtn() {
        return this.submitBtn;
    }

    public WebElement errorFirstNameBoxMsg() {
        return this.firstNameError;

    }
    public WebElement errorEmailBoxMsg() {
        return this.emailBoxError;
    }
    public WebElement invalidEmailMsg() {
        return this.invalidEmailFormat;
    }

    public WebElement errorInquiryBoxMsg() {
       return this.inquiryBoxErrorTxt;
    }

    public WebElement contactUs() {
        return this.contactUsTxt;
    }

    public WebElement phoneNumber() {
        return this.phoneNumber;
    }

    public WebElement address() {
      return this.address;
    }

    public WebElement contactUsFormTxt() {
        return this.contactUsFormTxt;
    }

    public WebElement requiredRedColorSign() {
        return this.requiredRedColorSign;
    }


}



