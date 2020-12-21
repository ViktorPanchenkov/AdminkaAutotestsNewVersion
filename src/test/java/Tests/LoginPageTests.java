package Tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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

    @Severity(SeverityLevel.BLOCKER)
    @Description("In this test we will log in as OCT Administrator ")
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

    @Severity(SeverityLevel.BLOCKER)
    @Description("In this test we will log in as OCT Moderator")
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
    @Severity(SeverityLevel.BLOCKER)
    @Description("In this test we will log in using email")
    @Test
    public void LoginByEmail(){
        String Email = "octadmin@crowdthinc.com";
        String Password = "qwerty";
        loginPage.TypeUserName(Email).
                TypePassword(Password).
                ClcikOnTheLoginButton();
        Assert.assertTrue(loginPage.IS_Login_By_Email_Sucsasfull());
    }
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("In this test we will log in as Content Manager ")
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
    @Severity(SeverityLevel.CRITICAL)
    @Description("In this test we will log in with invalid creds")
    public void LoginWithInvalidCreds(){
        String InvalidPhone = "+1111111";
        String InvalidPassword = "qwe";
        loginPage.TypeUserName(InvalidPhone).
                TypePassword(InvalidPassword).
                ClcikOnTheLoginButton();
        Assert.assertTrue(loginPage.IS_User_WAS_Not_Logged_With_Invalid_Creds());
    }

    @Test
    public void LoginWithInvalidPassword(){
         String Phone = "+11111111111";
         String InvalidPassword = "vdv";
         loginPage.TypeUserName(Phone).
                 TypePassword(InvalidPassword).
                 ClcikOnTheLoginButton();
         Assert.assertTrue(loginPage.IS_User_WAS_Not_Logged_With_Invalid_Creds());
    }
    @Severity(SeverityLevel.BLOCKER)
    @Description("In this test we will navigate to Forgot Password screen")
    @Test
    public void GotoForgotPasswordScreen(){
        loginPage.GotoForgotPasswordScreen();
        Assert.assertTrue(loginPage.IS_Forgot_Password_Screen_Opened());
    }

}
