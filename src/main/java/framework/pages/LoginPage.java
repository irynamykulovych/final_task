package framework.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class LoginPage extends BasePage {

  private final By createAccountLocator = By.xpath(
      "//a[contains(text(),'No account?')]");

  @Step("Click on [No account? Create one here] link")
  public RegistrationPage clickCreateAccountLink() {
    waitUntilElementClickable(createAccountLocator, 10).click();
    return new RegistrationPage();
  }

}

