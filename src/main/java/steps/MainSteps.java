package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps {

    @Step("развернут пункт меню {0}")
    public void selectInsMenu(String menuItem){
        new MainPage().selectMenuItem(menuItem);
    }

    @Step("выполнено нажатие на кнопку Страхование путешественников")
    public void selectTravelIns(){ new MainPage().goToTravelIns(); }

    @Step("проверено наличие {0} в заголовке страницы")
    public void chkTitleStep(String title){
        new MainPage().chkTitle(title);
    }

    @Step("выполнено нажатие на кнопку - Оформление онлайн")
    public void selectInsOnlainStep(){
        new MainPage().goToInsOnlain();
    }

}
