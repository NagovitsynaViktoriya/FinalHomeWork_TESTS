package test.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import java.util.Objects;

public class SelectCityWindowPage {

    private static SelectCityWindowPage selectCityWindowPage;

    @FindBy(xpath = "//div[contains(@class, 'modal-layout__content')]/..//h3[text() =' Выберите город ']")
    private SelenideElement modalWindowSelectCity;

    @FindBy(xpath = "//li")
    private ElementsCollection location;

    private SelectCityWindowPage() {

    }

    public static SelectCityWindowPage getSelectCityWindowPage() {
        if (Objects.isNull(selectCityWindowPage)) selectCityWindowPage = Selenide.page(new SelectCityWindowPage());
        return selectCityWindowPage;
    }

    public SelenideElement getModalWindowSelectCity() {
        return modalWindowSelectCity;
    }

    public ElementsCollection getLocation() {
        return location;
    }
}
