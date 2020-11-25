package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContactRequestsPageTest extends TestBase {


    @Before
    public void BeforeAction(){
        String Phone = "+1111111111";
        String Password = "qwerty";
        webDriver.manage().window().maximize();
        loginPage.TypeUserName(Phone).
                TypePassword(Password).
                ClcikOnTheLoginButton();
        contactRequestsPage.GotoContactRequestsTab();
    }
    @Test
    public void GotoSolvedTab(){
      contactRequestsPage.GotoSolvedTab();
        Assert.assertTrue(contactRequestsPage.IS_SolvedRequestsTab_Was_Selected());
    }
    @Test
    public void GotoRequestedTab(){
        contactRequestsPage.GotoSolvedTab().
        GotoRequestedTab();
        Assert.assertTrue(contactRequestsPage.IS_RequestedTab_Was_Selected());
    }
    @Test
    public void SolveRequest(){
     contactRequestsPage.
             GotoRequestedTab().
             ClickOnMarkSolvedButton();
     Assert.assertTrue(contactRequestsPage.IS_Request_Was_Solved());
    }
    @Test
    public void OpenContactRequestInfoInRequestedTab(){
       contactRequestsPage.OpenContactRequestInfo();
       Assert.assertTrue(contactRequestsPage.IS_Contact_Request_Info_Opened());
    }
    @Test
    public void OpenContactRequestInfoInSolvedTab(){
        contactRequestsPage.GotoSolvedTab()
                .OpenContactRequestInfo();
                Assert.assertTrue(contactRequestsPage.IS_Contact_Request_Info_Opened());
    }


}
