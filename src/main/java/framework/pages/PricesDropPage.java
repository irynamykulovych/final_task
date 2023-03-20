package framework.pages;

import framework.pages.components.ProductComponent.PriceOfDropProductModel;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PricesDropPage extends BasePage {
  private final By productContainerFromPriceDropPage = By.className("reviews-loaded");

  public List<PriceOfDropProductModel> getProductsFromPriceDropPage() {
    waitUntilElementPresence(productContainerFromPriceDropPage, 10);
    List<PriceOfDropProductModel> products = new ArrayList<>();
    List<WebElement> containers = findAll(productContainerFromPriceDropPage);
    for (WebElement container : containers) {
      products.add(new PriceOfDropProductModel(container));
    }
    return products;
  }

}