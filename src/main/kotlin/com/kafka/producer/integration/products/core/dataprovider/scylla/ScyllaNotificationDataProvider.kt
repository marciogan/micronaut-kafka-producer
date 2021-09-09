package com.kafka.producer.integration.products.core.dataprovider.scylla

import com.kafka.producer.integration.products.core.dataprovider.MessageDataProvider
import com.kafka.producer.integration.products.core.dataprovider.scylla.repository.ScyllaNotificationRepository
import com.kafka.producer.integration.products.core.model.Order
import com.kafka.producer.integration.products.core.model.Product
import io.micronaut.context.annotation.Requires
import kafka.producer.integration.products.commons.log.IuppLogger
import javax.inject.Singleton

@Singleton
@Requires(property = "dataprovider", value = "scylla")
class ScyllaNotificationDataProvider(private val notificationRepository: ScyllaNotificationRepository) : MessageDataProvider {

    override fun createProductMessage(product: Product) {
        IuppLogger.logger.info("Entrou no ScyllaNotificationDataProvider => $product")
        notificationRepository.productCreate(product.toEntity())
    }

    override fun productDelete(product: Product) {
        IuppLogger.logger.info("Entrou no ScyllaNotificationDataProvider => $product")
        notificationRepository.productRemove(product.toEntity())
    }

    override fun productUpdate(product: Product) {
        IuppLogger.logger.info("Entrou no ScyllaNotificationDataProvider => $product")
        notificationRepository.productUpdate(product.toEntity())
    }

    override fun createOrderMessage(order: Order) {
        IuppLogger.logger.info("Entrou no ScyllaNotificationDataProvider => $order")
        notificationRepository.orderCreate(order.toEntity())
    }
}