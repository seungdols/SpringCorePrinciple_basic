package com.inflearn.spring.core.beanfind

import com.inflearn.spring.core.AppConfig
import com.inflearn.spring.core.member.MemberService
import com.inflearn.spring.core.member.MemberServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ApplicationContextBasicFindTest {

    val ac: AnnotationConfigApplicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    @DisplayName("빈 이름으로 조회")
    fun findBeanByName() {
        val memberService: MemberService = ac.getBean("memberService", MemberService::class.java)
        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    fun findBeanByType() {
        val memberService = ac.getBean(MemberService::class.java)
        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    fun findBeanByImpl() {
        val memberService: MemberServiceImpl = ac.getBean("memberService", MemberServiceImpl::class.java)
        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    @DisplayName("빈 이름으로 조회 했을때, 없는 경우")
    fun findBeanNameIsNull() {
//        val excutable: () -> Unit = { ac.getBean("xxxx", MemberService::class.java) }
//        assertThrows(NoSuchBeanDefinitionException::class.java, excutable )
        assertThrows(NoSuchBeanDefinitionException::class.java) {
            ac.getBean(
                "xxxx",
                MemberService::class.java
            )
        }
    }
}
