package com.kafka.producer.integration.products.core.interactor.ordercreate


interface OrderCreateInteractor {
    fun orderCreate(request: OrderCreateRequest)
}