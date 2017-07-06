package org.voegtle.demo;

/**
 * Diese Klasse repräsentiert eine Bestellung in einem Restaurant wie z.B. einer Pizzeria. Ggf. könnte man die Klasse
 * auch für einen Bestellservice wie Paderbringdienst verwenden.
 *
 * @author Christian Vögtle
 * @since 16.6.2017
 */
public class DocumentedOrder {
  private String item;
  private double pricePerItem;
  private int quantity;

  /**
   * Konstruktor für eine Bestellung mit der Anzahl 1
   *
   * @param item         das gewählte Element von der Speisekarte
   * @param pricePerItem der Preis inklusive evenutell gewährter Rabatte, allen Steuern und Servicegebühr
   */
  public DocumentedOrder(String item, double pricePerItem) {
    this(item, pricePerItem, 1);
  }

  /**
   * Konstruktor für eine Bestellung mit variabler Anzahl
   *
   * @param item         das gewählte Element von der Speisekarte
   * @param pricePerItem der Preis inklusive evenutell gewährter Rabatte, allen Steuern und Servicegebühr
   * @param quantity     die Anzahl der gewählten Elemente von der Speisekarte
   */
  public DocumentedOrder(String item, double pricePerItem, int quantity) {
    this.item = item;
    this.pricePerItem = pricePerItem;
    this.quantity = quantity;
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
   * @return double der Preis des gewählten Elements
   */
  public double getPricePerItem() {
    return pricePerItem;
  }

  /**
   * den Preis eines Elements setzen
   *
   * @param pricePerItem double der zu setzen Preis
   */
  public void setPricePerItem(double pricePerItem) throws IllegalArgumentException {
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
   * Vergleicht die Bestellung mit anderen Objekten
   *
   * @param o das Vergleichsobjekt
   * @return true, wenn das Vergleichsobjekt eine Bestellung des gleichen Elements ist, zum gleichen Preis und in
   * der gleichen Anzahl
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof DocumentedOrder)) return false;

    DocumentedOrder documentedOrder = (DocumentedOrder) o;

    if (Double.compare(documentedOrder.pricePerItem, pricePerItem) != 0) return false;
    if (quantity != documentedOrder.quantity) return false;
    return item != null ? item.equals(documentedOrder.item) : documentedOrder.item == null;
  }

  /**
   * Anscheinend ist es guter Stil hashCode zu überschreiben, damit unser Objekt gut in Maps abgelegt werden kann
   * oder so.
   *
   * @return int der Hashcode der Bestellung
   */
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

  public static void main(String args[]) {
    DocumentedOrder ersteBestellung = new DocumentedOrder("Pizza Tonno", 7);
    DocumentedOrder zweiteBestellung = new DocumentedOrder("Pizza Tonno", 7);

    System.out.println(ersteBestellung + " == " + zweiteBestellung + " ist " + (ersteBestellung == zweiteBestellung));
  }
}
