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

  public static void print(Order order) {
    String printContent = getContent(order);
    System.out.println(printContent);
  }

  private static String getContent(Order order) {
    StringBuffer content = new StringBuffer();
    for (OrderItem orderItem : order.getOrderItems()) {
      content.append(orderItem.getItem().getLabel() + TAB
              + orderItem.getQuality() + TAB
              + formatter.format(orderItem.getItem().getPrice()) + TAB
              + formatter.format(orderItem.getTotalItemPrice()));
      content.append("\r\n");
    }

    content.append("-----------------------------------");
    content.append("\r\n");

    float totalAmount = order.getTotalAmount();
    content.append(String.format("Total without taxes: " + TAB + "%s", formatter.format(totalAmount)));
    content.append("\r\n");

    float discountAmount = discountCalculator.getRatioAmount(totalAmount, Discount.getDiscount(totalAmount).getRatio() / 100);
    content.append(String.format("Discout XXX :  " + TAB + "- %s", formatter.format(discountAmount)));
    content.append("\r\n");

    float taxAmount = taxCalculator.getRatioAmount(totalAmount, Tax.getTax(Tax.AL.getStateCode()).getRatio() / 100);
    content.append(String.format("Tax XXX :  " + TAB + "+ %s", formatter.format(taxAmount)));
    content.append("\r\n");

    content.append("-----------------------------------");
    content.append("\r\n");
    content.append(String.format("Total price:  %s", formatter.format(totalAmount - discountAmount + taxAmount)));

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
