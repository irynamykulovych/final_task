package ui;

import framework.pages.AcceptProductPage;
import framework.pages.MainPage;
import framework.pages.PricesDropPage;
import framework.pages.ProductDetailsPage;
import framework.pages.ProductPage;
import framework.pages.SearchResultPage;
import framework.pages.ShoppingCartPage;

import framework.pages.helpers.Helpers;
import java.math.BigDecimal;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class CheckoutEndToEndTest extends BaseTest {

  MainPage mainPage = new MainPage();
  ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
  ProductDetailsPage productDetailsPage = new ProductDetailsPage();

  @Test
  public void checkEndToEndTest() {
    mainPage.enterProductName("Mug")
        .clickCustomizableMug()
        .enterProductCustomizationText("Best mug ever")
        .clickSaveCustomizationButton();

    String customizableMugPrice = productDetailsPage.getPrice();

    productDetailsPage.clickAddToCartButton()
        .clickContinueShoppingButton()
        .enterSearchProductName("T-Shirt")
        .clickHummingbirdPrintedTShirt()
        .selectColor();

    String tShirtPrice = productDetailsPage.getPrice();

    productDetailsPage.clickAddToCartButton()
        .clickProceedToCheckoutButton();

    String totalPrice = shoppingCartPage.getTotalPrice();
    String actualTotalPrice = String.valueOf(
        Helpers.convertStringPriceToDouble(customizableMugPrice)
            +Helpers.convertStringPriceToDouble(tShirtPrice));
    String expectedTotalPrice = String.valueOf(Helpers.convertStringPriceToDouble(totalPrice));

        SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(actualTotalPrice)
        .as("Total price is not equals expected")
        .isEqualTo(expectedTotalPrice);

    shoppingCartPage.clickProceedToCheckoutButton()
        .clickSocialTitleMr()
        .enterFirstName(Helpers.generateValidFirstName())
        .enterLastName(Helpers.generateValidLastName())
        .enterEmail(Helpers.generateValidEmail())
        .enterBirthdate(Helpers.generateBirthdate())
        .checkCheckboxPrivacy()
        .checkCheckboxTerms()
        .clickContinueButton()
        .enterAddress(Helpers.generateAddress())
        .enterZipCode(Helpers.generatePostalCode())
        .enterCity(Helpers.generateCity())
        .clickContinueConfirmAddressButton()
        .clickShippingMethodMyCarrier()
        .clickConfirmDeliveryButton()
        .clickPayByCheckPayment();

    String subtotalPrice = shoppingCartPage.getSubtotalPrice();
    String shippingPrice = shoppingCartPage.getShippingPrice();
    String newTotalPrice = shoppingCartPage.getTotalPrice();
    String expectedNewTotalPrice = String.valueOf(
        Helpers.convertStringPriceToDouble(subtotalPrice)
            +Helpers.convertStringPriceToDouble(shippingPrice));

    softAssertions.assertThat(expectedNewTotalPrice)
        .as("Total price is not equals expected")
        .isEqualTo(Helpers.convertStringPriceToDouble(newTotalPrice));

    softAssertions.assertAll();
  }

}
