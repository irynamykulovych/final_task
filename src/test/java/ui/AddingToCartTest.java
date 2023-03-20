package ui;

import framework.pages.AcceptProductPage;
import framework.pages.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class AddingToCartTest extends BaseTest {

  MainPage mainPage = new MainPage();

  @Test
  public void AddingProductToCart() {
    AcceptProductPage acceptProductPage = mainPage.enterProductName("Bear")
        .clickBrownBearNotebook()
        .selectDoterPaperType()
        .changeQuantity(String.valueOf(5))
        .clickAddToCartButton();

    SoftAssertions softAssertions = new SoftAssertions();

    String actualTitle = String.valueOf(acceptProductPage.getProductSuccessfullyTitle());
    String exceptedTitle = "\uE876" + "Product successfully added to your shopping cart";

    softAssertions.assertThat(actualTitle)
        .as("We expected that the title should be: "
            + "[Product successfully added to your shopping cart]")
        .isEqualTo(exceptedTitle);

    softAssertions.assertAll();
  }
}
