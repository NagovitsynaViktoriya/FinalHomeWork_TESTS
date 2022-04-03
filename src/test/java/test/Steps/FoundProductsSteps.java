package test.Steps;



import java.util.ArrayList;
import java.util.List;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import test.Pages.FoundProductsPage;

import static com.codeborne.selenide.Selenide.*;

public class FoundProductsSteps {

    private FoundProductsPage foundProductsPage;

    public FoundProductsSteps() {
        foundProductsPage = FoundProductsPage.getFoundProductPage();
    }

    public void checkURLProductListPage() {
        String expectedResult = "/product-list-page";
        String actualResult = WebDriverRunner.url().substring(21,39);
        Assert.assertEquals(expectedResult, actualResult);
    }

    public void checkButtonShowMoreIsDisplayed() {
        Assert.assertTrue(foundProductsPage.getButtonShowMore().isDisplayed());
    }

    public void checkProductContainApple() {
        for (int i = 0; i < 24; i++) {
            foundProductsPage.getFoundProductTitle().get(i).scrollIntoView(false);
            Assert.assertTrue(foundProductsPage.getFoundProductTitle().get(i).text().toLowerCase().contains("apple"));
        }
    }

    public List clickThreeProductToComparison() {
        List<String> expectedAppleTitle = new ArrayList<String>();
        for (int i = 0; i < 3; i++){
            expectedAppleTitle.add(foundProductsPage.getFoundProductTitle().get(i).text());
            foundProductsPage.getButtonComparison().get(i).click();
        }
        sleep(3000);
        return expectedAppleTitle;
    }

    public List clickThreeProductToFavorite() {
        List<String> expectedAppleTitle = new ArrayList<String>();
        for (int i = 0; i < 3; i++){
            expectedAppleTitle.add(foundProductsPage.getFoundProductTitle().get(i).text());
            foundProductsPage.getButtonFavorite().get(i).click();
        }
        sleep(3000);
        return expectedAppleTitle;
    }

    public void checkDropDownIsDisplayed() {
        Assert.assertTrue(foundProductsPage.getDropDown().isDisplayed());
    }

    public void clickDropDown() {
        foundProductsPage.getDropDown().click();
    }

    public void clickDropDownFirstExpensive() {
        foundProductsPage.getDropDownFirstExpensive().click();
    }

    public void checkSortedFirstExpensive() {
        for (int i = 0; i < 23; i++) {
            Assert.assertTrue(Integer.parseInt(foundProductsPage.getPriceProduct().get(i).text().replaceAll(" ", "").substring(0, 6)) >= Integer.parseInt(foundProductsPage.getPriceProduct().get(i + 1).text().replaceAll(" ", "").substring(0, 6)));
        }
    }

}