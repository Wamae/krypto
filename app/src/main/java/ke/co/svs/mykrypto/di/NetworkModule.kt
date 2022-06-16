package ke.co.svs.mykrypto.di

import com.google.gson.GsonBuilder
import ke.co.svs.mykrypto.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.scope.Scope
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val CONNECTION_TIMEOUT = 15L
private const val WRITE_TIMEOUT = 15L
private const val READ_TIMEOUT = 15L

val retrofitModule = module {
    single { GsonBuilder().create() }
    single { retrofitHttpClient() }
    single { retrofitBuilder() }
    single {
        Interceptor { chain ->
            chain.proceed(chain.request().newBuilder().apply {
                header("Accept", "application/json")
            }.build())
        }
    }
}

private fun retrofitHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().apply {
        connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        // addInterceptor(get())
        addInterceptor(HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        })
    }.build()
}

private fun Scope.retrofitBuilder(): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.COIN_GECKO_URL)
        .addConverterFactory(GsonConverterFactory.create(get()))
        .client(get())
        .build()
}