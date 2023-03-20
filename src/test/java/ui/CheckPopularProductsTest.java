package ui;


import static framework.pages.helpers.Helpers.getPrice;
import framework.pages.MainPage;
import framework.pages.components.ProductComponent;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class CheckPopularProductsTest extends BaseTest{

  MainPage mainPage = new MainPage();

  @Test
  public void checkProductsNamePriceQuantity() {
    List<ProductComponent> products = mainPage.getProductsFromProductsSection();

    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(products.size())
        .as("8 products should be on the page")
        .isEqualTo(8);
    for (ProductComponent product : products) {

      softAssertions.assertThat(product.getName())
          .as("Every product should have name")
          .isNotNull();

      softAssertions.assertThat(product.getPrice())
          .as("Every product should have price")
          .isNotNull();

      softAssertions.assertThat(getPrice(product.getPrice()))
          .as("All prices should be bigger than 0.00")
          .isGreaterThan(0.00);
    }
    softAssertions.assertAll();
  }
}



