package ke.co.svs.mykrypto.di

import ke.co.svs.mykrypto.cryptos.data.data_source.CryptoDao
import ke.co.svs.mykrypto.domain.database.RoomDB
import ke.co.svs.mykrypto.network.CoinGeckoService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    fun provideCoinGeckoService(retrofit: Retrofit): CoinGeckoService {
        return retrofit.create(CoinGeckoService::class.java)
    }
    single { provideCoinGeckoService(get()) }
}