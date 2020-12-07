package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StayInTouchEmailsTabTest extends TestBase {


    @Before
    public void BeforeAction(){
        String Phone = "+1111111111";
        String Password = "qwerty";
        webDriver.manage().window().maximize();
        loginPage.TypeUserName(Phone).
                TypePassword(Password).
                ClcikOnTheLoginButton();
        stayInTouchEmailsPage.GotoStayInTouchEmailsTab();
    }

    @Test
    public void GotoSubscribedTab(){
      stayInTouchEmailsPage.GotoUnsubscribedTab().
              GotoSubscribedTab();
        Assert.assertTrue(stayInTouchEmailsPage.IS_Subscribe_Tab_IS_Selected());
    }
    @Test
    public void GotoUnsubscribedTab(){
        stayInTouchEmailsPage.GotoUnsubscribedTab();
        Assert.assertTrue(stayInTouchEmailsPage.IS_UnsucscribeTab_Was_Selected());
    }
    @Test
    public void OpenGetInTouchEmailInfoInSubscribedTab(){
        stayInTouchEmailsPage.GotoSubscribedTab().
        OpenStayInTouchEmailInfo();
        Assert.assertTrue(stayInTouchEmailsPage.IS_StayInTouchEmail_Was_Opened());
    }
    @Test
    public void DeleteStayInTouchEmailFromSubscribedTab(){
        stayInTouchEmailsPage.GotoSubscribedTab().
                ClickOnDeleteButton();
        Assert.assertTrue(stayInTouchEmailsPage.IS_Stay_In_Touch_Email_Was_Deleted());
    }
}
