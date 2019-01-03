package elephant.carpaccio.domain;

public enum Tax {

  UT("UT", 6.85f),
  NV("NV", 8.00f),
  TX("TX", 6.25f),
  AL("AL", 4.00f),
  CA("CA", 8.25f);

  private final String stateCode;
  private final Float ratio;

  Tax(String stateCode, float ratio) {
    this.stateCode = stateCode;
    this.ratio = ratio;
  }

  public String getStateCode() {
    return stateCode;
  }

  public Float getRatio() {
    return ratio;
  }

  public static Tax getTax(String stateCode) {
    Tax tax = null;
    for (Tax value : Tax.values()) {
      if (value.getStateCode().equals(stateCode)) {
        tax = value;
      }
    }
    if(tax == null){
      throw new RuntimeException("can't find relative tax in " + stateCode);
    }
    return tax;
  }
}
