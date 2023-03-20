package framework.pages;

import framework.pages.components.ProductComponent.PriceOfDropProductModel;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class ShoppingCartPage extends BasePage{

  private final By proceedToCheckoutButtonLocator = By.xpath
      ("//div[@class='checkout cart-detailed-actions "
          + "js-cart-detailed-actions card-block']//a");
  private final By totalPriceLocator = By.xpath("//div[@class="
      + "'cart-summary-line cart-total']/span[2]");
  private final By subtotalPriceLocator = By.xpath
      ("//div[@id='cart-subtotal-products']/span[2]");
  private final By shippingPriceLocator = By.xpath
      ("//div[@id='cart-subtotal-shipping']/span[2]");

  @Step("Click on [PROCEED TO CHECKOUT] button")
  public RegistrationPage clickProceedToCheckoutButton() {
    log.info("Click on [PROCEED TO CHECKOUT] button");
    waitUntilElementClickable(proceedToCheckoutButtonLocator, 50).click();
    return new RegistrationPage();
  }

  @SneakyThrows
  public String getTotalPrice() {
    Thread.sleep(5000);
    return find(totalPriceLocator).getText();
  }

  @SneakyThrows
  public String getSubtotalPrice() {
    Thread.sleep(5000);
    return find(subtotalPriceLocator).getText();
  }

  @SneakyThrows
  public String getShippingPrice() {
    Thread.sleep(5000);
    return find(shippingPriceLocator).getText();
  }
}