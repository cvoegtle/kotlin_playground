package org.voegtle.demo

fun main(args: Array<String>) {
  println(Demo().text)

  val order = DocumentedOrder("Documented Pizza", 6.9F)
  println("my order $order")
}

class Demo(name: String = "World") {
  val text: String = name
    get() = "Hello $field!"
}