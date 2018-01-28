package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class InsurancePage extends BasePage {

    public InsurancePage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy (xpath = "//div[contains (text(), 'Минимальная')]")
    WebElement minSumBtn;

    @FindBy (xpath = "//span[contains(@ng-click, 'save')]")
    WebElement buyInsBtn;

    @FindBy (name = "male")
    WebElement sexMale;

    @FindBy (name = "female")
    WebElement sexFemale;

    @FindBy (xpath = "//span[contains(text(), 'Продолжить')]")
    WebElement continueBtn;

    public void chooseMinSum(){
        btnWaitAndClick(minSumBtn);
    }

    public void clickSaveBtn() {
        btnWaitAndClick(buyInsBtn);
    }

    public void selectSex(String sex){
        switch (sex) {
            case "Мужской":
                sexMale.click();
                break;
            case "Женский":
                sexFemale.click();
                break;
        }
    }

    public void chkSexField(String sex) {
        switch (sex) {
            case "Мужской":
                Assert.assertTrue(isElementPresent((By.xpath("//span[contains(@class, " +
                    "'b-radio-field b-checked-radio-field')]/input[@name = 'male']"))));
                break;
            case "Женский":
                Assert.assertTrue(isElementPresent((By.xpath("//span[contains(@class, " +
                    "'b-radio-field b-checked-radio-field')]/input[@name = 'female']"))));
                break;
        }
    }

    public void continueBtnClick(){
        continueBtn.click();
    }

}
