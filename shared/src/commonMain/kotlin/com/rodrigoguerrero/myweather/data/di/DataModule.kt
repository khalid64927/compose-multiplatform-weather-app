package com.rodrigoguerrero.myweather.data.di

import co.touchlab.kermit.Logger
import co.touchlab.kermit.StaticConfig
import co.touchlab.kermit.platformLogWriter
import com.rodrigoguerrero.myweather.data.local.datastore.DataStorePreferencesRepository
import com.rodrigoguerrero.myweather.data.local.db.LocationDataSource
import com.rodrigoguerrero.myweather.data.local.datastore.PreferencesRepository
import com.rodrigoguerrero.myweather.data.local.db.SqDelightLocationDataSource
import com.rodrigoguerrero.myweather.data.remote.config.createHttpClient
import com.rodrigoguerrero.myweather.data.remote.repositories.KtorWeatherRepositoryImpl
import com.rodrigoguerrero.myweather.data.remote.repositories.WeatherRepository
import com.rodrigoguerrero.mywheather.database.AppDatabase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf
import org.koin.core.scope.Scope
import org.koin.dsl.module

val dataModule = module {
    // Kermit logger factory
    factory { (tag: String? ) -> if (tag != null) baseLogger.withTag(tag) else baseLogger }
    single<PreferencesRepository> { DataStorePreferencesRepository(dataStoreProvider = get()) }
    single<WeatherRepository> { KtorWeatherRepositoryImpl(httpClient = get()) }
    single { createHttpClient(httpClientEngine = get(), preferencesRepository = get(), log = getWith<Logger>("Ktor").withTag("Ktor-Client")) }
    single<LocationDataSource> {
        SqDelightLocationDataSource(
            database = AppDatabase(driver = get())
        )
    }
}

// platformLogWriter() is a relatively simple config option, useful for local debugging. For production
// uses you *may* want to have a more robust configuration from the native platform. In KaMP Kit,
// that would likely go into platformModule expect/actual.
// See https://github.com/touchlab/Kermit
val baseLogger = Logger(config = StaticConfig(logWriterList = listOf(platformLogWriter())), "MyWeather")

internal inline fun <reified T> Scope.getWith(vararg params: Any?): T {
    return get(parameters = { parametersOf(*params) })
}

// Simple function to clean up the syntax a bit
fun KoinComponent.injectLogger(tag: String = "Ktor"): Lazy<Logger> = inject { parametersOf(tag) }