package com.inflearn.spring.core.beanfind

import com.inflearn.spring.core.member.MemberRepository
import com.inflearn.spring.core.member.MemoryMemberRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.NoUniqueBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class ApplicationContextSameBeanFindTest {
    val ac: AnnotationConfigApplicationContext = AnnotationConfigApplicationContext(SameBeanConfig::class.java)

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다.")
    fun findBeanByTypeDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException::class.java) {
            ac.getBean(MemberRepository::class.java)
        }
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다.")
    fun fineBeanByName() {
        val memberRepository = ac.getBean("memberRepository1", MemberRepository::class.java)
        assertThat(memberRepository).isInstanceOf(MemberRepository::class.java)
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    fun findAllBeanByType() {
        val beansOfType: MutableMap<String, MemberRepository> = ac.getBeansOfType(MemberRepository::class.java)
        for (key in beansOfType.keys) {
            println("key=$key, value=${beansOfType.get(key)}")
        }
        println("beansOfType=$beansOfType")
        assertThat(beansOfType.size).isEqualTo(2)
    }

    companion object {
        @Configuration
        class SameBeanConfig {

            @Bean
            fun memberRepository1(): MemberRepository {
                return MemoryMemberRepository()
            }
            @Bean
            fun memberRepository2(): MemberRepository {
                return MemoryMemberRepository()
            }
        }
    }
}
