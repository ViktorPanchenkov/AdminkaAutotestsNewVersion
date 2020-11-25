package Tests;

import Pages.*;
import org.apache.commons.lang3.EnumUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
    LoginPage loginPage;
    WebDriver webDriver;
    BuzzPage buzzPage;
    UserProfilePage userProfilePage;
    SurveysPage surveysPage;
    CommunitiesPage communitiesPage;
    UsersPage usersPage;
    ContactRequestsPage contactRequestsPage;
    StayInTouchEmailsPage stayInTouchEmailsPage;
    static WebDriverWait wait;

    @Before
    public void SetUP(){

        System.setProperty("webdriver.chrome.driver", "/home/user/ChromeDriver/chromedriver");
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver,5);
        loginPage = new LoginPage(webDriver);
        userProfilePage = new UserProfilePage(webDriver);
        buzzPage = new BuzzPage(webDriver);
        surveysPage = new SurveysPage(webDriver);
        communitiesPage = new CommunitiesPage(webDriver);
        usersPage = new UsersPage(webDriver);
        contactRequestsPage = new ContactRequestsPage(webDriver);
        stayInTouchEmailsPage = new StayInTouchEmailsPage(webDriver);
        webDriver.get("http://192.168.88.89");

    }
   // @After
    public void Close(){
        webDriver.quit();
    }

}
