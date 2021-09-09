package com.kafka.producer.integration.products.core.interactor.delete

import com.kafka.producer.integration.products.core.model.Product

interface DeleteProductInteractor {
    fun delete(product: Product)

}