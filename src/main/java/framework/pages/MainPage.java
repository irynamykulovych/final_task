package framework.pages;

import framework.pages.components.MenuCategory;
import framework.pages.components.ProductComponent;
import io.qameta.allure.Step;
import java.util.ArrayList;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class MainPage extends BasePage {

  private final By textNearTheEmailFieldLocator = By.id("block-newsletter-label");
  private final By textUnderEmailFieldLocator = By.xpath("//div[@class='col-xs-12']/p");
  private final By subscribeButtonLocator = By.xpath("//input[@value='Subscribe']");
  private final By dropDownLanguageMenuButtonLocator = By.xpath(
      "//ul[@class='dropdown-menu hidden-sm-down']//li");
  private final By loaderLocator = By.id("loadingMessage");
  private final By languageButtonLocator = By.xpath("//span[@class='expand-more']");
  private final By ukraineLanguageLocator = By.xpath("//a[text()='Українська']");
  private final By allProductsButtonLocator = By.xpath(
      "//a[@class='all-product-link float-xs-left float-md-right h4']");
  private final By signInButtonLocator = By.xpath("//span[text()='Sign in']");
  private final By accountNameLocator = By.xpath("//a[@class='account']/span");
  private final By searchFieldLocator = By.xpath(
      "//input[@placeholder='Search our catalog']");
  private final By productContainer = By.xpath(
      "//article[contains(@class,'product-miniature')]");
  private final By priceDropLinkLocator = By.id("link-product-page-prices-drop-1");


  @Step("Get [text] near the email field")
  public String getTextNearTheEmailField() {
    log.info("Get [text] near the email field");
    return waitUntilElementPresence(textNearTheEmailFieldLocator, 10).getText();
  }

  @Step("Get [text] under email field")
  public String getTextUnderEmailField() {
    log.info("Get [text] under email field");
    return waitUntilElementPresence(textUnderEmailFieldLocator, 5).getText();
  }

  @Step("Wait for loader hide")
  public void waitForPageLoad() {
    log.info("Wait for loader hide");
    WebElement loader = find(loaderLocator);
    BasePage.getWaiter().until(ExpectedConditions.invisibilityOf(loader));
  }

  @Step("Check that characters on [SUBSCRIBE] button in uppercase")
  public String checkThatCharactersOnSubscribeButtonInUpperCase() {
    log.info("Check that characters on [SUBSCRIBE] button in uppercase");
    return find(subscribeButtonLocator).getCssValue("text-transform");
  }

  @Step("Find [Ukraine language] in drop-down menu")
  public String findUkraineLanguageInDropDownMenu() {
    return find(ukraineLanguageLocator).getText();
  }

  @Step("Click on [language] button")
  public void clickOnLanguageButton() {
    log.info("Click on [language] button");
    waitUntilElementClickable(languageButtonLocator, 10).click();
  }

  @Step("Get all [language] from drop-down menu")
  public List<WebElement> getAllLanguageFromDropDownMenu() {
    return findAll(dropDownLanguageMenuButtonLocator);
  }

  @Getter
  private final MenuCategory menuCategory;

  public MainPage() {
    menuCategory = new MenuCategory();
  }


  @Step("Click on [All products] button")
  public ProductPage clickOnAllProductsButton() {
    waitUntilElementClickable(allProductsButtonLocator, 10).click();
    return new ProductPage();
  }

  @Step("Click on [sign in] button")
  public LoginPage clickOnSignInButton() {
    waitUntilElementClickable(signInButtonLocator, 20).click();
    return new LoginPage();
  }

  @Step("Check account name")
  public String checkAccountName() {
    return waitUntilElementPresence(accountNameLocator, 10).getText();
  }

  @Step("Enter product name in [search] field")
  public SearchResultPage enterProductName(String ProductName) {
    waitUntilElementPresence(searchFieldLocator, 20).sendKeys(ProductName);
    log.info("Tap enter");
    find(searchFieldLocator).sendKeys(Keys.ENTER);
    return new SearchResultPage();
  }

  public List<ProductComponent> getProductsFromProductsSection() {
    waitUntilElementPresence(productContainer, 10);
    List<ProductComponent> products = new ArrayList<>();
    List<WebElement> containers = findAll(productContainer);
    for (WebElement container : containers) {
      ProductComponent productModel = new ProductComponent(container);
      products.add(productModel);
    }
    return products;
  }

  @Step("Click on 'Price drop' link")
  public ProductPage clickOnPriceDropLink() {
    waitUntilElementPresence(priceDropLinkLocator, 10).click();
    return new ProductPage();
  }


}



