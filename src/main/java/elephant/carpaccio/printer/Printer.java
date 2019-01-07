package elephant.carpaccio.printer;

import elephant.carpaccio.calculator.RatioCalculator;
import elephant.carpaccio.domain.Discount;
import elephant.carpaccio.domain.Item;
import elephant.carpaccio.domain.Order;
import elephant.carpaccio.domain.OrderItem;
import elephant.carpaccio.domain.Tax;
import java.text.DecimalFormat;
import java.text.Format;

public class Printer {

  private static final String TAB = "  ";
  private static RatioCalculator discountCalculator = new RatioCalculator();
  private static RatioCalculator taxCalculator = new RatioCalculator();
  private static Format formatter = new DecimalFormat("##0.00");

  private void print(Order order) {
    String printContent = getContent(order);
    System.out.println(printContent);
  }

  private String getContent(Order order) {
    StringBuilder content = new StringBuilder();
    content.append(getOrderItemContent(order));

    content.append("-----------------------------------");
    content.append("\r\n");

    float totalAmount = order.getTotalAmount();
    content.append(getTotalAmountContent(totalAmount));
    content.append("\r\n");

    float discountRatio = Discount.getDiscount(totalAmount).getRatio();
    float discountAmount = discountCalculator.getRatioAmount(totalAmount, discountRatio / 100);
    content.append(String.format("Discout %s  :  " + TAB + "- %s", discountRatio+"", formatter.format(discountAmount)));
    content.append("\r\n");

    float taxRatio = Tax.getTax(Tax.AL.getStateCode()).getRatio();
    float taxAmount = taxCalculator.getRatioAmount(totalAmount - discountAmount, taxRatio / 100);
    content.append(String.format("Tax %s  :  " + TAB + "+ %s", taxRatio+"", formatter.format(taxAmount)));
    content.append("\r\n");

    content.append("-----------------------------------");
    content.append("\r\n");
    content.append(String.format("Total price:  %s", formatter.format(totalAmount - discountAmount + taxAmount)));

    return content.toString();
  }

  private String getTotalAmountContent(float totalAmount) {
    return String.format("Total without taxes: " + TAB + "%s", formatter.format(totalAmount));
  }

  private String getOrderItemContent(Order order) {
    StringBuilder content = new StringBuilder();
    for (OrderItem orderItem : order.getOrderItems()) {
      String orderContent = orderItem.getItem().getLabel() + TAB
          + orderItem.getQuality() + TAB
          + formatter.format(orderItem.getItem().getPrice()) + TAB
          + formatter.format(orderItem.getTotalItemPrice());
      content.append(orderContent);
      content.append("\r\n");
    }
    return content.toString();
  }

  public static void main(String[] args) {
    Order order = new Order();
    OrderItem orderItem = new OrderItem(new Item("Label1", 999.00f), 3);
    order.getOrderItems().add(orderItem);
    OrderItem orderItem2 = new OrderItem(new Item("Label2", 999.00f), 3);
    order.getOrderItems().add(orderItem2);
    new Printer().print(order);
  }
}
