package com.kafka.producer.integration.products.core.interactor.create

interface CreateProductInteractor {
    fun create(request: CreateProductRequest)
}
