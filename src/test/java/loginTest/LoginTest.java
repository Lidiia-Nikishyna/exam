package loginTest;

import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import parentTest.ParentTest;


public class LoginTest extends ParentTest {

    @Test
    public void validLogin () {
        loginPopup.loginUser("lidiianikishynatest@gmail.com","1");
    }

}
