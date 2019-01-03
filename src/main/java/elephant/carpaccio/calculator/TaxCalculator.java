package elephant.carpaccio.calculator;

import elephant.carpaccio.domain.Tax;

public class TaxCalculator {

  public float getTaxAmount(float totalAmount, String stateCode) {
    return totalAmount * Tax.getTax(stateCode).getRatio() / 100;
  }

}