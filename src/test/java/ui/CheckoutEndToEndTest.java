package ui;

import framework.pages.MainPage;
import framework.pages.OrderConfirmationPage;
import framework.pages.ProductDetailsPage;
import framework.pages.RegistrationPage;
import framework.pages.ShoppingCartPage;
import framework.pages.helpers.Helpers;
import java.math.BigDecimal;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class CheckoutEndToEndTest extends BaseTest {

  MainPage mainPage = new MainPage();
  ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
  ProductDetailsPage productDetailsPage = new ProductDetailsPage();
  RegistrationPage registrationPage = new RegistrationPage();
  OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage();

  @Test
  public void checkEndToEndTest() {
    mainPage.enterProductName("Mug")
        .clickCustomizableMug()
        .enterProductCustomizationText("Best mug ever")
        .clickSaveCustomizationButton();

    String customizableMugPriceStr = productDetailsPage.getPrice();

    productDetailsPage.clickAddToCartButton()
        .clickContinueShoppingButton()
        .enterSearchProductName("T-Shirt")
        .clickHummingbirdPrintedTShirt()
        .selectColor();

    String tShirtPriceStr = productDetailsPage.getPrice();

    productDetailsPage.clickAddToCartButton()
        .clickProceedToCheckoutButton();

    String totalPriceStr = shoppingCartPage.getTotalPrice();

    BigDecimal customizableMug = new BigDecimal(customizableMugPriceStr);
    BigDecimal tShirtPrice = new BigDecimal(tShirtPriceStr);
    BigDecimal actualTotalPrice = new BigDecimal(totalPriceStr);
    BigDecimal expectedTotalPrice = customizableMug.add(tShirtPrice);

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

    String subtotalPriceStr = shoppingCartPage.getSubtotalPrice();
    String shippingPriceStr = shoppingCartPage.getShippingPrice();
    String newTotalPriceStr = shoppingCartPage.getTotalPrice();

    BigDecimal subtotalPrice = new BigDecimal(subtotalPriceStr);
    BigDecimal shippingPrice = new BigDecimal(shippingPriceStr);
    BigDecimal actualNewTotalPrice = new BigDecimal(newTotalPriceStr);
    BigDecimal expectedNewTotalPrice = subtotalPrice.add(shippingPrice);

    softAssertions.assertThat(actualNewTotalPrice)
        .as("Total price is not equals expected")
        .isEqualTo(expectedNewTotalPrice);

    registrationPage.clickTermsCheckbox()
        .clickPlaceOrderButton();

    String actualTitle = String.valueOf(orderConfirmationPage.getOrderConfirmationTitle());
    String exceptedTitle = "\uE876" + "YOUR ORDER IS CONFIRMED";

    softAssertions.assertThat(actualTitle)
        .as("We expected that the title should be: "
            + "[Your order is confirmed]")
        .isEqualTo(exceptedTitle);

//    String lastSubtotalPrice = orderConfirmationPage.getLastSubtotalPrice();
//    String lastShippingPrice = orderConfirmationPage.getLastShippingPrice();
//    String lastTotalPrice = orderConfirmationPage.getLastTotalPrice();
//    String expectedLastTotalPrice = String.valueOf(
//        Helpers.convertStringPriceToDouble(lastSubtotalPrice)
//            +Helpers.convertStringPriceToDouble(lastShippingPrice));
//
//    softAssertions.assertThat(expectedLastTotalPrice)
//        .as("Total price is not equals expected")
//        .isEqualTo(Helpers.convertStringPriceToDouble(lastTotalPrice));

    String lastSubtotalPriceStr = orderConfirmationPage.getLastSubtotalPrice();
    String lastShippingPriceStr = orderConfirmationPage.getLastShippingPrice();
    String lastTotalPriceStr = orderConfirmationPage.getLastTotalPrice();

    BigDecimal lastSubtotalPrice = new BigDecimal(lastSubtotalPriceStr);
    BigDecimal lastShippingPrice = new BigDecimal(lastShippingPriceStr);
    BigDecimal actualLastTotalPrice = new BigDecimal(lastTotalPriceStr);
    BigDecimal expectedLastTotalPrice = lastSubtotalPrice.add(lastShippingPrice);

    softAssertions.assertThat(actualLastTotalPrice)
        .as("Total price is not equals expected")
        .isEqualTo(expectedLastTotalPrice);

    softAssertions.assertAll();
  }

}
