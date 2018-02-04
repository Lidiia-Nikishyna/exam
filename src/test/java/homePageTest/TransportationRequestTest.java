package homePageTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import parentTest.ParentTest;

public class TransportationRequestTest extends ParentTest {
    final String AddressFrom = "черкассы сурикова 10 ";
    final String HereAddressFrom = "Украина, Черкассы, Черкассы, Василия Сурикова улица, 10";
    final String AddressTo = "столичное 90 ";
    final String HereAddressTo = "Украина, 03045, Киев, Столичное шоссе, 90";

    @Before
    public void loginUser (){
        loginPopup.loginUser("lidiianikishynatest@gmail.com","1");
    }

    @Test
    public void createTransportRequest(){
        homePage.enterAddressFrom(AddressFrom, HereAddressFrom);
        homePage.enterAddressTo(AddressTo, HereAddressTo);
        homePage.chooseDates("3/6/2018", "3/22/2018");
        homePage.clickLinkAddVehicle();
        addVehiclePopup.addVehicle("Mazda", "CX-5", "2017", "2 generation[2017-2017]", "", "2");
    }

//    @After

}
