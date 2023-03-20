package framework.pages.components;

import framework.pages.BasePage;
import framework.pages.ProductPage;
import lombok.Data;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Data
public class ProductComponent extends BasePage {

  private String name;
  private String price;
  private WebElement nameWe;


  public ProductComponent(WebElement container) {
    this.name = container.findElement(By.xpath(".//*[@class='h3 product-title']"))
        .getText();
    this.price = container.findElement(By.xpath(".//div//span[@class='price']"))
        .getText();
    this.nameWe = container;
    this.name = nameWe.getText();
  }

  @Data
  public static class PriceOfDropProductModel {

    private String newPrice;
    private String oldPrice;
    private String discount;

    public PriceOfDropProductModel(WebElement container) {

      this.newPrice = container.findElement(By.xpath(
          ".//div//span[@class='price']")).getText();
      this.oldPrice = container.findElement(By.xpath(
          ".//div//span[@class='regular-price']"))
          .getText();
      this.discount = container.findElement(By.xpath(
          ".//li[@class='product-flag discount']"))
          .getText();
    }

//    @SneakyThrows
//    public double getDiscountFromProducts() {
//      Thread.sleep(5000);
//      double oldPrice = getPrice(this.oldPrice);
//      DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
//
//      DecimalFormat df = new DecimalFormat("##.##", symbols);
//
//      df.setRoundingMode(RoundingMode.CEILING);
//      double result = (oldPrice / 100) * Integer.valueOf(this.discount.replaceAll("\\D", ""));
//      return Double.valueOf(df.format(result));
//    }

  }





}