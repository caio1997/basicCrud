package caio.home.product.controller


import caio.home.product.model.ProductModel
import caio.home.product.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/products")
class ProductController {

    @Autowired
    lateinit var productRepository: ProductRepository

    @GetMapping
    fun findAll(): MutableIterable<ProductModel> {
        return productRepository.findAll()
    }

    @PostMapping
    fun add(@RequestBody product: ProductModel): ResponseEntity<ProductModel> {
        productRepository.save(product)
        return ResponseEntity.ok().body(product)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        try {
            return productRepository.deleteById(id)
        }catch (e: EmptyResultDataAccessException){
        }
     }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Optional<ProductModel>> {
        return ResponseEntity.ok().body(productRepository.findById(id))
    }
}