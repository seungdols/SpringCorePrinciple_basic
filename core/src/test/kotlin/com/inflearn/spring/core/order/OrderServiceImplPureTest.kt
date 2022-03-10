package com.inflearn.spring.core.order

import com.inflearn.spring.core.discount.FixDiscountPolicy
import com.inflearn.spring.core.member.Grade
import com.inflearn.spring.core.member.Member
import com.inflearn.spring.core.member.MemoryMemberRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrderServiceImplPureTest {

    @Test
    fun `스프링 프레임워크 없이 주문 테스트 - 주문서비스는 정상적으로 주문정보를 반환 한다`() {
        val memoryMemberRepository = MemoryMemberRepository()
        val member = Member(1L, "name", Grade.VIP)
        memoryMemberRepository.save(member)

        val orderService = OrderServiceImpl(memoryMemberRepository, FixDiscountPolicy())

        val order = orderService.createOrder(1L, "itemA", 10000)
        assertThat(order.memberId).isEqualTo(member.id)
    }
}
