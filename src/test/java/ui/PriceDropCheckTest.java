package ui;

import framework.pages.MainPage;
import framework.pages.PricesDropPage;
import framework.pages.components.ProductComponent.PriceOfDropProductModel;
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

      softAssertions.assertAll();
    }
  }
}