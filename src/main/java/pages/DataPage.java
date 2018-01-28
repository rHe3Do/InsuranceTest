package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class DataPage extends BasePage {

    public DataPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

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

    @FindBy (name = "passport_series")
    WebElement passportSeries;

    @FindBy (name = "passport_number")
    WebElement passportNumber;

    @FindBy (name = "issueDate")
    WebElement issueDate;

    @FindBy (name = "issuePlace")
    WebElement issuePlace;

    @FindBy (xpath = "//div[contains(text(), 'Заполнены')]")
    WebElement errorMsg;

    public void fillField(String element, String value){
        switch (element){
            case "Фамилия застрахованного":
                setFieldValue(insSurname, value);
                break;
            case "Имя застрахованного":
                setFieldValue(insName, value);
                break;
            case "Дата рождения застрахованного":
                setFieldValue(insBirthDate, value);
                break;
            case "Фамилия страхователя":
                setFieldValue(surname, value);
                break;
            case "Имя страхователя":
                setFieldValue(name, value);
                break;
            case "Отчество страхователя":
                setFieldValue(middlename, value);
                break;
            case "Дата рождения страхователя":
                setFieldValue(birthDate, value);
                break;
            case "Серия паспорта":
                setFieldValue(passportSeries, value);
                break;
            case "Номер паспорта":
                setFieldValue(passportNumber, value);
                break;
            case "Дата выдачи паспорта":
                setFieldValue(issueDate, value);
                break;
            case "Место выдачи паспорта":
                setFieldValue(issuePlace, value);
                break;
            default:
                throw new AssertionError("Поле '"+element+"' не объявлено на странице");
        }
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
            default:
                throw new AssertionError("Поле '"+element+"' не объявлено на странице");

        }
    }

    public void chkErrorMsg(String errorTxt){
        Assert.assertTrue(errorMsg.isDisplayed());
        Assert.assertTrue(errorMsg.getText().contains(errorTxt));
    }

}
