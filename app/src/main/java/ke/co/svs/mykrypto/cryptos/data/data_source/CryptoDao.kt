package ke.co.svs.mykrypto.cryptos.data.data_source

import androidx.room.*
import ke.co.svs.mykrypto.domain.model.Crypto
import kotlinx.coroutines.flow.Flow
/**
 *Accessing Room Database
 */
@Dao
interface CryptoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCrypto(crypto: Crypto)

    @Delete
    suspend fun deleteCrypto(crypto: Crypto)

    @Query("SELECT * FROM cryptos WHERE id = :id")
    suspend fun getCryptoById(id: Int): Crypto?

    @Query("SELECT * FROM cryptos")
    fun getCryptos(): Flow<List<Crypto>>
}