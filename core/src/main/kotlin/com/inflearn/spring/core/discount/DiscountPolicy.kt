package com.inflearn.spring.core.discount

import com.inflearn.spring.core.member.Member

/**
 * @PACKAGE com.inflearn.spring.core.discount
 * @Author seungdols
 * @Date 2022/01/03
 */
interface DiscountPolicy {

  /**
   *
   * @param member
   * @param price
   * @return 할인 대상 금액
   */
  fun discount(member: Member?, price: Int): Int
}