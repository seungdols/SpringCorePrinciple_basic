package com.inflearn.spring.core

import com.inflearn.spring.core.member.*
import com.inflearn.spring.core.order.OrderServiceImpl

/**
 * @PACKAGE com.inflearn.spring.core
 * @Author seungdols
 * @Date 2022/01/04
 */
fun main(args: Array<String>) {
  val memberService = MemberServiceImpl()
  val orderService = OrderServiceImpl()

  val memberId = 1L
  val member = Member(memberId, "memberA", Grade.VIP)
  memberService.join(member)

  val createOrder = orderService.createOrder(memberId, "itemA", 10000)
  println(createOrder)
  println(createOrder.caclulatePrice())
}