package elephant.carpaccio.domain;

public class Item {
  private String label;
  private float price;

  public Item(String label, float price) {
    this.label = label;
    this.price = price;
  }

  public String getLabel() {
    return label;
  }

  public float getPrice() {
    return price;
  }

}
