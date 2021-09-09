package com.kafka.producer.integration.products.core.interactor.ordercreate

import com.kafka.producer.integration.products.core.model.Order
import io.micronaut.core.annotation.Introspected

@Introspected
data class OrderCreateRequest(
    val id: String?,
    val name: String
){
    internal fun toOrder() = Order(id, name)
}