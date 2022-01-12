package com.inflearn.spring.core.beanfind

import com.inflearn.spring.core.AppConfig
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ApplicationContextInfoTest {

    val ac: AnnotationConfigApplicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    @DisplayName("모든 빈 출력하기")
    fun findAllBean() {
        val beanDefinitionNames: Array<String> = ac.beanDefinitionNames

        for (beanDefinitionName in beanDefinitionNames) {
            val bean = ac.getBean(beanDefinitionName)
            println("name=$beanDefinitionName, bean=$bean")
        }
    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    fun findApplicationBean() {
        val beanDefinitionNames: Array<String> = ac.beanDefinitionNames

        for (beanDefinitionName in beanDefinitionNames) {
            val beanDefinition = ac.getBeanDefinition(beanDefinitionName)

            // BeanDefinition.ROLE_APPLICATION 직접 등록한 애플리케이션 빈
            // BeanDefinition.ROLE_INFRASTRUCTURE 스프링 내부에서 등록한 애플리케이션 빈
            if (beanDefinition.role == BeanDefinition.ROLE_APPLICATION) {
                val bean = ac.getBean(beanDefinitionName)

                println("name=$beanDefinitionName, bean=$bean")
            }
        }
    }
}
