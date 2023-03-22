package framework.pages.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {

  BY_NAME_A_Z("Name, A to Z"),
  BY_NAME_Z_A("Name, Z to A"),
  BY_PRICE_LOW_HIGH("Price, low to high"),
  BY_PRICE_HIGH_LOW("Price, high to low"),

  MEN("MEN"),
  WOMEN("WOMEN"),
  STATIONERY("STATIONERY"),
  HOME_ACCESSORIES("HOME ACCESSORIES");

  private final String option;
}



