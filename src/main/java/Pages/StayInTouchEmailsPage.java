package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class StayInTouchEmailsPage extends BasePage {
    public StayInTouchEmailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy (xpath = "//span[contains(text(),'Stay In Touch Emails')]")
    WebElement StayInTouchEmailsTab;
    @FindBy (xpath = "//tbody/tr[1]/td[2]")
    WebElement StayInTouchEmail;
    @FindBy (xpath = "//span[contains(text(),'Delete')]")
    WebElement Deletebutton;
    By SubscribedTab = By.xpath("//h3[contains(text(),'Subscribed')]");
    By UnsubscribeTab = By.xpath("//h3[contains(text(),'Unsubscribed')]");


    public StayInTouchEmailsPage GotoStayInTouchEmailsTab(){
        WaitVisabilityOfElement(StayInTouchEmailsTab);
        StayInTouchEmailsTab.click();
        return this;
    }

    public StayInTouchEmailsPage GotoUnsubscribedTab(){
        WaitVisabilityOfElement(UnsubscribeTab);
        webDriver.findElement(UnsubscribeTab).click();
        return this;
    }
    public StayInTouchEmailsPage GotoSubscribedTab(){
        WaitVisabilityOfElement(SubscribedTab);
        webDriver.findElement(SubscribedTab).click();
        return this;
    }
    public StayInTouchEmailsPage OpenStayInTouchEmailInfo(){
        try {
            WaitVisabilityOfElement(StayInTouchEmail);
            StayInTouchEmail.click();
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any Stay in touch Email!");
        }
        return this;
    }

    public StayInTouchEmailsPage ClickOnDeleteButton() {
        try {
            WaitVisabilityOfElement(Deletebutton);
            List<WebElement> ListOfDeleteButtons = webDriver.findElements(By.xpath("//span[contains(text(),'Delete')]"));
            ListOfDeleteButtons.get(0).click();
        } catch (TimeoutException TimeOut) {
            Assert.fail("There is no any request to delete!");
        }
        return this;
    }


    public boolean IS_Subscribe_Tab_IS_Selected(){
        String color = webDriver.findElement(SubscribedTab).getCssValue("color");
        if(color.equals("rgba(153, 204, 0, 1)")){
            return true;
        } else {
            Assert.fail(" Subscribe tab is not Selected!");
            return false;
        }
    }

    public boolean IS_UnsucscribeTab_Was_Selected(){
        String color = webDriver.findElement(UnsubscribeTab).getCssValue("color");
        if (color.equals("rgba(153, 204, 0, 1)")){
            return true;
        } else {
            Assert.fail("Unsubscribe Tab is not Selected!");
            return false;
        }
    }

    public boolean IS_StayInTouchEmail_Was_Opened(){
        try {
            Boolean StayInTouchInfoText = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='ant-modal-title']"),"Get in Touch Email Info"));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Stay in Touch Info Was not opened!");
            return false;
        }
    }
    public boolean IS_Stay_In_Touch_Email_Was_Deleted(){
        try {
            WebElement User_Was_Deleted_PopUP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'User was deleted')]")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Stay in Touch Email was not Deleted!");
            return false;
        }
    }



}
