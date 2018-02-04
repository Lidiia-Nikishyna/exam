package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import popups.AddVehiclePopup;

import static libs.ActionsWithOurElements.*;

public class HomePage extends ParentPage {
    AddVehiclePopup addVehiclePopup;

    @FindBy(xpath=".//div[@class='login_btn']")
    private WebElement signInButton;

    //block Route
    @FindBy (xpath=".//div[@class='or_top_route']//*[@placeholder='From']")
    private WebElement inputRouteFrom;

    @FindBy (xpath=".//div[@class='or_top_route']//*[@placeholder='To']")
    private WebElement inputRouteTo;


    //block Delivery Dates
    @FindBy (xpath="(.//button[@class='mat-icon-button'])[position()=1]")
    private WebElement buttonFromCalendar;

    @FindBy (xpath="(.//*[@class='mat-icon material-icons'])[position()=2]")
    private WebElement buttonToCalendar;

    @FindBy (xpath=".//button[@class='mat-calendar-next-button mat-icon-button']")
    private WebElement buttonNextMonth;

    @FindBy (xpath = ".//div[@class='or_top_dates_box']//*[@placeholder='From']")
    private WebElement inputDateFrom;

    @FindBy (xpath = ".//div[@class='or_top_dates_box']//*[@placeholder='To']")
    private WebElement inputDateTo;

    @FindBy(xpath = ".//div[@class='or_top_btn']//button[@type='submit']")
    private WebElement buttonSubmitStartSearch;

//    xpath=".//div[@class='mat-calendar-body-cell-content'][contains (text(),'" + date + "')]") - xpath for date in calendat
//    .//*[@id='mat-datepicker-0']//div[@class='mat-calendar-body-cell-content'][contains (text(),'11')] - use this one if shorter doesn't work


    public HomePage (WebDriver webDriver) {
        super (webDriver, "/home");
//        webDriverWait20 = new WebDriverWait(webDriver,20);
    }

    public void openHomePage () {
        try{
            webDriver.get (configProperties.base_url());
            logger.info("Home page was opened");
        }catch (Exception e){
            logger.error("Can not open url");
            Assert.fail("Can not open url");
        }
    }

    public void clickOnButtonSignIn(){
        clickOnElement (signInButton);
    }

    public void openLoginPopup(){
        openHomePage();
        clickOnButtonSignIn();
    }

    public void enterAddressFrom(String addressFrom, String hereAddressFrom) {
        enterTextIntoInput(inputRouteFrom, addressFrom);
        clickOnElement(webDriver.findElement(By.xpath(".//span[@class='mat-option-text'][contains (text(), '" + hereAddressFrom + "')]")));
    }

    public void enterAddressTo(String addressTo, String hereAddressTo){
        enterTextIntoInput (inputRouteTo, addressTo);
        clickOnElement(webDriver.findElement(By.xpath(".//span[@class='mat-option-text'][contains (text(), '" + hereAddressTo + "')]")));

    }

    public void enterRoute(String addressFrom, String hereAddressFrom, String addressTo, String hereAddressTo){
        enterAddressFrom(addressFrom, hereAddressFrom);
        enterAddressTo(addressTo, hereAddressTo);
    }

//    public boolean isDateFromPresent (String dateFrom){
//        return isElementPresent(".//*[text()='"+ dateFrom +"']");
//
//    }

    public void chooseDates (String dateFrom, String dateTo){
//        clickOnElement(buttonFromCalendar);
//        clickOnElement(buttonNextMonth);
//        isDateFromPresent(dateFrom);
//        clickOnElement(webDriver.findElement(By.xpath(".//*[text()='"+ dateFrom +"']")));
        enterTextIntoInput(inputDateFrom, dateFrom);
        enterTextIntoInput(inputDateTo, dateTo);
    }

    public void clickLinkAddVehicle() {
            WebElement element = webDriver.findElement(By.xpath(".//a[contains (text(),'+ Add vehicle')]"));
            JavascriptExecutor executor = (JavascriptExecutor) webDriver;
            executor.executeScript("arguments[0].click();", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//   !!use this method when solve problem with "can not work with element" error
//    public void createTransportationRequest (String addressFrom, String hereAddressFrom, String addressTo, String hereAddressTo, String dateFrom, String dateTo,
//                                             String brand, String model, String year, String generation, String body, String checkboxIndex){
//        enterRoute(addressFrom, hereAddressFrom, addressTo, hereAddressTo);
//        chooseDates(dateFrom, dateTo);
//        addVehiclePopup.addVehicle(brand, model, year, generation, body, checkboxIndex);
//    }

    public void clickStartSearch (String offerIndex){
//        webDriverWait20.until(ExpectedConditions.invisibilityOf(addVehiclePopup.inputBrand));
        clickOnElement(buttonSubmitStartSearch);
        webDriverWait20.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[@class='or_body_card_order'])['"+offerIndex+"']")));
        clickOnElement(webDriver.findElement(By.xpath("(.//*[@class='or_body_card_order'])['"+offerIndex+"']")));
//        try {
//            Thread.sleep(1500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}



