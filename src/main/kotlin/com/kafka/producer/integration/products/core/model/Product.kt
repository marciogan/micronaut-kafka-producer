package com.kafka.producer.integration.products.core.model

import com.kafka.producer.integration.products.core.dataprovider.scylla.domain.ProductEntity
import java.math.BigDecimal

data class Product(
    val id: String?,
    val sku: String,
    val name: String,
    val price: BigDecimal,
    val color: String
){
    internal fun toEntity() = ProductEntity(id, sku,name, price, color)
}
