package com.kafka.producer.integration.products.core.interactor.update

import com.kafka.producer.integration.products.core.dataprovider.MessageDataProvider
import kafka.producer.integration.products.commons.log.IuppLogger
import javax.inject.Singleton

@Singleton
class UpdateProductInteractorImpl(private val productDataProvider: MessageDataProvider) : UpdateProductInteractor {
    override fun update(request: UpdateProductRequest) {
        IuppLogger.logger.info("Entrou no UpdateProductInteractorImpl => $request")
        productDataProvider.productUpdate(request.toProduct())

    }
}