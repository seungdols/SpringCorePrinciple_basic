package com.inflearn.spring.core.beandefinition

import com.inflearn.spring.core.AppConfig
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.support.GenericXmlApplicationContext

class BeanDefinitionTest {

    val ac: AnnotationConfigApplicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    val xmlAc: GenericXmlApplicationContext = GenericXmlApplicationContext("appConfig.xml")

    @Test
    @DisplayName("빈 설정 메타정보 확인 - annotation")
    fun findApplicationBeanByAnnotation() {
       val beanDefinitionNames: Array<String> = ac.beanDefinitionNames
        for (beanDefinitionName in beanDefinitionNames) {
            val beanDefinition: BeanDefinition = ac.getBeanDefinition(beanDefinitionName)

            if (beanDefinition.role == BeanDefinition.ROLE_APPLICATION) {
                println("beanDefinitionName=$beanDefinitionName, beanDefinition=$beanDefinition")
            }
        }

    }

    @Test
    @DisplayName("빈 설정 메타정보 확인 - xml")
    fun findApplicationBeanByXml() {
       val beanDefinitionNames: Array<String> = xmlAc.beanDefinitionNames
        for (beanDefinitionName in beanDefinitionNames) {
            val beanDefinition: BeanDefinition = xmlAc.getBeanDefinition(beanDefinitionName)

            if (beanDefinition.role == BeanDefinition.ROLE_APPLICATION) {
                println("beanDefinitionName=$beanDefinitionName, beanDefinition=$beanDefinition")
            }
        }

    }

}