package Pages;

import org.junit.Assert;
import org.junit.runner.OrderWith;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CategoriesPage extends BasePage {
    public CategoriesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy (xpath = "//span[contains(text(),'Categories')]")
    WebElement CategoriesTab;
    @FindBy (xpath = "//span[contains(text(),'Add New Category')]")
    WebElement AddCategoryButton;
    @FindBy (xpath = "//input[@name='categoryName']")
    WebElement TitleInput;
    @FindBy (xpath = "//span[contains(text(),'Create Category')]")
    WebElement CreateCategoryButton;
    @FindBy (xpath = "//span[contains(text(),'Delete')]")
    WebElement DeleteCategoryButton;
    @FindBy (xpath = "//span[contains(text(),'Edit')]")
    WebElement EditCategoryButton;
    @FindBy (xpath = "//div[@class='ant-modal-footer']/button[2]")
    WebElement UpdateCategoryButton;
    By CoverImageInput = By.xpath("//div[contains(@class,'ant-modal-body')]//div[2]//div[1]//div[1]//div[1]//div[2]//input[1]");
    By CategoryIconInput = By.xpath("//div//div[3]//div[1]//div[1]//div[1]//div[2]//input[1]");



    public CategoriesPage GotoGategoriesTab(){
        WaitVisabilityOfElement(CategoriesTab);
        CategoriesTab.click();
        return new CategoriesPage(webDriver);
    }
    @Override
    public void ScrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WaitVisabilityOfElement(AddCategoryButton);
        js.executeScript("window.scrollBy(0,2000)","");
        js.executeScript("alert('Hello World');");
    }


    public CategoriesPage ClickOnAddCategoryButton(){
        WaitVisabilityOfElement(AddCategoryButton);
        AddCategoryButton.click();
        return this;
    }
    public CategoriesPage EnterTitle(String Title){
        WaitVisabilityOfElement(TitleInput);
        TitleInput.clear();
        TitleInput.sendKeys(Title);
        return this;
    }
    public  CategoriesPage AddCoverImage(){

       webDriver.findElement(CoverImageInput).sendKeys("/home/user/Desktop/гребля.jpg");
        WebElement PopUP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-modal-content']")));
            WebElement CroupButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]")));
            CroupButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'preview-block f-s-sb')]//img")));
        return this;
    }
    public CategoriesPage AddCategoryIcon(){
        webDriver.findElement(CategoryIconInput).sendKeys("/home/user/Desktop/гребля.jpg");
        WebElement PopUP2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-modal-content']")));
        if(PopUP2.isDisplayed()){

            WebElement CroupButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div[3]/button[2]")));
            CroupButton.click();
        }
        WebElement img2 =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div[3]/div/div/div[2]/div")));
        return this;
    }
    public CategoriesPage ClickOnEditCategoryButton(){
        WaitVisabilityOfElement(EditCategoryButton);
        List<WebElement> ListOfEditbuttons = webDriver.findElements(By.xpath("//span[contains(text(),'Edit')]"));
        ListOfEditbuttons.get(1).click();
        return this;

    }
    public CategoriesPage ClcikOnDeleteCategoryButton(int numberofCategory){
        try {
            WaitVisabilityOfElement(DeleteCategoryButton);
            List<WebElement> ListOfDeleteButtons = webDriver.findElements(By.xpath("//span[contains(text(),'Delete')]"));
            ListOfDeleteButtons.get(numberofCategory).click();
            WebElement DeleteConfirmationButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-modal-footer']/button[2]")));
            DeleteConfirmationButton.click();
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any displayed delete button!");
        }

        return this;
    }

    public CategoriesPage ClcikOnTheCreateCategoryButton(){
        WaitVisabilityOfElement(CreateCategoryButton);
        CreateCategoryButton.click();
        return this;
    }
    public CategoriesPage ClcikOnUpdateCategoryButton(){
        WaitVisabilityOfElement(UpdateCategoryButton);
        UpdateCategoryButton.click();
        return this;
    }

    public boolean IS_Category_Created(){
        try {
            WebElement CategoryCreatedText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Category created successfully')]")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Category Was not Created!");
            return false;
        }
    }

    public boolean IS_CategoryUpdated(){
        try {
            WebElement CategoryUpdatedPopUP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Category updated successfully')]")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Category was not updated!");
            return false;
        }
    }

    public boolean IS_Category_Deleted(){
        try {
            WebElement CategoryDeletedPopUP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Category deleted successfully')]")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Category Was not deleted!");
            return false;
        }
    }
}
