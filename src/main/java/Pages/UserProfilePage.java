package Pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.Time;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class UserProfilePage extends BasePage {
    public UserProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy (xpath = "//input[@name='username']")
    WebElement UserNameInput;
    @FindBy (xpath = "//*[@id=\"root\"]/section/section/main/div/div[2]/form/div[6]/div/div/div/span[2]")
    WebElement GenderSelection;
    @FindBy (xpath = "//span[contains(text(),'Save Changes')]")
    WebElement SaveButton;
    @FindBy (xpath = "//input[@name='email']")
    WebElement EmailInput;
    @FindBy (xpath = "//input[@name='yearOfBirth']")
    WebElement BirthDateInput;
    @FindBy (xpath = "//input[@name='zipcode']")
    WebElement ZipCodeFiled;
    @FindBy (xpath = "//h3[contains(text(),'Change Password')]")
    WebElement ChangePasswordTab;
    @FindBy (xpath = "//span[contains(text(),'Change Password')]")
    WebElement ChangePasswordButton;


    public UserProfilePage TypeUserName(String UserName){
     WaitVisabilityOfElement(UserNameInput);
     UserNameInput.clear();
     UserNameInput.sendKeys(UserName);
     return this;
    }
    public UserProfilePage SelectGender(){
        int Random = (int) (Math.random() *10);
        WaitVisabilityOfElement(GenderSelection);
        GenderSelection.click();
       // WebElement ff = webDriver.findElement(By.cssSelector(".ant-select-item-option-active > .ant-select-item-option-content"));
       // ff.click();
        WebElement FeMaleSpan = webDriver.findElement(By.xpath("//span[contains(text(),'Female')]"));
      //  WebElement MaleSpan = webDriver.findElement(By.xpath("//span[contains(text(),'Male')]"));
            FeMaleSpan.click();
        return this;
    }

    public UserProfilePage EnterEmail(String Email){
        WaitVisabilityOfElement(EmailInput);
        EmailInput.clear();
        EmailInput.sendKeys(Email);
        return this;
    }
    public UserProfilePage ClcikOnTheSaveButton(){
        WaitVisabilityOfElement(SaveButton);
        SaveButton.click();
        return this;
    }

    public UserProfilePage SelectBirthDate(){
        int Random = (int) (Math.random() *10);
        WaitVisabilityOfElement(BirthDateInput);
        BirthDateInput.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-picker-cell-inner']")));
        List<WebElement> ListOfYears = webDriver.findElements(By.xpath("//div[@class='ant-picker-cell-inner']"));
        ListOfYears.get(Random).click();
        return this;
    }
    public UserProfilePage GotoChangePasswordTab(){
        WaitVisabilityOfElement(ChangePasswordTab);
        ChangePasswordTab.click();
        return this;
    }
    public UserProfilePage EnterOldPassword(String OldPassword){
        WebElement OldPasswordFiled = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='oldPassword']")));
        OldPasswordFiled.sendKeys(OldPassword);
        return this;
    }

    public UserProfilePage EnterNewPassword(String NewPassword){
        WebElement NewPasswordFiled = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='newPassword']")));
        NewPasswordFiled.sendKeys(NewPassword);
        return this;
    }
    public UserProfilePage EnterConfirmPassword(String ConfirmPassword){
        WebElement ConfirmPasswordFiled = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='confirmPassword']")));
        ConfirmPasswordFiled.sendKeys(ConfirmPassword);
        return this;
    }
    public UserProfilePage ShowEnteredPasswords(){
       // WebElement ShowPasswordButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("ant-input-suffix")));
        List<WebElement> ListOfShowPasswordButtons = webDriver.findElements(By.xpath("//span[@class='ant-input-suffix']"));
        for(int i =0; i<ListOfShowPasswordButtons.size(); i++){
            ListOfShowPasswordButtons.get(i).click();
        }
        return this;
    }
    public UserProfilePage ClcikOnChangePasswordButton(){
        WaitVisabilityOfElement(ChangePasswordButton);
        ChangePasswordButton.click();
        return this;
    }

    public UserProfilePage EnterZipCode(String ZIPCode){
        WaitVisabilityOfElement(ZipCodeFiled);
        ZipCodeFiled.clear();
        ZipCodeFiled.sendKeys(ZIPCode);
        return this;
    }


    public boolean IS_UserName_Was_Changed(String Username){
        try {
            WebElement ProfileUpdatedPopUP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Profile updated successfully')]")));
            Assert.assertEquals(UserNameInput.getAttribute("value"), Username);
            return true;

        } catch (TimeoutException TimeOut){
            Assert.fail("Profile was not updated!");
            return false;
        }
    }

    public boolean IS_Email_Was_Changed(String Email){
       try {
           WebElement ProfileUpdatedPopUP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Profile updated successfully')]")));
           Assert.assertEquals(EmailInput.getAttribute("value"),Email);
           return true;
       } catch (Exception Exp){
           Assert.fail("Email was not Changed!");
           return false;
       }
    }
    public boolean IS_ProfileWasUpdated(){
        try {
            WebElement ProfileUpdatedPopUP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Profile updated successfully')]")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Profile was not updated!");
            return false;
        }
    }
    public boolean IS_BirthDate_Displayed(){
        WaitVisabilityOfElement(BirthDateInput);
        if (BirthDateInput.getAttribute("value")!= null){
            return true;
        } else {
            return false;
        }
    }
    public boolean IS_ZipCode_Entered(String ZipCode){
        WaitVisabilityOfElement(ZipCodeFiled);
        if (ZipCodeFiled.getAttribute("value").equals(ZipCode)){
            return true;
        } else {
            Assert.fail("Zip code was not changed!");
            return false;
        }
    }

    public boolean IS_Password_Was_Changed(){
        try {
            WebElement PasswordChangedPop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'The password is changed')]")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Password was not changed!");
            return false;
        }
    }

    @Override
    public void ScrollDown() {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(SaveButton).build().perform();
       // JavascriptExecutor js = (JavascriptExecutor) webDriver;
      //  js.executeScript("window.scrollBy(0,200)");
      //  js.executeScript("alert('Hello')");

    }
}
