package elephant.carpaccio.printer;

import elephant.carpaccio.domain.Order;

public class OrderList {
  private Order order;
  private Float discountAmount;
  private Float discountRatio;
  private Float taxAmount;
  private Float taxRatio;
  private Float payAmount;

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public Float getDiscountAmount() {
    return discountAmount;
  }

  public void setDiscountAmount(Float discountAmount) {
    this.discountAmount = discountAmount;
  }

  public Float getDiscountRatio() {
    return discountRatio;
  }

  public void setDiscountRatio(Float discountRatio) {
    this.discountRatio = discountRatio;
  }

  public Float getTaxAmount() {
    return taxAmount;
  }

  public void setTaxAmount(Float taxAmount) {
    this.taxAmount = taxAmount;
  }

  public Float getTaxRatio() {
    return taxRatio;
  }

  public void setTaxRatio(Float taxRatio) {
    this.taxRatio = taxRatio;
  }

  public Float getPayAmount() {
    return payAmount;
  }

  public void setPayAmount(Float payAmount) {
    this.payAmount = payAmount;
  }
}
