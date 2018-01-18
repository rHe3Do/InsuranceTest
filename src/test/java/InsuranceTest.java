import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class InsuranceTest {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        driver = new ChromeDriver();
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void insuranceTest() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
/** 1. Перейти на страницу http://www.sberbank.ru/ru/person */
        driver.get(baseUrl);
/** 2. Нажать на – Застраховать себя и имущество */
        driver.findElement(By.xpath("//div[contains(@class,'header_more_nav')]//" +
                "*[contains(text(), 'Застраховать себя')]")).click();

        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//div[contains(@class,'header_more_nav')]" +
                        "//a[contains (text(), 'Страхование путешественников')]"))));
/** 3. Выбрать – Страхование путешественников */
        driver.findElement(By.xpath("//a[contains (text(), 'Страхование путешественников')]")).click();
/** 4. Проверить наличие на странице заголовка – Страхование путешественников */
        Assert.assertEquals("«Сбербанк» - Страхование путешественников", driver.getTitle());
/** 5. Нажать на – Оформить Онлайн */
        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//IMG[contains(@src,'id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53')]")).click();
/** 6. На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная */
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
            }
        }
        driver.findElement(By.xpath("//div[contains (text(), 'Минимальная')]")).click();
/** 7. Нажать Оформить */
        driver.findElement(By.xpath("//span[contains(@ng-click, 'save')]")).click();
/** 8. На вкладке Оформить заполнить поля:
    • Контактные данные не заполняем */
/**     • Фамилию и Имя, Дату рождения застрахованных */
        fillField(By.name("insured0_surname"), "IVANOV");
        fillField(By.name("insured0_name"), "IVAN");
        fillField(By.name("insured0_birthDate"), "23.12.1995");
/**     • Данные страхователя: Фамилия, Имя, Отчество, Дата рождения, Пол */
        fillField(By.name("surname"), "Петров");
        fillField(By.name("name"), "Петр");
        fillField(By.name("middlename"), "Петрович");
        fillField(By.name("birthDate"), "24.10.1998");
/**    • Паспортные данные */
        fillField(By.name("passport_series"), "3705");
        fillField(By.name("passport_number"), "033791");
        fillField(By.name("issueDate"), "18.04.2005");
        fillField(By.name("issuePlace"), "Тестовый паспорт");
/** 9.  Проверить, что все поля заполнены правильно */
        Assert.assertTrue(fieldDataCompare(By.name("insured0_surname"), "value" , "IVANOV"));
        Assert.assertTrue(fieldDataCompare(By.name("insured0_name"), "value", "IVAN"));
        Assert.assertTrue(fieldDataCompare(By.name("insured0_birthDate"), "value", "23.12.1995"));
        Assert.assertTrue(fieldDataCompare(By.name("surname"), "value", "Петров"));
        Assert.assertTrue(fieldDataCompare(By.name("name"), "value",  "Петр"));
        Assert.assertTrue(fieldDataCompare(By.name("middlename"), "value",  "Петрович"));
        Assert.assertTrue(fieldDataCompare(By.name("birthDate"), "value",  "24.10.1998"));
        Assert.assertTrue(fieldDataCompare(By.name("passport_series"), "value",  "3705"));
        Assert.assertTrue(fieldDataCompare(By.name("passport_number"), "value",  "033791"));
        Assert.assertTrue(fieldDataCompare(By.name("issueDate"), "value",  "18.04.2005"));
        Assert.assertTrue(fieldDataCompare(By.name("issuePlace"), "value",  "Тестовый паспорт"));
/** 10. Нажать продолжить */
        driver.findElement(By.xpath("//span[contains(text(), 'Продолжить')]")).click();
/** 11. Проверить, что появилось сообщение - Заполнены не все обязательные поля */
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text()," +
                " 'Заполнены не все обязательные поля')]")).isDisplayed());
    }

    @After
    public void end(){
        driver.quit();
    }

    private void fillField(By find, String data){
        driver.findElement(find).sendKeys(data);
    }

    private boolean fieldDataCompare(By field, String attr, String data){
        return (driver.findElement(field).getAttribute(attr).equals(data));
    }
}
