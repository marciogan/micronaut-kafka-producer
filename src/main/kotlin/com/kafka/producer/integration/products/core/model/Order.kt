package com.kafka.producer.integration.products.core.model

import com.kafka.producer.integration.products.core.dataprovider.scylla.domain.OrderEntity
import com.kafka.producer.integration.products.core.dataprovider.scylla.domain.ProductEntity

data class Order(
    val id: String?,
    val name: String
){
    internal fun toEntity() = OrderEntity(id, name)
}

