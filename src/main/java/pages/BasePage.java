package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class BasePage {

    public boolean isElementPresent(By by){
        try {
            BaseSteps.getDriver().findElement(by);
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public void setFieldValue(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }

    public void compareAttr(WebElement element, String value){
        Assert.assertEquals(value, element.getAttribute("value"));
    }

    public void btnWaitAndClick(WebElement element){
        WebDriverWait wait1 = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
        wait1.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void swapToNextPage(){
        String currentWindow = BaseSteps.getDriver().getWindowHandle();
        for (String window : BaseSteps.getDriver().getWindowHandles()) {
            if (!window.equals(currentWindow)) {
                BaseSteps.getDriver().switchTo().window(window);
            }
        }
    }
}
