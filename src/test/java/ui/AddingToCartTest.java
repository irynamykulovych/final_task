package ui;

import framework.pages.AcceptProductPage;
import framework.pages.MainPage;
import framework.pages.helpers.Helpers;
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

//    String onePrice = acceptProductPage.getOnePrice();
//    String quantity = String.valueOf(acceptProductPage.getQuantity());
//    String totalPrice = acceptProductPage.getTotalPrice();
//    Double expectedTotalPrice;
//    expectedTotalPrice = Helpers.convertStringPriceToDouble(onePrice)
//        * Double.parseDouble(quantity);

//    BigDecimal onePrice = new BigDecimal(acceptProductPage.getOnePrice());
//    BigDecimal quantity = new BigDecimal(acceptProductPage.getQuantity());
//    BigDecimal totalPrice = new BigDecimal(acceptProductPage.getTotalPrice());
//    BigDecimal expectedTotalPrice;
//    expectedTotalPrice = onePrice.multiply(quantity);

    String onePriceStr = acceptProductPage.getOnePrice()
        .replaceAll("[^\\d.]", "");
    String quantityStr = String.valueOf(acceptProductPage.getQuantity())
        .replaceAll("[^\\d.]", "");
    String totalPriceStr = acceptProductPage.getTotalPrice()
        .replaceAll("[^\\d.]", "");

    BigDecimal onePrice = new BigDecimal(onePriceStr);
    BigDecimal quantity = new BigDecimal(quantityStr);
    BigDecimal totalPrice = new BigDecimal(totalPriceStr);
    BigDecimal expectedTotalPrice = onePrice.multiply(quantity);

    softAssertions.assertThat(expectedTotalPrice)
        .as("Total price is not equals expected")
        .isEqualTo(totalPrice);


    softAssertions.assertAll();
  }
}
