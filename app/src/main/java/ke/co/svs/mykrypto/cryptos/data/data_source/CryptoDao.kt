package ke.co.svs.mykrypto.cryptos.data.data_source

import androidx.room.Dao
import androidx.room.Query
import ke.co.svs.mykrypto.domain.model.Crypto
import kotlinx.coroutines.flow.Flow

@Dao
interface CryptoDao {
    @Query("SELECT * FROM cryptos")
    fun getCryptos(): Flow<List<Crypto>>
}