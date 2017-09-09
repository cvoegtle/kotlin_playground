package org.voegtle.playground

data class KotlinOrder(val item: String,
                       val pricePerItem: Double,
                       val quantity: Int = 1)
