package ke.co.svs.mykrypto.di

import ke.co.svs.mykrypto.network.CoinGeckoService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single(createdAtStart = false) { get<Retrofit>().create(CoinGeckoService::class.java) }
}