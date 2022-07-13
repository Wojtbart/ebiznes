package models.shoppingCart
import models.product.Product

case class NewShoppingCart(payment_id: Int, products_in_cart: Array[ShoppingCartProduct])