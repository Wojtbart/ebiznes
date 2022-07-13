package models.shoppingCart
import models.product.Product

case class ShoppingCart(id: Long, payment_id: Int,email: String, products_in_cart: Array[ShoppingCartProduct])
