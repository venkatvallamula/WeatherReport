package uk.co.niceagency.testexercice.service

import android.app.DownloadManager
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import uk.co.niceagency.testexercice.model.Location


interface ApiServices {

    @GET("daily?")
    fun search(@Query("id") id: String, @Query("lang") lang: String, @Query("appid") appid: String):
            Observable<DownloadManager.Query>

    /**
     * Companion object to create the GithubApiService
     * https://samples.openweathermap.org/data/2.5/forecast/daily?id=524901&lang=5&appid=b1b15e88fa797225412429c1c50c122a1
     */
    companion object Factory {
        fun create(): ApiServices {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://samples.openweathermap.org/data/2.5/forecast/")
                    .build()

            return retrofit.create(ApiServices::class.java);
        }
    }

     object Factory1 {
        fun create1(): ApiServices {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://samples.openweathermap.org/data/2.5/forecast/")
                    .build()

            return retrofit.create(ApiServices::class.java);
        }
    }
}