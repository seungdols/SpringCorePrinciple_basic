package com.inflearn.spring.core.member

/**
 * @PACKAGE com.inflearn.spring.core.member
 * @Author seungdols
 * @Date 2022/01/03
 */
interface MemberRepository {
    fun save(member: Member)

    fun findById(memberId: Long): Member?
}
