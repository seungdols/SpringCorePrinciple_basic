package com.inflearn.spring.core

import com.inflearn.spring.core.discount.DiscountPolicy
import com.inflearn.spring.core.discount.RateDiscountPolicy
import com.inflearn.spring.core.member.MemberService
import com.inflearn.spring.core.member.MemberServiceImpl
import com.inflearn.spring.core.member.MemoryMemberRepository
import com.inflearn.spring.core.order.OrderService
import com.inflearn.spring.core.order.OrderServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun memoryMemberRepository() = MemoryMemberRepository()

    @Bean
    fun memberService(): MemberService = MemberServiceImpl(memoryMemberRepository())

    @Bean
    fun orderService(): OrderService = OrderServiceImpl(memoryMemberRepository(), discoutPolicy())

    @Bean
    fun discoutPolicy(): DiscountPolicy = RateDiscountPolicy()
}
