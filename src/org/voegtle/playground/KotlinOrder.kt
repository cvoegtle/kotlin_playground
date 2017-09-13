package org.voegtle.playground

import java.math.BigDecimal

data class KotlinOrder(val item: String,
                       val pricePerItem: Double,
                       val quantity: Int = 1)

fun main(args: Array<String>) {
}


















// Bonus-Feature
fun Double.bd(): BigDecimal {
  return BigDecimal(this)
}

