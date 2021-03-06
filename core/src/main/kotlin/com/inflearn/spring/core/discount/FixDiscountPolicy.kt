package com.inflearn.spring.core.discount

import com.inflearn.spring.core.member.Grade
import com.inflearn.spring.core.member.Member
import org.springframework.stereotype.Component

/**
 * @PACKAGE com.inflearn.spring.core.discount
 * @Author seungdols
 * @Date 2022/01/03
 */
@Component
class FixDiscountPolicy : DiscountPolicy {

    private val discountFixAmount = 1000

    override fun discount(member: Member, price: Int): Int {
        return if (member.grade == Grade.VIP) {
            discountFixAmount
        } else {
            0
        }
    }
}
