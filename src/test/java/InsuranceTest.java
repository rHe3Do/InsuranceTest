import Pages.InsurancePage;
import Pages.MainPage;
import org.junit.Test;

public class InsuranceTest extends BaseTest{

    @Test
    public void insuranceTest(){
/** 1. Перейти на страницу http://www.sberbank.ru/ru/person */
        driver.get(baseUrl);
        MainPage mainPage = new MainPage(driver);
        InsurancePage insPage = new InsurancePage(driver);
/** 2. Нажать на – Застраховать себя и имущество */
        mainPage.selectInsMenu();
/** 3. Выбрать – Страхование путешественников */
        mainPage.goToTravelIns();
/** 4. Проверить наличие на странице заголовка – Страхование путешественников */
        mainPage.chkTitle("«Сбербанк» - Страхование путешественников");
/** 5. Нажать на – Оформить Онлайн */
        mainPage.goToInsOnlain();
/** 6. На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная */
        mainPage.swapToNextPage();
        insPage.chooseMinSum();
/** 7. Нажать Оформить */
        insPage.clickSaveBtn();
/** 8. На вкладке Оформить заполнить поля:
 • Контактные данные не заполняем */
/**     • Фамилию и Имя, Дату рождения застрахованных */
        insPage.fillInsuredData("IVANOV", "IVAN", "25.12.1996");
/**     • Данные страхователя: Фамилия, Имя, Отчество, Дата рождения, Пол */
        insPage.fillData("Петров", "Петр", "Петрович", "12.05.1999","Мужской");
/**     • Паспортные данные */
        insPage.fillPassportData("3705", "033791", "18.04.2005", "Тестовый паспорт");
/** 9.  Проверить, что все поля заполнены правильно */
        insPage.chkFilledData("Фамилия застрахованного", "IVANOV");
        insPage.chkFilledData("Имя застрахованного", "IVAN");
        insPage.chkFilledData("Дата рождения застрахованного", "25.12.1996");
        insPage.chkFilledData("Фамилия страхователя", "Петров");
        insPage.chkFilledData("Имя страхователя", "Петр");
        insPage.chkFilledData("Отчество страхователя", "Петрович");
        insPage.chkFilledData("Дата рождения страхователя", "12.05.1999");
        insPage.chkSexField("Мужской");
        insPage.chkFilledData("Серия паспорта", "3705");
        insPage.chkFilledData("Номер паспорта", "033791");
        insPage.chkFilledData("Дата выдачи паспорта", "18.04.2005");
        insPage.chkFilledData("Место выдачи паспорта", "Тестовый паспорт");
/** 10. Нажать продолжить */
        insPage.continueBtnClick();
/** 11. Проверить, что появилось сообщение - Заполнены не все обязательные поля */
        String errorTxt = "Заполнены не все обязательные поля";
        insPage.chkErrorMsg(errorTxt);
        
    }

}
