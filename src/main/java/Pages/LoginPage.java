package Pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.*;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy (xpath = "//input[@name=\"username\"]")
    WebElement UserNameFiled;
    @FindBy(xpath = "//input[@name=\"password\"]")
    WebElement PasswordFiled;
    @FindBy (xpath = "//button[@type=\"submit\"]")
    WebElement LoginButton;
    @FindBy (xpath = "//a/span[2]")
    WebElement UserProfileButton;
    @FindBy (xpath = "//span[contains(text(),'Forgot Password?')]")
    WebElement ForgotPasswordButton;

    public LoginPage TypeUserName(String UserName){
        WaitVisabilityOfElement(UserNameFiled);
        UserNameFiled.sendKeys(UserName);
        return this;
    }
    public LoginPage TypePassword(String Password){
        WaitVisabilityOfElement(PasswordFiled);
        PasswordFiled.sendKeys(Password);
        return this;
    }
    public LoginPage ClcikOnTheLoginButton(){
        WaitVisabilityOfElement(LoginButton);
        LoginButton.click();
        return this;
    }
    public void GotoUserProfile(){
        WaitVisabilityOfElement(UserProfileButton);
        UserProfileButton.click();
    }
    public LoginPage GotoForgotPasswordScreen(){
        WaitVisabilityOfElement(ForgotPasswordButton);
        ForgotPasswordButton.click();
        return this;
    }


    public boolean IS_User_Loged_As_OctAdmin(){

        try {
          Boolean UserRole=  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class='label capitalize']"),"OCT Admin"));
          return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("User Role is not OCT Admin");
            return false;
        }

    }
    public boolean IS_User_Logged_As_OCT_Moderator(){
        try {
            Boolean UserRole=  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class='label capitalize']"),"OCT Moderator"));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("User role is not OCT Moderator!");
            return false;
        }
    }
    public boolean IS_User_Logged_As_ContentManager(){
        try {
            Boolean UserRole=  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class='label capitalize']"),"OCT Moderator"));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("User role is not a Content Manager");
            return false;
        }
    }

    public boolean IS_User_WAS_Not_Logged_With_Invalid_Creds(){
        try {

            wait.until(ExpectedConditions.visibilityOf(LoginButton));
            wait.until(ExpectedConditions.visibilityOf(UserNameFiled));
            Assert.fail("It is not possible to login with invalid creds!");
            return false;
        } catch (TimeoutException TimeOut){

            return true;
        }
    }
    public boolean IS_Login_By_Email_Sucsasfull(){
        try {
            wait.until(ExpectedConditions.visibilityOf(UserProfileButton));
            return true;
        } catch (TimeoutException Timeout){
            return false;
        }
    }
    public boolean IS_Forgot_Password_Screen_Opened(){
        try {
            WebElement ForgotYourPasswordText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Forgot your Password?')]")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Forgot Password Screen was not displayed!");
            return false;
        }
    }
}
