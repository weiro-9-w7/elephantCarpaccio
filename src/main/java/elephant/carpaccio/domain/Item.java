package elephant.carpaccio.domain;

public class Item {
  private String label;
  private float price;

  public Item() {
  }

  public Item(String label, float price) {
    this.label = label;
    this.price = price;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }
}
