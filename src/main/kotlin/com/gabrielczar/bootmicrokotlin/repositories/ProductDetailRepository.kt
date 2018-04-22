package com.gabrielczar.bootmicrokotlin.repositories

import com.gabrielczar.bootmicrokotlin.models.ProductDetail
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
interface ProductDetailRepository : PagingAndSortingRepository<ProductDetail, String> {
    fun existsByInventoryId(inventoryId: String): Boolean?
}