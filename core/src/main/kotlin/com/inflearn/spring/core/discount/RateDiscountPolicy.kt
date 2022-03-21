package com.inflearn.spring.core.discount

import com.inflearn.spring.core.annotation.MainDiscountPolicy
import com.inflearn.spring.core.member.Grade
import com.inflearn.spring.core.member.Member
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

@Component
@Primary
@MainDiscountPolicy
class RateDiscountPolicy : DiscountPolicy {

    private val discountPercent = 10

    override fun discount(member: Member, price: Int): Int {
        return if (member.grade == Grade.VIP) {
            price * discountPercent / 100
        } else {
            0
        }
    }
}
