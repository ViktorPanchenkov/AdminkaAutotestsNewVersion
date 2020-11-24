package Pages;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class UsersPage extends BasePage {
    public UsersPage(WebDriver webDriver) {
        super(webDriver);
    }


    @FindBy (xpath = "//span[contains(text(),'Users')]")
    WebElement UsersTab;
    @FindBy(xpath = "//input[@placeholder='Search...']")
    WebElement SearchFiled;
    @FindBy (xpath = "//span[contains(text(),'Ban User')]")
    WebElement BanUserButton;
    @FindBy (xpath = "//span[contains(text(),'Unban User')]")
    WebElement UnbanUserButton;
    @FindBy (xpath = "//span[contains(text(),'Notify everyone')]")
    WebElement NotifyEvereyoneButton;
    @FindBy (xpath = "//textarea[@name='message']")
    WebElement InputForGlobalNotitfication;
    @FindBy (xpath = "//span[contains(text(),'Create Notification')]")
    WebElement CreateNotificationButton;
    By UserCommunitiesTab = By.xpath("//div[@class='category-header-cmp-tabs f-c-s']/h3[2]");
    By UserSurveysTab = By.xpath("//div[@class='category-header-cmp-tabs f-c-s']/h3[3]");


    public UsersPage GotoUsersTab(){
        WaitVisabilityOfElement(UsersTab);
        UsersTab.click();
        return new UsersPage(webDriver);
    }
    public UsersPage SearchUser(String UserName) {
        WaitVisabilityOfElement(SearchFiled);
        SearchFiled.sendKeys(UserName);
        try {
            WebElement FoundSurvey = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + UserName + "')]")));
            FoundSurvey.click();
        } catch (TimeoutException TimeOut) {
            Assert.fail("There is no Survey with such name!");
        }
        return this;
    }
    public UsersPage GotoRandomUserProfile(int numberOfUser){
        WebElement User = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[2]")));
        List<WebElement> ListOfUsers = new ArrayList<WebElement>();
        for (int i =1 ; i< 10; i++){
            ListOfUsers.add(webDriver.findElement(By.xpath("//tbody/tr["+ i+"]/td[2]")));
        }
        ListOfUsers.get(numberOfUser).click();
        return this;
    }
    public UsersPage GotoUserCommunitiesTab(){
        WaitVisabilityOfElement(By.xpath("//h2"));
        webDriver.findElement(UserCommunitiesTab).click();
        return this;
    }
    public UsersPage GotoUserSurveysTab(){
        WaitVisabilityOfElement(By.xpath("//h2"));
        webDriver.findElement(UserSurveysTab).click();
        return this;
    }
    public UsersPage ClcikOnTheBanUserButton() throws IOException {
        try {
            WaitVisabilityOfElement(BanUserButton);
            BanUserButton.click();
            WebElement BanConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-modal-footer']/button[2]")));
            BanConfirmation.click();
        } catch (TimeoutException TimeOut){

            File screen = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screen, new File("/home/user/Desktop/SeleniumScrenshots/BanUser " + screen.getName()));
            Assert.fail("User already banned!");
        }

        return this;
    }
    public UsersPage ClickOnUnbanUserButton() throws IOException {
        try {
            WaitVisabilityOfElement(UnbanUserButton);
            UnbanUserButton.click();
            WebElement UnBanConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'ant-modal-root')]//button[2]")));
            UnBanConfirmation.click();
        } catch (TimeoutException TimeOut){
            File screen = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screen, new File("/home/user/Desktop/SeleniumScrenshots/BanUser " + screen.getName()));
         Assert.fail("User was not banned!");
        }
        return this;
    }
    public UsersPage ClcikonNotifyEvereoneButton(){
        WaitVisabilityOfElement(NotifyEvereyoneButton);
        NotifyEvereyoneButton.click();
        return this;
    }
    public UsersPage EnterTextOfNotification(String TextOfNotification){
        WaitVisabilityOfElement(InputForGlobalNotitfication);
        InputForGlobalNotitfication.sendKeys(TextOfNotification);
        return this;
    }
    public UsersPage ClickonCreteNotificationButton(){
        WaitVisabilityOfElement(CreateNotificationButton);
        CreateNotificationButton.click();
        return this;
    }


    public boolean IS_User_Was_Found(String userName){
        try {
            Boolean UserName = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2"),userName));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("The user name is not equal necessary!");
            return false;
        }
    }
    public boolean IS_UserOwnedCommunities_TabWasSelected(){

            String Tabcolor = webDriver.findElement(UserCommunitiesTab).getCssValue("color");
            if (Tabcolor.equals("rgba(153, 204, 0, 1)")){
                return true;
            } else {
                Assert.fail("Owned Communities Tab was not selected!");
                return false;
            }
    }
    public boolean IS_UserSurveysTab_Was_Selected(){

        String TabColour = webDriver.findElement(UserSurveysTab).getCssValue("color");

        if (TabColour.equals("rgba(153, 204, 0, 1)")){
            return true;
        } else {
            Assert.fail("User Surveys Tab was not selected!");
            return false;
        }
    }
    public boolean IS_User_Was_Banned() {
        try {
            WaitVisabilityOfElement(UnbanUserButton);
            WebElement UserBannedPopUP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'User banned successfully')]")));
            return true;
        } catch (TimeoutException TimeOut){

            Assert.fail("User was not banned!");
            return false;
        }
    }
    public boolean IS_User_Was_Unbanned(){
        try {
            WaitVisabilityOfElement(BanUserButton);
            WebElement UserUnbannedText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'User unbanned successfully')]")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("User was not Unbanned!");
            return false;
        }
    }
    public boolean IS_GlobalNotification_Was_Sent(){
        try {
            WebElement NotificationWasSentPopUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Notification was sent successfully')]")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Notification was not sent!");
            return false;
        }
    }
}
