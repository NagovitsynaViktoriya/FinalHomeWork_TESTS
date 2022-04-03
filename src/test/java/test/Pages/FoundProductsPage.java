package test.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import java.util.Objects;

public class FoundProductsPage {

    private static FoundProductsPage foundProductsPage;

    @FindBy(xpath = "//mvid-button[@label='Показать ещё']//button")
    private SelenideElement buttonShowMore;

    @FindBy(xpath = "//a[contains(@class,'product-title__text')]")
    private ElementsCollection foundProductTitle;

    @FindBy(xpath = "//a[contains(@class, 'product-title__text')]/../../../..//mvid-plp-product-checkout//div//div[contains(@class,'product-checkout__button-block')]//div[contains(@class,'compare-button-block')]")
    private ElementsCollection buttonComparison;

    @FindBy(xpath = "//a[contains(@class, 'product-title__text')]/../../../..//mvid-plp-product-checkout//div//div[contains(@class,'product-checkout__button-block')]//div[contains(@class,'wishlist-button-block')]")
    private ElementsCollection buttonFavorite;

    @FindBy(xpath = "//div[@class='dropdown__title']//span[text()='Сначала популярные']")
    private SelenideElement dropDown;

    @FindBy(xpath = "//div[text()=' Сначала дороже ']")
    private SelenideElement dropDownFirstExpensive;

    @FindBy(xpath = "//mvid-plp-price-block[contains(@class, 'price')]//div//mvid-price//div//span")
    private ElementsCollection priceProduct;

    private FoundProductsPage() {

    }

    public static FoundProductsPage getFoundProductPage() {
        if (Objects.isNull(foundProductsPage)) foundProductsPage = Selenide.page(new FoundProductsPage());
        return foundProductsPage;
    }

    public SelenideElement getButtonShowMore() {
        return buttonShowMore;
    }

    public ElementsCollection getFoundProductTitle() {
        return foundProductTitle;
    }

    public ElementsCollection getButtonComparison() { return buttonComparison; }

    public ElementsCollection getButtonFavorite() {
        return buttonFavorite;
    }

    public SelenideElement getDropDown() { return dropDown; }

    public SelenideElement getDropDownFirstExpensive() { return dropDownFirstExpensive; }

    public ElementsCollection getPriceProduct() { return priceProduct; }
}