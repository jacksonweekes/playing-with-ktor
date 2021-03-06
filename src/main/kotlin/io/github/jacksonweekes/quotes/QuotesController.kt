package io.github.jacksonweekes.quotes

import io.github.jacksonweekes.plugins.inject
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlin.random.Random


fun Route.addQuotesController() {
    val quotesService by inject<QuotesService>()

    get("about") {
        call.respondText {
            "This works right?"
        }
    }

    get("quote") {
        val quoteOfTheDay = quotesService.getQuoteOfTheDay()
        call.respondText {
            quoteOfTheDay.contents.quotes.first().quote
        }
    }

    get("quotesAsJson") {
        val quoteOfTheDay = quotesService.getQuoteOfTheDay().contents.quotes.first()
        call.respond(
            QuoteResponse(quoteOfTheDay.quote, quoteOfTheDay.author, Random.nextInt())
        )
    }
}