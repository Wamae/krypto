package ke.co.svs.mykrypto.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_cryptos")
class UserCrypto (
    @PrimaryKey
    val id: String,
    val myQuantity: Double? = 0.00,

)