package framework.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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


  @Step("Select [Doter] paper type")
  public ProductDetailsPage selectDoterPaperType() {
    Select select = new Select(find(paperTypeDropDownLocator));
    select.selectByVisibleText("Doted");
    return this;
  }

  public ProductDetailsPage changeQuantityToFive() {
    WebElement quantityInput = find(quantityLocator);
    quantityInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), "5");
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
    return find(priceLocator).getText()
        .replaceAll("[^\\d.]", "");
  }

  @Step("Click [ADD TO CART] button")
  public AcceptProductPage clickAddToCartButton() {
    waitUntilElementClickable(addToCartButtonLocator, 20).click();
    return new AcceptProductPage();
  }

  @Step("Enter product name in [search] field")
  public SearchResultPage enterSearchProductName(String ProductName) {
    BasePage.getWaiter()
        .until(ExpectedConditions.visibilityOfElementLocated(searchFieldProductLocator));
    waitUntilElementPresence(searchFieldProductLocator, 70).sendKeys(ProductName);
    log.info("Tap enter");
    find(searchFieldProductLocator).sendKeys(Keys.ENTER);
    return new SearchResultPage();
  }

  @Step("Select [Black] color")
  public ProductDetailsPage selectColor() {
    find(selectColorLocator).click();
    return this;
  }

}
