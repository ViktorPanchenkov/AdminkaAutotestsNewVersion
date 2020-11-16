package Tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class ProfilePageTest extends TestBase {

    @Before
    public void BeforeAction(){
        String Phone = "+1111111111";
        String Password = "qwerty";
        loginPage.TypeUserName(Phone).
                TypePassword(Password).
                ClcikOnTheLoginButton().
                GotoUserProfile();
        webDriver.manage().window().maximize();
    }
    @Test
    public void ChangeUserName(){
        String UserName = "OCT Admin";
        userProfilePage.TypeUserName(UserName);
        userProfilePage.ScrollDown();
    }

    @Test
    public void SelectGender(){
        userProfilePage.SelectGender();
    }
}
