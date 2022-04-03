package test.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import java.util.Objects;

public class CartPage {

    private static CartPage cartPage;

    @FindBy(xpath = "//span[contains(@class,'c-header-checkout__logo')]")
    private SelenideElement titleCart;

    @FindBy(xpath = "//a[contains(@class,'c-cart-item__title')]")
    private ElementsCollection titleProductInCart;

    @FindBy(xpath = "//input[@value='Перейти к оформлению']")
    private SelenideElement buttonGo;

    @FindBy(xpath = "//div[@class='c-cost-line__title-wrap']//span")
    private SelenideElement infoAboutProduct;

    @FindBy(xpath = "//span[@class='c-cart-item__price']")
    private ElementsCollection priceProduct;

    @FindBy(xpath = "//span[@class='c-cost-line__text']")
    private SelenideElement priceInfoAboutProduct;


    private CartPage() {

    }

    public static CartPage getCartPage() {
        if (Objects.isNull(cartPage)) cartPage = Selenide.page(new CartPage());
        return cartPage;
    }


    public SelenideElement getTitleCart() {
        return titleCart;
    }

    public ElementsCollection getTitleProductInCart() {
        return titleProductInCart;
    }

    public SelenideElement getButtonGo() {
        return buttonGo;
    }

    public SelenideElement getInfoAboutProduct() {
        return infoAboutProduct;
    }

    public ElementsCollection getPriceProduct() {
        return priceProduct;
    }

    public SelenideElement getPriceInfoAboutProduct() {
        return priceInfoAboutProduct;
    }
}
