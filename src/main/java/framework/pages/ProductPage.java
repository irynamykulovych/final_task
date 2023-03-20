package framework.pages;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;


@Log4j2
public class ProductPage extends BasePage {

  private final By sortByDropDownLocator = By.xpath
      ("//button[@class='btn-unstyle select-title']");
  private final By dropdownAZItemsLocator = By.xpath
      ("//div[@class='dropdown-menu']/a[3]");
  private final By dropdownZAItemsLocator = By.xpath
      ("//div[@class='dropdown-menu']/a[4]");
  private final By dropdownLHItemsLocator = By.xpath
      ("//div[@class='dropdown-menu']/a[5]");
  private final By dropdownHLItemsLocator = By.xpath
      ("//div[@class='dropdown-menu']/a[6]");


  @SneakyThrows
  public ProductPage clickSortByDropDown() {
    Thread.sleep(5000);
    waitUntilElementClickable(sortByDropDownLocator, 10).click();
    return this;
  }

  @SneakyThrows
  public ProductPage selectAZSortByDropDown() {
    Thread.sleep(5000);
    waitUntilElementClickable(dropdownAZItemsLocator, 10).click();
    return this;
  }

  @SneakyThrows
  public ProductPage selectZASortByDropDown() {
    Thread.sleep(5000);
    waitUntilElementClickable(dropdownZAItemsLocator, 10).click();
    return this;
  }

  @SneakyThrows
  public ProductPage selectLHSortByDropDown() {
    Thread.sleep(5000);
    waitUntilElementClickable(dropdownLHItemsLocator, 10).click();
    return this;
  }

  @SneakyThrows
  public ProductPage selectHLSortByDropDown() {
    Thread.sleep(5000);
    waitUntilElementClickable(dropdownHLItemsLocator, 10).click();
    return this;
  }

}
