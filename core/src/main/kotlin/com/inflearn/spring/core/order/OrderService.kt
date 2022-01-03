package com.inflearn.spring.core.order

/**
 * @PACKAGE com.inflearn.spring.core.order
 * @Author seungdols
 * @Date 2022/01/03
 */
interface OrderService {
  fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order
}