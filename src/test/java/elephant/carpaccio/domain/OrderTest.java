package elephant.carpaccio.domain;

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
    Assert.assertTrue(0.00f == order.getTotalAmount());
  }
}