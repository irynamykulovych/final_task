package framework.pages;

import io.qameta.allure.Step;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class SearchResultPage extends BasePage{
  private final By brownBearNotebookLocator = By.xpath
      ("//a[text()='Brown bear notebook']");
  private final By customizableMugLocator = By.xpath
      ("//a[text()='Customizable mug']");
  private final By hummingbirdPrintedTShirtLocator = By.xpath
      ("//a[text()='Hummingbird printed t-shirt']");



  @Step("Click on [Brown Bear Notebook]")
  public ProductDetailsPage clickBrownBearNotebook() {
    log.info("Click on [Brown Bear Notebook]");
    waitUntilElementClickable(brownBearNotebookLocator, 10).click();
    return new ProductDetailsPage();
  }

  @SneakyThrows
  @Step("Click on [Customizable Mug]")
  public ProductDetailsPage clickCustomizableMug() {
    log.info("Click on [Customizable Mug]");
    Thread.sleep(5000);
    find(customizableMugLocator).click();
    return new ProductDetailsPage();
  }

  @SneakyThrows
  @Step("Click on [Hummingbird Printed T-Shirt]")
  public ProductDetailsPage clickHummingbirdPrintedTShirt() {
    log.info("Click on [Hummingbird Printed T-Shirt]");
    Thread.sleep(5000);
    find(hummingbirdPrintedTShirtLocator).click();
    return new ProductDetailsPage();
  }



}
