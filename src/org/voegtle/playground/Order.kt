package org.voegtle.playground

data class Order(val item: String, val pricePerItem: Float, val quantity: Int = 1) {
  val sum: Float = pricePerItem * quantity

  operator fun component4(): Float {
    return sum
  }
  operator fun plus(order: Order): Order {
    return Order(item = "$item + ${order.item}",
        pricePerItem = (pricePerItem + order.pricePerItem) / 2,
        quantity = quantity + order.quantity)
  }
}

fun main(args: Array<String>) {
  val order1 = Order("Pizza", 5.5F, 1)
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
      Order("Pizza", 5.5F, 1), order3 -> println("found $it")
      order2 -> println("found ${it.item}")
      else -> println("found nothing important")
    }
  }
}