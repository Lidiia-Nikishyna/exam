package popups;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.ParentPage;

import static libs.ActionsWithOurElements.clickOnElement;
import static libs.ActionsWithOurElements.clickOnVisibleElement;

public class AddVehiclePopup extends ParentPage {
    HomePage homePage;
    Actions actions;
    WebDriverWait webDriverWait20;


    //block My vehicles
    @FindBy(xpath = ".//a[contains (text(),'+ Add vehicle')]") //  .//div[@class='or_top_vehicles_link']//a[contains (text(),'+ Add vehicle')] or .//a[@href="javascript:void(0)"]
    private WebElement linkAddVehicle;

//    .//div[@id='cdk-overlay-1'] - add-vehicle-modal

    @FindBy (xpath = ".//*[@placeholder='Brand']")  //.//div[@class='or_modal_box_top_brand']//div[@class='mat-input-infix mat-form-field-infix']
    public
    WebElement inputBrand;

// xpath =".//*[@class='mat-option-text'][contains(text(),'" + brand + "')]")    - brand oprion from the list of brands

    @FindBy(xpath = ".//*[@placeholder='Model']")  //.//div[@class='or_modal_box_top_model']//div[@class='mat-input-infix mat-form-field-infix']
    private WebElement inputModel;

// xpath =".//*[@class='mat-option-text'][contains(text(),'" + model + "')]")    - model oprion from the list of brands

    @FindBy (xpath = ".//*[@placeholder='Year']")    //.//div[@class='or_modal_box_top_year']//div[@class='mat-input-infix mat-form-field-infix']
    private WebElement inputYear;

//    xpath = ".//*[@class='mat-option-text'][contains(text(),'" + year + "')]"  - year option

    @FindBy (xpath = ".//*[@placeholder='Generation']")    //.//div[@class='or_modal_box_top_generation']//div[@class='mat-input-infix mat-form-field-infix']
    private WebElement inputGeneration;

//    xpath = ".//*[@class='mat-option-text'][contains(text(),'" + generation + "')]"  - generation option

//    xpath = ".//div[@class='or_modal_body_type_box_item'][contains(text(),'" + body + "')]"  - body type option

//    xpath=(//input[@type='checkbox'])[position()=2] - second checkbox. think how to make position variable

    @FindBy(xpath = ".//div[@class='or_modal_btns']//button[@type='submit']")
    private WebElement buttonSubmitAddVehicle;


    public AddVehiclePopup(WebDriver webDriver) {
        super(webDriver, "/home");
        homePage = new HomePage(webDriver);
        webDriverWait20 = new WebDriverWait(webDriver,20);
        actions = new Actions(webDriver);
    }

    public void addVehicle (String brand, String model, String year, String generation, String body, String checkboxIndex){
//        clickOnElement(webDriver.findElement(By.xpath(".//*[@class='or_top_vehicles_link']//a")));
//        webDriverWait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='or_modal_btns']//button[@type='submit']")));
        clickOnElement(inputBrand);
        clickOnElement(webDriver.findElement(By.xpath(".//*[@class='mat-option-text'][contains(text(),'" + brand + "')]")));
        clickOnElement(inputModel);
        clickOnElement(webDriver.findElement(By.xpath(".//*[@class='mat-option-text'][contains(text(),'" + model + "')]")));
        clickOnElement(inputYear);
        clickOnElement(webDriver.findElement(By.xpath(".//*[@class='mat-option-text'][contains(text(),'" + year + "')]")));
        clickOnElement(inputGeneration);
        clickOnElement(webDriver.findElement(By.xpath(".//*[@class='mat-option-text'][contains(text(),'" + generation + "')]")));
//        webDriverWait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*/p[text()='" + body + "']")));
//        clickOnElement(webDriver.findElement(By.xpath(".//*/p[text()='" + body + "']")));
//        webDriverWait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(.//*[@class='mat-checkbox-frame'])['"+ checkboxIndex +"']")));
//        clickOnElement(webDriver.findElement(By.xpath("(.//*[@class='mat-checkbox-frame'])['"+ checkboxIndex +"']")));
        WebElement buttonSubmitVehicle = webDriverWait20.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='or_modal_btns']//button[@type='submit']")));
        actions.moveToElement(buttonSubmitVehicle);
        clickOnElement(buttonSubmitAddVehicle);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
