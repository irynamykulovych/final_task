package framework.pages;

import io.qameta.allure.Step;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class ProductDetailsPage extends BasePage {

  private final By quantityLocator = By.id("quantity_wanted");
  private final By addToCartButtonLocator = By.xpath
      ("//button[@class='btn btn-primary add-to-cart']");
  private final By saveCustomizationButtonLocator = By.xpath
      ("//button[text()='Save Customization']");
  private final By priceLocator = By.xpath("//span[@class='current-price-value']");
  private final By paperTypeDropDownLocator = By.id("group_4");
  private final By productCustomizationFieldLocator = By.xpath
      ("//textarea[@placeholder='Your message here']");
  private final By searchFieldProductLocator = By.xpath(
      "//input[@placeholder='Search our catalog']");
  private final By selectColorLocator = By.xpath(
      "//input[@title='Black']");


  @SneakyThrows
  @Step("Select [Doter] paper type")
  public ProductDetailsPage selectDoterPaperType() {
    Thread.sleep(5000);
    Select select = new Select(find(paperTypeDropDownLocator));
    select.selectByVisibleText("Doted");
    return this;
  }

  public ProductDetailsPage changeQuantity(String value) {
    WebElement quantityInput = find(quantityLocator);
    String currentValue = quantityInput.getAttribute("value");
    if (!currentValue.isEmpty()) {
      quantityInput.clear();
    }
    quantityInput.sendKeys(value);
    return this;
  }

  @Step("Enter [Best mug ever] in [Product customization] field")
  public ProductDetailsPage enterProductCustomizationText(String text) {
    waitUntilElementPresence(productCustomizationFieldLocator, 20).sendKeys(text);
    log.info("Tap enter");
    find(productCustomizationFieldLocator).sendKeys(Keys.ENTER);
    return this;
  }

  @Step("Click on [SAVE CUSTOMIZATION] button")
  public ProductDetailsPage clickSaveCustomizationButton() {
    log.info("Click on [SAVE CUSTOMIZATION] button");
    waitUntilElementClickable(saveCustomizationButtonLocator, 10).click();
    return this;
  }

  public String getPrice() {
    return find(priceLocator).getText();
  }

  @Step("Click [ADD TO CART] button")
  public AcceptProductPage clickAddToCartButton() {
    waitUntilElementClickable(addToCartButtonLocator, 20).click();
    return new AcceptProductPage();
  }

  @SneakyThrows
  @Step("Enter product name in [search] field")
  public SearchResultPage enterSearchProductName(String ProductName) {
    Thread.sleep(5000);
    waitUntilElementPresence(searchFieldProductLocator, 50).sendKeys(ProductName);
    log.info("Tap enter");
    find(searchFieldProductLocator).sendKeys(Keys.ENTER);
    return new SearchResultPage();
  }

  @SneakyThrows
  @Step("Select [Black] color")
  public ProductDetailsPage selectColor() {
    Thread.sleep(5000);
    find(selectColorLocator).click();
    return this;
  }

}
