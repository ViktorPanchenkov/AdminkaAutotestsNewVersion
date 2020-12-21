package Tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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

    @Severity(SeverityLevel.NORMAL)
    @Test
    public void SearchSurvey(){
        String NameOFSurvey = "Survey With Yes/No Question";
        surveysPage.SearchSurvey(NameOFSurvey);
        Assert.assertTrue(surveysPage.IS_Survey_Was_Found(NameOFSurvey));
    }
    @Severity(SeverityLevel.CRITICAL)
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
    @Test
    public void CloneSurvey(){
        String Title = "Cloned Survey";
        String Description = "Cloned Description";
        surveysPage.GotoUsersSurveysTab().
                GotoCompletedSurvey().
                ClickOnCloneSurveyButton().
                ClcikOnEditDraftButton().
                EnterTitle(Title).
                EnterDescription(Description).
                ClcikOnPublishButton();
        Assert.assertTrue(surveysPage.IS_SurveyWas_ReturnedToFive());
    }
    @Test
    public void AddPulseSurvey(){
        String PulseTitle = "Pulse Created By automation test";
        String PulseDescription = "Description By Autotest";
        String QuestionText = "Does automation test works well?";
        String Answer1 = "Yes";
        String Answer2 = "No, it is a bad solution.";
        surveysPage.GotoPulseTab().
                ClcikOnAddPulseButton()
                .EnterTitle(PulseTitle).
                EnterDescription(PulseDescription)
                .EnterFirstQuestion(QuestionText).
                EnterTextToAnswerOptions(Answer1,Answer2).
                ClcikOnCreatePulseButton();
        Assert.assertTrue(surveysPage.IS_Pulse_Was_Created());
    }
    @Test
    public void BackToLivePulse(){
        surveysPage.GotoPulseTab().
                GotoCompletedPulse().
                ClcikOnBackToLiveButton();
        Assert.assertTrue(surveysPage.IS_SurveyWas_ReturnedToFive());
    }
    @Test
    public void DeletePulse(){
        surveysPage.GotoPulseTab().
                GotoCompletedPulse().
                ClickonDeletePulseButton();
        Assert.assertTrue(surveysPage.IS_SurveyDeleted());
    }

}
