package test.Steps;

import org.junit.Assert;
import test.Pages.LoginWindowPage;

import static com.codeborne.selenide.Condition.text;

public class LoginWindowSteps {
    private LoginWindowPage loginWindowPage;

    public LoginWindowSteps() {
        loginWindowPage = LoginWindowPage.getLoginWindowPage();
    }

    public void checkButtonCloseIsDisplayed() {
        Assert.assertTrue(loginWindowPage.getButtonClose().isDisplayed());
    }

    public void checkModalWindowTitleIsDisplayed() {
        Assert.assertTrue(loginWindowPage.getModalWindowTitle().shouldHave(text("Вход или регистрация")).isDisplayed());
    }

    public void checkInputFieldIsDisplayed() {
        Assert.assertTrue(loginWindowPage.getInputField().isDisplayed());
    }

    public void checkPlaceholder(String expectedResult) {
        Assert.assertEquals(expectedResult, loginWindowPage.getPlaceholder().text());
    }

    public void checkButtonProceedIsDisplayed() {
        Assert.assertTrue(loginWindowPage.getButtonProceed().isDisplayed());
    }

    public void checkButtonProceedIsDisabled() {
        Assert.assertTrue(String.valueOf(loginWindowPage.getButtonProceed()).contains("disabled=\"true\""));
    }
    public void checkLinkForLegalEntities(String expectedResult) {
        Assert.assertEquals(expectedResult, loginWindowPage.getLinkForLegalEntities().text());
    }

}
