package com.kafka.producer.integration.products.core.dataprovider.scylla.domain

import java.math.BigDecimal
import java.util.*

data class ProductEntity(
    val id: String?,
    val sku: String,
    val name: String,
    val price: BigDecimal,
    val color: String
)
