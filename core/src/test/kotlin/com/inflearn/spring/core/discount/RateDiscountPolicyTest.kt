package com.inflearn.spring.core.discount

import com.inflearn.spring.core.member.Grade
import com.inflearn.spring.core.member.Member
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class RateDiscountPolicyTest {

    val rateDiscountPolicy = RateDiscountPolicy()

    @Test
    @DisplayName("VIP는 10%할인이 적용 되어야 한다.")
    fun vip_discount() {
        // given
        val member = Member(1L, "memberVIP", Grade.VIP)

        // when
        val discount = rateDiscountPolicy.discount(member, 10000)

        // then
        assertThat(discount).isEqualTo(1000)
    }

    @Test
    @DisplayName("VIP가 아니면, 할인이 적용 되지 않아야 한다.")
    fun vip_not_discout() {
        // given
        val member = Member(1L, "memberBASIC", Grade.BASIC)

        // when
        val discount = rateDiscountPolicy.discount(member, 10000)

        // then
        assertThat(discount).isEqualTo(0)
    }
}
