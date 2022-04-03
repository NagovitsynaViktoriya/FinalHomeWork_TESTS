package test.Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import java.util.Objects;

public class HeaderPage {

    private static HeaderPage headerPage;

    @FindBy(xpath = "//span[contains(@class,'location-text')]")
    private SelenideElement city;

    @FindBy(xpath = "//input[@id='1']")
    private SelenideElement inputSearch;

    @FindBy(xpath = "//mvid-icon[@type='search']")
    private SelenideElement inputSearchButton;

    @FindBy(xpath = "//mvid-header-icon[contains(@class, 'tab-status-order')]")
    private SelenideElement buttonOrderStatus;

    @FindBy(xpath = "//div[contains(@class, 'tab-profile')]")
    private SelenideElement buttonCome;

    @FindBy(xpath = "//div[contains(@class, 'tab-compare')]//mvid-header-icon")
    private SelenideElement buttonComparison;

    @FindBy(xpath = "//div[contains(@class, 'tab-personal')]//mvid-header-icon")
    private SelenideElement buttonFavorite;

    @FindBy(xpath = "//div[contains(@class, 'tab-cart')]//mvid-header-icon")
    private SelenideElement buttonCart;

    @FindBy(tagName = "mvid-bubble")
    private SelenideElement cartBubble;

    private HeaderPage() {

    }

    public static HeaderPage getHeaderPage() {
        if (Objects.isNull(headerPage)) headerPage = Selenide.page(new HeaderPage());
        return headerPage;
    }

    public SelenideElement getCity() {
        return city;
    }

    public  SelenideElement getInputSearch() { return inputSearch; }

    public SelenideElement getInputSearchButton() {return inputSearchButton; }

    public SelenideElement getButtonOrderStatus() {
        return buttonOrderStatus;
    }

    public SelenideElement getButtonCome() {
        return buttonCome;
    }

    public SelenideElement getButtonComparison() {
        return buttonComparison;
    }

    public SelenideElement getButtonFavorite() {
        return buttonFavorite;
    }

    public SelenideElement getButtonCart() {
        return buttonCart;
    }

    public SelenideElement getCartBubble() {
        return cartBubble;
    }
}
