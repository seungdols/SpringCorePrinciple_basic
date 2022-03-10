package com.inflearn.spring.core.order

import com.inflearn.spring.core.discount.DiscountPolicy
import com.inflearn.spring.core.member.MemberRepository
import org.springframework.stereotype.Component

// discountPolicy의 구현체를 어디선가에서 넣어줘야 된다.
@Component
class OrderServiceImpl(
    private val memberRepository: MemberRepository,
    private val rateDiscountPolicy: DiscountPolicy
) : OrderService {

    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {
        val member = memberRepository.findById(memberId)
        val discountPrice = rateDiscountPolicy.discount(member, itemPrice)

        return Order(memberId, itemName, itemPrice, discountPrice)
    }
    // for test
    fun getMemberRepository(): MemberRepository {
        return memberRepository
    }
}
