package framework.pages.helpers;

import com.github.javafaker.Faker;
import framework.pages.BasePage;
import framework.pages.components.ProductComponent;
import io.qameta.allure.Attachment;
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

  public static double getPrice(String value) {
    return Double.valueOf(value.replace("€", ""));
  }

  public static Double convertStringPriceToDouble(String value) {
    String priceStr = value.replaceAll("[^\\d.]", "");
    return Double.parseDouble(priceStr);
  }

  @SneakyThrows
  public static List<ProductComponent> getAllProducts() {
    Thread.sleep(5000);
    List<ProductComponent> products = new ArrayList<>();
    List<WebElement> containers = BasePage.findAll(productContainerLocator);
    for (WebElement container : containers) {
      ProductComponent productComponent = new ProductComponent(container);
      products.add(productComponent);
    }
    return products;
  }

  public static List<String> getNamesFromProducts(List<ProductComponent> products) {
    List<String> productNames = new ArrayList<>();
    for (ProductComponent product : products) {
      productNames.add(product.getName());
    }
    return productNames;
  }

  public static List<Double> getProductNewPrices(List<ProductComponent> products) {

    List<String> pricesAsString = new ArrayList<>();
    for (ProductComponent product : products) {
      pricesAsString.add(product.getPrice());
    }

    List<Double> pricesAsDouble = new ArrayList<>();
    for (String price : pricesAsString) {
      pricesAsDouble.add(Double.parseDouble(price.replace("€", "")
          .replace(",", "")));
    }
    return pricesAsDouble;
  }

}



