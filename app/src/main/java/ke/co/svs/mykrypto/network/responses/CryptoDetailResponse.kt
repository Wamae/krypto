package ke.co.svs.mykrypto.network.responses

import com.google.gson.annotations.SerializedName

class CryptoDetailResponse(
    @SerializedName("id") val id: String?,
    @SerializedName("image") var imageUrl: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("symbol") val symbol: String?,
    @SerializedName("high_24h") val high_24h: Int?,
    @SerializedName("low_24h") val low_24h: Double?,
    @SerializedName("market_cap") val marketCapUSD: Double?,
    @SerializedName("market_cap_rank") val rank: Int?,
    @SerializedName("current_price") var priceUSD: Double?,
    @SerializedName("total_volume") val totalVolume: Double?,
    @SerializedName("fully_diluted_valuation") val fullyDilutedValuation: Double?,
    @SerializedName("circulating_supply") val circulatingSupply: Double?,
    @SerializedName("total_supply") val totalSupply: Double?,
    @SerializedName("max_supply") val maxSupply: Double?,
    @SerializedName("price_change_24h") val priceChange_24h: Double?,
    @SerializedName("price_change_percentage_24h") val priceChangePercentChange_24h: Double?,
    @SerializedName("market_cap_change_percentage_1h") val percentChange_1h: Double?,
    @SerializedName("market_cap_change_percentage_24h") val percentChange_24h: Double?,
    @SerializedName("market_cap_change_percentage_7d") val percentChange_7d: Double?,
    @SerializedName("last_updated") val lastUpdated: String?
) {
    override fun toString(): String {
        return this.name + " (${this.symbol})"
    }

    override fun equals(other: Any?): Boolean {
        other as CryptoDetailResponse
        if (this.symbol!! == other.symbol) {
            return true
        }
        return false

    }
}