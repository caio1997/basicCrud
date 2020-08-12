package caio.home.product.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class ProductModel(@Id
                   @GeneratedValue
                   val id: Long = 0L,
                    val name: String = "",
                    val price: Double = 0.00) {
                    //comentário teste para Git
}