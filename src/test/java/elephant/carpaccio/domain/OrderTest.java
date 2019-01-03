package elephant.carpaccio.domain;

import static org.junit.Assert.assertTrue;

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
    Item item = createItem("label1", 100.00f);
    OrderItem orderItem = new OrderItem(item, 1);
    order.getOrderItems().add(orderItem);
    assertTrue(order.getTotalAmount() == 100.00f);
  }

  @Test
  public void should_return_tax_amount_when_state_code_is_AL() {
    createOrder();
    assertTrue(order.getTaxAmount(order.getTotalAmount(), Tax.AL.getStateCode()) == 3097.00f * Tax.AL.getRatio() / 100);
  }

  private void createOrder() {
    Item item = createItem("label1", 100.00f);
    OrderItem orderItem = new OrderItem(item, 1);
    order.getOrderItems().add(orderItem);

    Item item2 = createItem("Label2", 999.00f);
    OrderItem orderItem2 = new OrderItem(item2, 3);
    order.getOrderItems().add(orderItem2);
  }

  private Item createItem(String label, float price) {
    Item item = new Item();
    item.setLabel(label);
    item.setPrice(price);
    return item;
  }
}