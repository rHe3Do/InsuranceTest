package steps;

import pages.InsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

public class InsuranceSteps extends BaseSteps {

    @Step("выбрана Минимальная сумма страховой защиты")
    public void selectMinStep(){
        new InsurancePage(driver).chooseMinSum();
    }

    @Step("выполнено нажатие на кнопку Оформить")
    public void clickSaveBtnStep(){
        new InsurancePage(driver).clickSaveBtn();
    }

    @Step("выбран {0} пол")
    public void selectSexStep(String sex){
        new InsurancePage(driver).selectSex(sex);
    }

    @Step("проверено, что пол выбран {0}")
    public void checkSexStep(String sex){
        new InsurancePage(driver).chkSexField(sex);
    }

    @Step("выполнено нажатие на кнопку Продолжить")
    public void continueBtnClickStep(){
        new InsurancePage(driver).continueBtnClick();
    }

}
