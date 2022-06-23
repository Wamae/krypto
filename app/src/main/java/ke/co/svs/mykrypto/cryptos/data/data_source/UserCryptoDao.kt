package ke.co.svs.mykrypto.cryptos.data.data_source

import androidx.room.*
import ke.co.svs.mykrypto.domain.model.UserCrypto
import kotlinx.coroutines.flow.Flow

/**
 *Accessing Room Database
 */
@Dao
interface UserCryptoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCrypto(crypto: UserCrypto)

    @Delete
    suspend fun deleteCrypto(cryptoDetails: UserCrypto)

    @Query("SELECT * FROM user_cryptos WHERE id = :id")
    suspend fun getCryptoById(id: Int): UserCrypto?

    @Query("SELECT * FROM user_cryptos")
    suspend fun getCryptos(): List<UserCrypto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg cryptoDetails: UserCrypto)
}