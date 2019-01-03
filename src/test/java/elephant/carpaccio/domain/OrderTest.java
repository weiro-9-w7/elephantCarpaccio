package elephant.carpaccio.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderTest {

  private Order order;

  @Before
  public void setUp() throws Exception {
    order = new Order();
  }

  @Test
  public void should_return_zero_when_order_have_no_order_item() {
    assertTrue(0.00f == order.getTotalAmount());
  }

  @Test
  public void should_return_item_price_when_order_contains_item() {
    Item item = new Item();
    item.setLabel("label1");
    item.setPrice(100.00f);
    OrderItem orderItem = new OrderItem(item, 1);
    order.getOrderItems().add(orderItem);
    assertTrue(order.getTotalAmount() == 100.00f);
  }
}