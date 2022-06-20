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
    suspend fun deleteCrypto(cryptoDetails: Crypto)

    @Query("SELECT * FROM cryptos WHERE id = :id")
    suspend fun getCryptoById(id: Int): Crypto?

    @Query("SELECT * FROM cryptos")
    fun getCryptos(): List<Crypto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg cryptos: Crypto)
}