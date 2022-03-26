package io.github.jacksonweekes

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.github.jacksonweekes.plugins.configureRouting
import io.github.jacksonweekes.plugins.configureSecurity
import io.github.jacksonweekes.plugins.configureSerialization

fun main() {
    embeddedServer(Netty, port = 8080) {
        configureRouting()
        configureSerialization()
        configureSecurity()
    }.start(wait = true)
}
