package steps;

import pages.InsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

public class InsuranceSteps {

    @Step("выбрана Минимальная сумма страховой защиты")
    public void selectMinStep(){
        new InsurancePage().chooseMinSum();
    }

    @Step("выполнено нажатие на кнопку Оформить")
    public void clickSaveBtnStep(){
        new InsurancePage().clickSaveBtn();
    }

    @Step("выбран {0} пол")
    public void selectSexStep(String sex){
        new InsurancePage().selectSex(sex);
    }

    @Step("проверено, что пол выбран {0}")
    public void checkSexStep(String sex){
        new InsurancePage().chkSexField(sex);
    }

    @Step("выполнено нажатие на кнопку Продолжить")
    public void continueBtnClickStep(){
        new InsurancePage().continueBtnClick();
    }

}
