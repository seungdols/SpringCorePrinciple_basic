package com.inflearn.spring.core.discount

import com.inflearn.spring.core.member.Grade
import com.inflearn.spring.core.member.Member

class RateDiscountPolicy : DiscountPolicy {

    private val discountPercent = 10

    override fun discount(member: Member?, price: Int): Int {
        if (member == null) {
            return 0
        }

        return if (member.grade == Grade.VIP) {
            price * discountPercent / 100
        } else {
            0
        }
    }
}
