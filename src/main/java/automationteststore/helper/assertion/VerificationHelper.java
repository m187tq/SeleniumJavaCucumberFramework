package automationteststore.helper.assertion;

import automationteststore.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificationHelper {

    private final WebDriver driver;
    private final Logger log = LoggerHelper.getLogger(VerificationHelper.class);

    public VerificationHelper(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isEnabled(WebElement element) {
        try {
            element.isEnabled();
            log.info("Element is Enabled => " + element.getText());
            System.out.println("Element is Enabled => " + element.getText());
            return true;
        } catch (Exception e) {
            log.error("Element is not Enabled... ", e.getCause());
            System.out.println("Element is not Enabled.." + e.getMessage());
            return false;
        }
    }

    public boolean isSelected(WebElement element) {
        try {
            element.isSelected();
            log.info("Element is Selected => " + element.getText());
            System.out.println("Element is Selected => " + element.getText());
            return true;
        } catch (Exception e) {
            log.error("Element is not Selected... ", e.getCause());
            System.out.println("Element is not Selected.." + e.getMessage());
            return false;
        }
    }

    public boolean isDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            log.info("Element is Displayed => " + element.getText());
            System.out.println("Element is Displayed => " + element.getText());
            return true;
        } catch (Exception e) {
            log.error("Element is not Displayed... ", e.getCause());
            System.out.println("Element is not Displayed.." + e.getMessage());
            return false;
        }
    }

    public boolean isNotDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            log.info("Element is present => " + element.getText());
            System.out.println("Element is present => " + element.getText());
            return false;
        } catch (Exception e) {
            log.error("Element is not present..");
            System.out.println("Element is not present..");
            return true;
        }
    }

    public String readValueFromElement(WebElement element) {
        if (null == element) {
            log.info("WebElement is null..");
            System.out.println("WebElement is null..");
            return null;
        }
        boolean status = isDisplayed(element);
        if (status) {
            log.info("Element text is => " + element.getText());
            System.out.println("Element text is => " + element.getText());
            return element.getText();
        } else {
            return null;
        }
    }

    public String getText(WebElement element) {
        if (null == element) {
            log.info("WebElement is null..");
            System.out.println("WebElement is null..");
            return null;
        }
        boolean status = isDisplayed(element);
        if (status) {
            log.info("Element text is => " + element.getText());
            System.out.println("Element text is => " + element.getText());
            return element.getText();
        } else {
            return null;
        }
    }

    public String getTitle() {
        log.info("Page title is => " + driver.getTitle());
        System.out.println("Page title is => " + driver.getTitle());
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        log.info("Page current url is => " + driver.getTitle());
        System.out.println("Page current url is => " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }


}
