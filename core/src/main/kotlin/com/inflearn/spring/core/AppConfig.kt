package com.inflearn.spring.core

import com.inflearn.spring.core.discount.FixDiscountPolicy
import com.inflearn.spring.core.member.MemberService
import com.inflearn.spring.core.member.MemberServiceImpl
import com.inflearn.spring.core.member.MemoryMemberRepository
import com.inflearn.spring.core.order.OrderService
import com.inflearn.spring.core.order.OrderServiceImpl

class AppConfig {

    fun memberService(): MemberService {
       return MemberServiceImpl(MemoryMemberRepository())
    }

    fun orderService(): OrderService {
        return OrderServiceImpl(MemoryMemberRepository(), FixDiscountPolicy())
    }
}