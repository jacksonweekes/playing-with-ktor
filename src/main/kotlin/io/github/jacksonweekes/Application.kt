package io.github.jacksonweekes

import io.github.jacksonweekes.plugins.configureDependencyInjection
import io.github.jacksonweekes.plugins.configureRouting
import io.github.jacksonweekes.plugins.configureSecurity
import io.github.jacksonweekes.plugins.configureSerialization
import io.ktor.server.application.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureSerialization()
    configureDependencyInjection()
    configureRouting()
    configureSecurity()
}