package elephant.carpaccio.calculator;

import static org.junit.Assert.assertTrue;

import elephant.carpaccio.domain.Discount;
import org.junit.Test;

public class RatioCalculatorTest {

  RatioCalculator calculator = new RatioCalculator();

  @Test
  public void should_return_item_price_multi_quality_given_order_contains_more_items() {
    assertTrue(calculator.getRatioAmount(3097.00f, Discount.getDiscount(3097.00f).getRatio()) == 3097.00f * Discount.three.getRatio() );
  }

}