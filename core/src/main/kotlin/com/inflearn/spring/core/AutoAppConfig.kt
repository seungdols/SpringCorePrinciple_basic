package com.inflearn.spring.core

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan(
    excludeFilters = [
        ComponentScan.Filter(
            type = FilterType.ANNOTATION,
            classes = [Configuration::class]
        )
    ]
)
class AutoAppConfig {
//    @Bean("memoryMemberRepository")
//    fun memberRepository() = MemoryMemberRepository()
}
