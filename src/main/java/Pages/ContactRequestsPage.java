package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ContactRequestsPage extends BasePage {
    public ContactRequestsPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy (xpath = "//span[contains(text(),'Contact Requests')]")
    WebElement ContactRequestTab;
    @FindBy (xpath = "//span[contains(text(),'Mark Solved')]")
    WebElement MarkSolvedButton;
    @FindBy (xpath = "//tbody/tr[1]/td[2]")
    WebElement ContactRequest;
    By SolvedTab = By.xpath("//h3[contains(text(),'Solved')]");
    By RequestedTab = By.xpath("//h3[contains(text(),'Requested')]");


    public ContactRequestsPage GotoContactRequestsTab(){
        WaitVisabilityOfElement(ContactRequestTab);
        ContactRequestTab.click();
        return new ContactRequestsPage(webDriver);
    }
    public ContactRequestsPage GotoSolvedTab(){
        WaitVisabilityOfElement(SolvedTab);
        webDriver.findElement(SolvedTab).click();
        return this;
    }
    public ContactRequestsPage GotoRequestedTab(){
        WaitVisabilityOfElement(RequestedTab);
        webDriver.findElement(RequestedTab).click();
        return this;
    }

    public ContactRequestsPage ClickOnMarkSolvedButton(){
        try {
            WaitVisabilityOfElement(MarkSolvedButton);
            List<WebElement> ListOfMarkedSolevedButton = webDriver.findElements(By.xpath("//span[contains(text(),'Mark Solved')]"));
            ListOfMarkedSolevedButton.get(0).click();
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any Request!");
        }

        return this;
    }
    public ContactRequestsPage OpenContactRequestInfo(){
        try {
            WaitVisabilityOfElement(ContactRequest);
            ContactRequest.click();
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any requests!");
        }

        return this;
    }

    public boolean IS_SolvedRequestsTab_Was_Selected(){
        String ColorOfTab = webDriver.findElement(SolvedTab).getCssValue("color");
        if (ColorOfTab.equals("rgba(153, 204, 0, 1)")){
            return true;
        } else {
            Assert.fail("Solved tab was not Selected!");
            return false;
        }
    }
    public boolean IS_RequestedTab_Was_Selected(){
        String ColorOfTab = webDriver.findElement(RequestedTab).getCssValue("color");
        if(ColorOfTab.equals("rgba(153, 204, 0, 1)")){
            return true;
        } else {
            Assert.fail("Requested tab was not Selected");
            return false;
        }
    }
    public boolean IS_Request_Was_Solved(){
        try {
            WebElement RequestMarkedSolvedPopUP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Request marked as solved successfully.')]")));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Request was not Solved!");
            return false;
        }
    }

    public boolean IS_Contact_Request_Info_Opened(){
        try {
            Boolean ContactRequestInfo = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='ant-modal-title']"),"Contact Request Info"));
            return true;
        } catch (TimeoutException TimeOut){
            Assert.fail("Contact Request Info was not opened!");
            return false;
        }
    }

}
