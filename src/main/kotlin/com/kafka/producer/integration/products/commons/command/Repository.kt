package com.kafka.producer.integration.products.commons.command

import com.kafka.producer.integration.products.core.dataprovider.scylla.domain.OrderEntity

interface Repository<T> {
    fun productCreate(productEntity: T)
    fun productRemove(productEntity: T)
    fun list(): List<T>
    fun productUpdate(productEntity: T)
    fun orderCreate(orderEntity: OrderEntity)
}
