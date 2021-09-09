package com.kafka.producer.integration.products.core.interactor.create

import com.kafka.producer.integration.products.core.model.Product
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import java.util.*

@Introspected
data class CreateProductRequest(
    val sku: String,
    val name: String,
    val price: BigDecimal,
    val color: String
){
    internal fun toProduct() = Product(id = UUID.randomUUID().toString(), sku,name, price, color)
}