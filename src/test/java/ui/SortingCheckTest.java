package ui;

import framework.pages.MainPage;
import framework.pages.ProductPage;
import framework.pages.components.ProductComponent;
import framework.pages.helpers.Helpers;
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
        .clickSortByDropDown().selectAZSortByDropDown();

    List<ProductComponent> products = Helpers.getAllProducts();
    List<String> expectedProductNames = Helpers.getNamesFromProducts(products);
    expectedProductNames.sort(Comparator.comparing(String::toLowerCase));
    products = Helpers.getAllProducts();

    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(Helpers.getNamesFromProducts(products))
        .as("Product list is not sorted correctly")
        .containsExactlyElementsOf(expectedProductNames);
    softAssertions.assertAll();

    productPage.clickSortByDropDown().selectZASortByDropDown();
    products = Helpers.getAllProducts();
    expectedProductNames = Helpers.getNamesFromProducts(products);
    expectedProductNames.sort(Collections.reverseOrder());
    products = Helpers.getAllProducts();

    softAssertions.assertThat(Helpers.getNamesFromProducts(products))
        .as("Product list is not sorted correctly")
        .containsExactlyElementsOf(expectedProductNames);

    productPage.clickSortByDropDown().selectLHSortByDropDown();
    products = Helpers.getAllProducts();
    List<Double> expectedProductPrice = Helpers.getProductNewPrices(products);
    expectedProductPrice.sort(Comparator.comparing(Double::doubleValue));
    softAssertions.assertThat(Helpers.getProductNewPrices(products))
        .as("Product list is not sorted correctly")
        .containsExactlyElementsOf(expectedProductPrice);

    productPage.clickSortByDropDown().selectHLSortByDropDown();
    products = Helpers.getAllProducts();
    expectedProductPrice = Helpers.getProductNewPrices(products);
    expectedProductPrice.sort(Collections.reverseOrder());

    softAssertions.assertThat(Helpers.getProductNewPrices(products))
        .as("Product list is not sorted correctly")
        .containsExactlyElementsOf(expectedProductPrice);


    softAssertions.assertAll();
  }

}
