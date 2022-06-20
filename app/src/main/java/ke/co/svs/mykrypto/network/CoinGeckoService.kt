package ke.co.svs.mykrypto.network

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import ke.co.svs.mykrypto.network.responses.CryptoDetailsResponse
import ke.co.svs.mykrypto.network.responses.CryptoResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface CoinGeckoService {
    @GET("ticker")
    suspend fun fetchCryptoDetails(@Query("limit") limit: Int):
            List<CryptoDetailsResponse>

    @GET("coins/list")
    suspend fun fetchBasicCryptoList(@Query("limit") limit: Int):
            List<CryptoDetailsResponse>


    @GET("coins/markets")
    suspend fun fetchCryptoDetails(
        @Query("vs_currency") currency: String,
        @Query("ids") ids: String,
//        @Query("sparkline") sparkLine: Boolean,
//        @Query("per_page") perPage: Int,
    ): List<CryptoDetailsResponse>

    @GET
    suspend fun fetchCryptoDetails(@Url url: String): JsonObject

    @GET
    suspend fun fetchCurrencies(@Url url: String): JsonObject
}