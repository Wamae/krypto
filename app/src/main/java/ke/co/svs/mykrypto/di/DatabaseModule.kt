package ke.co.svs.mykrypto.di

import android.app.Application
import androidx.room.Room
import ke.co.svs.mykrypto.cryptos.data.data_source.CryptoDao
import ke.co.svs.mykrypto.cryptos.data.data_source.CryptoDetailsDao
import ke.co.svs.mykrypto.cryptos.data.data_source.UserCryptoDao
import ke.co.svs.mykrypto.domain.database.RoomDB
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    fun provideDatabase(app: Application): RoomDB {
        return Room.databaseBuilder(
            app,
            RoomDB::class.java,
            "app_crypto_db"
        ).build()
    }

    fun provideCryptoDao(dataBase: RoomDB): CryptoDao {
        return dataBase.cryptoDao
    }

    fun provideCryptoDetailsDao(dataBase: RoomDB): CryptoDetailsDao {
        return dataBase.cryptoDetailsDao
    }

    fun provideUserCryptoDetailsDao(dataBase: RoomDB): UserCryptoDao {
        return dataBase.userCryptoDetailsDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideCryptoDao(get()) }
    single { provideCryptoDetailsDao(get()) }
    single { provideUserCryptoDetailsDao(get()) }
}