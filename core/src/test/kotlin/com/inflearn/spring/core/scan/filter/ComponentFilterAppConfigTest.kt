package com.inflearn.spring.core.scan.filter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

class ComponentFilterAppConfigTest {

    @Test
    fun `filter scan이 정상적이면, beanA는 null이 아니다`() {
        val ac =
            AnnotationConfigApplicationContext(ComponentFilterAppConfig::class.java)

        val beanA = ac.getBean("beanA", BeanA::class.java)

        assertThat(beanA).isNotNull
    }

    @Test
    fun `filter scan이 정상적이면, beanB는 Exception이 발생한다`() {
        val ac =
            AnnotationConfigApplicationContext(ComponentFilterAppConfig::class.java)

        assertThrows(NoSuchBeanDefinitionException::class.java) {
            ac.getBean("beanB", BeanA::class.java)
        }
    }

    companion object {
        @Configuration
        @ComponentScan(
            includeFilters = [ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = [MyIncludeComponent::class]
            )],
            excludeFilters = [ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = [MyExcludeComponent::class]
            )]
        )
        class ComponentFilterAppConfig {

        }
    }
}