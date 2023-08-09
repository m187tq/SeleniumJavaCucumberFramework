package automationteststore.pages;

import automationteststore.helper.alert.AlertHelper;
import automationteststore.helper.assertion.VerificationHelper;
import automationteststore.helper.javaScript.JavaScriptHelper;
import automationteststore.helper.logger.LoggerHelper;
import automationteststore.helper.select.DropDownHelper;
import automationteststore.helper.wait.WaitHelper;
import automationteststore.helperutilities.GlobalVars;
import automationteststore.pageObjects.AccountLoginPage;
import automationteststore.pageObjects.AccountLogoutPage;
import automationteststore.pageObjects.CheckoutCartPage;
import automationteststore.pageObjects.CheckoutSuccessPage;
import automationteststore.pageObjects.HomePages.SpecialsPage;
import automationteststore.pageObjects.ProductCategoryPage;
import automationteststore.pageObjects.ProductIDPage;
import com.google.common.collect.Ordering;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class Page {
    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        verificationHelper = new VerificationHelper(driver);
        js = new JavaScriptHelper(driver);
        dropdownHelper = new DropDownHelper(driver);

    }

    public WebDriver driver;
    public WaitHelper waitHelper;
    public DropDownHelper dropdownHelper;
    public VerificationHelper verificationHelper;
    public ProductCategoryPage productCategoryPage;
    public CheckoutSuccessPage checkoutSuccessPage;
    public AlertHelper alertHelper;
    Logger log = LoggerHelper.getLogger(Page.class);
    public JavaScriptHelper js;
    public final String url = "https://automationteststore.com/";

    @FindBy(css = ".maintext")
    public WebElement header;
    @FindBy(xpath = "//h2[@id='content']")
    public WebElement headerTxt;
    @FindBy(css = "ul#customer_menu_top  a")
    public WebElement loginOrRegisterLink;
    @FindBy(css = ".navbar-header.header-logo")
    public WebElement logoImage;
    @FindBy(xpath = "//*[@id='main_menu_top']/li[1]/a/span")
    public WebElement specialsLink;
    @FindBy(xpath = "//*[@id='main_menu_top']/li[2]/a/span")
    public WebElement accountLink;
    @FindBy(css = "ul#main_menu_top  .dropdown-menu.sub_menu  .menu_login.sub > .menu_text")
    public WebElement account_loginDropdownLink;
    @FindBy(css = "ul#main_menu_top.dropdown-menu.sub_menu.menu_login.sub>.menu_text")
    public WebElement accountCheckYourOrderDropdownLink;
    @FindBy(css = "i.fa.fa-unlock")
    public WebElement accountLogoutLink;
    @FindBy(css = "i.fa.fa-shopping-cart")
    public WebElement cartLink;
    @FindBy(css = "ul#main_menu_top.menu_checkout.top>.menu_text")
    public WebElement checkoutLink;
    @FindBy(css = "#filter_keyword")
    public WebElement searchBox;
    @FindBy(css = ".button-in-search")
    public WebElement searchBtn;
    @FindBy(xpath = "//div[contains(text(),'Welcome back')]")
    public WebElement welcomeBackTxt;
    @FindBy(css = "ul.currency.dropdown-menu")
    public WebElement currencyDropdown;
    @FindBy(xpath = "/html/body/div/header/div[2]/div/div[2]/ul/li/ul/li")
    public List<WebElement> currencyDropdownList;
    @FindBy(xpath = "/html/body/div/header/div[2]/div/div/ul/li/ul")
    public List<WebElement> itemsInCartDropdownList;

    @FindBy(xpath = "/html/body/div/header/div[2]/div/div[3]/ul/li")
    public WebElement itemsCartDropdown;
    @FindBy(linkText = "[xpath] .dropdown-toggle")
    public WebElement itemsCountInCart;
    @FindBy(css = "#main_menu_top.fa-user")
    public WebElement accountIconImage;
    @FindBy(css = "a.top.menu_account")
    public WebElement account_link;
    @FindBy(css = ".col-md-12.headerdetails a[title='Facebook']")
    public WebElement facebook_icon;
    @FindBy(css = ".col-md-12.headerdetails a[title='Twitter']")
    public WebElement twitter_icon;
    @FindBy(css = ".col-md-12.headerdetails a[title='Linkedin']")
    public WebElement linkedin_icon;

    //================submenu=====================================
    @FindBy(xpath = "/html/body/div/div[1]/div[1]/section/nav/ul/li/a")
    public List<WebElement> subMenuList;
    @FindBy(linkText = "Home")
    public WebElement home;
    @FindBy(linkText = "Apparel & accessories")
    public WebElement   apparelAndaccessories;
    @FindBy(linkText = "Makeup")
    public WebElement makeup;
    @FindBy(linkText = "Skincare")
    public WebElement skincare;
    @FindBy(linkText = "Fragrance")
    public WebElement fragrance;
    @FindBy(linkText = "Men")
    public WebElement men;
    @FindBy(linkText = "Hair Care")
    public WebElement hairCare;
    @FindBy(linkText = "Books")
    public WebElement books;
    @FindBy(xpath = "/html/body/div/div[1]/div[1]/section/nav/ul/li[5]/div/ul/li/a")
    public List<WebElement> fragranceDropdown;
    @FindBy(xpath = "/html/body/div/div[1]/div[1]/section/nav/ul/li[6]/div/ul/li/a")
    public List<WebElement> menDropdown;
    @FindBy(xpath = "/html/body/div/div[1]/div[1]/section/nav/ul/li[6]/div/ul/li/a")
    public List<WebElement> hairCareDropdown;
    @FindBy(xpath = "/html/body/div/div[1]/div[1]/section/nav/ul/li[8]/div/ul/li/a")
    public List<WebElement> booksDropdown;
    @FindBy(xpath = "/html/body/div/div[1]/div[1]/section/nav/ul/li[1]/div/ul/li/a/span")
    public List<WebElement> homeDropdown;
    @FindBy(xpath = "/html/body/div/div[1]/div[1]/section/nav/ul/li[2]/div/ul/li/a")
    public List<WebElement>   apparelAndaccessoriesDropdown;
    @FindBy(xpath = "/html/body/div/div[1]/div[1]/section/nav/ul/li[3]/div/ul/li/a")
    public List<WebElement>   makeupDropdown;
    @FindBy(xpath = "/html/body/div/div/div/section/nav/ul/li/div/ul/li/a")
    public List<WebElement> subMenuAllDropdownList;
    @FindBy(xpath = "/html/body/div/div[1]/div[1]/section/nav/ul/li[4]/div/ul[1]/li/a")
    public List<WebElement> skincareDropdown;

    //==========================================//
    public List<WebElement> getSubMenuList() {
        return subMenuList;
    }

    public WebElement getHome() {
        return home;
    }
    public WebElement getApparelAndaccessories() {
        return apparelAndaccessories;
    }
    public WebElement getMakeup() {
        return makeup;
    }

    public WebElement getSkincare() {
        return skincare;
    }

    public WebElement getFragrance() {
        return fragrance;
    }

    public WebElement getMen() {
        return men;
    }

    public WebElement getHairCare() {
        return hairCare;
    }

    public WebElement getBooks() {
        return books;
    }
    public List<WebElement> getFragranceDropdown() {
        return fragranceDropdown;
    }

    public List<WebElement> getMenDropdown() {
        return menDropdown;
    }

    public List<WebElement> getHairCareDropdown() {
        return hairCareDropdown;
    }

    public List<WebElement> getBooksDropdown() {
        return booksDropdown;
    }

    public List<WebElement> getHomeDropdown() {
        return homeDropdown;
    }

    public List<WebElement> getApparelAndaccessoriesDropdown() {
        return apparelAndaccessoriesDropdown;
    }

    public List<WebElement> getMakeupDropdown() {
        return makeupDropdown;
    }

    public List<WebElement> getSubMenuAllDropdownList() {
        return subMenuAllDropdownList;
    }

    public List<WebElement> getSkincareDropdown() {
        return skincareDropdown;
    }


    //==========================================//

    public String getPageHeaderTxt() {
        return verificationHelper.getText(header);
    }
    public AccountLoginPage clickLoginOrRegisterLink() throws IOException {
        waitForWebElementAndClick(loginOrRegisterLink);
        return new AccountLoginPage(driver);
    }
    public WebElement getLogoImage() {
        return logoImage;
    }

    public SpecialsPage clickSpecialsLink() throws IOException {
        waitForWebElementAndClick(specialsLink);
        return new SpecialsPage(driver);
    }

    public AccountLoginPage clickAccountLink() throws IOException {
        waitForWebElementAndClick(accountLink);
        return new AccountLoginPage(driver);
    }

    public WebElement getAccountLoginDropdownLink() {
        return account_loginDropdownLink;
    }

    public WebElement getAccountCheckYourOrderDropdownLink() {
        return accountCheckYourOrderDropdownLink;
    }

    public AccountLogoutPage clickAccountLogoutLink() throws IOException {
        waitForWebElementAndClick(accountLogoutLink);
        return new AccountLogoutPage(driver);
    }

    public CheckoutCartPage clickCartLink() throws IOException {
        waitForWebElementAndClick(cartLink);
        return new CheckoutCartPage(driver);
    }

    public WebElement getCheckoutLink() {
        return checkoutLink;
    }

    public ProductCategoryPage searchByKeyword(String keyword) throws IOException {
        searchBox.click();
        searchBox.clear();
        waitAndSendKeys(searchBox, keyword);
        waitForWebElementAndClick(searchBtn);
        return new ProductCategoryPage(driver);

    }
    public String getSearchBtnTxt() {
        return verificationHelper.getText(searchBtn);
    }
    public ProductIDPage clickSearchBtn() throws IOException {
        waitForWebElementAndClick(searchBtn);
        return new ProductIDPage(driver);
    }

    public String getWelcomeBackTxt() {
        return verificationHelper.getText(welcomeBackTxt);
    }

    public void clickCurrencyDropdown() {
        waitForWebElementAndClick(currencyDropdown);
    }

    public List<WebElement> getCurrencyDropdownList() {
        return currencyDropdownList;
    }

    public String getFirstItemsInCartDropdownList() {
        return itemsInCartDropdownList.get(0).getText();
    }

    public void clickFirstItemsInCartDropdownList() {
        itemsInCartDropdownList.get(0).click();
    }
    public List<WebElement> itemsInCartDropdownList() {
        return itemsInCartDropdownList;
    }

    public WebElement getItemsCartDropdown() {
        return itemsCartDropdown;
    }

    public CheckoutCartPage clickItemsCart() throws IOException {
        waitForWebElementAndClick(itemsCartDropdown);
        return new CheckoutCartPage(driver);
    }

    public WebElement getItemsCountInCart() {
        return itemsCountInCart;
    }

    public WebElement getAccountIconImage() {
        return accountIconImage;
    }

    public String getAccount_linkTxt() {
        return verificationHelper.getText(account_link);
    }
    public WebElement getFacebook_icon() {
        return facebook_icon;
    }
    public WebElement getTwitter_icon() {
        return twitter_icon;
    }
    public WebElement getLinkedin_icon() {
        return linkedin_icon;
    }
    public String getCurrentPageUrl()                                                                                                                                                                                                      {
        return verificationHelper.getCurrentUrl().trim();
    }

    public String getCurrentPageTitle() {
        return verificationHelper.getTitle().trim();
    }

    public void waitForElementToAppear(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
                wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    public void waitForListOfElementsToAppear(By findBy) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
    }

    public void waitForWebElementToAppear(WebElement findBy) {
        log.info("Waiting for element to be visible...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public void waitAndSendKeys(WebElement findBy, String keysToSend) {
        findBy.clear();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        wait.until(ExpectedConditions.visibilityOf(findBy)).sendKeys(keysToSend);
        log.info("Entered text :" + keysToSend);    }

    public void waitAndClick(WebElement findBy) {
        log.info("Element clicked...." + getText(findBy));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        wait.until(ExpectedConditions.elementToBeClickable(findBy)).click();
    }

    public void waitForElementToDisappear(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        wait.until(ExpectedConditions.invisibilityOf(ele));

    }
    public void SwitchWindowToChild() {
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String parentWindow = i1.next();
        String childWindow = i1.next();
        driver.switchTo().window(childWindow);
    }

    public void navigateToApplicationUrl(String url) {
        driver.get(url);
        log.info("navigating to >> : +url");
    }

    public void getApplicationUrl(String url) {
        driver.get(url);
        log.info("navigating to ..." + url);
    }

    public void navigateToUrl(String url) {
        log.info("navigates to the url: " + url);
        driver.get(url);
    }
    public String generateRandomNumber(int length) {
        log.info("Entered generated Random loginName.... ");
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public void sendKeys(By by, String textToType) {
        log.info("Entered text :" + textToType);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
    }

    public void sendKeys(WebElement element, String textToType) {
        element.clear();
        log.info("Entered text :" + textToType);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
                wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
        log.info("Keys successfully sent to field :: " + textToType);
    }

    public void waitFor(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForWebElementAndClick(By by) {
        log.info("Waited and clicked on the element: ");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();

    }

    public void waitForWebElementAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        log.info("Successfully clicked on " + element.getText());
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    public void clickOnTextFromDropdownList(WebElement list, String textToSearchFor) {
        Wait<WebDriver> tempWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        try {
            tempWait.until(ExpectedConditions.elementToBeClickable(list)).click();
            list.sendKeys(textToSearchFor);
            list.sendKeys(Keys.ENTER);
            System.out.println("Successfully sent the following keys: " + textToSearchFor + ", to the following WebElement: " + "<" + list.toString() + ">");
        } catch (Exception e) {
            System.out.println("Unable to send the following keys: " + textToSearchFor + ", to the following WebElement: " + "<" + list.toString() + ">");
            Assert.fail("Unable to select the required text from the dropdown menu, Exception: " + e.getMessage());
        }
    }

    public static boolean selectByVisibleText(String visibletext, WebElement ele) {
        boolean flag = false;
        try {
            Select s = new Select(ele);
            s.selectByVisibleText(visibletext);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Option selected by VisibleText: " + "<" + visibletext + ">");
            } else {
                System.out.println("Option not selected by VisibleText");
            }
        }
    }
    
    public void waitAndClickElement(WebElement element) {
        log.info("It is visible now.... " + element.getText());
        waitFor(element);
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();*/
        element.click();
        log.info("Clicked on the element => " + element.getText());
    }

    public void waitForAndSendKeys(WebElement element, String textToSend) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        wait.until(d -> element.isDisplayed());
        element.clear();
        element.sendKeys(textToSend);
        log.info("Waited and send on the element: " + textToSend);
    }

    public void sendKeysToWebElement(WebElement element, String textToSend) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(textToSend);
        log.info("Waited and send on the element: " + textToSend);
    }

    public void waitForAlert_And_ValidateText(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));        
        wait.until(ExpectedConditions.alertIsPresent());
        String alert_Message_Text = driver.switchTo().alert().getText();
        Assert.assertEquals(alert_Message_Text, text);
    }


    public void clickMatchingElementByText(List<WebElement> elements, String productName) {
        WebElement element = elements
                .stream()
                .parallel()
                .filter(s -> s.getText().equalsIgnoreCase(productName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Element with text" + productName + "not present"));
        element.click();

    }

    public List<String> getAccountsSectionsList(List<WebElement> products) {
        List<String> accountsList = new ArrayList<>();
        List<WebElement> accountsHeaderList = driver.findElements((By) products);
        for (WebElement e : accountsHeaderList) {
            String text = e.getText();
            log.info(text);
            accountsList.add(text);
        }
        return accountsList;
    }

    // =================================Wait===========================================

    public void setImplicitWait(long timeout) {
        log.info("Implicit Wait has been set to: " + timeout);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    public void WaitForElementClickable(WebElement element, int timeOutInSeconds) {
        log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.info("element is clickable now");
    }

    public boolean waitForElementNotPresent(WebElement element, long timeOutInSeconds) {
        log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
        log.info("element is invisibile now");
        return status;
    }

    public void waitForFrameToBeAvailableAndSwitchToIt(WebElement element, long timeOutInSeconds) {
        log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        log.info("frame is available and switched");
    }

    private Wait<WebDriver> getfluentWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
        Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeOutInSeconds))
                .pollingEvery(Duration.ofMillis(pollingEveryInMiliSec)).ignoring(NoSuchElementException.class);
        return fWait;
    }

    public void waitForElement(WebElement element, int timeOutInSeconds) {
        log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("element is visible now");
    }

    //=====================Alerts=====================================

    public Alert getAlert() {
        log.info("alert test: " + driver.switchTo().alert().getText());
        return driver.switchTo().alert();
    }

    public void acceptAlert() {
        getAlert().accept();
        log.info("accept Alert is done...");
    }

    public void dismissAlert() {
        getAlert().dismiss();
        log.info("dismiss Alert is done...");
    }

    public String getAlertText() {
        String text = getAlert().getText();
        log.info("alert text: " + text);
        return text;
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            log.info("alert is present");
            return true;
        } catch (NoAlertPresentException e) {
            log.info(e.getCause());
            return false;
        }
    }

    public void acceptAlertIfPresent() {
        if (isAlertPresent()) {
            acceptAlert();
        } else {
            log.info("Alert is not present..");
        }
    }

    public void dismissAlertIfPresent() {
        if (isAlertPresent()) {
            dismissAlert();
        } else {
            log.info("Alert is not present..");
        }
    }

    public void acceptPrompt(String text) {
        if (isAlertPresent()) {
            Alert alert = getAlert();
            alert.sendKeys(text);
            alert.accept();
            log.info("alert text: " + text);
        }
    }

    //====================Dropdowns============================================

    public void SelectUsingVisibleValue(WebElement element, String visibleValue) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleValue);
        log.info("Locator : " + element + " Value : " + visibleValue);
    }

    public String getSelectedValue(WebElement element) {
        String value = new Select(element).getFirstSelectedOption().getText();
        log.info("WebElement : " + element + " Value : " + value);
        return value;
    }

    public void SelectUsingIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
        log.info("Locator : " + element + " Value : " + index);
    }

    public void SelectUsingVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
        log.info("Locator : " + element + " Value : " + text);
    }
    
    public List<String> getAllDropDownValues(WebElement locator) {
        Select select = new Select(locator);
        List<WebElement> elementList = select.getOptions();
        List<String> valueList = new LinkedList<String>();
        for (WebElement element : elementList) {
            log.info(element.getText());
            valueList.add(element.getText());
        }
        return valueList;
    }
    
    //================================Verify=====================================
    public boolean verifyTextContains(String actualText, String expText) {
        if (actualText.toLowerCase().contains(expText.toLowerCase())) {
            log.info("Actual Text From Web Application UI   --> : " + actualText);
            log.info("Expected Text From Web Application UI --> : " + expText);
            log.info("### Verification Contains !!!");
            return true;
        } else {
            log.info("Actual Text From Web Application UI   --> : " + actualText);
            log.info("Expected Text From Web Application UI --> : " + expText);
            log.info("### Verification DOES NOT Contains !!!");
            return false;
        }

    }

    public boolean verifyTextMatch(String actualText, String expText) {
        if (actualText.equals(expText)) {
            log.info("Actual Text From Web Application UI   --> : " + actualText);
            log.info("Expected Text From Web Application UI --> : " + expText);
            log.info("### Verification MATCHED !!!");
            return true;
        } else {
            log.info("Actual Text From Web Application UI   --> : " + actualText);
            log.info("Expected Text From Web Application UI --> : " + expText);
            log.info("### Verification DOES NOT MATCH !!!");
            return false;
        }
    }

    public Boolean verifyListContains(List<String> actList, List<String> expList) {
        int expListSize = expList.size();
        for (int i = 0; i < expListSize; i++) {
            if (!actList.contains(expList.get(i))) {
                return false;
            }
        }
        log.info("Actual List Contains Expected List !!!");
        return true;
    }

    public Boolean verifyListMatch(List<String> actList, List<String> expList) {
        boolean found = false;
        int actListSize = actList.size();
        int expListSize = expList.size();
        if (actListSize != expListSize) {
            return false;
        }

        for (int i = 0; i < actListSize; i++) {
            found = false;
            for (int j = 0; j < expListSize; j++) {
                if (verifyTextMatch(actList.get(i), expList.get(j))) {
                    found = true;
                    break;
                }
            }
        }
        if (found) {
            log.info("Actual List Matches Expected List !!!");
            return true;
        } else {
            log.info("Actual List DOES NOT Match Expected List !!!");
            return false;
        }
    }

    public Boolean verifyItemPresentInList(List<String> actList, String item) {
        int actListSize = actList.size();
        for (int i = 0; i < actListSize; i++) {
            if (!actList.contains(item)) {
                log.info("Item is NOT present in List !!!");
                return false;
            }
        }
        log.info("Item is present in List !!!");
        return true;
    }

    public boolean isListAscendingOrder(List<Long> list) {
        return Ordering.natural().isOrdered(list);
    }

    //====================Generator==================================

    public int getRandomNumber(int min, int max) {
        int diff = max - min;
        int randomNum = (int) (min + Math.random() * diff);
        log.info("Random Number :: " + randomNum +
                " within range :: " + min + " and :: " + max);
        return randomNum;
    }

    public int getRandomNumber(int number) {
        return getRandomNumber(1, number);
    }

    public String getRandomString(int length) {
        StringBuilder sbuilder = new StringBuilder();
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * chars.length());
            sbuilder.append(chars.charAt(index));
        }
        String randomString = sbuilder.toString();
        log.info("Random string with length :: "
                + length + " is :: " + randomString);
        return randomString;
    }

    public String getRandomString() {
        return getRandomString(GlobalVars.getExplicitWait());
    }

    //======================Validation============================================

    public boolean isDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            log.info("element is Displayed.." + element.getText());
            return true;
        } catch (Exception e) {
            log.error("element is not Displayed..", e.getCause());
            return false;
        }
    }

    public boolean isEnabled(WebElement element) {
        try {
            element.isEnabled();
            log.info("element is enabled.." + element.getText());
            return true;
        } catch (Exception e) {
            log.error("element is not enabled..", e.getCause());
            return false;
        }
    }

    public boolean isSelected(WebElement element) {
        try {
            element.isSelected();
            log.info("The element is Selected:  " + "<" + element + ">");
            return true;
        } catch (Exception e) {
            log.info("The element is not Selected.... ");
            log.error("The element is not Selected: ", e.getCause());
            return false;
        }
    }

    public boolean isNotDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            log.info("element is present.." + element.getText());
            return false;
        } catch (Exception e) {
            log.error("element is not present..");
            return true;
        }
    }

    public String readValueFromElement(WebElement element) {
        if (null == element) {
            log.info("WebElement is null..");
            return null;
        }
        boolean status = isDisplayed(element);
        if (status) {
            log.info("element text is .." + element.getText());
            return element.getText();
        } else {
            return null;
        }
    }

    public String getText(WebElement element) {
        if (null == element) {
            log.info("WebElement is null..");
            return null;
        }
        boolean status = isDisplayed(element);
        if (status) {
            log.info("element text is .." + element.getText());
            return element.getText();
        } else {
            return null;
        }
    }
    
    public void switchToFrame(int frameIndex) {
        driver.switchTo().frame(frameIndex);
        log.info("switched to :" + frameIndex + " frame");
    }

    /**
     * this method will switchToFrame based on frame name
     *
     * @param frameName
     */
    public void switchToFrame(String frameName) {
        driver.switchTo().frame(frameName);
        log.info("switched to :" + frameName + " frame");
    }

    public void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
        log.info("switched to frame " + element.toString());
    }

    //====================Window======================================


    public void switchToParentWindow() {
        log.info("switching to parent window...");
        driver.switchTo().defaultContent();
    }
    public void switchToWindow(int index) {
        Set<String> windows = driver.getWindowHandles();
        int i = 1;
        for (String window : windows) {
            if (i == index) {
                log.info("switched to : " + index + " window");
                driver.switchTo().window(window);
            } else {
                i++;
            }
        }
    }


    public void closeAllTabsAndSwitchToMainWindow() {
        Set<String> windows = driver.getWindowHandles();
        String mainwindow = driver.getWindowHandle();

        for (String window : windows) {
            if (!window.equalsIgnoreCase(mainwindow)) {
                driver.close();
            }
        }
        log.info("switched to main window");
        driver.switchTo().window(mainwindow);
    }
    public void navigateBack() {
        log.info("navigating back");
        driver.navigate().back();
    }
    public void navigateForward() {
        log.info("navigating forward");
        driver.navigate().forward();
    }

    //==================JavascriptExecutor=============================================

    public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ele);

    }

    public boolean JSClick(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            // WebElement element = driver.findElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", ele);
            // driver.executeAsyncScript("arguments[0].click();", element);

            flag = true;

        } catch (Exception e) {
            throw e;

        } finally {
            if (flag) {
                log.info("Click Action is performed: " + ele.getText());
            } else if (!flag) {
                log.info("Click Action is not performed: " + ele.getText());
            }
        }
        return flag;
    }

