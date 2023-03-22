package ui;

import static framework.pages.BasePage.getWebDriver;

import framework.pages.BasePage;
import framework.pages.BrowserFactory;
import framework.pages.BrowserFactory.Browsers;
import framework.pages.MainPage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@Log4j2
public class BaseTest {


  @BeforeMethod(alwaysRun = true)
  public synchronized void setUp() {

    int width = Integer.parseInt(System.getProperty("browser.width"));
    int height = Integer.parseInt(System.getProperty("browser.height"));
    String browser = System.getProperty("browser.type");

    log.info("Tests will run at {}x{}", width, height);

    WebDriver driver = BrowserFactory.getBrowser(Browsers.valueOf(browser));

    driver.get("https://demo.prestashop.com/");
    driver.manage().window().setSize(new Dimension(width, height));
    BasePage.setDriverThreadLocal(driver);
    MainPage mainPage = new MainPage();
    mainPage.waitForPageLoad();
    getWebDriver().switchTo().frame("framelive");
  }

  @AfterMethod(alwaysRun = true)
  public void quite() {
    if (BasePage.getDriverThreadLocal() != null) {
      getWebDriver().quit();
      BasePage.getDriverThreadLocal().remove();
    }
  }
}
