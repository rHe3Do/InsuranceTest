package steps;

import cucumber.api.DataTable;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;

public class ScenarioSteps {

    BaseSteps baseSteps = new BaseSteps();
    MainSteps mainSteps = new MainSteps();
    InsuranceSteps insuranceSteps = new InsuranceSteps();
    DataSteps dataSteps = new DataSteps();

    @Когда("развернут пункт меню \"(.*)\"$")
    public void selectInsMenuStep(String menuItem){
        mainSteps.selectInsMenu(menuItem);
    }

    @Тогда("выполнено нажатие на кнопку Страхование путешественников")
    public void selectTravelInsStep(){
        mainSteps.selectTravelIns();
    }

    @Когда("проверено наличие \"(.*)\" в заголовке страницы")
    public void chkTitleStep(String title){
        mainSteps.chkTitleStep(title);
    }

    @Тогда("выполнено нажатие на кнопку - Оформление онлайн")
    public void insOnlainBtnClickStep(){
        mainSteps.selectInsOnlainStep();
        baseSteps.swapToNextPage();
    }

    @Когда("выбрана Минимальная сумма страховой защиты")
    public void setMinSumStep(){
        insuranceSteps.selectMinStep();
    }

    @Когда("выполнено нажатие на кнопку Оформить")
    public void saveBtnClickStep(){
        insuranceSteps.clickSaveBtnStep();
    }

    @Когда("заполняются поля")
    public void fillFields(DataTable fields){
        fields.asMap(String.class, String.class).forEach(
                (key, value) -> dataSteps.fillFieldStep(key, value)
        );
    }

    @Когда("выбран \"(.*)\" пол")
    public void setSexStep(String sex){
        insuranceSteps.selectSexStep(sex);
    }

    @Когда("проверены значения полей")
    public void chkFieldsValuesStep(DataTable fields){
        fields.asMap(String.class, String.class).forEach(
                (key, value) -> dataSteps.chkFieldValueStep(key, value)
        );
    }

    @Когда("проверено, что выбран \"(.*)\" пол")
    public void chkSexStep(String sex){
        insuranceSteps.checkSexStep(sex);
    }

    @Тогда("выполнено нажатие на кнопку Продолжить")
    public void continueBtnClickStep(){
        insuranceSteps.continueBtnClickStep();
    }

    @Когда("проверено отображение ошибки с текстом \"(.*)\"")
    public void chkErrorMsgStep(String errorTxt){
        dataSteps.chkErrorMsgStep(errorTxt);
    }

}
