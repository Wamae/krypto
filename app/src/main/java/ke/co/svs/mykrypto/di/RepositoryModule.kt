package ke.co.svs.mykrypto.di

import ke.co.svs.mykrypto.cryptos.data.data_source.CryptoDao
import ke.co.svs.mykrypto.domain.database.RoomDB
import ke.co.svs.mykrypto.domain.repositories.CryptoRepository
import ke.co.svs.mykrypto.domain.repositories.CryptoRepositoryImpl
import ke.co.svs.mykrypto.network.CoinGeckoService
import org.koin.dsl.module
import retrofit2.Retrofit


val repositoryModule = module {

    fun provideCryptoRepository(
        coinGeckoService: CoinGeckoService,
        cryptoDao: CryptoDao,
    ): CryptoRepository {
        return CryptoRepositoryImpl(coinGeckoService, cryptoDao)
    }
    single { provideCryptoRepository(get(), get()) }

}