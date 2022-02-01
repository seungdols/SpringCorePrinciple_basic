package com.inflearn.spring.core.singleton

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean

internal class StatefulServiceTest {

    @Test
    fun `싱글톤 객체의 필드를 변경하게 되면, 데이터 불일치 문제가 생긴다`() {
        val ac = AnnotationConfigApplicationContext(TestConfig::class.java)

        val statefulService1 = ac.getBean("statefulService", StatefulService::class.java)
        val statefulService2 = ac.getBean("statefulService", StatefulService::class.java)

        // thread 가정

        // thread A
        statefulService1.order("userA", 10000)
        // thread B
        statefulService2.order("userB", 20000)

        val price = statefulService1.price
        assertThat(price).isEqualTo(20000)
    }

    companion object {
        class TestConfig {
            @Bean
            fun statefulService(): StatefulService {
                return StatefulService()
            }
        }
    }
}
