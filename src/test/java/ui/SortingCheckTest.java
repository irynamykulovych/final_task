package ui;

import framework.pages.MainPage;
import framework.pages.ProductPage;
import framework.pages.components.ProductComponent;
import framework.pages.helpers.Category;
import framework.pages.helpers.Helpers;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class SortingCheckTest extends BaseTest {

  MainPage mainPage = new MainPage();
  ProductPage productPage = new ProductPage();

  @Test
  public void checkThatProductSortedCorrectly() {

    mainPage.clickOnAllProductsButton()
        .clickSortByDropDown().clickOnCategory(Category.BY_NAME_A_Z.getOption());

    List<ProductComponent> products = Helpers.getAllProducts();
    List<String> expectedProductNames = Helpers.getNamesFromProducts(products);
    expectedProductNames.sort(Comparator.comparing(String::toLowerCase));


    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(Helpers.getNamesFromProducts(products))
        .as("Product list is not sorted correctly")
        .containsExactlyElementsOf(expectedProductNames);

    productPage.clickSortByDropDown().clickOnCategory(Category.BY_NAME_Z_A.getOption());
    products = Helpers.getAllProducts();
    expectedProductNames = Helpers.getNamesFromProducts(products);
    expectedProductNames.sort(Collections.reverseOrder());
    products = Helpers.getAllProducts();

    softAssertions.assertThat(Helpers.getNamesFromProducts(products))
        .as("Product list is not sorted correctly")
        .containsExactlyElementsOf(expectedProductNames);

    productPage.clickSortByDropDown().clickOnCategory(Category.BY_PRICE_LOW_HIGH.getOption());
    products = Helpers.getAllProducts();
    List<BigDecimal> expectedProductPrice = Helpers.getSortedProductPrices(products);
    expectedProductPrice.sort(Comparator.comparing(BigDecimal::doubleValue));
    softAssertions.assertThat(Helpers.getSortedProductPrices(products))
        .as("Product list is not sorted correctly")
        .containsExactlyElementsOf(expectedProductPrice);

    productPage.clickSortByDropDown().clickOnCategory(Category.BY_PRICE_HIGH_LOW.getOption());
    products = Helpers.getAllProducts();
    expectedProductPrice = Helpers.getSortedProductPrices(products);
    expectedProductPrice.sort(Collections.reverseOrder());

    softAssertions.assertThat(Helpers.getSortedProductPrices(products))
        .as("Product list is not sorted correctly")
        .containsExactlyElementsOf(expectedProductPrice);

    softAssertions.assertAll();
  }
}
