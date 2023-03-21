package ui;

import framework.pages.AcceptProductPage;
import framework.pages.MainPage;
import java.math.BigDecimal;
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

    String actualPaperType = String.valueOf(acceptProductPage.getPaperType());
    String exceptPaperType = "Doted";

    softAssertions.assertThat(actualPaperType)
        .as("We expected that the [Doted] Paper Type should be on the page")
        .isEqualTo(exceptPaperType);

    Double actualQuantity = Double.valueOf(acceptProductPage.getQuantity());
    Double exceptQuantity = Double.valueOf("5");

    softAssertions.assertThat(actualQuantity)
        .as("We expected that the [5] Quantity should be on the page")
        .isEqualTo(exceptQuantity);

    String onePriceStr = acceptProductPage.getOnePrice();
    String quantityStr = String.valueOf(acceptProductPage.getQuantity());
    String totalPriceStr = acceptProductPage.getTotalPrice();

    BigDecimal onePrice = new BigDecimal(onePriceStr);
    BigDecimal quantity = new BigDecimal(quantityStr);
    BigDecimal actualTotalPrice = new BigDecimal(totalPriceStr);
    BigDecimal expectedTotalPrice = onePrice.multiply(quantity);

    softAssertions.assertThat(actualTotalPrice)
        .as("Total price is not equals expected")
        .isEqualTo(expectedTotalPrice);


    softAssertions.assertAll();
  }
}
