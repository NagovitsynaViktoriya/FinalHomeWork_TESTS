package test.Steps;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import test.Pages.ComparisonPage;
import java.util.ArrayList;
import java.util.List;

public class ComparisonSteps {

    private ComparisonPage comparisonPage;

    public ComparisonSteps() {
        comparisonPage = ComparisonPage.getComparisonPage();
    }

    public void checkURLProductComparison() {
        String expectedResult = "/product-comparison";
        String actualResult = WebDriverRunner.url().substring(21,40);
        Assert.assertEquals(expectedResult, actualResult);
    }

    public void checkTitleComparisonPage (String expectedResult) {
        Assert.assertEquals(expectedResult, comparisonPage.getTitleComparisonPage().text().substring(0,17));
    }

    public List getActualTitle() {
        List<String> actualAppleTitle = new ArrayList<String>();
        for (int i = 0; i < 3; i++) {
            actualAppleTitle.add(comparisonPage.getTitleProduct().get(i).text());
        }
        return actualAppleTitle;
    }

    public void checkExpectedAndActualTitleProduct(List expectedTitleProducts, List actualTitleProducts) {
        Assert.assertTrue(expectedTitleProducts.containsAll(actualTitleProducts));
    }
}
