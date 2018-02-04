package popups;

import libs.ActionsWithOurElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.HomePage;
import pages.ParentPage;

import static libs.ActionsWithOurElements.*;

public class LoginPopup extends ParentPage{
    HomePage homePage;
//    ActionsWithOurElements actionsWithOurElements;

    @FindBy (xpath=".//*[@placeholder='Email']")  ////input[@type='email']
    private WebElement inputEmail;

    @FindBy (xpath=".//input[@type='password']")
    private WebElement inputPassword;

    @FindBy (xpath=".//div[@class='modal-footer']//dx-button[@type='success']")
    private WebElement buttonSubmit;

    public LoginPopup(WebDriver webDriver) {
        super(webDriver, "/home");
        homePage = new HomePage(webDriver);
//        actionsWithOurElements = new ActionsWithOurElements(webDriver);

    }



    public void enterTextIntoInputEmail(String email) {
        enterTextIntoInput(inputEmail, email);
    }

    public void enterTextIntoInputPassword(String password) {
        enterTextIntoInput(inputPassword, password);
    }

    public void clickOnButtonSubmit(){
        clickOnElement(buttonSubmit);
    }

    public void loginUser(String email, String password){
        homePage.openLoginPopup ();
        enterTextIntoInputEmail(email);
        enterTextIntoInputPassword(password);
        clickOnButtonSubmit();
    }

}


