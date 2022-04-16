package io.github.jacksonweekes.quotes

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

interface QuotesApi {
    suspend fun getQuoteOfTheDay(): QuoteOfTheDay
}

class QuotesApiImpl(private val client: HttpClient): QuotesApi {
    override suspend fun getQuoteOfTheDay(): QuoteOfTheDay = client.get("/qod").body()
}