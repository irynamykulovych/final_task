package ui;

import framework.pages.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class CheckLanguagesTest extends BaseTest {

  MainPage mainPage = new MainPage();

  @Test
  public void checkHowMuchLanguagesInDropDownMenu() {

    String exceptedLanguageResult = "Українська";
    mainPage.clickOnLanguageButton();
    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(mainPage.getAllLanguageFromDropDownMenu().size())
        .as("44 languages should be in 'Language' dropdown in the top menu")
        .isEqualTo(44);

    String actualLanguageResult = mainPage.findUkraineLanguageInDropDownMenu();

    softAssertions.assertThat(actualLanguageResult)
        .as("Українська")
        .isEqualTo(exceptedLanguageResult);
    softAssertions.assertAll();
  }
}
