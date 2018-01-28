package util;

import gherkin.formatter.model.Result;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.cucumberjvm.AllureReporter;
import steps.BaseSteps;

public class AllureListener extends AllureReporter {

    @Override
    public void result(Result result){
        if (result.getStatus().equals("failed")) {
            BaseSteps.takeScreenshot();
        }
        super.result(result);
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot)
                BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}