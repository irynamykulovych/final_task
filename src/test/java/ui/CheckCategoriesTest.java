package ui;

import framework.pages.MainPage;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class CheckCategoriesTest extends BaseTest {

  MainPage mainPage = new MainPage();

  @Test
  public void checkThatCategoryMenAndWomenSubMenuItemsAppears() {
    List<String> clothesCategories = Arrays.asList("Men", "Women");
    List<String> accessoriesCategories = Arrays.asList("Stationery", "Home Accessories");
    List<String> artCategories = Collections.emptyList();

    mainPage.hoverMouseOverClothesCategory();

    SoftAssertions softAssertions = new SoftAssertions();

    for (String category : clothesCategories) {
      softAssertions.assertThat(mainPage.categoriesIsDisplayed(category))
          .as("sub menu 'MEN' and 'WOMEN' should be in the 'Clothes' category").isTrue();
    }
    mainPage.hoverMouseAccessoriesCategory();
    for (String category : accessoriesCategories) {
      softAssertions.assertThat(mainPage.categoriesIsDisplayed(category))
          .as("Sub menu 'Stationery' and 'Accessories' "
              + "should be in the 'Accessories' category")
          .isTrue();
    }
    mainPage.hoverMouseArtCategory();
    for (String category : artCategories) {
      softAssertions.assertThat(mainPage.categoriesIsDisplayed(category))
          .as("There is no sub menu in the 'Art' category").isTrue();
    }
    softAssertions.assertAll();
  }

}