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
    suspend  fun fetchCryptoDetails(@Query("limit") limit: Int):
            List<CryptoDetailsResponse>

    @GET("coins/list")
    suspend fun fetchBasicCryptoList(): List<CryptoDetailsResponse>


    @GET("coins/markets")
    suspend fun fetchCryptoInfo(@Query("per_page") perPage: Int,
                      @Query("vs_currency") currency: String,
                      @Query("sparkline") sparkLine: Boolean): Flow<JsonArray>

    @GET
    suspend fun fetchCryptoDetails(@Url url: String): Flow<JsonObject>

    @GET
    suspend fun fetchCurrencies(@Url url: String): Flow<JsonObject>
}