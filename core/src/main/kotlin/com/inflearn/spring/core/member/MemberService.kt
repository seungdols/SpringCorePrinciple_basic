package com.inflearn.spring.core.member

/**
 * @PACKAGE com.inflearn.spring.core.member
 * @Author seungdols
 * @Date 2022/01/03
 */
interface MemberService {
    fun join(member: Member)

    fun findMember(memberId: Long): Member
}
