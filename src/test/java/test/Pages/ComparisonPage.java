package test.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import java.util.Objects;

public class ComparisonPage {
    private static ComparisonPage comparisonPage;

    @FindBy(xpath = "//h1")
    private SelenideElement titleComparisonPage;

    @FindBy(xpath = "//div[contains(@Class,'c-compare-cell__pinable-product-tile')]//div[contains(@class,'c-product-tile__description')]//div//div")
    private ElementsCollection titleProduct;

    private ComparisonPage() {

    }

    public static ComparisonPage getComparisonPage() {
        if (Objects.isNull(comparisonPage)) comparisonPage = Selenide.page(new ComparisonPage());
        return comparisonPage;
    }

    public SelenideElement getTitleComparisonPage() {
        return titleComparisonPage;
    }

    public ElementsCollection getTitleProduct() {
        return titleProduct;
    }

}
