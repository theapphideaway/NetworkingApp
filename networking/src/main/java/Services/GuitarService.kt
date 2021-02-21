package Services

import com.ianschoenrock.networking.Interfaces.IGuitarService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GuitarService {
    private var retrofit: Retrofit

    init {

        val interceptor = HttpLoggingInterceptor().
        setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
            .retryOnConnectionFailure(false)
            .addInterceptor(interceptor)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl("http://electricguitar.schoenrockserver.co/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    fun getGuitars(): IGuitarService {
        return retrofit.create<IGuitarService>(IGuitarService::class.java)
    }
}