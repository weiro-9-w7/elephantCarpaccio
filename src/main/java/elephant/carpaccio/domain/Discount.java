package elephant.carpaccio.domain;

public enum Discount {

  fifth(50000f, 15),
  ten(10000f, 10),
  seven(7000f, 7),
  five(5000f, 5),
  three(1000f, 3),
  zero(0f, 0);

  private final float totalAmount;
  private final int ratio;

  Discount(float totalAmount, int ratio) {
    this.totalAmount = totalAmount;
    this.ratio = ratio;
  }

  public float getTotalAmount() {
    return totalAmount;
  }

  public int getRatio() {
    return ratio;
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
