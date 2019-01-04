package elephant.carpaccio.calculator;

import static org.junit.Assert.*;

import elephant.carpaccio.domain.Tax;
import org.junit.Test;

public class TaxCalculatorTest {

  RatioCalculator calculator = new RatioCalculator();

  @Test
  public void should_return_tax_amount_given_state_code_is_AL() {
    assertTrue(calculator.getRatioAmount(3097.00f, Tax.getTax(Tax.AL.getStateCode()).getRatio() / 100) == 3097.00f * Tax.AL.getRatio() / 100);
  }

}