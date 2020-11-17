package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.print.DocFlavor;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class SurveysPage extends BasePage {

    public SurveysPage(WebDriver webDriver) {
        super(webDriver);
    }


    @FindBy(xpath = "//span[contains(text(),'Surveys')]")
    WebElement SurveysTab;
    @FindBy (xpath = "//input[@placeholder='Search...']")
    WebElement SearchFiled;
    @FindBy (xpath = "//div[@class='search-block f-c-s']/button")
    WebElement AddOfficialSurveybutton;
    @FindBy (xpath = "//input[@name='title']")
    WebElement Title;
    @FindBy (xpath = "//textarea[@name='description']")
    WebElement Description;
    @FindBy (xpath = "//div[@class=' css-1hwfws3']")
    WebElement CategorySelection;
    @FindBy (xpath = "//span[contains(text(),'Create Survey')]")
    WebElement CreateSurveyButton;
    @FindBy (xpath = "//h3[contains(text(),'User Surveys')]")
    WebElement UserSurveysTab;
    @FindBy (xpath = "//span[contains(text(),'Back to Live')]")
    WebElement BackToLiveButton;
    @FindBy (xpath = "//span[contains(text(),'Complete Survey')]")
    WebElement CompleteSurveyButton;
    @FindBy (xpath = "//span[contains(text(),'Delete survey')]")
    WebElement DeleteSurveyButton;



    public SurveysPage GotoSurveysTab(){
        WaitVisabilityOfElement(SurveysTab);
        SurveysTab.click();
        return new SurveysPage(webDriver);
    }
    public SurveysPage SearchSurvey(String NameOFSurvey){
        WaitVisabilityOfElement(SearchFiled);
        SearchFiled.sendKeys(NameOFSurvey);
        try {
            WebElement FoundBuzz = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" +NameOFSurvey+"')]")));
            FoundBuzz.click();
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no Survey with such title!");
        }

        return this;

    }
    public SurveysPage ClickOnAddOffSurveyButton(){
        WaitVisabilityOfElement(AddOfficialSurveybutton);
        AddOfficialSurveybutton.click();
        return this;
    }
    public SurveysPage EnterTitle(String SurveyTitle){
        WaitVisabilityOfElement(Title);
        Title.sendKeys(SurveyTitle);
        return this;
    }
    public SurveysPage EnterDescription(String SurveyDescription){
        WaitVisabilityOfElement(Description);
        Description.sendKeys(SurveyDescription);
        return this;
    }
    public SurveysPage SelectCategory(int categoryNumber){
        WaitVisabilityOfElement(CategorySelection);
        CategorySelection.click();
        WebElement Category = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-2-option-" +categoryNumber+"']")));
        Category.click();
        return this;
    }
    public SurveysPage EnterFirstQuestion(String QuestionText){
        WebElement FirstQuestion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/section/section/main/div/form/div[2]/ol/li/div[2]/div/span[1]/input")));
        FirstQuestion.sendKeys(QuestionText);
        return this;
    }
    public SurveysPage EnterTextToAnswerOptions(String Answer1, String Answer2){

        WebElement AnswerOption1 = webDriver.findElement(By.xpath("//input[@name='questionDtoList[0].optionList[0].text']"));
        WebElement AnswerOption2 = webDriver.findElement(By.xpath("//input[@name='questionDtoList[0].optionList[1].text']"));
        AnswerOption1.sendKeys(Answer1);
        AnswerOption2.sendKeys(Answer2);
        return this;
    }
    public SurveysPage ClcikOnCreateSurveyButton(){
        WaitVisabilityOfElement(CreateSurveyButton);
        CreateSurveyButton.click();
        return this;
    }
    public SurveysPage GotoUsersSurveysTab(){
        WaitVisabilityOfElement(UserSurveysTab);
        UserSurveysTab.click();
        return this;
    }
    public SurveysPage GotoCompletedSurvey(){
        try {
            WebElement SurveyWithCompletedStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Completed')]")));
            List<WebElement> ListOfCompletedSurvey = webDriver.findElements(By.xpath("//span[contains(text(),'Completed')]"));
            ListOfCompletedSurvey.get(0).click();
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any completed survey!");
        }
        return this;

    }
    public SurveysPage GotoToLiveSurvey(){
        try {
            WebElement LiveSurvey = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Live')]")));
            List<WebElement> ListOfLiveSurveys = webDriver.findElements(By.xpath("//span[contains(text(),'Live')]"));
            ListOfLiveSurveys.get(0).click();
        } catch (TimeoutException TimeOut){
            Assert.fail("There is No Any Live Survey!");
        }
        return this;
    }
    public SurveysPage ClcikonTheCompleteSurveyButton(){
        WaitVisabilityOfElement(CompleteSurveyButton);
        CompleteSurveyButton.click();
        WebElement completeConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Complete!')]")));
        completeConfirmation.click();
        return this;
    }
    public SurveysPage ClcikOnBackToLiveButton(){
        WaitVisabilityOfElement(BackToLiveButton);
        BackToLiveButton.click();
        WebElement ReoPenButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Re-open!')]")));
        ReoPenButton.click();
        return this;
    }
    public SurveysPage ClcikOnDeleteSurveyButton(){
        WaitVisabilityOfElement(DeleteSurveyButton);
        DeleteSurveyButton.click();
        WebElement DeleteConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Yes, Delete it!')]")));
        DeleteConfirmation.click();
        return this;
    }

    public boolean IS_Survey_Was_Found(String nameOfSurvey){
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2"),nameOfSurvey));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("There is not survey with such name!");
            return false;
        }
    }
    public boolean IS_Survey_Was_Created(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Your survey was cuccessfully created!')]")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Survey was not Created!");
            return false;
        }
    }
    public boolean IS_SurveyWas_ReturnedToFive(){
        try {
            WebElement StatusUpdatedText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Status updated successfully')]")));
            WebElement LiveStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Live')]")));
            WaitVisabilityOfElement(CompleteSurveyButton);
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Survey is not in Live!");
            return  false;
        }
    }
    public boolean IS_Survey_Was_Completed(){
        try {
            WebElement StatusUpdatedText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Status updated successfully')]")));
            WebElement LiveStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Completed')]")));
            WaitVisabilityOfElement(BackToLiveButton);
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Survey Was not completed!");
            return false;
        }
    }
    public boolean IS_SurveyDeleted(){
        try {
         WebElement DeleteSuccsesText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Survey removed successfully')]")));
         return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Survey was not deleted!");
            return false;
        }
    }
}
