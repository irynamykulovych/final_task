package ui;

import framework.pages.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class SubscribeTest extends BaseTest {

  MainPage mainPage = new MainPage();

  @Test
  public void validTextByEmailField() {
    String exceptedTextNearTheEmailField = "Get our latest news and special sales";
    String exceptedTextUnderEmailField = "You may unsubscribe at any moment. "
        + "For that purpose, please find our contact info in the legal notice.";
    String exceptedUpperCaseOfSubscribeButton = "uppercase";
    String actualTextNearTheEmailField = mainPage.getTextNearTheEmailField();
    String actualTextUnderEmailField = mainPage.getTextUnderEmailField();
    String actualUpperCaseOfSubscribeButton = mainPage
        .checkThatCharactersOnSubscribeButtonInUpperCase();

    SoftAssertions softAssertions = new SoftAssertions();

    //TODO
    softAssertions.assertThat(actualTextNearTheEmailField)
        .as("We expected that the text near the email field should be: "
            + "[Get our latest news and special sales]")
        .isEqualTo(exceptedTextNearTheEmailField);

    //TODO
    softAssertions.assertThat(actualTextUnderEmailField)
        .as("We expected that the text under the email field should be: "
            + "[You may unsubscribe at any moment. "
            + "For that purpose, please find our contact info in the legal notice.]")
        .isEqualTo(exceptedTextUnderEmailField);

    softAssertions.assertThat(actualUpperCaseOfSubscribeButton)
        .as("We expected that "
            + "the [SUBSCRIBE] button should be in uppercase")
        .isEqualTo(exceptedUpperCaseOfSubscribeButton);
    softAssertions.assertAll();
  }
}
