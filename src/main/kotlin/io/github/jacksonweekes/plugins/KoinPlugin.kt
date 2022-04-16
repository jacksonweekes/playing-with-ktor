package io.github.jacksonweekes.plugins

import io.ktor.events.EventDefinition
import io.ktor.server.application.*
import io.ktor.util.*
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.java.KoinJavaComponent.getKoin

internal class KoinPlugin(internal val koinApplication: KoinApplication) {
    // Implements ApplicationPlugin as a companion object.
    companion object Plugin : BaseApplicationPlugin<ApplicationCallPipeline, KoinApplication, KoinPlugin> {
        // Creates a unique key for the plugin.
        override val key = AttributeKey<KoinPlugin>("CustomKoinPlugin")

        // Code to execute when installing the plugin.
        override fun install(
            pipeline: ApplicationCallPipeline,
            configure: KoinApplication.() -> Unit
        ): KoinPlugin {
            val monitor = pipeline.environment?.monitor
            val koinApplication = startKoin(appDeclaration = configure)
            monitor?.subscribe(ApplicationStopping) {
                stopKoin()
            }
            return KoinPlugin(koinApplication)
        }
    }
}

inline fun <reified T : Any> inject(
    qualifier: Qualifier? = null,
    noinline parameters: ParametersDefinition? = null
) = lazy { get<T>(qualifier, parameters) }


inline fun <reified T : Any> get(
    qualifier: Qualifier? = null,
    noinline parameters: ParametersDefinition? = null
) = getKoin().get<T>(qualifier, parameters)