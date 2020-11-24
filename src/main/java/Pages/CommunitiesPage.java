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

public class CommunitiesPage extends BasePage {
    public CommunitiesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//span[contains(text(),'Communities')]")
    WebElement CommunitiesTab;
    @FindBy(xpath = "//input[@placeholder='Search...']")
    WebElement SearchFiled;
    @FindBy(xpath = "//span[contains(text(),'Add community')]")
    WebElement AddCommunitybutton;
    @FindBy(xpath = "//input[@name='title']")
    WebElement Title;
    @FindBy(xpath = "//textarea[@name='description']")
    WebElement Description;
    @FindBy(xpath = "//div[@class=' css-1hwfws3']")
    WebElement CategorySelection;
    @FindBy(xpath = "//div[contains(@class,'cropper-cmp')]//input")
    WebElement ImageInput;
    @FindBy(xpath = "//span[contains(text(),'Create Community')]")
    WebElement CreateCommuntyButton;
    @FindBy(xpath = "//tr[1]//td[2]")
    WebElement CommunityFromList;
     By FollowersTab = By.xpath("//div[@class='category-header-cmp-tabs f-c-s']/h3[2]");
    By ModeratorsTab = By.xpath("//h3[contains(text(),'Moderators')]");
     By InactivnewsTab = By.xpath("//h3[contains(text(),'Inactive News')]");
     By ActiveNewsTab = By.xpath("//h3[contains(text(),'Active News')]");
     @FindBy (xpath = "//span[contains(text(),'Create News')]")
     WebElement CreateNewsButton;
     @FindBy (xpath = "//span[contains(text(),'Delete News')]")
     WebElement DeleteNewsButton;
     @FindBy (xpath = "//span[contains(text(),'block Community')]")
     WebElement BlockCommunityButton;
     @FindBy (xpath = "//span[contains(text(),'unblock Community')]")
     WebElement UnblockCommunityButton;
     @FindBy (xpath = "//span[contains(text(),'Edit Community')]")
     WebElement EditCommunityButton;
     @FindBy (xpath = "//button[@name='surveyAutoReview']")
     WebElement AutomaticAprovalOfSurveysButton;
     @FindBy (xpath = "//span[contains(text(),'Update Community')]")
     WebElement UpdateCommunityButton;


    public CommunitiesPage GotoComunitiesTab() {
        WaitVisabilityOfElement(CommunitiesTab);
        CommunitiesTab.click();
        return new CommunitiesPage(webDriver);
    }

