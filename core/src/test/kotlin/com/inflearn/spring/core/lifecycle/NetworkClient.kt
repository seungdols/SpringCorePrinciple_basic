package com.inflearn.spring.core.lifecycle

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

    fun init() {
        connect()
        call("초기화 연결 메시지")
    }

    fun close() {
        disconnect()
    }
}
