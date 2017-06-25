package org.voegtle.demo

fun main(args: Array<String>) {
  println(Demo().text)
}

class Demo(name: String = "World") {
  val text: String = name
    get() = "Hello $field!"
}