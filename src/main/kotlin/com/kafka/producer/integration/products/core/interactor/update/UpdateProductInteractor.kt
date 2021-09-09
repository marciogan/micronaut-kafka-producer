package com.kafka.producer.integration.products.core.interactor.update

interface UpdateProductInteractor {
        fun update(request: UpdateProductRequest)
}