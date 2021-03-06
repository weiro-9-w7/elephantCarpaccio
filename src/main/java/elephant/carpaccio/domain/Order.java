package elephant.carpaccio.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {

  private List<OrderItem> orderItems = new ArrayList<OrderItem>();

  public List<OrderItem> getOrderItems() {
    return orderItems;
  }

  public float getTotalAmount(){
    float totalAmount = 0.00f;
    for (OrderItem orderItem : orderItems) {
      totalAmount += orderItem.getQuality() * orderItem.getItem().getPrice();
    }
    return totalAmount;
  }

}
