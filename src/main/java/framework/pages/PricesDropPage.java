package framework.pages;

import static framework.pages.helpers.Helpers.getPrice;

import framework.pages.components.ProductComponent;
import framework.pages.components.ProductComponent.PriceOfDropProductModel;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PricesDropPage  extends BasePage {
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