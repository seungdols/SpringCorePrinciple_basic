package com.inflearn.spring.core.singleton

import com.inflearn.spring.core.AppConfig
import com.inflearn.spring.core.member.MemberRepository
import com.inflearn.spring.core.member.MemberServiceImpl
import com.inflearn.spring.core.order.OrderServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ConfingurationSingletonTest {

    @Test
    fun `ConfigurationTest`() {

        val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

        val memberServiceImpl = ac.getBean("memberService", MemberServiceImpl::class.java)

        val orderServiceImpl = ac.getBean("orderService", OrderServiceImpl::class.java)
        val memberRepository = ac.getBean("memberRepository", MemberRepository::class.java)

        val memberRepository1 = memberServiceImpl.getMemberRepository()
        val memberRepository2 = orderServiceImpl.getMemberRepository()

        println("memberService -> memberRepository: $memberRepository1")
        println("orderService  -> memberRepository: $memberRepository2")
        println("memberRepository: $memberRepository")

        assertThat(memberServiceImpl.getMemberRepository()).isSameAs(memberRepository)
        assertThat(orderServiceImpl.getMemberRepository()).isSameAs(memberRepository)
    }

    @Test
    fun `Configuration Deep Test`() {
        val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

        val bean = ac.getBean(AppConfig::class.java)

        // bean: class com.inflearn.spring.core.AppConfig$$EnhancerBySpringCGLIB$$3befd555
        println("bean: ${bean.javaClass}")
    }
}
