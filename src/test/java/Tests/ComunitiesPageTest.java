package Tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Ignore;
 import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

public class ComunitiesPageTest extends TestBase {


    @Before
    public void BeforeAction(){
        int Random = (int) (Math.random()*10);
        String Phone = "+1111111111";
        String Password = "qwerty";
        webDriver.manage().window().maximize();
        loginPage.TypeUserName(Phone).
                TypePassword(Password).
                ClcikOnTheLoginButton();
        communitiesPage.GotoComunitiesTab();
    }
    @Severity(SeverityLevel.NORMAL)
    @Description("in this test we will find the community by CommunityName")
    @Test
    public void SearchCommunity(){
        String NameOFCommunity = "14 Soviet army";
        communitiesPage.SearchCommunity(NameOFCommunity);
        Assert.assertTrue(communitiesPage.IS_Community_Was_Found(NameOFCommunity));
    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("In this test we will add a new community")
    @Test
    public void AddCommunity(){
        int Random = (int) (Math.random() *10);
        int NumberOfCategory = 2;
        String CommunityTitle = "Created by autotest" + Random;
        String CommunityDescription = "Description";
        communitiesPage.ClcikOnAddCommunityButton().
                EnterTitle(CommunityTitle).
                EnterDescription(CommunityDescription).
                SelectCategory(NumberOfCategory).
                AddImage().
                ClcikOnCreateCommunitybutton();
        Assert.assertTrue(communitiesPage.IS_Community_Was_Created());
    }
    @Severity(SeverityLevel.NORMAL)
    @Description("In this test we will go to the list of community followers")
    @Test
    public void GoToFollowersTab(){
        int Random = (int) (Math.random()*10);
       communitiesPage.GotoCommunityFromList(Random).
               GotoFollowersTab();
       Assert.assertTrue(communitiesPage.IS_ListOfUsers_Displayed());

    }
    @Severity(SeverityLevel.NORMAL)
    @Description("In this test we will go to list of community moderators")
    @Test
    public void GotoModeratorsTab(){
        int Random = (int) (Math.random()*10);
    communitiesPage.GotoCommunityFromList(Random).
          GotoModeratorsTab();
    Assert.assertTrue(communitiesPage.IS_ListOfUsers_Displayed());
    }
    @Severity(SeverityLevel.NORMAL)
    @Description("In this test we will deactivate community news ")
    @Test
    public void DeactivateNews(){
        communitiesPage.GotoCommunityFromList(0).
                GotoActiveNewsTab();
        Assert.assertTrue(communitiesPage.InactiveNews());
    }
    @Severity(SeverityLevel.NORMAL)
    @Description("In this test we will activate community news")
    @Test
    public void ActivateNews(){
      communitiesPage.GotoCommunityFromList(0).
              GotoInactiveNewsTab();
      Assert.assertTrue(communitiesPage.ActivateNews());
    }
    @Severity(SeverityLevel.NORMAL)
    @Description("In this test we will create community news in active tab")
    @Test
    public void CreateActiveNews(){

        int Random = (int) (Math.random()*10);
        String NewsTitle = "Created By autotest" + Random;
        String NewsDescription = "Description By Autotest" + Random;
        communitiesPage.GotoCommunityFromList(Random).
                GotoActiveNewsTab().
                ClcikOnCreateNewsButton().
                EnterTitle(NewsTitle).
                EnterDescription(NewsDescription).
                AddImage().ClcikOnCreateNewsButton();
        Assert.assertTrue(communitiesPage.IS_News_Was_Created());
    }
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("In this test we will create community news in inactive tab")
    public void CreateInactiveNews(){
        int Random = (int) (Math.random()*10);
        String NewsTitle = "Created By autotest" + Random;
        String NewsDescription = "Description By Autotest" + Random;
        communitiesPage.GotoCommunityFromList(Random).
                GotoInactiveNewsTab().
                ClcikOnCreateNewsButton().
                EnterTitle(NewsTitle).
                EnterDescription(NewsDescription).
                AddImage().ClcikOnCreateNewsButton();
        Assert.assertTrue(communitiesPage.IS_News_Was_Created());
    }
    @Severity(SeverityLevel.NORMAL)
    @Description("In this test we will delete inactive news")
    @Test
    public void DeleteInactiveNews(){
        int Random = (int) (Math.random()*10);
        communitiesPage.GotoCommunityFromList(0).
                GotoInactiveNewsTab().
                GotoInactiveNews().
                ClcikOnDeleteNewsButton();
        Assert.assertTrue(communitiesPage.IS_News_Deleted());
    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("In this test we will block community")
    @Test
    public void BlockCommunity(){
        communitiesPage.GotoCommunityFromList(8).
                ClcikOnBlockCommunityButton();
        Assert.assertTrue(communitiesPage.IS_CommunityWas_Blocked());
    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("In this test we will unblock community")
    @Test
    public void UnblockCommunity(){
        communitiesPage.GotoCommunityFromList(8).
                ClcikOnUnblockCommunityButton();
        Assert.assertTrue(communitiesPage.IS_Community_Was_Unblocked());
    }
   @Ignore
    public void DeleteCommunity(){
        String CommunityToDelete = "Created By autotest";
        communitiesPage.SearchCommunity(CommunityToDelete);
    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("In this test we will edit existing community")
    @Test
    public void EditCommunity(){
        String nameOFCommunity = "QA commnuity";
        String newCommunityDescription = "Updated by autotest";
        communitiesPage.SearchCommunity(nameOFCommunity).
                ClcikOnEditButton().
                EnterTitle(nameOFCommunity).
                EnterDescription(newCommunityDescription).
                SelectCategory(4).
                ClikonTheAutomaticApprovalButton().
                ClickOnUpdateCommunityButton();
        Assert.assertTrue(communitiesPage.IS_Community_Was_Updated());
    }

    //Negative Cases
    @Severity(SeverityLevel.NORMAL)
    @Description("In this test we will create community with already existing name")
    @Test
    public void CreateCommunityWithAlreadyExistName(){
        String CommunityTitle = "QA commnuity";
        String CommunityDescription = "Updated by autotest";
        int NumberOfCategory = 2;
        communitiesPage.ClcikOnAddCommunityButton().
                EnterTitle(CommunityTitle).
                EnterDescription(CommunityDescription).
                SelectCategory(NumberOfCategory).
                AddImage().
                ClcikOnCreateCommunitybutton();
        Assert.assertTrue(communitiesPage.IS_IT_Not_Possible_To_Create_Community_With_ExitsName());
    }
    @Test
    public void JSInjection(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("document.getElementsByTagName('button')[1].style.backgroundColor ='red'");
        js.executeScript("alert('Hello World');");
    }


}
