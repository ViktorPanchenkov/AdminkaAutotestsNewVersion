package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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


    public UserProfilePage TypeUserName(String UserName){
     WaitVisabilityOfElement(UserNameInput);
     UserNameInput.clear();
     UserNameInput.sendKeys(UserName);
     return this;
    }
    public UserProfilePage SelectGender(){
        WaitVisabilityOfElement(GenderSelection);
        GenderSelection.click();
       // WebElement ff = webDriver.findElement(By.cssSelector(".ant-select-item-option-active > .ant-select-item-option-content"));
       // ff.click();
        WebElement MaleSpan = webDriver.findElement(By.xpath("//span[contains(text(),'Female')]"));
        MaleSpan.click();
        return this;
    }

    @Override
    public void ScrollDown() {
        WaitVisabilityOfElement(UserNameInput);
        super.ScrollDown();
    }
}
