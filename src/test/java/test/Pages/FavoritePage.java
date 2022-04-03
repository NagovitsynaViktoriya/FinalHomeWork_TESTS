package test.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class FavoritePage {
    private static FavoritePage favoritePage;

    @FindBy(xpath = "//h1")
    private SelenideElement titleFavoritePage;

    @FindBy(xpath = "//h3")
    private ElementsCollection titleProduct;

    private FavoritePage() {

    }

    public static FavoritePage getFavoritePage() {
        if (Objects.isNull(favoritePage)) favoritePage = Selenide.page(new FavoritePage());
        return favoritePage;
    }

    public SelenideElement getTitleFavoritePage() {
        return titleFavoritePage;
    }

    public ElementsCollection getTitleProduct() {
        return titleProduct;
    }
}