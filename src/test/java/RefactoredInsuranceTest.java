import org.junit.Test;
import pages.DataPage;
import pages.InsurancePage;
import pages.MainPage;

public class RefactoredInsuranceTest extends BaseTest{

    @Test
    public void insuranceTest(){
/* 1. Перейти на страницу http://www.sberbank.ru/ru/person */
        driver.get(baseUrl);
        MainPage mainPage = new MainPage();
        InsurancePage insPage = new InsurancePage();
        DataPage dataPage = new DataPage();
/* 2. Нажать на – Застраховать себя и имущество */
        mainPage.selectMenuItem("Застраховать себя");
/* 3. Выбрать – Страхование путешественников */
        mainPage.goToTravelIns();
/* 4. Проверить наличие на странице заголовка – Страхование путешественников */
        mainPage.chkTitle("«Сбербанк» - Страхование путешественников");
/* 5. Нажать на – Оформить Онлайн */
        mainPage.goToInsOnlain();
/* 6. На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная */
        mainPage.swapToNextPage();
        insPage.chooseMinSum();
/* 7. Нажать Оформить */
        insPage.clickSaveBtn();
/* 8. На вкладке Оформить заполнить поля:
 • Контактные данные не заполняем */
/*     • Фамилию и Имя, Дату рождения застрахованных */
        dataPage.fillField("Фамилия застрахованного", "IVANOV");
        dataPage.fillField("Имя застрахованного", "IVAN");
        dataPage.fillField("Дата рождения застрахованного", "25.12.1996");
/*     • Данные страхователя: Фамилия, Имя, Отчество, Дата рождения, Пол */
        dataPage.fillField("Фамилия страхователя", "Петров");
        dataPage.fillField("Имя страхователя", "Петр");
        dataPage.fillField("Отчество страхователя", "Петрович");
        dataPage.fillField("Дата рождения страхователя", "12.05.1999");
        insPage.selectSex("Мужской");
/*     • Паспортные данные */
        dataPage.fillField("Серия паспорта", "3705");
        dataPage.fillField("Номер паспорта", "033791");
        dataPage.fillField("Дата выдачи паспорта", "18.04.2005");
        dataPage.fillField("Место выдачи паспорта", "Тестовый паспорт");
/* 9.  Проверить, что все поля заполнены правильно */
        dataPage.chkFilledData("Фамилия застрахованного", "IVANOV");
        dataPage.chkFilledData("Имя застрахованного", "IVAN");
        dataPage.chkFilledData("Дата рождения застрахованного", "25.12.1996");
        dataPage.chkFilledData("Фамилия страхователя", "Петров");
        dataPage.chkFilledData("Имя страхователя", "Петр");
        dataPage.chkFilledData("Отчество страхователя", "Петрович");
        dataPage.chkFilledData("Дата рождения страхователя", "12.05.1999");
        insPage.chkSexField("Мужской");
        dataPage.chkFilledData("Серия паспорта", "3705");
        dataPage.chkFilledData("Номер паспорта", "033791");
        dataPage.chkFilledData("Дата выдачи паспорта", "18.04.2005");
        dataPage.chkFilledData("Место выдачи паспорта", "Тестовый паспорт");
/* 10. Нажать продолжить */
        insPage.continueBtnClick();
/* 11. Проверить, что появилось сообщение - Заполнены не все обязательные поля */
        dataPage.chkErrorMsg("Заполнены не все обязательные поля");
        
    }

}
