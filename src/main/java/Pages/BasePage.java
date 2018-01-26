package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver driver;

    public boolean isElementPresent(By by){
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public void fillField(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }

    public void compareAttr(WebElement element, String value){
        Assert.assertEquals(value, element.getAttribute("value"));
    }

    public void btnWaitAndClick(WebElement element){
        WebDriverWait wait1 = new WebDriverWait(driver, 5, 1000);
        wait1.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void swapToNextPage(){
        String currentWindow = driver.getWindowHandle();
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
            }
        }
    }
}
