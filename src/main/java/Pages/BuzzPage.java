package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

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
    @FindBy (xpath = "//span[contains(text(),'Delete The Buzz')]")
    WebElement DeleteBuzzButton;
    @FindBy (xpath = "//span[contains(text(),'Edit The Buzz')]")
    WebElement EditBuzzButton;
    @FindBy (xpath = "//div[contains(@class,'form-control-download')]/input[1]")
    WebElement PDFFileInput;


    public BuzzPage GotoBuzzTab(){
        WaitVisabilityOfElement(BuzzTub);
        BuzzTub.click();
        return  new BuzzPage(webDriver);
    }
    public BuzzPage SearchBuzz(String NameOFBuzz){
        WaitVisabilityOfElement(SearchFiled);
        SearchFiled.sendKeys(NameOFBuzz);
        try {
            WebElement FoundBuzz = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" +NameOFBuzz+"')]")));
            FoundBuzz.click();
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no Buzz with such name!");
        }

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
    public BuzzPage ClcikOnTheDeleteBuzzButton(){
        WaitVisabilityOfElement(DeleteBuzzButton);
        DeleteBuzzButton.click();
        WebElement DeleteConfirmationButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Yes, Delete it!')]")));
        DeleteConfirmationButton.click();
        return  this;

    }
    public BuzzPage AddPDFFile(){
        WaitVisabilityOfElement(PDFFileInput);
        PDFFileInput.sendKeys("/home/user/Downloads/Wireframing (4).pdf");
        WebElement AddedPDF = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'pdf.pdf')]")));
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
    public BuzzPage GoToRandomBuzz() {
        int Random = (int) (Math.random() * 10);
        WaitVisabilityOfElement(AddBuzzButton);
        List<WebElement> ListOfBuzzes = new ArrayList<WebElement>();
        System.out.println(Random);
        for (int i = 1; i < 10; i++) {
            ListOfBuzzes.add(webDriver.findElement(By.xpath("//tr[" + i + "]//td[2]")));

        }
        ListOfBuzzes.get(Random).click();
        return this;
    }
    public BuzzPage GotoEditBuzzScreen(){
        WaitVisabilityOfElement(EditBuzzButton);
        EditBuzzButton.click();
        return this;
    }

    public boolean IS_Buzz_was_Found(String nameOfBuzz){
        try {
            WaitVisabilityOfElement(DeleteBuzzButton);
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2"),nameOfBuzz));

            return true;

        } catch (TimeoutException TimeOut){
            Assert.fail("Buzz was not Found!");
            return false;

        }
    }
    public boolean IS_Buzz_Was_Created(String nameOfBuzz,String buzzDescription){
        try {
            WebElement BuzzCreatedText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Buzz created successfully')]")));
            SearchBuzz(nameOfBuzz);
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(text(),'" + buzzDescription+"')]"),buzzDescription));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Buzz was not Created!");
            return false;
        }
    }

    public boolean IS_Buzz_Updated(String BuzzTitle,String BuzzDescription){
        try {
            WebElement BuzzEditedText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Buzz edited successfully')]")));
           wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2"),BuzzTitle));

            return true;
        } catch (Exception Exp){
            Assert.fail("Buzz was not updated!");
            return false;
        }
    }

    public boolean IS_Buzz_was_Removed(){
        try {
           WebElement BuzzRemovedText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Buzz removed successfully')]")));
           return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Buzz was not Removed!");
            return false;
        }
    }







}
