package test.Steps;


import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import test.Pages.CartPage;
import java.util.ArrayList;
import java.util.List;

public class CartSteps {

    private CartPage cartPage;

    public CartSteps() {
        cartPage =CartPage.getCartPage();
    }

    public void checkURLCart () {
        String expectedResult = "https://www.mvideo.ru/cart";
        String actualResult = WebDriverRunner.url();
        Assert.assertEquals(expectedResult, actualResult);
    }

    public void checkTitleMyCartIsDisplayed(String expectedResult) {
        Assert.assertEquals(expectedResult, cartPage.getTitleCart().text());
    }

    public void checkButtonGoIsDisplayed() {
        Assert.assertTrue(cartPage.getButtonGo().isDisplayed());
    }

    public void checkInfoAboutProductIsDisplayed (String expectedResult) {
        Assert.assertEquals(expectedResult, cartPage.getInfoAboutProduct().text());
    }

    public void checkEqualPrice() {
        Assert.assertEquals(cartPage.getPriceProduct().get(0).text(), cartPage.getPriceInfoAboutProduct().text());
    }

    public void checkEqualTitle(String expectedResult) {
        Assert.assertEquals(expectedResult, cartPage.getTitleProductInCart().get(0).text());
    }

    public List getActualTitleProducts() {
        List<String> actualTitleProducts = new ArrayList<String>();
        for (int i = 0; i < 2; i++) {
            actualTitleProducts.add(cartPage.getTitleProductInCart().get(i).text());
        }
        return actualTitleProducts;
    }

    public void checkExpectedAndActualTitleProduct(List expectedTitleProducts, List actualTitleProducts) {
        Assert.assertTrue(expectedTitleProducts.containsAll(actualTitleProducts));
    }

    public void checkSumAddedProductsEqualTotalSum() {
        String price1_ = cartPage.getPriceProduct().get(0).text().replaceAll(" ", "");
        String price2_ = cartPage.getPriceProduct().get(1).text().replaceAll(" ", "");
        int price1 = Integer.parseInt(price1_.substring(0,price1_.length()-1));
        int price2 = Integer.parseInt(price2_.substring(0,price2_.length()-1));
        int actualPrice = price1 + price2;
        String expectedPrice_ = cartPage.getPriceInfoAboutProduct().text().replaceAll(" ","");
        int expectedPrice = Integer.parseInt(expectedPrice_.substring(0, expectedPrice_.length()-1));
        Assert.assertTrue(expectedPrice == actualPrice);
        System.out.println(expectedPrice);
        System.out.println(actualPrice);
    }

}