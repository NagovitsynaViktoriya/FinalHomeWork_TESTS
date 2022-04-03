package test.Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import java.util.Objects;

public class LoginWindowPage {

    private static LoginWindowPage loginWindowPage;

    @FindBy(xpath = "//button[contains(@class, 'login-form-top-nav__btn_close')]")
    private SelenideElement buttonClose;

    @FindBy(xpath = "//h2[contains(@class, 'login-form__header')]")
    private SelenideElement modalWindowTitle;

    @FindBy(xpath = "//input[@type='tel']")
    private SelenideElement inputField;

    @FindBy(xpath = "//input[@type='tel']/..//div//div//label//mvid-form-field-label//span")
    private SelenideElement placeholder;

    @FindBy(xpath = "//button[contains(@class,'login-form__button')]")
    private SelenideElement buttonProceed;

    @FindBy(xpath = "//button[contains(@class, 'login-form__link')]")
    private SelenideElement linkForLegalEntities;


    private LoginWindowPage() {

    }

    public static LoginWindowPage getLoginWindowPage() {
        if (Objects.isNull(loginWindowPage)) loginWindowPage = Selenide.page(new LoginWindowPage());
        return loginWindowPage;
    }

    public SelenideElement getButtonClose() { return buttonClose; }

    public SelenideElement getModalWindowTitle() {
        return modalWindowTitle;
    }

    public SelenideElement getInputField() {
        return inputField;
    }

    public SelenideElement getPlaceholder() {
        return placeholder;
    }

    public SelenideElement getButtonProceed() {
        return buttonProceed;
    }

    public SelenideElement getLinkForLegalEntities() {
        return linkForLegalEntities;
    }

}

