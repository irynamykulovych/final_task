package ui;

import framework.pages.MainPage;
import framework.pages.RegistrationPage;
import framework.pages.helpers.Helpers;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class RegistrationWithInvalidDataTest extends BaseTest {

  MainPage mainPage = new MainPage();
  RegistrationPage registrationPage = new RegistrationPage();

  @Test
  public void RegistrationNewUserWithInvalidData() {
    String firstName = "James8";
    String lastName = Helpers.generateValidLastName();
    String exceptedFirstNameFrameColor = "rgba(255, 76, 76, 1)";
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

    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(registrationPage.getFirstNameFrameColor())
        .as("First name is highlighted in red")
        .isEqualTo(exceptedFirstNameFrameColor);

    String exceptedPopUpWithInvalidFormatText = "Invalid format.";

        softAssertions.assertThat(registrationPage.getInvalidFormatPopUp())
        .as("Pop-up should appear with text 'Invalid format.' ")
        .isEqualTo(exceptedPopUpWithInvalidFormatText);

    softAssertions.assertAll();
  }
}
