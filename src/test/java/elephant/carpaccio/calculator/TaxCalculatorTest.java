package elephant.carpaccio.calculator;

import static org.junit.Assert.*;

import elephant.carpaccio.domain.Tax;
import org.junit.Test;

public class TaxCalculatorTest {

  TaxCalculator calculator = new TaxCalculator();

  @Test
  public void should_return_tax_amount_given_state_code_is_AL() {
    assertTrue(calculator.getTaxAmount(3097.00f, Tax.AL.getStateCode()) == 3097.00f * Tax.AL.getRatio() / 100);
  }

}