package com.kafka.producer.integration.products.commons

import com.kafka.producer.integration.products.core.interactor.create.CreateProductInteractor
import com.kafka.producer.integration.products.core.interactor.create.CreateProductRequest
import com.kafka.producer.integration.products.core.interactor.delete.DeleteProductInteractor
import com.kafka.producer.integration.products.core.interactor.ordercreate.OrderCreateInteractor
import com.kafka.producer.integration.products.core.interactor.ordercreate.OrderCreateRequest
import com.kafka.producer.integration.products.core.interactor.update.UpdateProductInteractor
import com.kafka.producer.integration.products.core.interactor.update.UpdateProductRequest
import com.kafka.producer.integration.products.core.model.Product
import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.event.annotation.EventListener
import kafka.producer.integration.products.commons.log.IuppLogger
import java.math.BigDecimal
import java.util.*
import javax.inject.Singleton

@Singleton
class DataInitializer(
    private val createProductInteractor: CreateProductInteractor,
    private val deleteProductInteractor: DeleteProductInteractor,
    private val updateProductInteractor: UpdateProductInteractor,
    private val orderCreateInteractor: OrderCreateInteractor
) {

    @EventListener
    fun init(event: StartupEvent) {
        val idToDelete = "fef5503c-be5a-45ad-a9de-68f70d713784"
        val idToUpdate = "b9d1b09b-77d9-4972-b3d5-54fb7c57122b"

        IuppLogger.logger.info("=== NOVA MSG - CREATE PRODUCT===")
        createProductInteractor.create(CreateProductRequest("ABC123", "Iphone", BigDecimal.TEN, "Blue"))

        IuppLogger.logger.info("=== NOVA MSG - UPDATE PRODUCT ===")
        updateProductInteractor.update(UpdateProductRequest(idToUpdate,"Sku Atualizado","Produto Atualizado", BigDecimal.ZERO,"blue"))

        IuppLogger.logger.info("=== NOVA MSG - DELETE PRODUCT===")
        deleteProductInteractor.delete(Product(idToDelete, "", "", BigDecimal.ZERO,""))

        IuppLogger.logger.info("=== NOVA MSG - CREATE ORDER ===")
        orderCreateInteractor.orderCreate(OrderCreateRequest(UUID.randomUUID().toString(), "Cliente XYZ"))

    }
}
