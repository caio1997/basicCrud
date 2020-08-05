package caio.home.product.repository

import caio.home.product.model.ProductModel
import org.springframework.data.repository.CrudRepository

interface ProductRepository : CrudRepository<ProductModel, Long> {
}