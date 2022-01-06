package com.inflearn.spring.core.order

import com.inflearn.spring.core.discount.DiscountPolicy
import com.inflearn.spring.core.discount.RateDiscountPolicy
import com.inflearn.spring.core.member.MemberRepository
import com.inflearn.spring.core.member.MemoryMemberRepository

class OrderServiceImpl : OrderService {

    private val memberRepository: MemberRepository = MemoryMemberRepository()
//    private val discountPolicy: DiscountPolicy = FixDiscountPolicy()
    // 요구사항에 대해 변경이 필요해서 바꾸자니, OCP를 위반함. 역할이 구현체까지 의존하는 상태
    private val discountPolicy: DiscountPolicy = RateDiscountPolicy()

    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {
        val member = memberRepository.findById(memberId)
        val discountPrice = discountPolicy.discount(member, itemPrice)

        return Order(memberId, itemName, itemPrice, discountPrice)
    }
}
