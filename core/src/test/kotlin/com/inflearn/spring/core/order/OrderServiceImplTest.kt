package com.inflearn.spring.core.order

import com.inflearn.spring.core.AppConfig
import com.inflearn.spring.core.member.Grade
import com.inflearn.spring.core.member.Member
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * @PACKAGE com.inflearn.spring.core.order
 * @Author seungdols
 * @Date 2022/01/04
 */
internal class OrderServiceImplTest {

    val appConfig = AppConfig()
    val memberService = appConfig.memberService()
    val orderService = appConfig.orderService()

    @Test
    fun createOrder() {
        val memberId = 1L
        val member = Member(memberId, "memberA", Grade.VIP)
        memberService.join(member)

        val order = orderService.createOrder(memberId, "itemA", 10000)
        assertThat(order.discountPrice).isEqualTo(1000)
    }
}
