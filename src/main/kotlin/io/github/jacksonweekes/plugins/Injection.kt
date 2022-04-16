package io.github.jacksonweekes.plugins

import io.github.jacksonweekes.quotes.quotesModule
import io.ktor.server.application.*

fun Application.configureDependencyInjection() {
    install(KoinPlugin) {
        modules(
            quotesModule
        )
    }
}
