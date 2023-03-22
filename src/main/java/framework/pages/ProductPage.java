package framework.pages;

import java.util.List;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


@Log4j2
public class ProductPage extends BasePage {

  private final By sortByDropDownLocator = By.xpath
      ("//button[@class='btn-unstyle select-title']");
  private final By sortByDropdownItemsLocator = By.xpath
      ("//div[@class='dropdown-menu']/a");
  private final By dropdownAZItemsLocator = By.xpath
      ("//div[@class='dropdown-menu']/a[3]");
  private final By dropdownZAItemsLocator = By.xpath
      ("//div[@class='dropdown-menu']/a[4]");
  private final By dropdownLHItemsLocator = By.xpath
      ("//div[@class='dropdown-menu']/a[5]");
  private final By dropdownHLItemsLocator = By.xpath
      ("//div[@class='dropdown-menu']/a[6]");
  private final By spinnerLocator = By.xpath("//span[@class='spinner']");


  public ProductPage clickSortByDropDown() {
    waitUntilElementClickable(sortByDropDownLocator, 10).click();
    return this;
  }

  public ProductPage clickOnCategory(String name) {
    List<WebElement> dropDownItems = findAll(sortByDropdownItemsLocator);
    for (WebElement e : dropDownItems) {
      if (e.getText().equals(name)) {
        e.click();
        BasePage.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(spinnerLocator));
        return this;
      }
    }
    return this;
  }

  public ProductPage selectAZSortByDropDown() {
    waitUntilElementClickable(dropdownAZItemsLocator, 10).click();
    return this;
  }

  public ProductPage selectZASortByDropDown() {
    waitUntilElementClickable(dropdownZAItemsLocator, 10).click();
    return this;
  }

  public ProductPage selectLHSortByDropDown() {
    waitUntilElementClickable(dropdownLHItemsLocator, 10).click();
    return this;
  }

  public ProductPage selectHLSortByDropDown() {
    waitUntilElementClickable(dropdownHLItemsLocator, 10).click();
    return this;
  }

}
