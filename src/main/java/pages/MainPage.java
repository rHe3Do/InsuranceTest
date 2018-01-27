package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//ul[@class=\"alt-menu-mid__list\"]")
    WebElement menuItems;

    @FindBy (xpath = "//a[contains (text(), 'Страхование путешественников')]")
    WebElement TravelInsBtn;

    @FindBy (xpath = "//IMG[contains(@src,'id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53')]")
    WebElement InsOnlainBtn;

    public void selectMenuItem(String itemName){
        btnWaitAndClick(menuItems.findElement(By.xpath("//ul[contains(@class, lt-menu-mid__list)]//" +
                "*[contains(text(), '"+itemName+"')]")));
    }

    public void goToTravelIns(){
        btnWaitAndClick(TravelInsBtn);
    }

    public void goToInsOnlain(){
        btnWaitAndClick(InsOnlainBtn);
    }

    public void chkTitle(String title){
        String actualTitle = driver.getTitle();
        Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualTitle, title),
                actualTitle.contains(title));
    }

}
