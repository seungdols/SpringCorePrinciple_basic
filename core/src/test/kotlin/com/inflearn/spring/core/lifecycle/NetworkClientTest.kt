package com.inflearn.spring.core.lifecycle

import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

internal class NetworkClientTest {
    @Test
    fun `네트워크 클라이언트 생명주기 테스트`() {

        val ac = AnnotationConfigApplicationContext(LifeCycleConfig::class.java)
        val networkClient = ac.getBean(NetworkClient::class.java)
        
        ac.close()
    }

    companion object {
        @Configuration
        class LifeCycleConfig {
            @Bean
            fun networkClient(): NetworkClient {
                return NetworkClient("http://hello-spring.dev")
            }
        }
    }
}