package ke.co.svs.mykrypto.cryptos.data.data_source

import androidx.room.*
import ke.co.svs.mykrypto.domain.model.Crypto
import ke.co.svs.mykrypto.domain.model.CryptoDetails
import kotlinx.coroutines.flow.Flow

/**
 *Accessing Room Database
 */
@Dao
interface CryptoDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCrypto(crypto: CryptoDetails)

    @Delete
    suspend fun deleteCrypto(cryptoDetails: CryptoDetails)

    @Query("SELECT * FROM cryptos_details WHERE id = :id")
    suspend fun getCryptoById(id: Int): CryptoDetails?

    @Query("SELECT * FROM cryptos_details")
    fun getCryptos(): List<CryptoDetails>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg cryptoDetails: CryptoDetails)
}