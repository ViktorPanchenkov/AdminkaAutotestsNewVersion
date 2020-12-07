package Tests;

import org.junit.Assert;
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
        userProfilePage.TypeUserName(UserName).
                ClcikOnTheSaveButton();
        Assert.assertTrue(userProfilePage.IS_UserName_Was_Changed(UserName));
    }

    @Test
    public void ChangeEmail(){
        String Email = "octadmin@crowdthinc.com";
        userProfilePage.EnterEmail(Email).
                ClcikOnTheSaveButton();
        Assert.assertTrue(userProfilePage.IS_Email_Was_Changed(Email));
    }

    @Test
    public void SelectGender() {
        userProfilePage.SelectGender().
                ClcikOnTheSaveButton();
        Assert.assertTrue(userProfilePage.IS_ProfileWasUpdated());
    }
    @Test
    public void SelectBirthDate(){
        userProfilePage.SelectBirthDate().
                ClcikOnTheSaveButton();
        Assert.assertTrue(userProfilePage.IS_ProfileWasUpdated());
        Assert.assertTrue(userProfilePage.IS_BirthDate_Displayed());
    }
    @Test
    public void ChangeZipCode(){
        int Random = (int) (Math.random() *10);
        String ZipCode = "1234" + Random;
     userProfilePage.EnterZipCode(ZipCode).
             ClcikOnTheSaveButton();
     Assert.assertTrue(userProfilePage.IS_ZipCode_Entered(ZipCode));
    }

    @Test
    public void ChangePassword(){
        String OldPassword = "qwerty";
        String NewPassword = "qwerty";
        userProfilePage.GotoChangePasswordTab().
                EnterOldPassword(OldPassword).
                EnterNewPassword(NewPassword).
                EnterConfirmPassword(NewPassword).
                ShowEnteredPasswords().
                ClcikOnChangePasswordButton();
        Assert.assertTrue(userProfilePage.IS_Password_Was_Changed());
    }
}
