package elephant.carpaccio.calculator;

import static org.junit.Assert.*;

import elephant.carpaccio.domain.Discount;
import org.junit.Test;

public class DiscountCalculatorTest {

  DiscountCalculator calculator = new DiscountCalculator();

  @Test
  public void should_return_item_price_multi_quality_given_order_contains_more_items() {
    assertTrue(calculator.getDiscountAmount(3097.00f, Discount.getDiscount(3097.00f).getRatio()) == 3097.00f * Discount.three.getRatio() );
  }
}