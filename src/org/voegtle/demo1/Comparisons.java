package org.voegtle.demo1;

import java.util.Objects;

public class Comparisons {
  public static void main(String[] args) {
    Integer a127 = 127;
    Integer b127 = 127;
    System.out.println("a127 == b127 ist " + (a127 == b127));

    Integer a128 = 128;
    Integer b128 = 128;
    System.out.println("a128 == b128 ist " + (a128 == b128));
    System.out.println("a128 equals b128 ist " + (a128.equals(b128)));

    Integer integerNull = null;
    System.out.println("integerNull equals b128 ist " + (integerNull != null && integerNull.equals(b128)));
    System.out.println("Objects.equals(integerNull, b128) ist " + Objects.equals(integerNull, b128)); // Java 7

    int int128 = 128;
    System.out.println("a128 == int128 ist " + (a128 == int128));

    try {
      System.out.println("integerNull == int128 ist " + (integerNull == int128));
    } catch (Exception ignore) {}

    String strA = "Hallo";
    String strB = "Hallo";
    System.out.println("strA == strB ist " + (strA == strB));
  }
}
