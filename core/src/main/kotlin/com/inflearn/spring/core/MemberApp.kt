package com.inflearn.spring.core

import com.inflearn.spring.core.member.Grade
import com.inflearn.spring.core.member.Member
import com.inflearn.spring.core.member.MemberService
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {
    val applicationContext: ApplicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    val memberService: MemberService = applicationContext.getBean("memberService") as MemberService

    val member = Member(1L, "memberA", Grade.VIP)
    memberService.join(member)

    val findMember = memberService.findMember(1L)
    println(findMember.id)
    println(findMember.name)
}
