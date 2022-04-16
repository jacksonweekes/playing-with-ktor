package io.github.jacksonweekes.quotes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuoteOfTheDay(
    @SerialName("contents") val contents: Contents
)

@Serializable
data class Contents(
    @SerialName("quotes") val quotes: List<Quote>
)

@Serializable
data class Quote(
    @SerialName("quote") val quote: String,
    @SerialName("author") val author: String
)