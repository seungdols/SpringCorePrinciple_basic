package com.inflearn.spring.core.member

/**
 * @PACKAGE com.inflearn.spring.core.member
 * @Author seungdols
 * @Date 2022/01/03
 */
class MemoryMemberRepository : MemberRepository {

//  concurrent hashmap을 쓰는게 맞다.
    companion object {
        private val store: MutableMap<Long, Member> = HashMap()
    }

    override fun save(member: Member) {
        store[member.id] = member
    }

    override fun findById(memberId: Long): Member? {
        return store[memberId]
    }
}
