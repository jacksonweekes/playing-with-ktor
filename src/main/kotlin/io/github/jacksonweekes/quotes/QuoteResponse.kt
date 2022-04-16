package io.github.jacksonweekes.quotes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuoteResponse(
    @SerialName("quote") val quote: String,
    @SerialName("author") val author: String,
    @SerialName("randomNumber") val randomNumber: Int
)