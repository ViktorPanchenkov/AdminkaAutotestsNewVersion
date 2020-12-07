package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PointsPageTest extends TestBase {


    @Before
    public void BeforeAction(){
        String Phone = "+1111111111";
        String Password = "qwerty";
        webDriver.manage().window().maximize();
        loginPage.TypeUserName(Phone).
                TypePassword(Password).
                ClcikOnTheLoginButton();
        pointsPage.GotoPointsTab();
    }

    @Test
    public void ChangeCreateCommunityCost(){
        int Random = (int) (Math.random() * 10);
        String Sum = "100" + Random;
        pointsPage.EnterSumToCreateCommunityInput(Sum).
                ClcikOnSaveChangesButton();
        Assert.assertTrue(pointsPage.IS_UpdatedPopUP_Displayed());
        Assert.assertTrue(pointsPage.IS_Create_Community_Cost_Was_Changed(Sum));
    }
    @Test
    public void HideCommunityActionCostSection(){
        pointsPage.ClcikOnHideCommunityActionSectionButton();
        Assert.assertTrue(pointsPage.IS_CommunityActionCostSection_Was_Hide());
    }
    @Test
    public void ChangeCreateSurveyActionCost(){
        int Random = (int) (Math.random() * 10);
        String Sum = "10" + Random;
        pointsPage.ClcikOnHideCommunityActionSectionButton().
                EnterSumToCreateSurveyInput(Sum).
                ClcikOnSaveChangesButton();
        Assert.assertTrue(pointsPage.IS_UpdatedPopUP_Displayed());
        Assert.assertTrue(pointsPage.IS_CreateSurvey_CostWas_Changed(Sum));
    }
    @Test
    public void HideSurveyActionCostSection(){
        pointsPage.ClcikOnHideSurveyActionCostSection();
        Assert.assertTrue(pointsPage.IS_Survey_Action_Cost_SectionWasHide());
    }

}
