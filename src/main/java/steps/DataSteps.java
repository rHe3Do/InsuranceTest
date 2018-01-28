package steps;

import pages.DataPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class DataSteps{

    @Step("поле {0} заполнено значением {1}")
    public void fillFieldStep(String field, String value){
        new DataPage().fillField(field, value);
    }

    @Step("заполняются поля")
    public void fillFieldsStep(HashMap<String, String> fields){
        fields.forEach(this::fillFieldStep);
    }

    @Step("проверено, что значение поля {0} соответствует {1}")
    public void chkFieldValueStep(String field, String value){
        new DataPage().chkFilledData(field, value);
    }

    @Step("проверяются значения полей")
    public void chkFieldsStep(HashMap<String, String> fields){
        fields.forEach(this::chkFieldValueStep);
    }

    @Step("проверено, что отображена ошибка с текстом {0}")
    public void chkErrorMsgStep(String errorTxt){
        new DataPage().chkErrorMsg(errorTxt);
    }

}
