package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StayInTouchEmailsPage extends BasePage {
    public StayInTouchEmailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy (xpath = "//span[contains(text(),'Stay In Touch Emails')]")
    WebElement StayInTouchEmailsTab;
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



}
