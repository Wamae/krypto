package ke.co.svs.mykrypto.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cryptos")
class Crypto (
    @PrimaryKey
    val id: String,
    val name: String,
    val symbol: String)