package com.inflearn.spring.core.member

/**
 * @PACKAGE com.inflearn.spring.core.member
 * @Author seungdols
 * @Date 2022/01/03
 */
class Member(val id: Long, val name: String, val grade: Grade)

fun createDefaultMember(): Member {
    return Member(0L, "", Grade.DEFAULT)
}
