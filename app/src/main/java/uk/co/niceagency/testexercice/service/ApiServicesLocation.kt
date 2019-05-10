package uk.co.niceagency.testexercice.service

import android.app.DownloadManager
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import uk.co.niceagency.testexercice.model.Location
import uk.co.niceagency.testexercice.model.LocationText


interface ApiServicesLocation {


    @GET("geocode?")
    fun getCity(@Query("address") address: String):
            Observable<LocationText>
    /**
     * Companion object to create the GithubApiService
     * https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyA6sXKfV9gk8utssiQWRxWAf
     */
    companion object Factory {
        fun create(): ApiServicesLocation {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://maps.googleapis.com/maps/api/geocode/")
                    .build()

            return retrofit.create(ApiServicesLocation::class.java);
        }
    }


}