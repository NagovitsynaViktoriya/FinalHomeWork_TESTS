package test.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import java.util.Objects;

public class MostViewedPage {

    private static MostViewedPage mostViewedPage;

    @FindBy(xpath = "//mvid-simple-product-collection")
    private ElementsCollection block;

    @FindBy(xpath = "//mvid-simple-product-collection//h2[text()='Самые просматриваемые']")
    private SelenideElement blockMostViewed;

    @FindBy(xpath = "//mvid-simple-product-collection//h2[text()='Самые просматриваемые']/..//mvid-carousel//div//div//mvid-product-cards-group//div[contains(@class,'product-mini-card__controls')]//mvid-product-actions//mvid-product-actions-tooltip//button[contains(@class, 'actions__cart')]")
    private ElementsCollection buttonToCart;

    @FindBy(xpath = "//mvid-simple-product-collection//h2[text()='Самые просматриваемые']/..//mvid-carousel//div//div//mvid-product-cards-group//div[contains(@class, 'product-mini-card__name')]//div//div")
    private ElementsCollection titleProduct;

    private MostViewedPage() {

    }

    public static MostViewedPage getMostViewedPage() {
        if (Objects.isNull(mostViewedPage)) mostViewedPage = Selenide.page(new MostViewedPage());
        return mostViewedPage;
    }

    public ElementsCollection getBlock() {
        return block;
    }

    public SelenideElement getBlockMostViewed() {
        return blockMostViewed;
    }

    public ElementsCollection getButtonToCart() {
        return buttonToCart;
    }

    public ElementsCollection getTitleProduct() {
        return titleProduct;
    }
}