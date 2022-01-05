package com.inflearn.spring.core.order

/**
 * @PACKAGE com.inflearn.spring.core.order
 * @Author seungdols
 * @Date 2022/01/03
 */
class Order(val memberId: Long, val itemName: String, val itemPrice: Int, val discountPrice: Int) {

    fun caclulatePrice(): Int {
        return itemPrice - discountPrice
    }

    override fun toString(): String {
        return "Order(memberId=$memberId, itemName='$itemName', itemPrice=$itemPrice, discountPrice=$discountPrice)"
    }
}
