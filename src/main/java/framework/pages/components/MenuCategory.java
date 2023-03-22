package framework.pages.components;

import static framework.pages.BasePage.find;
import static framework.pages.BasePage.getWebDriver;
import static framework.pages.BasePage.isElementPresent;

import framework.pages.helpers.MainCategory;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MenuCategory {

  public final By subMenuValueLocator = By.xpath
      (".//li[@class='category']/a");
  private final By clothesMenuLocator = By.id("category-3");
  private final By accessoriesMenuLocator = By.id("category-6");
  private final By artMenuLocator = By.id("category-9");
  private final By subMenuArtLocator = By.xpath
      ("//li[@id='category-9']//div[@class='popover " +
          "sub-menu " +
          "js-sub-menu collapse']");
  private List<WebElement> subMenuElements;

  @Step("Hover over element")
  public void hoverOverElement(MainCategory mainCategory) {
    switch (mainCategory) {
      case CLOTHES:
        this.subMenuElements = find(clothesMenuLocator).findElements(subMenuValueLocator);
        hoverOverElement(clothesMenuLocator);
        break;
      case ACCESSORIES:
        this.subMenuElements = find(accessoriesMenuLocator).findElements(subMenuValueLocator);
        hoverOverElement(accessoriesMenuLocator);
        break;
      case ART:
        this.subMenuElements = find(artMenuLocator).findElements(subMenuValueLocator);
        hoverOverElement(artMenuLocator);
        break;

      default:
        throw new IllegalStateException("Unexpected value: " + mainCategory);
    }
  }

  private void hoverOverElement(By locator) {
    WebElement webElement = getWebDriver().findElement(locator);
    Actions action = new Actions(getWebDriver());
    action.moveToElement(webElement).perform();
  }

  public boolean isArtSubMenuVisible() {
    return isElementPresent(subMenuArtLocator);
  }

  public List<String> getSubMenuNames() {
    List<String> list = new ArrayList<>();
    for (WebElement element : subMenuElements) {
      list.add(element.getText());
    }
    return list;
  }
}