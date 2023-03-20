package framework.pages;

import io.qameta.allure.Step;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class RegistrationPage extends BasePage {

  private final By socialTitleMrLocator = By.id("field-id_gender-1");
  private final By firstNameFieldLocator = By.id("field-firstname");
  private final By lastNameFieldLocator = By.id("field-lastname");
  private final By emailFieldLocator = By.id("field-email");
  private final By passwordFieldLocator = By.id("field-password");
  private final By birthdateFieldLocator = By.id("field-birthday");
  private final By PrivacyCheckboxLocator = By.xpath
      ("//input[@name='customer_privacy']");
  private final By TermsCheckboxLocator = By.xpath("//input[@name='psgdpr']");
  private final By saveButtonLocator = By.xpath("//button[contains(text(),'Save')]");
  private final By colorFirstNameFrameLocator = By.xpath("//input[@value='James8']");
  private final By invalidFormatPopUpLocator = By.xpath
      ("//li[text()='Invalid format.']");
  private final By continueButtonLocator = By.xpath
      ("//form[@id='customer-form']//button[@type='submit']");
  private final By addressLocator = By.id
      ("field-address1");
  private final By zipCodeLocator = By.id("field-postcode");
  private final By cityLocator = By.id("field-city");
  private final By continueConfirmAddressButtonLocator = By.xpath
      ("//button[@name='confirm-addresses']");
  private final By shippingMethodMyCarrierLocator = By.id("delivery_option_2");
  private final By confirmDeliveryButtonLocator = By.xpath
      ("//button[@name='confirmDeliveryOption']");
  private final By payByCheckPaymentLocator = By.xpath
      ("//input[@id='payment-option-1']");
  private final By termsCheckboxLocator = By.id("conditions_to_approve[terms-and-conditions]");
  private final By placeOrderButtonLocator = By.xpath
      ("//div[@id='payment-confirmation']/div/button");

  @SneakyThrows
  @Step("Click on social title [Mr]")
  public RegistrationPage clickSocialTitleMr() {
    Thread.sleep(5000);
    find(socialTitleMrLocator).click();
    return this;
  }

  @Step("Enter first name {firstName}")
  public RegistrationPage enterFirstName(String firstName) {
    log.info("Enter first name [{}]", firstName);
    find(firstNameFieldLocator).sendKeys(firstName);
    return this;
  }

  @Step("Enter last name {lastName}")
  public RegistrationPage enterLastName(String lastName) {
    log.info("Enter last name [{}]", lastName);
    find(lastNameFieldLocator).sendKeys(lastName);
    return this;
  }

  @Step("Enter email {email}")
  public RegistrationPage enterEmail(String email) {
    log.info("Enter email [{}]", email);
    find(emailFieldLocator).sendKeys(email);
    return this;
  }

  @Step("Enter password {password}")
  public RegistrationPage enterPassword(String password) {
    find(passwordFieldLocator).sendKeys(password);
    return this;
  }

  @Step("Enter birthdate {birthdate}")
  public RegistrationPage enterBirthdate(String birthdate) {
    find(birthdateFieldLocator).sendKeys(birthdate);
    return this;
  }

  @Step("Agree with customer data privacy")
  public RegistrationPage checkCheckboxPrivacy() {
    clickOnLocator(PrivacyCheckboxLocator);
    return this;
  }

  @Step("Agree with terms and conditions")
  public RegistrationPage checkCheckboxTerms() {
    clickOnLocator(TermsCheckboxLocator);
    return this;
  }

  @Step("Click on [save] button")
  public MainPage clickSaveButton() {
    clickOnLocator(saveButtonLocator);
    return new MainPage();
  }

  @Step("Get [first name] frame color")
  public String getFirstNameFrameColor() {
    return waitUntilVisible(colorFirstNameFrameLocator, 10)
        .getCssValue("outline-color");
  }

  @Step("Get pop-up with text [Invalid format.]")
  public String getInvalidFormatPopUp() {
    return find(invalidFormatPopUpLocator).getText();
  }

  @Step("Click on [CONTINUE] button")
  public RegistrationPage clickContinueButton() {
    clickOnLocator(continueButtonLocator);
    return this;
  }

  @SneakyThrows
  @Step("Enter address {address}")
  public RegistrationPage enterAddress(String address) {
    Thread.sleep(5000);
    find(addressLocator).sendKeys(address);
    return this;
  }

  @Step("Enter Zip Code")
  public RegistrationPage enterZipCode(String zipCode) {
    find(zipCodeLocator).sendKeys(zipCode);
    return this;
  }

  @Step("Enter city")
  public RegistrationPage enterCity(String city) {
    find(cityLocator).sendKeys(city);
    return this;
  }

  @Step("Click on [CONTINUE] button")
  public RegistrationPage clickContinueConfirmAddressButton() {
    clickOnLocator(continueConfirmAddressButtonLocator);
    return this;
  }

  @SneakyThrows
  @Step("Set [My Carrier] Shipping Method")
  public RegistrationPage clickShippingMethodMyCarrier() {
    Thread.sleep(5000);
    clickOnLocator(shippingMethodMyCarrierLocator);
    return this;
  }

  @Step("Click on [CONTINUE] button")
  public RegistrationPage clickConfirmDeliveryButton() {
    clickOnLocator(confirmDeliveryButtonLocator);
    return this;
  }

  @SneakyThrows
  @Step("Set [Pay by Check] Payment method")
  public RegistrationPage clickPayByCheckPayment() {
    Thread.sleep(5000);
    clickOnLocator(payByCheckPaymentLocator);
    return this;
  }

  @SneakyThrows
  @Step("Click on ['I agree..'] checkbox")
  public RegistrationPage clickTermsCheckbox() {
    Thread.sleep(5000);
    clickOnLocator(termsCheckboxLocator);
    return this;
  }

  @Step("Click on [PLACE ORDER] button")
  public RegistrationPage clickPlaceOrderButton() {
    clickOnLocator(placeOrderButtonLocator);
    return this;
  }
}
