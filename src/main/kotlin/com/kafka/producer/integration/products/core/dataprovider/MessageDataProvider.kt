package com.kafka.producer.integration.products.core.dataprovider

import com.kafka.producer.integration.products.core.model.Order
import com.kafka.producer.integration.products.core.model.Product

interface MessageDataProvider {

    fun createProductMessage(product: Product)
    fun productDelete(product: Product)
    fun productUpdate(product: Product)
    fun createOrderMessage(order: Order)
}