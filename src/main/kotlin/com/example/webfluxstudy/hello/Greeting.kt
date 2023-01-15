package com.example.webfluxstudy.hello

import com.fasterxml.jackson.annotation.JsonProperty

class Greeting(@JsonProperty("message") val message: String)
