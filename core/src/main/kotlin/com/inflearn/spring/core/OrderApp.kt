package com.inflearn.spring.core

import com.inflearn.spring.core.member.Grade
import com.inflearn.spring.core.member.Member
import com.inflearn.spring.core.member.MemberService
import com.inflearn.spring.core.order.Order
import com.inflearn.spring.core.order.OrderService
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {

    val applicationContext: ApplicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    val memberService: MemberService = applicationContext.getBean("memberService", MemberService::class.java)

    val orderService: OrderService = applicationContext.getBean("orderService", OrderService::class.java)

    val member = Member(1L, "memberA", Grade.VIP)
    memberService.join(member)

    val order: Order = orderService.createOrder(member.id, "itemA", 10000)
    println(order)
}
