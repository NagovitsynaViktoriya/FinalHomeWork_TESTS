package test.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import java.util.Objects;

public class ProductDayPage {

    private static ProductDayPage productDayPage;

    @FindBy(xpath = "//div[contains(@class, 'carousel-desktop')]//mvid-title-timer//div//div[contains(@class, 'title')]//span[text()='Товары дня']")
    private SelenideElement productDayTitle;

    @FindBy(xpath = "//div[contains(@class, 'carousel-desktop')]//div//div/mvid-day-product//button")
    private ElementsCollection productDayButtonToCart;

    @FindBy(xpath = "//div[contains(@class, 'carousel-desktop')]//div//div/mvid-day-product//div[contains(@class,'title')]//a")
    private ElementsCollection productDayTitleProduct;


    private ProductDayPage() {

    }

    public static ProductDayPage getProductDayPage() {
        if (Objects.isNull(productDayPage)) productDayPage = Selenide.page(new ProductDayPage());
        return productDayPage;
    }

    public SelenideElement getProductDayTitle() {
        return productDayTitle;
    }

    public ElementsCollection getProductDayButtonToCart() {
        return productDayButtonToCart;
    }

    public ElementsCollection getProductDayTitleProduct() {
        return productDayTitleProduct;
    }


}
