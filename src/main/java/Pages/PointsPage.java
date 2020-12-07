package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.Time;

public class PointsPage extends BasePage{
    public PointsPage(WebDriver webDriver) {
        super(webDriver);
    }
   @FindBy (xpath = "//span[contains(text(),'Points')]")
    WebElement PointsTab;
   public  @FindBy (xpath = "//input[@name='createCommunity']")
    WebElement CreateCommunityField;
    @FindBy (xpath = "//input[@name='createSurvey']")
    WebElement CreateSurveyField;
    @FindBy (xpath = "//div[@class='category-header-cmp-control-btns-block']/button")
    WebElement SaveChangesButton;
    @FindBy (xpath = "//*[@id=\"root\"]/section/section/main/div/form/div/div[1]/div[1]")
    WebElement HideCommunityActionCostSectionButton;
    @FindBy (xpath = "//*[@id=\"root\"]/section/section/main/div/form/div/div[2]/div[1]/span")
    WebElement HideSurveyActionCostSectionButton;



    public PointsPage GotoPointsTab(){
        WaitVisabilityOfElement(PointsTab);
        PointsTab.click();
        return new PointsPage(webDriver);
    }

    public PointsPage EnterSumToCreateCommunityInput(String Sum){
        WaitVisabilityOfElement(CreateCommunityField);
        CreateCommunityField.clear();
        CreateCommunityField.sendKeys(Sum);
        return this;
    }
    public PointsPage EnterSumToCreateSurveyInput(String Sum){
        WaitVisabilityOfElement(CreateSurveyField);
        CreateSurveyField.clear();
        CreateSurveyField.sendKeys(Sum);
        return this;
    }

    public PointsPage ClcikOnSaveChangesButton(){
        WaitVisabilityOfElement(SaveChangesButton);
        SaveChangesButton.click();
        return this;
    }
    public PointsPage ClcikOnHideCommunityActionSectionButton(){
        WaitVisabilityOfElement(HideCommunityActionCostSectionButton);
        HideCommunityActionCostSectionButton.click();
        return this;
    }

    public PointsPage ClcikOnHideSurveyActionCostSection(){
        WaitVisabilityOfElement(HideSurveyActionCostSectionButton);
        HideSurveyActionCostSectionButton.click();
        return this;
    }

    public boolean IS_UpdatedPopUP_Displayed(){
        try {
            WebElement UpdatedPopUP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Updated successfully')]")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Updated Pop up not displayed!");
            return false;
        }
    }
    public boolean IS_Create_Community_Cost_Was_Changed(String ExpectedSum){
        WaitVisabilityOfElement(CreateCommunityField);
        if(CreateCommunityField.getAttribute("value").equals(ExpectedSum)){
            return true;
        } else {
            Assert.fail("Sum was not changed!");
            return false;
        }
    }
    public boolean IS_CreateSurvey_CostWas_Changed(String ExpectedSum){
        WaitVisabilityOfElement(CreateSurveyField);
        if(CreateSurveyField.getAttribute("value").equals(ExpectedSum)){
            return true;
        } else {
            Assert.fail("Current sum not equal expected sum!");
            return false;

        }
    }
    public boolean IS_CommunityActionCostSection_Was_Hide(){
        try {
            wait.until(ExpectedConditions.invisibilityOf(CreateCommunityField));
           return true;
        } catch (TimeoutException TimeOut){
            Assert.fail(" Section Was not Hide!");
            return false;
        }
    }

    public boolean IS_Survey_Action_Cost_SectionWasHide(){
        try {
            wait.until(ExpectedConditions.invisibilityOf(CreateSurveyField));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Survey Action Cost Section was not Hide!");
            return false;
        }
    }


}
