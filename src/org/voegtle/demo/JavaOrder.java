package org.voegtle.demo;

public class JavaOrder {
  private String item;
  private double pricePerItem;
  private int quantity;

  public JavaOrder(String item, double pricePerItem) {
    this(item, pricePerItem, 1);
  }

  public JavaOrder(String item, double pricePerItem, int quantity) {
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

  public double getPricePerItem() {
    return pricePerItem;
  }

  public void setPricePerItem(double pricePerItem) {
    this.pricePerItem = pricePerItem;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    JavaOrder order = (JavaOrder) o;

    if (Double.compare(order.pricePerItem, pricePerItem) != 0) {
      return false;
    }
    if (quantity != order.quantity) {
      return false;
    }
    return item != null ? item.equals(order.item) : order.item == null;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = item != null ? item.hashCode() : 0;
    temp = Double.doubleToLongBits(pricePerItem);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + quantity;
    return result;
  }

  @Override
  public String toString() {
    return "Order{" + "item='" + item + '\'' + ", pricePerItem=" + pricePerItem + ", quantity=" + quantity + '}';
  }
}
