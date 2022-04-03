package test.Steps;

import org.junit.Assert;
import test.Pages.ProductDayPage;
import static com.codeborne.selenide.Selenide.sleep;

public class ProductDaySteps {

    private ProductDayPage productDayPage;

    public ProductDaySteps() {
        productDayPage = ProductDayPage.getProductDayPage();
    }

    public void checkProductDayTitleIsDisplayed() {
        Assert.assertTrue(productDayPage.getProductDayTitle().isDisplayed());
    }

    private String str;
    public String clickProductDayButtonToCart() {

        for (int i = 0; i < 5; i++) {
            if (productDayPage.getProductDayButtonToCart().get(i).isDisplayed()) {
                productDayPage.getProductDayButtonToCart().get(i).click();
                str = productDayPage.getProductDayTitleProduct().get(i).text();
            }
        }
        sleep(3000);
        return str;
    }


}
