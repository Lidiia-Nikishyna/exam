package homePageTest;

import org.junit.Before;
import org.junit.Test;
import parentTest.ParentTest;

public class SearchOffersTest extends ParentTest {
    final String AddressFrom = "черкассы сурикова 10 ";
    final String HereFrom = "Украина, Черкассы, Черкассы, Василия Сурикова улица, 10";
    final String AddressTo = "столичное 90 ";
    final String HereTo = "Украина, 03045, Киев, Столичное шоссе, 90";
    final String DateFrom = "3/6/2018";
    final String DateTo = "3/22/2018";
    final String Brand = "Mazda";
    final String Mmodel = "CX-5";
    final String Year = "2017";
    final String Generation = "2 generation[2017-2017]";
    final String Body = "";
    final String CheckboxIndex = "2";

    @Before
    public void LoginUserAndCreateRequest(){
    loginPopup.loginUser ("lidiianikishynatest@gmail.com","1");
//    homePage.createTransportationRequest (AddressFrom, HereFrom, AddressTo, HereTo, DateFrom, DateTo, Brand, Model, Year, Generation, Body, CheckboxIndex);
        homePage.enterAddressFrom(AddressFrom, HereFrom);
        homePage.enterAddressTo(AddressTo, HereTo);
        homePage.chooseDates("3/6/2018", "3/22/2018");
        homePage.clickLinkAddVehicle();
        addVehiclePopup.addVehicle("Mazda", "CX-5", "2017", "2 generation[2017-2017]", "", "2");
    }

    @Test
    public void searchAndChooseOffer(){
        homePage.clickStartSearch("1");
    }

//    @After
}
