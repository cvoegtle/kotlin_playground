package org.voegtle.demo

import java.io.IOException

fun main(args: Array<String>) {
  println(Demo().text)

  val order = DocumentedOrder("Documented Pizza", 6.9)
  println("my order $order")

  val christian = Person(firstname = "Christian", lastname = "Vögtle")
  val markus = Person(lastname = "Müller", firstname = "Markus")

  print(markus.greet(anrede = "Hallo", text = "schön, dass Du bei meinem Vortrag dabei bist!"))
}

class Demo(name: String = "World") {
  val text: String = name
    get() = "Hello $field!"

  @Throws(IOException::class)
  fun throwIt() {
    throw IOException("IO hat nicht geklappt")
  }
}

data class Person(val firstname: String, val lastname: String) {
  fun greet(anrede: String, text: String) = "$anrede $firstname,\n$text"
}