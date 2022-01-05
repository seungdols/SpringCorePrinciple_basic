package com.inflearn.spring.core.order

import com.inflearn.spring.core.discount.DiscountPolicy
import com.inflearn.spring.core.discount.FixDiscountPolicy
import com.inflearn.spring.core.member.MemberRepository
import com.inflearn.spring.core.member.MemoryMemberRepository

class OrderServiceImpl : OrderService {

    private val memberRepository: MemberRepository = MemoryMemberRepository()
    private val discountPolicy: DiscountPolicy = FixDiscountPolicy()

    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {
        val member = memberRepository.findById(memberId)
        val discountPrice = discountPolicy.discount(member, itemPrice)

        return Order(memberId, itemName, itemPrice, discountPrice)
    }
}
