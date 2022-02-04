package com.inflearn.spring.core.scan.filter

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class MyExcludeComponent()
