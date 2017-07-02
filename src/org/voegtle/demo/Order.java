package org.voegtle.demo;

public class Order {
  private String item;
  private float pricePerItem;
  private int quantity;

  public Order(String item, float pricePerItem) {
    this(item, pricePerItem, 1);
  }

  public Order(String item, float pricePerItem, int quantity) {
    this.item = item;
    this.pricePerItem = pricePerItem;
    this.quantity = quantity;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public float getPricePerItem() {
    return pricePerItem;
  }

  public void setPricePerItem(float pricePerItem) {
    this.pricePerItem = pricePerItem;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "Order(" +
        "item='" + item + '\'' +
        ", pricePerItem=" + pricePerItem +
        ", quantity=" + quantity +
        ')';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Order)) return false;

    Order order = (Order) o;

    if (Float.compare(order.pricePerItem, pricePerItem) != 0) return false;
    if (quantity != order.quantity) return false;
    return item != null ? item.equals(order.item) : order.item == null;
  }

  @Override
  public int hashCode() {
    int result = item != null ? item.hashCode() : 0;
    result = 31 * result + (pricePerItem != +0.0f ? Float.floatToIntBits(pricePerItem) : 0);
    result = 31 * result + quantity;
    return result;
  }
}
