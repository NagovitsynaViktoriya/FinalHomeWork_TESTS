package test.Steps;

import org.junit.Assert;
import test.Pages.MostViewedPage;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class MostViewedSteps {

    private MostViewedPage mostViewedPage;

    public MostViewedSteps() {
        mostViewedPage = MostViewedPage.getMostViewedPage();
    }

    public void checkBlockMostViewedIsDisplayed() {
        for (int i = 0; i < 2; i++) {
            mostViewedPage.getBlock().get(i).scrollIntoView(false);
        }
        sleep(5000);
        Assert.assertTrue(mostViewedPage.getBlockMostViewed().isDisplayed());
    }

    public List clickTwoProductInMostViewedGetTitle() {
        List<String> titleProducts = new ArrayList<String>();
        for (int i = 0; i < 2; i++) {
            mostViewedPage.getButtonToCart().get(i).click();
            titleProducts.add(mostViewedPage.getTitleProduct().get(i).text());
        }
        sleep(5000);
        return titleProducts;
    }

}
