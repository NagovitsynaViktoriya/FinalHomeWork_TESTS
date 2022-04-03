package test.Steps;


import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import test.Pages.FavoritePage;
import java.util.ArrayList;
import java.util.List;

public class FavoriteSteps {

    private FavoritePage favoritePage;

    public FavoriteSteps() { favoritePage = FavoritePage.getFavoritePage(); }

    public void checkURLWishList() {
        String expectedResult = "/wish-list";
        String actualResult = WebDriverRunner.url().substring(21,31);
        Assert.assertEquals(expectedResult, actualResult);
    }

    public void checkTitleFavoritePage (String expectedResult) {
        Assert.assertEquals(expectedResult, favoritePage.getTitleFavoritePage().text().substring(0,9));
    }

    public List getActualTitle() {
        List<String> actualAppleTitle = new ArrayList<String>();
        for (int i = 0; i < 3; i++) {
            actualAppleTitle.add(favoritePage.getTitleProduct().get(i).text());
        }
        return actualAppleTitle;
    }

    public void checkExpectedAndActualTitleProduct(List expectedTitleProducts, List actualTitleProducts) {
        Assert.assertTrue(expectedTitleProducts.containsAll(actualTitleProducts));
    }

}