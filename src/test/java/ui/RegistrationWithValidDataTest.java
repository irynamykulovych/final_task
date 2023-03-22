package ui;

import framework.pages.MainPage;
import framework.pages.helpers.Helpers;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class RegistrationWithValidDataTest extends BaseTest {

  MainPage mainPage = new MainPage();

  @Test
  public void RegistrationNewUserWithValidData() {
    String firstName = Helpers.generateValidFirstName();
    String lastName = Helpers.generateValidLastName();
    mainPage.clickOnSignInButton()
        .clickCreateAccountLink()
        .clickSocialTitleMr()
        .enterFirstName(firstName)
        .enterLastName(lastName)
        .enterEmail(Helpers.generateValidEmail())
        .enterPassword(Helpers.generateValidPassword())
        .enterBirthdate(Helpers.generateBirthdate())
        .checkCheckboxPrivacy()
        .checkCheckboxTerms()
        .clickSaveButton();
    String actualName = mainPage.checkAccountName();

    Assertions.assertThat(actualName)
        .as("Account name is not equals expected")
        .isEqualTo(firstName + " " +lastName);
  }
}
