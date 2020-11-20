package Pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver webDriver;
    protected WebDriverWait wait;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 5);
        PageFactory.initElements(webDriver, this);
    }

    public void WaitVisabilityOfElement(WebElement locator) {
        try {
            wait.until(ExpectedConditions.visibilityOf(locator));
        } catch (TimeoutException TimeOut){
            Assert.fail("Element is not displayed!");
        }
    }
    public void WaitVisabilityOfElement(By locator) {

            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public void ScrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,2000)","");
        //js.executeScript("alert('Hello World');");
    }
}