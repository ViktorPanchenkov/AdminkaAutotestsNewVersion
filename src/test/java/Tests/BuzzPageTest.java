package Tests;

import org.assertj.core.api.UriAssert;
import org.junit.Before;
import org.junit.Test;

public class BuzzPageTest extends TestBase {


    @Before
    public void BeforeAction(){
        String Phone = "+1111111111";
        String Password = "qwerty";
        webDriver.manage().window().maximize();
        loginPage.TypeUserName(Phone).
                TypePassword(Password).
                ClcikOnTheLoginButton();
        buzzPage.GotoBuzzTab();
    }

    @Test
    public void AddBuzz(){
        int Random = (int) (Math.random() * 10);
        String Title = "Buzz created by automation test" + Random;
        String Description = "Description of Buzz";
        String URL = "http://google.com";
        buzzPage.ClcikOnTheAddBuzzButton().
                EnterTitle(Title).
                EnterURL(URL).
                EnterDescription(Description).
                AddCoverImage().
                ClcikOnSaveButton();
    }
}
