package elephant.carpaccio.printer;

import elephant.carpaccio.calculator.DiscountCalculator;
import elephant.carpaccio.calculator.TaxCalculator;
import elephant.carpaccio.domain.Item;
import elephant.carpaccio.domain.Order;
import elephant.carpaccio.domain.OrderItem;
import elephant.carpaccio.domain.Tax;

public class Printer {

  private static final String TAB = "  ";
  private static DiscountCalculator discountCalculator = new DiscountCalculator();
  private static TaxCalculator taxCalculator = new TaxCalculator();

  public static void print(Order order) {
    String printContent = getContent(order);
    System.out.println(printContent);
  }

  private static String getContent(Order order) {
    StringBuffer content = new StringBuffer();
    for (OrderItem orderItem : order.getOrderItems()) {
      content
          .append(orderItem.getItem().getLabel() + TAB + orderItem.getQuality() + TAB + orderItem.getItem().getPrice() + TAB + orderItem.getTotalItemPrice());
      content.append("\r\n");
    }

    content.append("-----------------------------------");
    content.append("\r\n");

    float totalAmount = order.getTotalAmount();
    content.append(String.format("Total without taxes: " + TAB + "%s", totalAmount));
    content.append("\r\n");

    float discountAmount = discountCalculator.getDiscountAmount(totalAmount);
    content.append(String.format("Discout XXX :  " + TAB + "- %s", discountAmount));
    content.append("\r\n");

    float taxAmount = taxCalculator.getTaxAmount(totalAmount, Tax.AL.getStateCode());
    content.append(String.format("Tax XXX :  " + TAB + "+ %s", taxAmount));
    content.append("\r\n");

    content.append("-----------------------------------");
    content.append("\r\n");
    content.append(String.format("Total price:  %s", totalAmount - discountAmount + taxAmount));

    return content.toString();
  }

  public static void main(String[] args) {
    Order order = new Order();
    OrderItem orderItem = new OrderItem(new Item("Label1", 999.00f), 3);
    order.getOrderItems().add(orderItem);
    OrderItem orderItem2 = new OrderItem(new Item("Label2", 999.00f), 3);
    order.getOrderItems().add(orderItem2);
    Printer.print(order);
  }
}
