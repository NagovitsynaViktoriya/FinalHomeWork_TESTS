package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import test.Steps.*;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Tests {

    @Before
    public void setUp() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Selenide.open("https://www.mvideo.ru/");
        $(By.xpath("//span[contains(@class,'location-text')]")).click();
        $(By.xpath("//li[@data-index=\"1\"]")).click();
        sleep(7000);
    }

    @Test
    public void checkHeaderMVideo() {
        new HeaderSteps().checkButtonOrderStatusIsDisplayed();
        new HeaderSteps().checkButtonOrderStatusIsEnabled();
        new HeaderSteps().checkButtonComeIsDisplayed();
        new HeaderSteps().checkButtonComeIsEnabled();
        new HeaderSteps().checkButtonComparisonIsDisplayed();
        new HeaderSteps().checkButtonComparisonIsDisabled();
        new HeaderSteps().checkButtonFavoriteIsDisplayed();
        new HeaderSteps().checkButtonFavoriteIsDisabled();
        new HeaderSteps().checkButtonCartIsDisplayed();
        new HeaderSteps().checkButtonCartIsDisabled();
    }

    @Test
    public void checkCartButtonActivation() {
        new ProductDaySteps().checkProductDayTitleIsDisplayed();
        new ProductDaySteps().clickProductDayButtonToCart();
        new HeaderSteps().checkButtonCartIsEnabled();
        new HeaderSteps().checkButtonCartWithBubble1();
    }

    @Test
    public void checkGoToCart() {
        new ProductDaySteps().checkProductDayTitleIsDisplayed();
        String expectedResult = new ProductDaySteps().clickProductDayButtonToCart();
        new HeaderSteps().clickButtonCart();
        new CartSteps().checkURLCart();
        new CartSteps().checkTitleMyCartIsDisplayed("Моя корзина");
        new CartSteps().checkEqualTitle(expectedResult);
        new CartSteps().checkButtonGoIsDisplayed();
        new CartSteps().checkInfoAboutProductIsDisplayed("В корзине 1 товар");
        new CartSteps().checkEqualPrice();
    }

    @Test
    public void checkAddToCartTwoProducts() {
        new MostViewedSteps().checkBlockMostViewedIsDisplayed();
        List expectedTitleProducts = new MostViewedSteps().clickTwoProductInMostViewedGetTitle();
        new HeaderSteps().clickButtonCart();
        new CartSteps().checkExpectedAndActualTitleProduct(expectedTitleProducts, new CartSteps().getActualTitleProducts());
        new CartSteps().checkSumAddedProductsEqualTotalSum();
    }

    @Test
    public void checkProductSearch() {
        new HeaderSteps().checkInputSearchIsDisplayed();
        new HeaderSteps().inputTextInInputSearch("apple");
        new HeaderSteps().clickInputSearchButton();
        new FoundProductsSteps().checkURLProductListPage();
        new FoundProductsSteps().checkButtonShowMoreIsDisplayed();
        new FoundProductsSteps().checkProductContainApple();
    }

    @Test
    public void checkSortingProducts() {
        new HeaderSteps().checkInputSearchIsDisplayed();
        new HeaderSteps().inputTextInInputSearch("apple");
        new HeaderSteps().clickInputSearchButton();
        new FoundProductsSteps().checkURLProductListPage();
        new FoundProductsSteps().checkProductContainApple();
        new FoundProductsSteps().checkDropDownIsDisplayed();
        new FoundProductsSteps().clickDropDown();
        new FoundProductsSteps().clickDropDownFirstExpensive();
        new FoundProductsSteps().checkProductContainApple();
        new FoundProductsSteps().checkSortedFirstExpensive();
    }

    @Test
    public void checkClientAuthorizationModalWindow() {
        new HeaderSteps().clickButtonCome();
        new LoginWindowSteps().checkButtonCloseIsDisplayed();
        new LoginWindowSteps().checkModalWindowTitleIsDisplayed();
        new LoginWindowSteps().checkInputFieldIsDisplayed();
        new LoginWindowSteps().checkPlaceholder("Телефон");
        new LoginWindowSteps().checkButtonProceedIsDisplayed();
        new LoginWindowSteps().checkButtonProceedIsDisabled();
        new LoginWindowSteps().checkLinkForLegalEntities("Для юридических лиц");
    }

    @Test
    public void checkAddProductsToComparison() {
        new HeaderSteps().checkInputSearchIsDisplayed();
        new HeaderSteps().inputTextInInputSearch("apple");
        new HeaderSteps().clickInputSearchButton();
        new FoundProductsSteps().checkURLProductListPage();
        List expectedTitle = new FoundProductsSteps().clickThreeProductToComparison();
        new HeaderSteps().clickButtonComparison();
        new ComparisonSteps().checkURLProductComparison();
        new ComparisonSteps().checkTitleComparisonPage("Сравнение товаров");
        new ComparisonSteps().checkExpectedAndActualTitleProduct(expectedTitle, new ComparisonSteps().getActualTitle());
    }

    @Test
    public void checkAddProductToFavorite() {
        new HeaderSteps().checkInputSearchIsDisplayed();
        new HeaderSteps().inputTextInInputSearch("apple");
        new HeaderSteps().clickInputSearchButton();
        new FoundProductsSteps().checkURLProductListPage();
        List expectedTitle = new FoundProductsSteps().clickThreeProductToFavorite();
        new HeaderSteps().clickButtonFavorite();
        new FavoriteSteps().checkURLWishList();
        new FavoriteSteps().checkTitleFavoritePage("Избранное");
        new FavoriteSteps().checkExpectedAndActualTitleProduct(expectedTitle, new FavoriteSteps().getActualTitle());
    }

    @Test
    public void checkCityChange() {
        new HeaderSteps().clickCity();
        new SelectCityWindowSteps().checkModalWindowSelectCityIsDisplayed();
        new SelectCityWindowSteps().clickCity("Краснодар");
        new SelectCityWindowSteps().checkModalWindowSelectCityIsNotDisplayed();
        new HeaderSteps().checkCorrectCity("Краснодар");
    }

    @After
    public void q() {
        Selenide.closeWebDriver();
    }

}

