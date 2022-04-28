package ke.co.svs.mykrypto.domain.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ke.co.svs.mykrypto.cryptos.data.data_source.CryptoDao
import ke.co.svs.mykrypto.domain.model.CryptoDataModel

@Database(
    entities = [CryptoDataModel::class],
    version = 1,
    exportSchema = false,
)
abstract class RoomDB : RoomDatabase() {
    abstract val cryptoDao: CryptoDao
}