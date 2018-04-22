package com.gabrielczar.bootmicrokotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import com.gabrielczar.bootmicrokotlin.models.ProductDetail
import com.gabrielczar.bootmicrokotlin.repositories.ProductDetailRepository
import org.springframework.boot.SpringApplication



@ComponentScan
@SpringBootApplication
class BootMicroKotlinApplication

fun main(args: Array<String>) {
    val ctx = runApplication<BootMicroKotlinApplication>(*args)

    val detail = ProductDetail()

    detail.productId = "ABCD1234"
    detail.productName = "O livro de Dan sobre a escrita"
    detail.shortDescription = "Um livro sobre como escrever livros."
    detail.longDescription = "Neste livro Dan apresenta ao leitor técnicas sobre como escrever livros."
    detail.inventoryId = "009178461"

    val repository = ctx.getBean(ProductDetailRepository::class.java)
    repository.save(detail)

}
