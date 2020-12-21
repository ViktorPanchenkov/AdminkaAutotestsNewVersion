package Tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.assertj.core.api.UriAssert;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BuzzPageTest extends TestBase {


    @Before
    public void BeforeAction(){
        String Phone = "+11111111111";
        String Password = "qwerty";
        webDriver.manage().window().maximize();
        loginPage.TypeUserName(Phone).
                TypePassword(Password).
                ClcikOnTheLoginButton();
        buzzPage.GotoBuzzTab();
    }
    @Severity(SeverityLevel.MINOR)
    @Description("In this test we will find the Buzz in List of bazzes")
    @Test
    public void FindBuzz(){
        String nameOfBuzz = "QA";
        buzzPage.SearchBuzz(nameOfBuzz);
        Assert.assertTrue(buzzPage.IS_Buzz_was_Found(nameOfBuzz));


    }
   @Severity(SeverityLevel.CRITICAL)
   @Description("In this test we will Add The Buzz new Buzz.")
    @Test
    public void AddBuzz(){
        int Random = (int) (Math.random() * 10);
        String Title = "Buzz created by automation test" + Random;
        String Description = "Description of Buzz";
        String URL = "http://google.com";
        buzzPage.ClcikOnTheAddBuzzButton().
                EnterTitle(Title).
                EnterURL(URL).
                EnterDescription(Description).
                AddCoverImage().
                ClcikOnSaveButton();
        Assert.assertTrue(buzzPage.IS_Buzz_Was_Created(Title,Description));
    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("In this test we will Edit Title and Description of Existing Buzz")
    @Test
    public void EditBuzz(){
        int Random = (int) (Math.random() * 10);
        String NewBuzzTitle = "Updated by Selenium" + Random;
        String NewDescription = "Description By Selenium";
        buzzPage.GoToRandomBuzz().
                GotoEditBuzzScreen().
                EnterTitle(NewBuzzTitle).
                EnterDescription(NewDescription).
                ClcikOnSaveButton();
        Assert.assertTrue(buzzPage.IS_Buzz_Updated(NewBuzzTitle,NewDescription));

    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("In this test we will delete existing Buzz")
    @Test
    public void DeleteBuzz(){
        buzzPage.GoToRandomBuzz().
                ClcikOnTheDeleteBuzzButton();
        Assert.assertTrue(buzzPage.IS_Buzz_was_Removed());

    }
}
