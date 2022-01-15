package com.inflearn.spring.core.xml

import com.inflearn.spring.core.member.MemberService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.ApplicationContext
import org.springframework.context.support.GenericXmlApplicationContext

class XmlAppContext {

    @Test
    fun xmlAppContext() {
        val ac: ApplicationContext = GenericXmlApplicationContext("appConfig.xml")
        val memberService: MemberService = ac.getBean("memberService", MemberService::class.java)
        assertThat(memberService).isInstanceOf(MemberService::class.java)
    }
}
