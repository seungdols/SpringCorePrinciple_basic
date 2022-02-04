package com.inflearn.spring.core.scan

import com.inflearn.spring.core.AutoAppConfig
import com.inflearn.spring.core.member.MemberService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class AutoAppConfigTest {

    @Test
    fun `자동 빈 등록 테스트`() {
        val ac = AnnotationConfigApplicationContext(AutoAppConfig::class.java)

        val memberService = ac.getBean(MemberService::class.java)

        assertThat(memberService).isInstanceOf(MemberService::class.java)
    }
}
