package framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class OrderConfirmationPage extends BasePage {
  private final By orderConfirmationLocator = By.xpath("//h3[@class='h1 card-title']");
  private final By lastTotalPriceLocator = By.xpath
      ("//tr[@class='total-value font-weight-bold']/td[2]");
  private final By lastSubtotalPriceLocator = By.xpath
      ("//tr/td[2]");
  private final By lastShippingPriceLocator = By.xpath
      ("//div[@class='order-confirmation-table']//tr[2]/td[2]");


  @Step("Get [Your order is confirmed] title")
  public String getOrderConfirmationTitle() {
    return waitUntilElementClickable(orderConfirmationLocator, 10).getText();
  }

  public String getLastTotalPrice() {
    return find(lastTotalPriceLocator).getText();
  }

  public String getLastSubtotalPrice() {
    return find(lastSubtotalPriceLocator).getText();
  }

  public String getLastShippingPrice() {
    return find(lastShippingPriceLocator).getText();
  }

}
