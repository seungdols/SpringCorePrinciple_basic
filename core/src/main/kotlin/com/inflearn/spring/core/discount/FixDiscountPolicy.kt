package com.inflearn.spring.core.discount

import com.inflearn.spring.core.member.Grade
import com.inflearn.spring.core.member.Member

/**
 * @PACKAGE com.inflearn.spring.core.discount
 * @Author seungdols
 * @Date 2022/01/03
 */
class FixDiscountPolicy : DiscountPolicy {

    private val discountFixAmount = 1000

    override fun discount(member: Member?, price: Int): Int {
        // 우선 null check를 넣어 준다. 깔끔하게 뺄 수 있는 방법 고려
        if (member == null) {
            return 0
        }

        return if (member.grade == Grade.VIP) {
            discountFixAmount
        } else {
            0
        }
    }
}
