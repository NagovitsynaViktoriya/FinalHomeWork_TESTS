package test.Steps;

import org.junit.Assert;
import test.Pages.SelectCityWindowPage;
import static com.codeborne.selenide.Selenide.sleep;

public class SelectCityWindowSteps {
    private SelectCityWindowPage selectCityWindowPage;

    public SelectCityWindowSteps() {
        selectCityWindowPage = SelectCityWindowPage.getSelectCityWindowPage();
    }

    public void checkModalWindowSelectCityIsDisplayed() {
        Assert.assertTrue(selectCityWindowPage.getModalWindowSelectCity().isDisplayed());
    }

    public void checkModalWindowSelectCityIsNotDisplayed() {
        Assert.assertFalse(selectCityWindowPage.getModalWindowSelectCity().isDisplayed());
    }

    public void clickCity(String city) {
        int i = 0;
        while (true) {
            if (selectCityWindowPage.getLocation().get(i).text().equals(city)) {
                selectCityWindowPage.getLocation().get(i).click();
                break;
            }
            i = i + 1;
        }
        sleep(3000);
    }
}