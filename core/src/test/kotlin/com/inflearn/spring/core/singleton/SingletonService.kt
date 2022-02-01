package com.inflearn.spring.core.singleton

class SingletonService private constructor() {
    companion object {
        val instance = SingletonService()
    }

    fun logic() {
        println("싱글톤 로직 호출")
    }
}