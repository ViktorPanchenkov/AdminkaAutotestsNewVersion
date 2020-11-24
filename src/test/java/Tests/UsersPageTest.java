package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.io.IOException;

public class UsersPageTest extends TestBase {


    @Before
    public void BeforeAction() {
        String Phone = "+1111111111";
        String Password = "qwerty";
        webDriver.manage().window().maximize();
        loginPage.TypeUserName(Phone).
                TypePassword(Password).
                ClcikOnTheLoginButton();
        usersPage.GotoUsersTab();

    }

    @Test
    public void SearchUser() {
        String Username = "14 Soviet Army";
        usersPage.SearchUser(Username);
        Assert.assertTrue(usersPage.IS_User_Was_Found(Username));
    }

    @Test
    public void GotoUserCommunitiesTab() {
        int Random = (int) (Math.random() * 10);
        usersPage.GotoRandomUserProfile(Random).
                GotoUserCommunitiesTab();
        Assert.assertTrue(usersPage.IS_UserOwnedCommunities_TabWasSelected());
    }
    @Test
    public void NotifyEvereyone(){
        String TextOfNotification = "Test notification by autotest";
       usersPage.ClcikonNotifyEvereoneButton().
               EnterTextOfNotification(TextOfNotification).
               ClickonCreteNotificationButton();
       Assert.assertTrue(usersPage.IS_GlobalNotification_Was_Sent());
    }

    @Test
    public void GotoUserSurveysTab() {
        int Random = (int) (Math.random() * 10);
        usersPage.GotoRandomUserProfile(Random).
                GotoUserSurveysTab();
        Assert.assertTrue(usersPage.IS_UserSurveysTab_Was_Selected());

    }

    @Test
    public void BanUser() throws IOException {
        String UserName = "User For Ban";
        usersPage.SearchUser(UserName).
                ClcikOnTheBanUserButton();
        Assert.assertTrue(usersPage.IS_User_Was_Banned());
    }

    @Test
    public void UnbunUser() throws IOException {
        String UserName = "User For Ban";
        usersPage.SearchUser(UserName).
                ClickOnUnbanUserButton();
        Assert.assertTrue(usersPage.IS_User_Was_Unbanned());
    }

}
