package com.inflearn.spring.core.lifecycle

import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

class NetworkClient(
    val url: String
) {

    init {
        println("url=$url")
    }

    fun connect() {
        println("connect: $url")
    }

    fun call(message: String) {
        println("call: $url, message: $message")
    }

    fun disconnect() {
        println("close connection...")
    }

    @PostConstruct
    fun init() {
        connect()
        call("초기화 연결 메시지")
    }

    @PreDestroy
    fun close() {
        disconnect()
    }
}
