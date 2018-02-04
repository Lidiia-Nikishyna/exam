package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithOurElements {
    static WebDriver webDriver;
    static Logger logger;
    public static WebDriverWait webDriverWait20;

    public ActionsWithOurElements (WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger("ActionsWithOurElements");
        webDriverWait20 = new WebDriverWait(webDriver,20);
    }

    /**
     * Method Enter text into input and textArea
     * @param input
     * @param text
     */
    public static void enterTextIntoInput (WebElement input, String text) {
        try{
//           webDriverWait20.until(ExpectedConditions.elementToBeClickable(input)).click();
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was entered into input " + input);
        }catch (Exception e) {
            logErrorAndStopTest ();
        }
    }

    /**
     *  Method click on the Elements: button, link, radiobutton, checkbox etc.
     * @param element
     */
    public static void clickOnElement (WebElement element) {
        try{
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("Element was clicked " + element);
        }catch (Exception e) {
            logErrorAndStopTest();
        }
    }

    public static void clickOnVisibleElement (WebElement element) {
        try{
            webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.invisibilityOf(element)));
            element.click();
            logger.info("Element was clicked " + element);
        }catch (Exception e) {
            logErrorAndStopTest();
        }
    }
    /**
     * Method to check whether any element is present in DOM, present on the page and enabled or disabled
     * @param element
     * @return
     */
    public static boolean isElementPresent (WebElement element) {
        try{
            boolean tempState = element.isDisplayed()&&element.isEnabled();
            logger.info ("Is Element present? - " + tempState);
            return tempState;
        }catch (Exception e) {
            logger.info ("Is Element present? - false");
            return false;
        }
    }

    /**
     * Method to check whether any element is present in DOM, present on the page and enabled or disabled
     * @param locator
     * @return
     */
    public static boolean isElementPresent (String locator) {
        try{
            return isElementPresent(webDriver.findElement(By.xpath(locator)));
        }catch (Exception e) {
            logger.info ("Is Element Present? - false");
            return false;
        }
    }

    /**
     * Method to set checkbox in needed state
     * @param element
     * @param neededState
     */
    public static void setStateToCheckBox (WebElement element, String neededState) {
        final String CHECK_STATUS = "Checked";
        final String UNCHECK_STATUS = "Unchecked";
        if (!neededState.equals(CHECK_STATUS) && !neededState.equals(UNCHECK_STATUS)) {
            logger.error(neededState + " - Value of neededState is not expected ");
            Assert.fail(neededState + " - Value of neededState is not expected ");
        } else {
            try {
                if (neededState.equals(CHECK_STATUS) && !element.isSelected() ||
                        neededState.equals(UNCHECK_STATUS) && element.isSelected()){
                    clickOnElement(element);
                } else {
                    logger.info("CheckBox has " + neededState + " state already ");
                }
            }catch (Exception e){
                logErrorAndStopTest();
            }
        }
    }

    /**
     * Method to open dropdown and select one option from it
     * @param element
     * @param option
     */
    public static void selectOptionsInDropDown (WebElement element, WebElement option) {
        clickOnElement(element);
        clickOnElement(option);
    }

    /**
     * Method to select option in dropdown
     * @param selectDropDown
     * @param textInDropdown
     */
    public static void selectOptionsInDropDown (WebElement selectDropDown, String textInDropdown) {
        try {
            Select options = new Select (selectDropDown);
            options.selectByVisibleText(textInDropdown);
            logger.info(textInDropdown + " was selected in DD");
        }catch (Exception e) {
            logErrorAndStopTest();
        }
    }

    /**
     * Method informs on exception of working with elements and records to log
     */
    private static void logErrorAndStopTest () {
        logger.error("Can not work with element "); // пишет в консоль и в лог
        Assert.fail ("Can not work with element "); //пишет в отчет и останавливает тест
    }

}

