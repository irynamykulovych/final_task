package ui;

import framework.pages.MainPage;
import framework.pages.helpers.Category;
import framework.pages.helpers.MainCategory;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class CheckCategoriesTest extends BaseTest {

  MainPage mainPage = new MainPage();

  @Test
  public void checkThatCategoryMenAndWomenSubMenuItemsAppears() {

    mainPage.getMenuCategory().hoverOverElement(MainCategory.CLOTHES);

    List<String> clothesSubMenuExceptedNames = Arrays.asList(Category.MEN.getOption(),
        Category.WOMEN.getOption());
    List<String> clothesSubMenuNames = mainPage.getMenuCategory().getSubMenuNames();

    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(clothesSubMenuExceptedNames)
        .as("Sub menu 'MEN' and 'WOMEN' should be in the 'Clothes' category")
        .containsExactlyElementsOf(clothesSubMenuNames);

    mainPage.getMenuCategory().hoverOverElement(MainCategory.ACCESSORIES);

    List<String> accessoriesSubMenuExceptedNames = Arrays.asList(
        Category.STATIONERY.getOption(),
        Category.HOME_ACCESSORIES.getOption());
    List<String> accessoriesSubMenuNames = mainPage.getMenuCategory().getSubMenuNames();

    softAssertions.assertThat(accessoriesSubMenuExceptedNames)
        .as("Sub menu 'Stationery' and 'Accessories' should be in the 'Accessories' category")
        .containsExactlyElementsOf(accessoriesSubMenuNames);

    mainPage.getMenuCategory().hoverOverElement(MainCategory.ART);
    boolean isArtSubMenuExist = mainPage.getMenuCategory().isArtSubMenuVisible();

    softAssertions.assertThat(!isArtSubMenuExist)
        .as("The 'Art' category is not as expected");


    softAssertions.assertAll();
  }
}