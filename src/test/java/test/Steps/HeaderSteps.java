package test.Steps;



import org.junit.Assert;
import test.Pages.HeaderPage;
import static com.codeborne.selenide.Selenide.sleep;

public class HeaderSteps {

    private HeaderPage headerPage;

    public HeaderSteps() {
        headerPage = HeaderPage.getHeaderPage();
    }

    public void checkButtonOrderStatusIsDisplayed () {
        Assert.assertTrue(headerPage.getButtonOrderStatus().isDisplayed());
    }

    public void checkButtonOrderStatusIsEnabled () {
        Assert.assertFalse(String.valueOf(headerPage.getButtonOrderStatus()).contains("disabled"));
    }

    public void checkButtonComeIsDisplayed () {
        Assert.assertTrue(headerPage.getButtonCome().isDisplayed());
    }

    public void checkButtonComeIsEnabled () {
        Assert.assertFalse(String.valueOf(headerPage.getButtonCome()).contains("disabled"));
    }

    public void clickButtonCome () {
        headerPage.getButtonCome().click();
    }

    public void checkButtonComparisonIsDisplayed() {
        Assert.assertTrue(headerPage.getButtonComparison().isDisplayed());
    }

    public void checkButtonComparisonIsDisabled() {
        Assert.assertEquals("disabled", headerPage.getButtonComparison().attr("class"));
    }

    public void clickButtonComparison() {
        headerPage.getButtonComparison().click();
    }

    public void checkButtonFavoriteIsDisplayed() {
        Assert.assertTrue(headerPage.getButtonFavorite().isDisplayed());
    }

    public void checkButtonFavoriteIsDisabled() {
        Assert.assertEquals("disabled", headerPage.getButtonFavorite().attr("class"));
    }

    public void clickButtonFavorite() {
        headerPage.getButtonFavorite().click();
        sleep(7000);
    }

    public void checkButtonCartIsDisplayed() {
        Assert.assertTrue(headerPage.getButtonCart().isDisplayed());
    }

    public void checkButtonCartIsDisabled() {
        Assert.assertEquals("disabled", headerPage.getButtonCart().attr("class"));
    }

    public void checkButtonCartIsEnabled() {
        Assert.assertFalse(String.valueOf(headerPage.getButtonCart()).contains("disabled"));
    }

    public void checkButtonCartWithBubble1() {
        Assert.assertEquals("1", headerPage.getCartBubble().text());
    }

    public void clickButtonCart() {
        headerPage.getButtonCart().click();
        sleep(7000);
    }

    public void checkInputSearchIsDisplayed() {
        Assert.assertTrue(headerPage.getInputSearch().isDisplayed());
    }

    public void inputTextInInputSearch(String inputText) {
        headerPage.getInputSearch().sendKeys(inputText);
    }

    public void clickInputSearchButton() {
        headerPage.getInputSearchButton().click();
        sleep(7000);
    }

    public void clickCity() {
        headerPage.getCity().click();
    }

    public void checkCorrectCity (String expectedResult) {
        Assert.assertEquals(expectedResult, headerPage.getCity().text());
    }
}
