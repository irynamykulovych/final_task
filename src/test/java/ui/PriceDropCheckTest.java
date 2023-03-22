package ui;

import framework.pages.MainPage;
import framework.pages.components.ProductComponent;
import framework.pages.helpers.Helpers;
import java.math.BigDecimal;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class PriceDropCheckTest extends BaseTest {

  MainPage mainPage = new MainPage();

  @Test
  public void checkPriseOfProductInPriceDropPage() {

    mainPage.clickOnPriceDropLink();
    List<ProductComponent> products = Helpers.getAllProducts();
    List<BigDecimal> actualNewPrices = Helpers.getNewProductPrices(products);
    List<BigDecimal> actualOldPrices = Helpers.getOldProductPrices(products);
    List<BigDecimal> actualDiscounts = Helpers.getCalculatedDiscount(products);
    List<BigDecimal> expectedDiscountsPrice = Helpers.getCalculatedDiscount(products);

    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(actualOldPrices)
        .as("Value of old price should be for products")
        .isNotNull();

    softAssertions.assertThat(actualNewPrices)
        .as("Value of new price should be for products")
        .isNotNull();

    softAssertions.assertThat(actualDiscounts)
        .as("products discount should be 20%")
        .isEqualTo(expectedDiscountsPrice);

    softAssertions.assertAll();
  }
}