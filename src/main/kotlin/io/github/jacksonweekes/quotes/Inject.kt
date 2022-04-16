package io.github.jacksonweekes.quotes

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val quotesModule = module {
    single {
        HttpClient(CIO) {
            expectSuccess = true
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }
            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "quotes.rest"
                }
                header(HttpHeaders.Accept, ContentType.Application.Json)
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
        }
    }
    single<QuotesService> { QuotesServiceImpl(get()) }
    single<QuotesApi> { QuotesApiImpl(get()) }
}