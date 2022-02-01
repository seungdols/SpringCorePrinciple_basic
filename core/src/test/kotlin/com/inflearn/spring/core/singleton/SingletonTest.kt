package com.inflearn.spring.core.singleton

import com.inflearn.spring.core.AppConfig
import com.inflearn.spring.core.member.MemberService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class SingletonTest {

    @Test
    fun `스프링 없는 순수한 DI 컨테이너`() {
        val appConfig = AppConfig()

        val memberService1 = appConfig.memberService()

        val memberService2 = appConfig.memberService()

        println("memberService1: $memberService1")
        println("memberService2: $memberService2")

        assertThat(memberService1).isNotSameAs(memberService2)
    }

    @Test
    fun `싱글톤 패턴을 적용한 객체 사용`() {
        val singletonService1 = SingletonService.instance
        val singletonService2 = SingletonService.instance

        println("singletonService1: $singletonService1")
        println("singletonService2: $singletonService2")

        assertThat(singletonService1).isSameAs(singletonService2)
    }

    @Test
    fun `스프링 컨테이너와 싱글톤`() {

        val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

        val memberService1 = ac.getBean("memberService", MemberService::class.java)

        val memberService2 = ac.getBean("memberService", MemberService::class.java)

        println("memberService1: $memberService1")
        println("memberService2: $memberService2")

        assertThat(memberService1).isSameAs(memberService2)
    }
}
