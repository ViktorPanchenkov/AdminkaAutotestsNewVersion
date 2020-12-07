package Tests;

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

    @Test
    public void SearchCommunity(){
        String NameOFCommunity = "14 Soviet army";
        communitiesPage.SearchCommunity(NameOFCommunity);
        Assert.assertTrue(communitiesPage.IS_Community_Was_Found(NameOFCommunity));
    }
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
    @Test
    public void GoToFollowersTab(){
        int Random = (int) (Math.random()*10);
       communitiesPage.GotoCommunityFromList(Random).
               GotoFollowersTab();
       Assert.assertTrue(communitiesPage.IS_ListOfUsers_Displayed());

    }
    @Test
    public void GotoModeratorsTab(){
        int Random = (int) (Math.random()*10);
    communitiesPage.GotoCommunityFromList(Random).
          GotoModeratorsTab();
    Assert.assertTrue(communitiesPage.IS_ListOfUsers_Displayed());
    }
    @Test
    public void DeactivateNews(){
        communitiesPage.GotoCommunityFromList(0).
                GotoActiveNewsTab();
        Assert.assertTrue(communitiesPage.InactiveNews());
    }
    @Test
    public void ActivateNews(){
      communitiesPage.GotoCommunityFromList(0).
              GotoInactiveNewsTab();
      Assert.assertTrue(communitiesPage.ActivateNews());
    }
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
    @Test
    public void DeleteInactiveNews(){
        int Random = (int) (Math.random()*10);
        communitiesPage.GotoCommunityFromList(0).
                GotoInactiveNewsTab().
                GotoInactiveNews().
                ClcikOnDeleteNewsButton();
        Assert.assertTrue(communitiesPage.IS_News_Deleted());
    }
    @Test
    public void BlockCommunity(){
        communitiesPage.GotoCommunityFromList(8).
                ClcikOnBlockCommunityButton();
        Assert.assertTrue(communitiesPage.IS_CommunityWas_Blocked());

    }
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
