package com.kafka.producer.integration.products.core.interactor.ordercreate

import com.kafka.producer.integration.products.core.dataprovider.MessageDataProvider
import kafka.producer.integration.products.commons.log.IuppLogger
import javax.inject.Singleton

@Singleton
class OrderCreateInteractorImpl(private val messageDataProvider: MessageDataProvider) : OrderCreateInteractor {
    override fun orderCreate(request: OrderCreateRequest) {
        IuppLogger.logger.info("Entrou no OrderCreateInteractorImpl => $request")
        messageDataProvider.createOrderMessage(request.toOrder())
    }
}