package com.inflearn.spring.core.autowired

import com.inflearn.spring.core.AutoAppConfig
import com.inflearn.spring.core.discount.DiscountPolicy
import com.inflearn.spring.core.member.Grade
import com.inflearn.spring.core.member.Member
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class AllBeanTest {

    @Test
    fun `모든 빈을 조회한다`() {
        val applicationContext =
            AnnotationConfigApplicationContext(AutoAppConfig::class.java, DiscountService::class.java)

        val discountService = applicationContext.getBean(DiscountService::class.java)
        assertThat(discountService).isInstanceOf(DiscountService::class.java)
        assertThat(discountService.policies.size).isGreaterThan(1)
    }

    @Test
    fun `할인가격을 할인 정책에 따라 반환 할 수 있다`() {
        val applicationContext =
            AnnotationConfigApplicationContext(AutoAppConfig::class.java, DiscountService::class.java)

        val discountService = applicationContext.getBean(DiscountService::class.java)
        val member = Member(1L, "userA", Grade.VIP)
        val discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy")

        assertThat(discountPrice).isEqualTo(1000)

        val rateDiscountPrice = discountService.discount(member, 20000, "rateDiscountPolicy")
        assertThat(rateDiscountPrice).isEqualTo(2000)
    }

    companion object {
        class DiscountService(
            val policyMap: Map<String, DiscountPolicy>,
            val policies: List<DiscountPolicy>
        ) {
            fun discount(member: Member, price: Int, discountCode: String): Int {
                val discountPolicy = policyMap[discountCode]
                return discountPolicy?.discount(member, price) ?: 0
            }

            init {
                println(policies)
                println(policyMap)
            }
        }
    }
}
