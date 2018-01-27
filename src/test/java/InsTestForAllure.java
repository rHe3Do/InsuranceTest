import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.BaseSteps;
import steps.DataSteps;
import steps.InsuranceSteps;
import steps.MainSteps;

import java.util.HashMap;

public class InsTestForAllure extends BaseSteps {

    MainSteps mainSteps = new MainSteps();
    InsuranceSteps insuranceSteps = new InsuranceSteps();
    DataSteps dataSteps = new DataSteps();


    HashMap<String, String> testData = new HashMap<>();

    @Test
    @Title("Страхование путешественников")
    public void insuranceTest(){

        testData.put("Фамилия застрахованного", "IVANOV");
        testData.put("Имя застрахованного", "IVAN");
        testData.put("Дата рождения застрахованного", "25.12.1996");
        testData.put("Фамилия страхователя", "Петров");
        testData.put("Имя страхователя", "Петр");
        testData.put("Отчество страхователя", "Петрович");
        testData.put("Дата рождения страхователя", "12.05.1999");
        testData.put("Серия паспорта", "3705");
        testData.put("Номер паспорта", "033791");
        testData.put("Дата выдачи паспорта", "18.04.2005");
        testData.put("Место выдачи паспорта", "Тестовый паспорт");

        mainSteps.selectInsMenu("Застраховать себя");
        mainSteps.selectTravelIns();
        mainSteps.chkTitleStep("Страхование путешественников");
        mainSteps.selectInsOnlainStep();

        mainSteps.swapToNextPage();

        insuranceSteps.selectMinStep();
        insuranceSteps.clickSaveBtnStep();
        dataSteps.fillFieldsStep(testData);
        insuranceSteps.selectSexStep("Женский");
        dataSteps.chkFieldsStep(testData);
        insuranceSteps.checkSexStep("Мужской");
        insuranceSteps.continueBtnClickStep();
        dataSteps.chkErrorMsgStep("Заполнены не все обязательные поля");

    }
}
