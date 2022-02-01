package com.inflearn.spring.core.singleton

class StatefulService {

    var price: Int = 0

    fun order(name: String, price: Int) {
        println("name: $name, price: $price")
        this.price = price
    }
}