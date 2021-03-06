package com.inflearn.spring.core.member

import com.inflearn.spring.core.AppConfig
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * @PACKAGE com.inflearn.spring.core.member
 * @Author seungdols
 * @Date 2022/01/03
 */
internal class MemberServiceImplTest {

    val appConfig = AppConfig()
    val memberService = appConfig.memberService()

    @Test
    fun joinTest() {
        // given
        val member = Member(1L, "memberA", Grade.VIP)

        // when
        memberService.join(member)
        val findMember = memberService.findMember(1L)

        // then
        assertThat(member).isEqualTo(findMember)
    }
}
