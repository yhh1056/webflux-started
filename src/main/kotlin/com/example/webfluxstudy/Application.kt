package com.example.webfluxstudy

import com.example.webfluxstudy.hello.GreetingClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    val application = runApplication<Application>(*args)

    val greetingClient = application.getBean(GreetingClient::class.java)

    println(">> message = ${greetingClient.getMessage().block()}")
}
