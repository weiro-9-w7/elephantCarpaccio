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
    float totalAmout = 0.00f;
    for (OrderItem orderItem : orderItems) {
      totalAmout += orderItem.getQuality() * orderItem.getItem().getPrice();
    }
    return totalAmout;
  }

}
