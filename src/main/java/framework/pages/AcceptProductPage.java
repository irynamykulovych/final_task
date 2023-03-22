package framework.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class AcceptProductPage extends BasePage{

  private final By productSuccessfullyTitleLocator = By.id("myModalLabel");
  private final By paperTypeLocator = By.xpath("//strong[text()=' Doted']");
  private final By quantityLocator = By.xpath
      ("//span[@class='product-quantity']/strong");
  private final By continueShoppingButtonLocator = By.xpath
      ("//button[@class='btn btn-secondary']");
  private final By proceedToCheckoutButtonLocator = By.xpath
      ("//a[text()='Proceed to checkout']");
  private final By onePriceLocator = By.xpath
      ("//p[@class='product-price']");
  private final By totalPriceLocator = By.xpath
      ("//span[@class='value']");


  @Step("Get [Product successfully added to your shopping cart] title")
  public String getProductSuccessfullyTitle() {
    return waitUntilElementClickable(productSuccessfullyTitleLocator, 10).getText();
  }

  @Step("Get [Paper Type]")
  public String getPaperType() {
    return waitUntilElementClickable(paperTypeLocator, 10).getText();
  }

  @Step("Get [Quantity]")
  public String getQuantity() {
    return waitUntilElementClickable(quantityLocator, 10).getText();
  }

  @Step("Click on [CONTINUE SHOPPING] button")
  public ProductDetailsPage clickContinueShoppingButton() {
    log.info("Click on [CONTINUE SHOPPING] button");
    waitUntilElementClickable(continueShoppingButtonLocator, 10).click();
    return new ProductDetailsPage();
  }

  @Step("Click on [PROCEED TO CHECKOUT] button")
  public ShoppingCartPage clickProceedToCheckoutButton() {
    log.info("Click on [PROCEED TO CHECKOUT] button");
    waitUntilElementClickable(proceedToCheckoutButtonLocator, 10).click();
    return new ShoppingCartPage();
  }

  @Step("Get one price")
  public String getOnePrice() {
    return waitUntilElementClickable(onePriceLocator, 10).getText()
        .replaceAll("[^\\d.]", "");
  }

  @Step("Get total price")
  public String getTotalPrice() {
    return waitUntilElementClickable(totalPriceLocator, 10).getText()
        .replaceAll("[^\\d.]", "");
  }

}