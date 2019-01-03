package elephant.carpaccio.domain;

public class OrderItem {
  private Item item;
  private int quality = 1;

  public OrderItem() {
  }

  public OrderItem(Item item, int quality) {
    this.item = item;
    this.quality = quality;
  }

  public int getQuality() {
    return quality;
  }

  public void setQuality(int quality) {
    this.quality = quality;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public float getTotalItemPrice() {
    return this.item.getPrice() * quality;
  }
}
