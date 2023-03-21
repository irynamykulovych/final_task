package ui;

import framework.pages.MainPage;
import framework.pages.PricesDropPage;
import framework.pages.components.ProductComponent.PriceOfDropProductModel;
import java.math.BigDecimal;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class PriceDropCheckTest extends BaseTest {

  MainPage mainPage = new MainPage();
  PricesDropPage pricesDropPage = new PricesDropPage();

  @Test
  public void checkPriseOfProductInPriceDropPage() {

    SoftAssertions softAssertions = new SoftAssertions();

    mainPage.clickOnPriceDropLink();
    List<PriceOfDropProductModel> products = pricesDropPage.getProductsFromPriceDropPage();
    for (PriceOfDropProductModel product : products) {

      softAssertions.assertThat(product.getOldPrice())
          .as("Value of old price should be for products")
          .isNotNull();

      softAssertions.assertThat(product.getNewPrice())
          .as("Value of new price should be for products")
          .isNotNull();


//      softAssertions.assertThat(product.getDiscountFromProducts())
//          .as("products discount should be 20%")
//          .isEqualTo(getPrice(product.getOldPrice()));


//    public double getDiscountFromProducts() {
//      Thread.sleep(5000);
//      double oldPrice = getPrice(this.oldPrice);
//      DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
//
//      DecimalFormat df = new DecimalFormat("##.##", symbols);
//
//      df.setRoundingMode(RoundingMode.CEILING);
//      double result = (oldPrice / 100) * Integer.valueOf(this.discount.replaceAll("\\D", ""));
//      return Double.valueOf(df.format(result));
//    }

//      String onePriceStr = acceptProductPage.getOnePrice();
//        .replaceAll("[^\\d.]", "");
//      String quantityStr = String.valueOf(acceptProductPage.getQuantity());
//        .replaceAll("[^\\d.]", "");
//      String totalPriceStr = acceptProductPage.getTotalPrice();
//        .replaceAll("[^\\d.]", "");

//      BigDecimal onePrice = new BigDecimal(onePriceStr);
//      BigDecimal quantity = new BigDecimal(quantityStr);
//      BigDecimal totalPrice = new BigDecimal(totalPriceStr);
//      BigDecimal expectedTotalPrice = onePrice.multiply(quantity);
//
//      softAssertions.assertThat(expectedTotalPrice)
//          .as("Total price is not equals expected")
//          .isEqualTo(totalPrice);

      softAssertions.assertAll();
    }
  }
}