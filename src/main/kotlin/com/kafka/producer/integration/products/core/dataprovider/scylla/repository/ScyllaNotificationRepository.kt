package com.kafka.producer.integration.products.core.dataprovider.scylla.repository

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.BoundStatement
import com.datastax.oss.driver.api.core.cql.PreparedStatement
import com.fasterxml.jackson.databind.ObjectMapper
import com.kafka.producer.integration.products.commons.command.Repository
import com.kafka.producer.integration.products.core.dataprovider.scylla.domain.OrderEntity
import com.kafka.producer.integration.products.core.dataprovider.scylla.domain.ProductEntity
import kafka.producer.integration.products.commons.log.IuppLogger
import java.util.*
import javax.inject.Singleton


@Singleton
class ScyllaNotificationRepository(private val cqlSession: CqlSession): Repository<ProductEntity> {

    override fun productCreate(productEntity: ProductEntity) {
        IuppLogger.logger.info("Entrou no ScyllaNotificationRepository => $productEntity")

        val preparedInsert: PreparedStatement = cqlSession.prepare(
            "INSERT INTO cdc.notifications(id, type, payload) VALUES (?,?,?) IF NOT EXISTS"
        )
        val mapper = ObjectMapper()
        val json = mapper.writeValueAsString(productEntity)

        val insert: BoundStatement = preparedInsert.bind(
            UUID.randomUUID(),
            MessageType.PRODUCT_INSERT.name,
            json)

        cqlSession.execute(insert)
        IuppLogger.logger.info("Salvou no DB/Notifications com sucesso")

    }

    override fun productRemove(productEntity: ProductEntity) {
        IuppLogger.logger.info("Entrou no ScyllaNotificationRepository => $productEntity")

        val preparedInsert: PreparedStatement = cqlSession.prepare(
            "INSERT INTO cdc.notifications(id, type, payload) VALUES (?,?,?) IF NOT EXISTS"
        )
        val mapper = ObjectMapper()
        val json = mapper.writeValueAsString(productEntity)

        val insert: BoundStatement = preparedInsert.bind(
            UUID.randomUUID(),
            MessageType.PRODUCT_DELETE.name,
            json)

        cqlSession.execute(insert)
        IuppLogger.logger.info("Salvou no DB/Notifications com sucesso")
    }

    override fun list(): List<ProductEntity> {
        TODO("Not yet implemented")
    }

    override fun productUpdate(productEntity: ProductEntity) {

        IuppLogger.logger.info("Entrou no ScyllaNotificationRepository => $productEntity")

        val preparedInsert: PreparedStatement = cqlSession.prepare(
            "INSERT INTO cdc.notifications(id, type, payload) VALUES (?,?,?) IF NOT EXISTS"
        )
        val mapper = ObjectMapper()
        val json = mapper.writeValueAsString(productEntity)

        val insert: BoundStatement = preparedInsert.bind(
            UUID.randomUUID(),
            MessageType.PRODUCT_UPDATE.name,
            json)

        cqlSession.execute(insert)
        IuppLogger.logger.info("Salvou no DB/Notifications com sucesso")
    }

    override fun orderCreate(orderEntity: OrderEntity) {
        IuppLogger.logger.info("Entrou no ScyllaNotificationRepository => $orderEntity")

        val preparedInsert: PreparedStatement = cqlSession.prepare(
            "INSERT INTO cdc.notifications(id, type, payload) VALUES (?,?,?) IF NOT EXISTS"
        )
        val mapper = ObjectMapper()
        val json = mapper.writeValueAsString(orderEntity)

        val insert: BoundStatement = preparedInsert.bind(
            UUID.randomUUID(),
            MessageType.ORDER_INSERT.name,
            json)

        cqlSession.execute(insert)
        IuppLogger.logger.info("Salvou no DB/Notifications com sucesso")
    }
}