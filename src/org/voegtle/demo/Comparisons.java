package org.voegtle.demo;

import java.util.Objects;

public class Comparisons {
  enum Language {
    Java, Kotlin, Typescript, Javascript
  }

  public static void main(String[] args) {
    Integer a127 = 127;
    Integer b127 = 127;
    System.out.println("a127 == b127 ist " + (a127 == b127));

    Integer a128 = 128;
    Integer b128 = 128;
    System.out.println("a128 == b128 ist " + (a128 == b128));
    System.out.println("a128 equals b128 ist " + (a128.equals(b128)));

    int int128 = 128;
    System.out.println("a128 == int128 ist " + (a128 == int128));

    Integer integerNull = null;
    System.out.println(" int128 == integerNull ist " + (int128 == integerNull ));
    System.out.println("Objects.equals(a128, int128) ist " + Objects.equals(a128, int128));

    System.out.println("integerNull equals b128 ist "
        + (integerNull != null && integerNull.equals(b128)));

    System.out.println("Objects.equals(integerNull, b128) ist "
        + Objects.equals(integerNull, b128)); // Java 7

    String strA = "Hallo";
    String strB = "Hallo";
    System.out.println("strA == strB ist " + (strA == strB));

    Language l1 = Language.Kotlin;
    Language l2 = Language.Kotlin;
    System.out.println( "l1 == l2 ist " + (l1 == l2));
  }
}
