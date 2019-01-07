package elephant.carpaccio.domain;

public class OrderItem {
  private Item item;
  private int quality;

  public OrderItem(Item item, int quality) {
    this.item = item;
    this.quality = quality;
  }

  public int getQuality() {
    return quality;
  }

  public Item getItem() {
    return item;
  }

  public float getTotalItemPrice() {
    return this.item.getPrice() * quality;
  }
}
