package com.inflearn.spring.core.annotation

import org.springframework.beans.factory.annotation.Qualifier
import java.lang.annotation.*
import java.lang.annotation.Retention
import java.lang.annotation.Target

@Target(
    ElementType.FIELD,
    ElementType.METHOD,
    ElementType.PARAMETER,
    ElementType.TYPE,
    ElementType.ANNOTATION_TYPE
)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
annotation class MainDiscountPolicy()
