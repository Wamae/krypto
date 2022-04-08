package ke.co.svs.mykrypto.network.responses

import com.google.gson.annotations.SerializedName

class CryptoResponse(
    @SerializedName("id") val id: String?,
    @SerializedName("quantity") var myQuantity: Double? = 0.0,
    @Transient var imageUrl: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("symbol") val symbol: String?,
    @SerializedName("rank") val rank: Int?,
    @SerializedName("price_usd") var priceUSD: Double?,
    @SerializedName("price_btc") val priceBTC: Double?,
    @SerializedName("24h_volume_usd") val volumeUSD_24h: Double?,
    @SerializedName("market_cap_usd") val marketCapUSD: Double?,
    @SerializedName("available_supply") val availableSupply: Double?,
    @SerializedName("total_supply") val totalSupply: Double?,
    @SerializedName("max_supply") val maxSupply: Double?,
    @SerializedName("percent_change_1h") val percentChange_1h: Double?,
    @SerializedName("percent_change_24h") val percentChange_24h: Double?,
    @SerializedName("percent_change_7d") val percentChange_7d: Double?,
    @SerializedName("last_updated") val lastUpdated: Int?
) {
    override fun toString(): String {
        return this.name + " (${this.symbol})"
    }

    override fun equals(other: Any?): Boolean {
        other as CryptoResponse
        if (this.symbol!! == other.symbol) {
            return true
        }
        return false

    }
}