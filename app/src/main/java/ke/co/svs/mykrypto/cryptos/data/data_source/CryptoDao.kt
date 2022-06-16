package ke.co.svs.mykrypto.cryptos.data.data_source

import androidx.room.*
import ke.co.svs.mykrypto.domain.model.Crypto

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

    /**
     * Insert shows in the database. If the show already exists, replace it.
     *
     * @param shows the shows to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg shows: Crypto)
}