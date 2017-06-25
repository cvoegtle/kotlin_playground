package org.voegtle.demo2;


/**
 * Diese Klasse repräsentiert eine Bestellung in einem Restaurant wie einer Pizzeria. Ggf. könnte man die Klasse
 * auch für einen Bestellservice wie Paderbringdienst verwenden.
 *
 * @author Christian Vögtle
 * @since 16.6.2017
 */
public class Order {
  private String item;
  private float pricePerItem;
  private int quantity;

  /**
   * Konstruktor für eine Bestellung mit der Anzahl 1
   *
   * @param item         das gewählte Element von der Speisekarte
   * @param pricePerItem der Preis inklusive evenutell gewährter Rabatte, allen Steuern und Servicegebühr
   */
  public Order(String item, float pricePerItem) {
    this(item, pricePerItem, 1);
  }


  /**
   * Konstruktor für eine Bestellung mit variabler Anzahl
   *
   * @param item         das gewählte Element von der Speisekarte
   * @param pricePerItem der Preis inklusive evenutell gewährter Rabatte, allen Steuern und Servicegebühr
   * @param quantity     die Anzahl der gewählten Elemente von der Speisekarte
   */
  public Order(String item, float pricePerItem, int quantity) {
    this.item = item;
    this.pricePerItem = pricePerItem;
    this.quantity = quantity;
  }

  public static void main(String args[]) {
    Order ersteBestellung = new Order("Pizza Tonno", 7);
    Order zweiteBestellung = new Order("Pizza Tonno", 7);

    System.out.println(ersteBestellung + " == " + zweiteBestellung + " ist " + (ersteBestellung.equals(zweiteBestellung)));
  }

  /**
   * @return String Beschreibung des gewählten Elements
   */
  public String getItem() {
    return item;
  }

  /**
   * Die Beschreibung des gewählten Elements setzen
   *
   * @param item String Beschreibung des gewählten Elements
   */
  public void setItem(String item) {
    this.item = item;
  }

  /**
   * den Preis pro Element abfragen
   *
   * @return float der Preis des gewählten Elements
   */
  public float getPricePerItem() {
    return pricePerItem;
  }

  /**
   * den Preis eines Elements setzen
   *
   * @param pricePerItem float der zu setzen Preis
   */
  public void setPricePerItem(float pricePerItem) throws IllegalArgumentException {
    if (pricePerItem < 0.0) {
      throw new IllegalArgumentException("Negativer Preis. Bist Du da sicher?");
    }
    this.pricePerItem = pricePerItem;
  }

  /**
   * die Anzahl der bestellten Elemente abfragen
   *
   * @return int die Anzahl der bestellten Elemente
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * die Anzahl der bestellten Elemente setzen
   *
   * @param quantity die Anzahl der bestellten Elemente
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * die Bestellung als Text darstellen
   *
   * @return String die Bestellung als Text
   */
  @Override
  public String toString() {
    return "Order(" +
        "item='" + item + '\'' +
        ", pricePerItem=" + pricePerItem +
        ", quantity=" + quantity +
        ')';
  }

  /**
   * Vergleicht die Bestellung mit anderen Objekten
   *
   * @param o das Vergleichsobjekt
   * @return true, wenn das Vergleichsobjekt eine Bestellung des gleichen Elements ist, zum gleichen Preis und in
   * der gleichen Anzahl
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Order)) return false;

    Order order = (Order) o;

    if (Float.compare(order.pricePerItem, pricePerItem) != 0) return false;
    if (quantity != order.quantity) return false;
    return item != null ? item.equals(order.item) : order.item == null;
  }

  /**
   * Anscheinend ist es guter Stil hashCode zu überschreiben, damit unser Objekt gut in Maps abgelegt werden kann
   * oder so.
   *
   * @return int der Hashcode der Bestellung
   */
  @Override
  public int hashCode() {
    int result = item != null ? item.hashCode() : 0;
    result = 31 * result + (pricePerItem != +0.0f ? Float.floatToIntBits(pricePerItem) : 0);
    result = 31 * result + quantity;
    return result;
  }
}
