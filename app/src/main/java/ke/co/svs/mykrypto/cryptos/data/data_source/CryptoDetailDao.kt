package ke.co.svs.mykrypto.cryptos.data.data_source

import androidx.room.*
import ke.co.svs.mykrypto.domain.model.CryptoDetail

/**
 *Accessing Room Database
 */
@Dao
interface CryptoDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCrypto(crypto: CryptoDetail)

    @Delete
    suspend fun deleteCrypto(cryptoDetails: CryptoDetail)

    @Query("SELECT * FROM cryptos_details WHERE id = :id")
    suspend fun getCryptoById(id: Int): CryptoDetail?

    @Query("SELECT * FROM cryptos_details")
    fun getCryptos(): List<CryptoDetail>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg cryptoDetails: CryptoDetail)
}