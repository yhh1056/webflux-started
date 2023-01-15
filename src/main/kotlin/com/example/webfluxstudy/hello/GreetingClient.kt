package com.example.webfluxstudy.hello

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class GreetingClient(builder: WebClient.Builder) {
    private val client: WebClient

    // Spring Boot auto-configures a `WebClient.Builder` instance with nice defaults and customizations.
    // We can use it to create a dedicated `WebClient` for our component.
    init {
        client = builder.baseUrl("http://localhost:8080").build()
    }

    fun getMessage(): Mono<String> {
        return client
            .get()
            .uri("/hello")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Greeting::class.java)
            .map(Greeting::message)
    }
}