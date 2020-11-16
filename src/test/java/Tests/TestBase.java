package Tests;

import Pages.BuzzPage;
import Pages.LoginPage;
import Pages.UserProfilePage;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
    LoginPage loginPage;
    WebDriver webDriver;
    BuzzPage buzzPage;
    UserProfilePage userProfilePage;
    static WebDriverWait wait;

    @Before
    public void SetUP(){
        System.setProperty("webdriver.chrome.driver", "/home/user/ChromeDriver/chromedriver");
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver,5);
        loginPage = new LoginPage(webDriver);
        userProfilePage = new UserProfilePage(webDriver);
        buzzPage = new BuzzPage(webDriver);
        webDriver.get("http://192.168.88.89");

    }

}
