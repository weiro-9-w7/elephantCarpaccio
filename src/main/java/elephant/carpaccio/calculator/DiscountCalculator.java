package elephant.carpaccio.calculator;

import elephant.carpaccio.domain.Discount;

public class DiscountCalculator {

  public float getDiscountAmount(float totalAmount) {
    return totalAmount * Discount.getDiscount(totalAmount).getRatio() / 100;
  }
}