package com.inflearn.spring.core.beanfind

import com.inflearn.spring.core.discount.DiscountPolicy
import com.inflearn.spring.core.discount.FixDiscountPolicy
import com.inflearn.spring.core.discount.RateDiscountPolicy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.NoUniqueBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class ApplicationContextExtendsFindTest {
    val ac: AnnotationConfigApplicationContext = AnnotationConfigApplicationContext(TestConfig::class.java)

    @Test
    @DisplayName("부모 타입으로 조회, 자식이 둘 이상 있으면, 중복 오류가 발생한다.")
    fun findBeanByParentTypeDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException::class.java) {
            ac.getBean(DiscountPolicy::class.java)
        }
    }
    @Test
    @DisplayName("부모 타입으로 조회, 자식이 둘 이상 있으면, 빈 이름을 지정하면 된다.")
    fun findBeanByParentTypeBeanName() {
        val rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy::class.java)
        assertThat(rateDiscountPolicy).isInstanceOf(DiscountPolicy::class.java)
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    fun findBeanBySubType() {
        val rateDiscountPolicy = ac.getBean(RateDiscountPolicy::class.java)
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy::class.java)
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회 하기")
    fun findBeanByParentType() {
        val beansOfType: MutableMap<String, DiscountPolicy> = ac.getBeansOfType(DiscountPolicy::class.java)
        assertThat(beansOfType.size).isEqualTo(2)
    }
    @Test
    @DisplayName("부모 타입으로 모두 조회 하기 - Any")
    fun findBeanByAnyType() {
        val beansOfType: MutableMap<String, Any> = ac.getBeansOfType(Any::class.java)
        for (key in beansOfType.keys) {
            println("key=$key, value=${beansOfType.get(key)}")
        }
        assertThat(beansOfType.size).isGreaterThan(2)
    }

    companion object {
        @Configuration
        class TestConfig {

            @Bean
            fun rateDiscountPolicy(): DiscountPolicy {
                return RateDiscountPolicy()
            }
            @Bean
            fun fixDiscountPolicy(): DiscountPolicy {
                return FixDiscountPolicy()
            }
        }
    }
}
