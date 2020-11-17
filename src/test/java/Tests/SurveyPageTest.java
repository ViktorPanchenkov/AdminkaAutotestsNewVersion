package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.FindBy;

public class SurveyPageTest extends TestBase{

    @Before
    public void BeforeAction(){
        String Phone = "+1111111111";
        String Password = "qwerty";
        webDriver.manage().window().maximize();
        loginPage.TypeUserName(Phone).
                TypePassword(Password).
                ClcikOnTheLoginButton();
        surveysPage.GotoSurveysTab();
    }

    @Test
    public void SearchSurvey(){
        String NameOFSurvey = "Survey With Yes/No Question";
        surveysPage.SearchSurvey(NameOFSurvey);
        Assert.assertTrue(surveysPage.IS_Survey_Was_Found(NameOFSurvey));
    }
    @Test
    public void AddOfficialSurvey(){
        String SurveyTitle = "CreatedByAutomatedTest";
        String SurveyDescription = "Description By Autotest";
        String QuestionText = "TextOfQuestion?";
        String Answer1 = "One";
        String Answer2 = "Not one";
        int CategoryNumber = 4;
        surveysPage.ClickOnAddOffSurveyButton().
                EnterTitle(SurveyTitle).
                EnterDescription(SurveyDescription).
                SelectCategory(CategoryNumber).
                EnterFirstQuestion(QuestionText).
                EnterTextToAnswerOptions(Answer1,Answer2).
                ClcikOnCreateSurveyButton();
        Assert.assertTrue(surveysPage.IS_Survey_Was_Created());
    }
    @Test
    public void BackToLiveUserSurvey(){
        surveysPage.GotoUsersSurveysTab().
                GotoCompletedSurvey().
                ClcikOnBackToLiveButton();
        Assert.assertTrue(surveysPage.IS_SurveyWas_ReturnedToFive());
    }
    @Test
    public void CompleteOfficialSurvey(){
            surveysPage.GotoToLiveSurvey().
                    ClcikonTheCompleteSurveyButton();
            Assert.assertTrue(surveysPage.IS_Survey_Was_Completed());
    }
    @Test
    public void DeleteCompletedUserSurvey(){
        surveysPage.GotoUsersSurveysTab().
                GotoCompletedSurvey().
                ClcikOnDeleteSurveyButton();
        Assert.assertTrue(surveysPage.IS_SurveyDeleted());
    }


}