//===============Actions===================================================
    
    public boolean moveToElement(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            // WebElement element = driver.findElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView(true);", ele);
            Actions actions = new Actions(driver);
            // actions.moveToElement(driver.findElement(locator)).build().perform();
            actions.moveToElement(ele).build().perform();
            flag = true;
            log.info(" Moving to the element & Action is performed on: " + ele.getText());
        } catch (Exception e) {
            log.info(" Action Not performed on: " + ele.getText());
            e.printStackTrace();
        }
        return flag;
    }


    public boolean mouseover(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            new Actions(driver).moveToElement(ele).build().perform();
            flag = true;
            log.info(" MouserOver Action is performed on: " + ele.getText());
            return true;
        } catch (Exception e) {
            log.info("MouseOver action is not performed on: " + ele.getText());
            return false;
        } finally {
            /*
             * if (flag) {
             * SuccessReport("MouseOver ","MouserOver Action is performed on \""+locatorName
             * +"\""); } else {
             * failureReport("MouseOver","MouseOver action is not performed on \""
             * +locatorName+"\""); }
             */
        }
    }

    public boolean draggable(WebDriver driver, WebElement source, int x, int y) {
        boolean flag = false;
        try {
            new Actions(driver).dragAndDropBy(source, x, y).build().perform();
            Thread.sleep(5000);
            flag = true;
            return true;

        } catch (Exception e) {
            return false;

        } finally {
            if (flag) {
                log.info("Draggable Action is performed on \"" + source + "\"");
            } else if (!flag) {
                log.info("Draggable action is not performed on \"" + source + "\"");
            }
        }
    }

    public boolean dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
        boolean flag = false;
        try {
            new Actions(driver).dragAndDrop(source, target).perform();
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                log.info("DragAndDrop Action is performed");
            } else if (!flag) {
                log.info("DragAndDrop Action is not performed");
            }
        }
    }

    public boolean slider(WebDriver driver, WebElement ele, int x, int y) {
        boolean flag = false;
        try {
            // new axe(driver).dragAndDropBy(dragitem, 400, 1).build()
            // .perform();
            new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// GlobalVars.getExplicitWait()0,0
            Thread.sleep(5000);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                log.info("Slider Action is performed");
            } else {
                log.info("Slider Action is not performed");
            }
        }
    }

    public boolean getText(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            ele.getText();
            flag = true;
        } catch (Exception e) {
            log.info("Got element text : " + ele.getText());
            flag = false;
        } finally {
            if (flag) {
                log.info("Successfully Found element text: " + ele.getText());

            } else {
                log.info("Unable to get element text..." + ele.getText());
            }
        }
        return flag;
    }

    public boolean verifyHeaderTxtIsDisplayed(WebElement element) {
        return verificationHelper.isDisplayed(element);
    }

    public static void fluentWait(WebDriver driver, WebElement element, int timeOut) {
        Wait<WebDriver> wait = null;
        try {
            wait = new FluentWait<WebDriver>((WebDriver) driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(Exception.class);
            wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        } catch (Exception e) {
        }
    }
}

