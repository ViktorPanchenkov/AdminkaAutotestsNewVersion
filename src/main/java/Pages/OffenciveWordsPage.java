package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class OffenciveWordsPage extends BasePage {
    public OffenciveWordsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy (xpath = "//span[contains(text(),'Offensive Words')]")
    WebElement OffensiveWardsTab;
    @FindBy (xpath = "//input[@type='text']")
    WebElement OffenciveWordsInput;
    @FindBy (xpath = "//span[contains(text(),'Add Offensive Word')]")
    WebElement AddOffenciveWordButton;
    @FindBy (xpath = "//span[@class='ant-tag c-tag']/span")
    WebElement DeleteWordButton;

    public OffenciveWordsPage GoToOffenciveWordsTab(){
        WaitVisabilityOfElement(OffensiveWardsTab);
        OffensiveWardsTab.click();
        return new OffenciveWordsPage(webDriver);
    }

    public OffenciveWordsPage EnterOffenciveWord(String Word){
        WaitVisabilityOfElement(OffenciveWordsInput);
        OffenciveWordsInput.sendKeys(Word);
        return this;
    }
    public OffenciveWordsPage ClcikOnAddOffensiveWordButton(){
        WaitVisabilityOfElement(AddOffenciveWordButton);
        AddOffenciveWordButton.click();
        return this;
    }
    public boolean DeleteWord(){
        try {
            WaitVisabilityOfElement(DeleteWordButton);
            List<WebElement> ListOFDeleteButtons = webDriver.findElements(By.xpath("//span[@class='ant-tag c-tag']/span"));
            ListOFDeleteButtons.get(0).click();

            try {
                wait.until(ExpectedConditions.invisibilityOf(ListOFDeleteButtons.get(0)));
                return true;
            } catch (TimeoutException TimeOut){
                return false;
            }
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any offencive word! ");
            return false;
        }


    }
    public boolean IS_Word_Was_Added(String Word){
        try {
            Boolean WordAddedPopUp = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(text(),'added successfully')]"), Word));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Word was not added!");
            return false;
        }
    }
}
