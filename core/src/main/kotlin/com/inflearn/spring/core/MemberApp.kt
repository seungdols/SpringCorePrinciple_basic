package com.inflearn.spring.core

import com.inflearn.spring.core.member.Grade
import com.inflearn.spring.core.member.Member
import com.inflearn.spring.core.member.MemberService
import com.inflearn.spring.core.member.MemberServiceImpl

/**
 * @PACKAGE com.inflearn.spring.core
 * @Author seungdols
 * @Date 2022/01/03
 */

fun main(args: Array<String>) {
    val memberService: MemberService = MemberServiceImpl()

    val member = Member(1L, "memberA", Grade.VIP)
    memberService.join(member)

    val findMember = memberService.findMember(1L)
    println("new member: ${member.name}")
    println("find member: ${findMember?.name}")
}
