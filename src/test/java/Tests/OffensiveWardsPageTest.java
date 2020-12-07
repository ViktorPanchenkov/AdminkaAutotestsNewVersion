package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OffensiveWardsPageTest extends TestBase {



    @Before
    public void BeforeAction(){
        String Phone = "+1111111111";
        String Password = "qwerty";
        webDriver.manage().window().maximize();
        loginPage.TypeUserName(Phone).
                TypePassword(Password).
                ClcikOnTheLoginButton();
        offenciveWordsPage.GoToOffenciveWordsTab();
    }

    @Test
    public void AddOffenciveWord(){
        int Random = (int) (Math.random() * 10);
       String Word = "Dick" + Random;
       offenciveWordsPage.EnterOffenciveWord(Word).
               ClcikOnAddOffensiveWordButton();
        Assert.assertTrue(offenciveWordsPage.IS_Word_Was_Added(Word));
    }

    @Test
    public void DeleteOffenciveWord(){
        Assert.assertTrue(offenciveWordsPage.DeleteWord());
    }

}
