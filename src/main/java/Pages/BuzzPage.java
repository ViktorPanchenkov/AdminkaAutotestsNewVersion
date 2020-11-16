package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class BuzzPage extends BasePage {
    public BuzzPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy (xpath = "//span[contains(text(),'The Buzz')]")
    WebElement BuzzTub;
    @FindBy (xpath = "//input[@placeholder='Search...']")
    WebElement SearchFiled;
    @FindBy(xpath = "//*[@id=\"root\"]/section/section/main/div/div[2]/button")
    WebElement AddBuzzButton;
    @FindBy (xpath = "//input[@name='title']")
    WebElement Title;
    @FindBy (xpath = "//textarea[@name='description']")
    WebElement Description;
    @FindBy (xpath = "//div[contains(@class,'form-control-download')]/input[1]")
    WebElement PDFInput;
    @FindBy (xpath = "//input[@name='webURL']")
    WebElement URlFiled;
    @FindBy (xpath = "//div[contains(@class,'cropper-cmp')]//input")
    WebElement CoverImageButton;
    @FindBy (xpath = "//div[@class='category-header-cmp-control-btns-block']/button")
    WebElement SaveButton;

    public BuzzPage GotoBuzzTab(){
        WaitVisabilityOfElement(BuzzTub);
        BuzzTub.click();
        return  new BuzzPage(webDriver);
    }
    public BuzzPage SearchBuzz(String NameOFBuzz){
        WaitVisabilityOfElement(SearchFiled);
        SearchFiled.sendKeys(NameOFBuzz);
        return this;

    }


    public BuzzPage ClcikOnTheAddBuzzButton(){
        WaitVisabilityOfElement(AddBuzzButton);
        AddBuzzButton.click();
        return this;
    }
    public BuzzPage EnterTitle(String BuzzTitle){
        WaitVisabilityOfElement(Title);
        Title.clear();
        Title.sendKeys(BuzzTitle);
        return this;
    }
    public BuzzPage EnterDescription(String BuzzDescription){
        WaitVisabilityOfElement(Description);
        Description.clear();
        Description.sendKeys(BuzzDescription);
        return this;
    }
    public BuzzPage EnterURL(String URL){
        WaitVisabilityOfElement(URlFiled);
        URlFiled.sendKeys(URL);
        return this;
    }
    public BuzzPage ClcikOnSaveButton(){
        WaitVisabilityOfElement(SaveButton);
        SaveButton.click();
        return this;
    }
    public BuzzPage AddCoverImage(){
      CoverImageButton.sendKeys("/home/user/Desktop/гребля.jpg");
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-modal-content']")));
        if(popup.isDisplayed()){
            WebElement CroupButton =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-modal-footer']/button[2]")));
            CroupButton.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'preview-block f-s-sb')]")));
        }
      return this;
    }






}
