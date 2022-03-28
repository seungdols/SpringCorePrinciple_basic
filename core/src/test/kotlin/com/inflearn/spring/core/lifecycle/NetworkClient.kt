package com.inflearn.spring.core.lifecycle

import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.InitializingBean

class NetworkClient(
    val url: String
) : InitializingBean, DisposableBean {

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

    override fun afterPropertiesSet() {
        println("NetworkClient.afterPropertiesSet")
        connect()
        call("초기화 연결 메시지")
    }

    override fun destroy() {
        println("NetworkClient.destroy")
        disconnect()
    }
}
