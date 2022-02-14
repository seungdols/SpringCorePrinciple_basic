package com.inflearn.spring.core.autowired

import com.inflearn.spring.core.member.Member
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.lang.Nullable
import java.util.*

class AutoWiredTest {

    @Test
    fun `의존성 주입을 선택적으로 주입 하는 테스트`() {
        val ac = AnnotationConfigApplicationContext(TestBean::class.java)
    }

    companion object {
        class TestBean {

            @Autowired(required = false)
            fun setNoBean1(member: Member) {
                println("noBean1 = $member")
            }

            @Autowired
            fun setNoBean2(@Nullable member: Member?) {
                println("noBean2 = $member")
            }

            @Autowired
            fun setNoBean3(member: Optional<Member>) {
                println("noBean3 = $member")
            }
            /*
            * noBean1은 출력 안 됨.
            * noBean2 = null
            * noBean3 = Optional.empty
            * */
        }
    }
}
