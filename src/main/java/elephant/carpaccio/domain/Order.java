package elephant.carpaccio.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {

  private List<OrderItem> orderItems;

  public List<OrderItem> getOrderItems() {
    if(orderItems == null){
      orderItems = new ArrayList<OrderItem>();
    }
    return orderItems;
  }

  public float getTotalAmount(){
    float totalAmount = 0.00f;
    for (OrderItem orderItem : getOrderItems()) {
      totalAmount += orderItem.getQuality() * orderItem.getItem().getPrice();
    }
    return totalAmount;
  }

}
