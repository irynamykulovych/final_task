package framework.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class SearchResultPage extends BasePage {

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

  @Step("Click on [Customizable Mug]")
  public ProductDetailsPage clickCustomizableMug() {
    log.info("Click on [Customizable Mug]");
    BasePage.getWaiter()
        .until(ExpectedConditions.visibilityOfElementLocated(customizableMugLocator));
    find(customizableMugLocator).click();
    return new ProductDetailsPage();
  }

  @Step("Click on [Hummingbird Printed T-Shirt]")
  public ProductDetailsPage clickHummingbirdPrintedTShirt() {
    log.info("Click on [Hummingbird Printed T-Shirt]");
    BasePage.getWaiter()
        .until(ExpectedConditions.visibilityOfElementLocated(hummingbirdPrintedTShirtLocator));
    find(hummingbirdPrintedTShirtLocator).click();
    return new ProductDetailsPage();
  }


}
