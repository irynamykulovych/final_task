package framework.pages.helpers;

import com.github.javafaker.Faker;
import framework.pages.BasePage;
import framework.pages.components.ProductComponent;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class Helpers {

  private static final By productContainerLocator = By.xpath(
      "//div[@class='products row']/div");
  private static Faker faker = new Faker();
  public static String generateValidFirstName() {
    return faker.name().firstName();
  }
  public static String generateValidLastName() {
    return faker.name().lastName();
  }
  public static String generateValidEmail() {
    return faker.internet().emailAddress();
  }
  public static String generateValidPassword() {
    return faker.internet().password();
  }
  public static String generateBirthdate() {
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    return sdf.format(faker.date().birthday());
  }
  public static String generateAddress() {
    return faker.address().fullAddress();
  }
  public static String generatePostalCode() {
    return faker.address().zipCode().substring(0, 5);
  }
  public static String generateCity() {
    return faker.address().cityName();
  }

  @Attachment(value = "{fileName}", type = "image/png")
  public static byte[] takeScreenShot(String fileName) {
    return ((TakesScreenshot) BasePage.getWebDriver()).getScreenshotAs(OutputType.BYTES);
  }

  @SneakyThrows
  @Step("Get all products")
  public static List<ProductComponent> getAllProducts() {
    Thread.sleep(5000);
    List<WebElement> webElementList = BasePage.findAll(productContainerLocator);
    List<ProductComponent> result = new ArrayList<>();
    for (WebElement element : webElementList) {
      result.add(new ProductComponent(element));
    }
    return result;
  }

  public static List<BigDecimal> getOldProductPrices(List<ProductComponent> products) {
    List<BigDecimal> oldProductPrices = new ArrayList<>();
    for (ProductComponent productComponent : products) {
      oldProductPrices.add(productComponent.getOldPrice());
    }
    return oldProductPrices;
  }

  public static List<BigDecimal> getNewProductPrices(List<ProductComponent> products) {
    List<BigDecimal> newProductPrices = new ArrayList<>();
    for (ProductComponent productComponent : products) {
      newProductPrices.add(productComponent.getOldPrice());
    }
    return newProductPrices;
  }

  public static List<BigDecimal> getSortedProductPrices(List<ProductComponent> productComponents) {
    List<BigDecimal> result = new ArrayList<>();
    for (ProductComponent productComponent : productComponents) {
      if (productComponent.getOldPrice() != null) {
        result.add(productComponent.getOldPrice());
      } else {
        result.add(productComponent.getPrice());
      }
    }
    return result;
  }

  public static BigDecimal getDiscountFromProducts(BigDecimal oldPrice, int discount) {
    return oldPrice.multiply(new BigDecimal(100 - discount))
        .divide(new BigDecimal(100))
        .setScale(2, BigDecimal.ROUND_HALF_DOWN);
  }

  public static List<BigDecimal> getCalculatedDiscount(List<ProductComponent> products) {
    List<BigDecimal> result = new ArrayList<>();
    for (ProductComponent productComponent : products) {
      result.add(getDiscountFromProducts(
          productComponent.getOldPrice(),
          productComponent.getDiscountValue()
      ));
    }
    return result;
  }

  public static List<String> getNamesFromProducts(List<ProductComponent> products) {
    List<String> productNames = new ArrayList<>();
    for (ProductComponent product : products) {
      productNames.add(product.getName());
    }
    return productNames;
  }

  public static List<BigDecimal> getProductPrices(List<ProductComponent> productComponents) {
    List<BigDecimal> result = new ArrayList<>();
    for (ProductComponent productComponent : productComponents) {
      result.add(productComponent.getPrice());
    }
    return result;
  }

}



