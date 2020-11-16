package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.*;

public class LoginPageTests extends TestBase{

    @Before
    public void BeforeAction(){
        webDriver.manage().window().maximize();
    }
    @Test
    public void Login_as_OCTAdmin(){
        String Phone = "+1111111111";
        String Password = "qwerty";
        loginPage.TypeUserName(Phone).
                TypePassword(Password).
                ClcikOnTheLoginButton().
                GotoUserProfile();
        Assert.assertTrue(loginPage.IS_User_Loged_As_OctAdmin());
    }
    @Test
    public void Login_As_OCTModerator(){
        String Phone = "+1111111112";
        String Password = "qwerty";
        loginPage.TypeUserName(Phone).
                TypePassword(Password).
                ClcikOnTheLoginButton().
                GotoUserProfile();
        Assert.assertTrue(loginPage.IS_User_Logged_As_OCT_Moderator());

    }
    @Test
    public void LoginAs_ContentManager(){
        String Phone = "+1111111113";
        String Password = "qwerty";
        loginPage.TypeUserName(Phone).
                TypePassword(Password).
                ClcikOnTheLoginButton().
                GotoUserProfile();
        Assert.assertTrue(loginPage.IS_User_Logged_As_ContentManager());

    }
    @Test
    public void LoginWithInvalidCreds(){
        String InvalidPhone = "+1111111";
        String InvalidPassword = "qwe";
        loginPage.TypeUserName(InvalidPhone).
                TypePassword(InvalidPassword).
                ClcikOnTheLoginButton();
        Assert.assertTrue(loginPage.IS_User_WAS_Not_Logged_With_Invalid_Creds());
    }

}
