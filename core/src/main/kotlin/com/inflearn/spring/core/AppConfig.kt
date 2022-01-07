package com.inflearn.spring.core

import com.inflearn.spring.core.discount.DiscountPolicy
import com.inflearn.spring.core.discount.FixDiscountPolicy
import com.inflearn.spring.core.member.MemberService
import com.inflearn.spring.core.member.MemberServiceImpl
import com.inflearn.spring.core.member.MemoryMemberRepository
import com.inflearn.spring.core.order.OrderService
import com.inflearn.spring.core.order.OrderServiceImpl

class AppConfig {

    private fun memoryMemberRepository() = MemoryMemberRepository()

    fun memberService(): MemberService = MemberServiceImpl(memoryMemberRepository())

    fun orderService(): OrderService = OrderServiceImpl(memoryMemberRepository(), discoutPolicy())

    fun discoutPolicy(): DiscountPolicy = FixDiscountPolicy()
}
