package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsurancePage extends BasePage {

    public InsurancePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//div[contains (text(), 'Минимальная')]")
    WebElement minSumBtn;

    @FindBy (xpath = "//span[contains(@ng-click, 'save')]")
    WebElement buyInsBtn;

    @FindBy (name = "insured0_surname")
    WebElement insSurname;

    @FindBy (name = "insured0_name")
    WebElement insName;

    @FindBy (name = "insured0_birthDate")
    WebElement insBirthDate;

    @FindBy (name = "surname")
    WebElement surname;

    @FindBy (name = "name")
    WebElement name;

    @FindBy (name="middlename")
    WebElement middlename;

    @FindBy (name = "birthDate")
    WebElement birthDate;

    @FindBy (name = "male")
    WebElement sexMale;

    @FindBy (name = "female")
    WebElement sexFemale;

    @FindBy (name = "passport_series")
    WebElement passportSeries;

    @FindBy (name = "passport_number")
    WebElement passportNumber;

    @FindBy (name = "issueDate")
    WebElement issueDate;

    @FindBy (name = "issuePlace")
    WebElement issuePlace;

    @FindBy (xpath = "//span[contains(text(), 'Продолжить')]")
    WebElement continueBtn;

    @FindBy (xpath = "//div[contains(text(), 'Заполнены')]")
    WebElement errorMsg;

    public void chooseMinSum(){
        btnWaitAndClick(minSumBtn);
    }

    public void clickSaveBtn() {
        btnWaitAndClick(buyInsBtn);
    }

    public void fillInsuredData(String surname, String name, String birthDate){
        fillField(insSurname, surname);
        fillField(insName, name);
        fillField(insBirthDate, birthDate);
    }

    public void fillData(String surnamein, String namein, String middlenamein, String birthDatein, String sex){
        fillField(surname, surnamein);
        fillField(name, namein);
        fillField(middlename, middlenamein);
        fillField(birthDate, birthDatein);
        switch (sex) {
            case "Мужской":
                sexMale.click();
                break;
            case "Женский":
                sexFemale.click();
                break;
        }
    }

    public void fillPassportData(String series, String number, String date, String place){
        fillField(passportSeries, series);
        fillField(passportNumber, number);
        fillField(issueDate, date);
        fillField(issuePlace, place);
    }

    public void chkFilledData(String element, String value){
        switch (element){
            case "Фамилия застрахованного":
                compareAttr(insSurname, value);
                break;
            case "Имя застрахованного":
                compareAttr(insName, value);
                break;
            case "Дата рождения застрахованного":
                compareAttr(insBirthDate, value);
                break;
            case "Фамилия страхователя":
                compareAttr(surname, value);
                break;
            case "Имя страхователя":
                compareAttr(name, value);
                break;
            case "Отчество страхователя":
                compareAttr(middlename, value);
                break;
            case "Дата рождения страхователя":
                compareAttr(birthDate, value);
                break;
            case "Серия паспорта":
                compareAttr(passportSeries, value);
                break;
            case "Номер паспорта":
                compareAttr(passportNumber, value);
                break;
            case "Дата выдачи паспорта":
                compareAttr(issueDate, value);
                break;
            case "Место выдачи паспорта":
                compareAttr(issuePlace, value);
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

    public void chkErrorMsg(String errorTxt){
        Assert.assertTrue(errorMsg.isDisplayed());
        Assert.assertEquals(errorMsg.getText(), errorTxt);
    }
}
