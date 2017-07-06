package org.voegtle.playground

import java.math.BigDecimal

data class Order(val item: String, val pricePerItem: Double, val quantity: Int = 1) {
  val sum: Double = pricePerItem * quantity

  operator fun component4(): Double {
    return sum
  }
  operator fun plus(order: Order): Order {
    return Order(item = "$item + ${order.item}",
        pricePerItem = (pricePerItem + order.pricePerItem) / 2,
        quantity = quantity + order.quantity)
  }
}

fun Double.bd(): BigDecimal {
  return BigDecimal(this)
}

fun main(args: Array<String>) {
  val order1 = Order("Pizza", 5.5, 1)
  val order2 = order1.copy(quantity = 2, item = "Spaghetti")
  val order3 = order1 + order2
  println(order3)

  println("$order1 == $order2 ist ${order1 == order2}")
  println("$order1 === $order2 ist ${order1 === order2}")

  val isEqual = order1 == order2
  println("$order1 == $order2 ist ${isEqual}")

  val orders = ArrayList<Order>()
  orders.add(order1)
  orders.add(order2)
  orders.add(order3)
  for ((item, _, _, sum) in orders) {
    println("Die $item-Bestellung kostet $sum")
  }

  orders.forEach {
    when (it) {
      Order("Pizza", 5.5, 1), order2 -> println("found $it")
      in orders -> println("found at last ${it.item} ")
      else -> println("found nothing important")
    }
  }
}