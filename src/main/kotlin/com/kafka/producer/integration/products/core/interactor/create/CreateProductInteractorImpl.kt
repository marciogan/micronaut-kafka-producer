package com.kafka.producer.integration.products.core.interactor.create

import com.kafka.producer.integration.products.core.dataprovider.MessageDataProvider

import kafka.producer.integration.products.commons.log.IuppLogger
import javax.inject.Singleton

@Singleton
class CreateProductInteractorImpl(private val messageDataProvider: MessageDataProvider) : CreateProductInteractor {

    override fun create(request: CreateProductRequest) {
        IuppLogger.logger.info("Entrou no CreateProductInteractorImpl => $request")
        messageDataProvider.createProductMessage(request.toProduct())
    }
}