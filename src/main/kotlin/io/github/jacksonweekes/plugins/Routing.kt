package io.github.jacksonweekes.plugins

import io.github.jacksonweekes.quotes.addQuotesController
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        addQuotesController()
    }
}
