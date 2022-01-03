package com.inflearn.spring.core.member

class MemberServiceImpl : MemberService {

    private val memberRepository: MemberRepository = MemoryMemberRepository()

    override fun join(member: Member) {
        memberRepository.save(member)
    }

    override fun findMember(memberId: Long): Member? {
        return memberRepository.findById(memberId)
    }
}
