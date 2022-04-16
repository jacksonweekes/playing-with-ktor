package io.github.jacksonweekes.quotes

interface QuotesService {
    suspend fun getQuoteOfTheDay(): QuoteOfTheDay
}

class QuotesServiceImpl(private val quotesApi: QuotesApi): QuotesService {
    override suspend fun getQuoteOfTheDay(): QuoteOfTheDay = quotesApi.getQuoteOfTheDay()
}