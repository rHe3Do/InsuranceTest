package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//div[contains(@class,'header_more_nav')]//*[contains(text(), 'Застраховать себя')]")
    WebElement InsSelect;

    @FindBy (xpath = "//a[contains (text(), 'Страхование путешественников')]")
    WebElement TravelInsBtn;

    @FindBy (xpath = "//IMG[contains(@src,'id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53')]")
    WebElement InsOnlainBtn;

    public void selectInsMenu() {
        btnWaitAndClick(InsSelect);
    }

    public void goToTravelIns(){
        btnWaitAndClick(TravelInsBtn);
    }

    public void goToInsOnlain(){
        btnWaitAndClick(InsOnlainBtn);
    }

    public void chkTitle(String title){
        Assert.assertEquals(title, driver.getTitle());
    }

}
