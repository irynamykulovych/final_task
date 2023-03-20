package framework.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class AcceptProductPage extends BasePage{

  private final By productSuccessfullyTitleLocator = By.id("myModalLabel");
  private final By paperTypeLocator = By.xpath("//strong[text()=' Doted']");
  private final By quantityLocator = By.xpath("//strong[text()='5']");
  private final By continueShoppingButtonLocator = By.xpath
      ("//button[@class='btn btn-secondary']");
  private final By proceedToCheckoutButtonLocator = By.xpath
      ("//a[text()='Proceed to checkout']");

  @Step("Get [Product successfully added to your shopping cart] title")
  public String getProductSuccessfullyTitle() {
    return waitUntilElementClickable(productSuccessfullyTitleLocator, 10).getText();
  }
  @Step("Get [Paper Type]")
  public AcceptProductPage getPaperType() {
    waitUntilElementClickable(paperTypeLocator, 10).getText();
    return this;
  }
  @Step("Get [Quantity]")
  public AcceptProductPage getQuantity() {
    waitUntilElementClickable(quantityLocator, 10).getText();
    return this;
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

}