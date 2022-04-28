package ke.co.svs.mykrypto.cryptos.data.data_source

import androidx.room.*
import ke.co.svs.mykrypto.domain.model.CryptoDataModel
import kotlinx.coroutines.flow.Flow
/**
 *Accessing Room Database
 */
@Dao
interface CryptoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCrypto(cryptoDataModel: CryptoDataModel)

    @Insert()
    suspend fun insertAll(vararg cryptoDataModel: CryptoDataModel)

    @Delete
    suspend fun deleteCrypto(cryptoDataModel: CryptoDataModel)

    @Query("SELECT * FROM cryptos WHERE id = :id")
    suspend fun getCryptoById(id: Int): CryptoDataModel?

    @Query("SELECT * FROM cryptos")
    fun getCryptos(): Flow<List<CryptoDataModel>>
}