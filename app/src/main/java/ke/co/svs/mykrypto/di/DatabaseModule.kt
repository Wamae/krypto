package ke.co.svs.mykrypto.di

import android.app.Application
import androidx.room.Room
import ke.co.svs.mykrypto.cryptos.data.data_source.CryptoDao
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

    fun provideDao(dataBase: RoomDB): CryptoDao {
        return dataBase.cryptoDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }
}