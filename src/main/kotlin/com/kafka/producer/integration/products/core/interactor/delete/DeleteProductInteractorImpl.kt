package com.kafka.producer.integration.products.core.interactor.delete

import com.kafka.producer.integration.products.core.dataprovider.MessageDataProvider
import com.kafka.producer.integration.products.core.model.Product
import kafka.producer.integration.products.commons.log.IuppLogger
import javax.inject.Singleton

@Singleton
class DeleteProductInteractorImpl(private val productDataProvider: MessageDataProvider) : DeleteProductInteractor {
    override fun delete(product: Product) {
        IuppLogger.logger.info("Entrou no DeleteProductInteractorImpl => $product")
        productDataProvider.productDelete(product)
    }
}