    public CommunitiesPage SearchCommunity(String NameOFCommunity) {
        WaitVisabilityOfElement(SearchFiled);
        SearchFiled.sendKeys(NameOFCommunity);
        try {
            WebElement FoundSurvey = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + NameOFCommunity + "')]")));
            FoundSurvey.click();
        } catch (TimeoutException TimeOut) {
            Assert.fail("There is no Survey with such title!");
        }
        return this;
    }

    public CommunitiesPage ClcikOnAddCommunityButton() {
        WaitVisabilityOfElement(AddCommunitybutton);
        AddCommunitybutton.click();
        return this;
    }

    public CommunitiesPage EnterTitle(String CommunityTitle) {
        WaitVisabilityOfElement(Title);
        Title.clear();
        Title.sendKeys(CommunityTitle);
        return this;
    }

    public CommunitiesPage EnterDescription(String CommunityDescription) {
        WaitVisabilityOfElement(Description);
        Description.clear();
        Description.sendKeys(CommunityDescription);
        return this;
    }

    public CommunitiesPage SelectCategory(int categoryNumber) {
        WaitVisabilityOfElement(CategorySelection);
        CategorySelection.click();
        WebElement Category = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-2-option-" + categoryNumber + "']")));
        Category.click();
        return this;
    }

    public CommunitiesPage AddImage() {

        ImageInput.sendKeys("/home/user/Desktop/гребля.jpg");
        WebElement CropButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Crop')]")));
        CropButton.click();
        WebElement AddedImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='w100']/img")));
        return this;
    }

    public CommunitiesPage GotoCommunityFromList( int numberofCommunity) {
        WaitVisabilityOfElement(CommunityFromList);
        List<WebElement> ListOfCommunities = new ArrayList<WebElement>();
        for (int i = 1; i < 10; i++) {
            WebElement Community = webDriver.findElement(By.xpath("//tr[" + i + "]//td[2]"));
            ListOfCommunities.add(Community);
        }
        ListOfCommunities.get(numberofCommunity).click();
        return this;
    }
    public CommunitiesPage GotoFollowersTab(){
       WaitVisabilityOfElement(FollowersTab);
       webDriver.findElement(FollowersTab).click();


       return this;
    }
    public CommunitiesPage GotoModeratorsTab(){
      WaitVisabilityOfElement(ModeratorsTab);
      webDriver.findElement(ModeratorsTab).click();
      return this;
    }
    public CommunitiesPage ClcikOnDeleteNewsButton(){
       WaitVisabilityOfElement(DeleteNewsButton);
        DeleteNewsButton.click();
       WebElement DeleteConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-modal-footer']/button[2]")));
       DeleteConfirmation.click();
       return this;

    }
    public CommunitiesPage ClcikOnCreateNewsButton(){
        WaitVisabilityOfElement(CreateNewsButton);
        CreateNewsButton.click();
        return this;
    }
    public CommunitiesPage ClcikOnBlockCommunityButton(){

            WaitVisabilityOfElement(BlockCommunityButton);
            System.out.println(BlockCommunityButton.getText());
            if (BlockCommunityButton.getText().equals("BLOCK COMMUNITY")){
                BlockCommunityButton.click();
                WebElement BlockConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-modal-footer']/button[2]")));
                BlockConfirmation.click();
            } else {
                Assert.fail("Commnunity already blocked!");
            }
        return this;
    }



    public CommunitiesPage ClcikOnCreateCommunitybutton(){
        WaitVisabilityOfElement(CreateCommuntyButton);
        CreateCommuntyButton.click();
        return this;
    }

    public boolean InactiveNews(){
        try {
            WebElement InactiveNewsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Inactive')]")));
            List<WebElement> ListOFActiveNews = webDriver.findElements(By.xpath("//span[contains(text(),'Inactive')]"));
            ListOFActiveNews.get(0).click();

            try {
                wait.until(ExpectedConditions.invisibilityOf(ListOFActiveNews.get(0)));
                WebElement UpdatedText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'News updated successfully.')]")));
                return true;
            } catch (TimeoutException TimeOut){
                Assert.fail("News was not marked Inactive!");
                return false;
            }
        } catch (TimeoutException TimeOut){
            Assert.fail("In this community no any Active news!");
            return false;
        }


    }
    public boolean ActivateNews(){
        try {
            WebElement ActiveNewsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Active')]")));
            List<WebElement> ListOfActivebutton = webDriver.findElements(By.xpath("//span[contains(text(),'Active')]"));
            ListOfActivebutton.get(0).click();

            try {
                wait.until(ExpectedConditions.invisibilityOf(ListOfActivebutton.get(0)));
                WebElement UpdatedText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'News updated successfully.')]")));
                return true;
            } catch (TimeoutException Timeout){
                Assert.fail("News was not Activated!");
                return false;
            }

        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any Inactive news!");
            return false;
        }
    }

    public CommunitiesPage GotoActiveNewsTab(){
        WaitVisabilityOfElement(ActiveNewsTab);
        webDriver.findElement(ActiveNewsTab).click();
        return this;
    }
    public  CommunitiesPage GotoInactiveNewsTab(){
        WaitVisabilityOfElement(InactivnewsTab);
        webDriver.findElement(InactivnewsTab).click();
        return this;
    }
    public CommunitiesPage ClcikOnUnblockCommunityButton(){

            WaitVisabilityOfElement(UnblockCommunityButton);
        if(UnblockCommunityButton.getText().equals("UNBLOCK COMMUNITY")){
            UnblockCommunityButton.click();
            WebElement UnblockConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-modal-footer']/button[2]")));
           UnblockConfirmation.click();
        } else {
            Assert.fail("Community was not blocked!");
        }
        return this;
    }
    public CommunitiesPage GotoInactiveNews(){
        try {
            WebElement InactiveNews = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[2]")));
            InactiveNews.click();
        } catch (TimeoutException TimeOut){
            Assert.fail("In this community no any Inactive news!");
        }
        return this;

    }
    public CommunitiesPage ClcikOnEditButton(){
        try {
            WaitVisabilityOfElement(EditCommunityButton);
            EditCommunityButton.click();
        } catch (TimeoutException TimeOut){
            Assert.fail("Edit community button was not dispalyed!");

        }

        return this;
    }

    public CommunitiesPage ClikonTheAutomaticApprovalButton(){
        WaitVisabilityOfElement(AutomaticAprovalOfSurveysButton);
        AutomaticAprovalOfSurveysButton.click();
        return this;
    }
    public CommunitiesPage ClickOnUpdateCommunityButton(){
        WaitVisabilityOfElement(UpdateCommunityButton);
        UpdateCommunityButton.click();
        return this;
    }
    public boolean IS_Community_Was_Found(String nameOfCommunity){
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2"),nameOfCommunity));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("There is not community with such name!");
            return false;
        }
    }
    public boolean IS_Community_Was_Created(){
        try {
            WebElement CommunityCreatedText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Community created successfully.')]")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Community was not created!");
            return false;
        }
    }
    public boolean IS_ListOfUsers_Displayed(){
        try {
         WebElement User = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[2]")));

         return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Users in the List are not displayed!");
            return false;
        }
    }
    public boolean IS_News_Was_Created(){
        try {
            WebElement NewCreatedPopUP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'News created successfully.')]")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("News Was not Created!");
            return false;
        }
    }
    public boolean IS_News_Deleted(){
        try {
            WebElement NewsDeletedPopUP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'News deleted successfully.')]")));
            return true;
        }catch (TimeoutException TimeOut){
            Assert.fail("News was not Deleted!");
            return false;
        }
    }
    public boolean IS_CommunityWas_Blocked(){
       WaitVisabilityOfElement(BlockCommunityButton);
       if(BlockCommunityButton.getText().equals("UNBLOCK COMMUNITY")){
           return true;
       } else {
           Assert.fail("Community was not blocked!");
           return false;
       }
    }
    public boolean IS_Community_Was_Unblocked(){
        WaitVisabilityOfElement(BlockCommunityButton);
        if(BlockCommunityButton.getText().equals("BLOCK COMMUNITY")){
            return true;
        } else {
            Assert.fail("Community was not blocked!");
            return false;
        }

    }
    public boolean IS_Community_Was_Updated(){
        try {
            WebElement CommnityUpdatedText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Community saved successfully.')]")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Community was not Updated!");
            return false;
        }
    }
}
