package com.gabrielczar.bootmicrokotlin.models

import javax.persistence.Entity
import javax.persistence.Id


@Entity
data class ProductDetail (
    @Id
    var productId: String? = null,
    var productName: String? = null,
    var shortDescription: String? = null,
    var longDescription: String? = null,
    var inventoryId: String? = null
)