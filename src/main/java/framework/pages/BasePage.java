package framework.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@Log4j2
public class BasePage {

  private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

  public static ThreadLocal<WebDriver> getDriverThreadLocal() {
    return DRIVER_THREAD_LOCAL;
  }

  public static void setDriverThreadLocal(WebDriver driver) {
    DRIVER_THREAD_LOCAL.set(driver);
  }

  public static WebDriver getWebDriver() {
    return getDriverThreadLocal().get();
  }

  public static WebElement find(By locator) {
    return getWebDriver().findElement(locator);
  }

  public static List<WebElement> findAll(By locator) {
    return getWebDriver().findElements(locator);
  }


  public void clickOnLocator(By locator) {
    WebElement element = find(locator);
    JavascriptExecutor executor = (JavascriptExecutor) getWebDriver();
    executor.executeScript("arguments[0].click()", element);
  }

  public static WebDriverWait getWaiter() {
    return new WebDriverWait(BasePage.getWebDriver(), Duration.ofSeconds(20));
  }

  protected static WebElement waitUntilElementPresence(By locator, int seconds) {
    log.info("Wait for [{}] seconds until [{}] element will be presence", seconds, locator);
    return new WebDriverWait(getWebDriver(), Duration.ofSeconds(seconds))
        .until(ExpectedConditions.presenceOfElementLocated(locator));
  }

  protected WebElement waitUntilVisible(By locator, int seconds) {
    log.info("Wait for [{}] seconds until [{}] element will be visible", seconds, locator);
    return new WebDriverWait(getWebDriver(), Duration.ofSeconds(seconds))
        .until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  protected WebElement waitUntilElementClickable(By locator, int seconds) {
    log.info("Wait for [{}] seconds until [{}] element will be clickable", seconds, locator);
    return new WebDriverWait(getWebDriver(), Duration.ofSeconds(seconds))
        .until(ExpectedConditions.elementToBeClickable(locator));
  }

  public static boolean isElementPresent(By locator) {
    try {
      getWebDriver().findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

}
