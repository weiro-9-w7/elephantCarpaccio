package elephant.carpaccio.domain;

public enum Discount {

  fifth(50000f, 15.00f),
  ten(10000f, 10.00f),
  seven(7000f, 7.00f),
  five(5000f, 5.00f),
  three(1000f, 3.00f),
  zero(0f, 0.00f);

  private final float totalAmount;
  private final float ratio;

  Discount(float totalAmount, float ratio) {
    this.totalAmount = totalAmount;
    this.ratio = ratio;
  }

  public float getTotalAmount() {
    return totalAmount;
  }

  public float getRatio() {
    return ratio / 100;
  }

  public static Discount getDiscount(Float total) {
    for (Discount value : Discount.values()) {
      if (total >= value.getTotalAmount()) {
        return value;
      }
    }

    return zero;
  }

}
