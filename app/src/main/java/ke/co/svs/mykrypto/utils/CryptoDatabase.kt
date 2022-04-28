package ke.co.svs.mykrypto.utils

import androidx.room.Database
import androidx.room.RoomDatabase
import ke.co.svs.mykrypto.cryptos.data.data_source.CryptoDao
import ke.co.svs.mykrypto.domain.model.CryptoDataModel

@Database(entities = [CryptoDataModel::class], version = 1)
abstract class CryptoDatabase : RoomDatabase() {
    abstract fun cryptoDao(): CryptoDao

    companion object {
        const val DATABASE_NAME = "cryptos_db"
    }
}